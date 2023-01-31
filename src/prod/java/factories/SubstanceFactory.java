package factories;

import Library.Constants;
import Library.HelperMethods;
import entities.Substance;
import exceptions.InvalidFieldException;
import exceptions.MissingFieldException;
import java.util.ArrayList;
import java.util.List;
import messages.SubstanceErrorMessages;

public class SubstanceFactory implements FactoryInterface<Substance> {

  public static List<Substance> substanceList = new ArrayList<>();

  @Override
  public Substance create(String[] splitBlock, long lineNumber) {

    // Create Substance reference to be used later.
    Substance substance = null;
    long errorLineNumber;

    // The first line of the block corresponds to Substance.
    // Therefore, split the first line and get the individual fields of the
    // Substance.
    String[] splitSubstance = splitBlock[0].split("\t");

    // If an error is present on this first line, it will be lineNumber minus the lines of the block
    // plus 1 to get the first line of the block.
    errorLineNumber = lineNumber - splitBlock.length + 1;

    // Check if all the required fields for Substance are present, according to FileSpec.
    // If not, throw exception.
    if (hasAllRequiredFields(splitSubstance) == false) {
      throw new MissingFieldException(
          "A field is missing from the Substance record at line: "
              + errorLineNumber
              + "Please verify the completess of the"
              + " record."
              + splitSubstance);
    }

    // Check if individual fields are valid according to FileSpec specifications.
    // If yes, build Substance object, if not, throw exception.
    if (allFieldsAreValid(splitSubstance, errorLineNumber) == true) {

      // Build Substance object
      char substanceIdentifier = splitSubstance[Constants.RECORD_IDENTIFIER_INDEX].charAt(0);
      Substance.setRecordIdentifier(substanceIdentifier);

      long substanceNodeID = Long.parseLong(splitSubstance[Constants.SUBSTANCE_NODE_ID_INDEX]);
      String casCode =
          HelperMethods.checkForFieldAvailability(
              splitSubstance[Constants.SUBSTANCE_CAS_CODE_INDEX]);
      String euIndexCode =
          HelperMethods.checkForFieldAvailability(
              splitSubstance[Constants.SUBSTANCE_EU_CODE_INDEX]);
      String einecsOrElincsCode =
          HelperMethods.checkForFieldAvailability(
              splitSubstance[Constants.SUBSTANCE_EINECS_ELINCS_CODE_INDEX]);
      boolean dutyToDeclare =
          HelperMethods.parseStringToBoolean(
              splitSubstance[Constants.SUBSTANCE_DUTY_TO_DECLARE_INDEX]);
      String isUnwanted =
          convertIsUnwantedNumericalsToWords(splitSubstance[Constants.SUBSTANCE_IS_UNWANTED_INDEX]);
      boolean isProhibited =
          HelperMethods.parseStringToBoolean(
              splitSubstance[Constants.SUBSTANCE_IS_PROHIBITED_INDEX]);
      boolean isReach =
          HelperMethods.parseStringToBoolean(splitSubstance[Constants.SUBSTANCE_IS_REACH_INDEX]);
      boolean isDeleted =
          HelperMethods.parseStringToBoolean(splitSubstance[Constants.SUBSTANCE_IS_DELETED_INDEX]);
      boolean isHidden =
          HelperMethods.parseStringToBoolean(splitSubstance[Constants.SUBSTANCE_IS_HIDDEN_INDEX]);

      substance =
          new Substance(
              substanceNodeID,
              casCode,
              euIndexCode,
              einecsOrElincsCode,
              dutyToDeclare,
              isUnwanted,
              isProhibited,
              isReach,
              isDeleted,
              isHidden);
    }

    return substance;
  }

  @Override
  public boolean hasAllRequiredFields(String[] splitItemLine) {

    if (splitItemLine.length == Constants.SUBSTANCE_FIELDS) {
      return true;
    }

    return false;
  }

  @Override
  public boolean allFieldsAreValid(String[] splitSubstance, long errorLineNumber) {

    if (isValidRecordIdentifier(splitSubstance) == false) {

      throw new InvalidFieldException(
          SubstanceErrorMessages.invalidRecordIdentifier(
              splitSubstance[Constants.RECORD_IDENTIFIER_INDEX], errorLineNumber));
    }

    if (isValidNodeID(splitSubstance) == false) {

      throw new InvalidFieldException(
          SubstanceErrorMessages.invalidNodeID(
              splitSubstance[Constants.SUBSTANCE_NODE_ID_INDEX], errorLineNumber));
    }

    if (isValidCASCode(splitSubstance) == false) {
      throw new InvalidFieldException(
          SubstanceErrorMessages.invalidCASCode(
              splitSubstance[Constants.SUBSTANCE_CAS_CODE_INDEX], errorLineNumber));
    }

    if (isValidEUIndexCode(splitSubstance) == false) {
      throw new InvalidFieldException(
          SubstanceErrorMessages.invalidEUCode(
              splitSubstance[Constants.SUBSTANCE_EU_CODE_INDEX], errorLineNumber));
    }

    if (isValidEinecsOrElincsCode(splitSubstance) == false) {
      throw new InvalidFieldException(
          SubstanceErrorMessages.invalidEinecsOrElincsCode(
              splitSubstance[Constants.SUBSTANCE_EINECS_ELINCS_CODE_INDEX], errorLineNumber));
    }

    if (isValidDutyToDeclareField(splitSubstance) == false) {
      throw new InvalidFieldException(
          SubstanceErrorMessages.invalidDutyToDeclare(
              splitSubstance[Constants.SUBSTANCE_DUTY_TO_DECLARE_INDEX], errorLineNumber));
    }

    if (isValidIsUnwantedField(splitSubstance) == false) {
      throw new InvalidFieldException(
          SubstanceErrorMessages.invalidIsUnwanted(
              splitSubstance[Constants.SUBSTANCE_IS_UNWANTED_INDEX], errorLineNumber));
    }

    if (isValidIsProhibitedField(splitSubstance) == false) {
      throw new InvalidFieldException(
          SubstanceErrorMessages.invalidIsProhibited(
              splitSubstance[Constants.SUBSTANCE_IS_PROHIBITED_INDEX], errorLineNumber));
    }

    if (isValidIsReachField(splitSubstance) == false) {
      throw new InvalidFieldException(
          SubstanceErrorMessages.invalidIsReach(
              splitSubstance[Constants.SUBSTANCE_IS_REACH_INDEX], errorLineNumber));
    }

    if (isValidIsDeletedField(splitSubstance) == false) {
      throw new InvalidFieldException(
          SubstanceErrorMessages.invalidIsDeleted(
              splitSubstance[Constants.SUBSTANCE_IS_DELETED_INDEX], errorLineNumber));
    }

    if (isValidIsHiddenField(splitSubstance) == false) {
      throw new InvalidFieldException(
          SubstanceErrorMessages.invalidIsHidden(
              splitSubstance[Constants.SUBSTANCE_IS_HIDDEN_INDEX], errorLineNumber));
    }

    if (isDeletedAndIsHiddenAreNotBothTrue(
            splitSubstance[Constants.SUBSTANCE_IS_DELETED_INDEX],
            splitSubstance[Constants.SUBSTANCE_IS_HIDDEN_INDEX])
        == false) {
      throw new InvalidFieldException(
          SubstanceErrorMessages.bothIsDeletedAndIsHiddenAreTrue(errorLineNumber));
    }

    return true;
  }

  @Override
  public void addToItemList(Substance item) {

    this.substanceList.add(item);
  }

  private boolean isValidRecordIdentifier(String[] splitSubstance) {

    if (splitSubstance[Constants.RECORD_IDENTIFIER_INDEX].length()
        != Constants.SUBSTANCE_RECORD_IDENTIFIER_CHAR_NUMBER) {

      return false;
    }

    return true;
  }

  private boolean isValidNodeID(String[] splitSubstance) {

    if (HelperMethods.stringIsNotNullorEmptyAndContainsOnlyDigits(
            splitSubstance[Constants.SUBSTANCE_NODE_ID_INDEX])
        == false) {

      return false;
    }

    if (splitSubstance[Constants.SUBSTANCE_NODE_ID_INDEX].length()
        > Constants.SUBSTANCE_NODEID_DIGITS) {

      return false;
    }

    return true;
  }

  private boolean isValidCASCode(String[] splitSubstance) {

    if (splitSubstance[Constants.SUBSTANCE_CAS_CODE_INDEX].length()
        <= Constants.SUBSTANCE_CAS_CODE_MAX_CHARACTERS) {

      return true;
    }

    return false;
  }

  private boolean isValidEUIndexCode(String[] splitSubstance) {

    if (splitSubstance[Constants.SUBSTANCE_EU_CODE_INDEX].length()
        <= Constants.SUBSTANCE_EU_CODE_MAX_CHARACTERS) {

      return true;
    }

    return false;
  }

  private boolean isValidEinecsOrElincsCode(String[] splitSubstance) {

    if (splitSubstance[Constants.SUBSTANCE_EINECS_ELINCS_CODE_INDEX].length()
        <= Constants.SUBSTANCE_EINECS_ELINCS_CODE_MAX_CHARACTERS) {

      return true;
    }

    return false;
  }

  private boolean isValidDutyToDeclareField(String[] splitSubstance) {

    String dutyToDeclare = splitSubstance[Constants.SUBSTANCE_DUTY_TO_DECLARE_INDEX];
    return dutyToDeclare != null && (dutyToDeclare.equals("0") || dutyToDeclare.equals("1"));
  }

  private boolean isValidIsUnwantedField(String[] splitSubstance) {

    String isUnwanted = splitSubstance[Constants.SUBSTANCE_IS_UNWANTED_INDEX];
    return isUnwanted != null
        && (isUnwanted.equals("0") || isUnwanted.equals("1") || isUnwanted.equals("-1"));
  }

  private boolean isValidIsProhibitedField(String[] splitSubstance) {

    String isProhibited = splitSubstance[Constants.SUBSTANCE_IS_PROHIBITED_INDEX];
    return isProhibited != null && (isProhibited.equals("0") || isProhibited.equals("1"));
  }

  private boolean isValidIsReachField(String[] splitSubstance) {

    String isReach = splitSubstance[Constants.SUBSTANCE_IS_REACH_INDEX];
    return isReach != null && (isReach.equals("0") || isReach.equals("1"));
  }

  private boolean isValidIsDeletedField(String[] splitSubstance) {

    String isDeleted = splitSubstance[Constants.SUBSTANCE_IS_DELETED_INDEX];
    return isDeleted != null && (isDeleted.equals("0") || isDeleted.equals("1"));
  }

  private boolean isValidIsHiddenField(String[] splitSubstance) {

    String isHidden = splitSubstance[Constants.SUBSTANCE_IS_HIDDEN_INDEX];

    return isHidden != null && (isHidden.equals("0") || isHidden.equals("1"));
  }

  // According to FileSpec1.1, section 3.3.2:
  // Either “IsDeleted” or “IsHidden” can possess value “1”, never both at the same time (but both
  // can be “0” of course).
  private boolean isDeletedAndIsHiddenAreNotBothTrue(String isDeleted, String isHidden) {

    return !(isDeleted.equals("1") && isHidden.equals("1"));
  }

  // In section 3.3.2 of the FileSpec 1.1 it is stated that: "In 2001 the field "IsUnwanted" has
  // been removed from the ILRS (former VDA) classifications. For that reason newer substances have
  // an "IsUnwanted" value of "-1" (unspecified)."
  private String convertIsUnwantedNumericalsToWords(String isUnwantedNumerical) {

    if ("0".equals(isUnwantedNumerical)) {
      return "false";
    }

    if ("1".equals(isUnwantedNumerical)) {
      return "true";
    }

    if ("-1".equals(isUnwantedNumerical)) {
      return Constants.IS_UNWANTED_UNSPECIFIED;
    }

    throw new IllegalArgumentException("Parsed value is neither 0 nor 1 nor -1.");
  }
}
