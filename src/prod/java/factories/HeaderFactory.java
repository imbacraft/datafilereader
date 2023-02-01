package factories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import constants.HeaderConstants;
import constants.ItemConstants;
import entities.Header;
import exceptions.InvalidFieldException;
import exceptions.MissingFieldException;
import messages.HeaderErrorMessages;
import utils.HelperMethods;

public class HeaderFactory implements FactoryInterface<Header> {

  public List<Header> allHeaders = new ArrayList<>();

  @Override
  public void addToItemList(Header item) {

    this.allHeaders.add(item);
  }

  @Override
  public boolean allFieldsAreValid(String[] splitHeader, long errorLineNumber) {

    if (isValidRecordIdentifier(splitHeader) == false) {

      throw new InvalidFieldException(
          HeaderErrorMessages.invalidRecordIdentifier(
              splitHeader[ItemConstants.RECORD_IDENTIFIER_INDEX], errorLineNumber));
    }

    if (isValidSpecificationVersion(splitHeader) == false) {

       throw new InvalidFieldException(
          HeaderErrorMessages.invalidSpecificationVersion(
              splitHeader[HeaderConstants.SPECIFICATION_VERSION_INDEX], errorLineNumber));

    }

    if (HelperMethods.isValidDate(
            splitHeader[HeaderConstants.DATE_OF_FILE_GENERATION_INDEX],
            HeaderConstants.dateFormatter)
        == false) {

      throw new InvalidFieldException(
          HeaderErrorMessages.invalidDate(
              splitHeader[HeaderConstants.DATE_OF_FILE_GENERATION_INDEX], errorLineNumber));
    }

    if (HelperMethods.isValidTime(splitHeader[HeaderConstants.TIME_OF_FILE_GENERATION_INDEX], HeaderConstants.timeFormatter) == false){

       throw new InvalidFieldException(
          HeaderErrorMessages.invalidTime(
              splitHeader[HeaderConstants.TIME_OF_FILE_GENERATION_INDEX], errorLineNumber));

    }

    if (HelperMethods.isValidDate(
            splitHeader[HeaderConstants.START_DATE_INDEX], HeaderConstants.dateFormatter)
        == false) {

      throw new InvalidFieldException(
          HeaderErrorMessages.invalidDate(
              splitHeader[HeaderConstants.START_DATE_INDEX], errorLineNumber));
    }

    if (HelperMethods.isValidDate(
            splitHeader[HeaderConstants.END_DATE_INDEX], HeaderConstants.dateFormatter)
        == false) {

      throw new InvalidFieldException(
          HeaderErrorMessages.invalidDate(
              splitHeader[HeaderConstants.END_DATE_INDEX], errorLineNumber));
    }

    return true;
  }

   private boolean isValidRecordIdentifier(String[] splitheader) {

    if (!splitheader[ItemConstants.RECORD_IDENTIFIER_INDEX].equals(HeaderConstants.RECORD_IDENTIFIER)) {

      return false;
    }

    return true;
  }

 private boolean isValidSpecificationVersion(String[] splitHeader) {

   if (splitHeader[HeaderConstants.SPECIFICATION_VERSION_INDEX].length() > 7) {


     return false;
   }

   if (HelperMethods.parseDoubleWithComma(splitHeader[HeaderConstants.SPECIFICATION_VERSION_INDEX]) == 0.0){


     return false;
   }

    return true;
  }

  @Override
  public Header create(String[] splitHeader, long lineNumber) {

    Header header = null;
    long errorLineNumber = lineNumber;

    // Check if all the required fields for Substance are present, according to FileSpec.
    // If not, throw exception.
    if (hasAllRequiredFields(splitHeader) == false) {
      throw new MissingFieldException(
          "A field is missing from the Header record at line: "
              + errorLineNumber
              + "Please verify the completess of the"
              + " record."
              + splitHeader);
    }

    // Check if individual fields are valid according to FileSpec specifications.
    // If yes, build Substance object, if not, throw exception.
    if (allFieldsAreValid(splitHeader, errorLineNumber) == true) {

      // Build Header object
      char recordIdentifier = splitHeader[ItemConstants.RECORD_IDENTIFIER_INDEX].charAt(0);
      Header.setRecordIdentifier(recordIdentifier);

      String dataFileIdentifier = splitHeader[HeaderConstants.DATA_FILE_IDENTIFIER_INDEX];
      double specificationVersion =
          HelperMethods.parseDoubleWithComma(splitHeader[HeaderConstants.SPECIFICATION_VERSION_INDEX]);
      LocalDate dateOfGeneration =
          LocalDate.parse(splitHeader[HeaderConstants.DATE_OF_FILE_GENERATION_INDEX], HeaderConstants.dateFormatter);
      LocalTime time = LocalTime.parse(splitHeader[HeaderConstants.TIME_OF_FILE_GENERATION_INDEX]);
      LocalDate startDate = LocalDate.parse(splitHeader[HeaderConstants.START_DATE_INDEX], HeaderConstants.dateFormatter);
      LocalDate endDate = LocalDate.parse(splitHeader[HeaderConstants.END_DATE_INDEX], HeaderConstants.dateFormatter);

      header =
          new Header(
              dataFileIdentifier, specificationVersion, dateOfGeneration, time, startDate, endDate);
    }
    return header;
  }

  @Override
  public boolean hasAllRequiredFields(String[] splitItemLine) {

    if (splitItemLine.length == HeaderConstants.TOTAL_FIELDS) {
      return true;
    }

    return false;
  }
}
