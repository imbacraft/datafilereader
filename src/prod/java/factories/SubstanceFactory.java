package factories;

import Library.Constants;
import Library.HelperMethods;
import entities.Substance;
import exceptions.InvalidFieldException;
import exceptions.MissingFieldException;
import java.util.ArrayList;
import java.util.List;
import messages.Messages;

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
      short isUnwanted =
          HelperMethods.parseStringToThreeValuedBoolean(
              splitSubstance[Constants.SUBSTANCE_IS_UNWANTED_INDEX]);
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
          Messages.invalidSubstanceRecordIdentifierField(
              splitSubstance[Constants.RECORD_IDENTIFIER_INDEX], errorLineNumber));
    }

    if (isValidNodeID(splitSubstance) == false) {

      throw new InvalidFieldException(
          Messages.invalidSubstanceNodeIDField(
              splitSubstance[Constants.SUBSTANCE_NODE_ID_INDEX], errorLineNumber));
    }

    if (isValidCASCode(splitSubstance) == false) {
      throw new InvalidFieldException(
          Messages.invalidSubstanceCASCodeField(
              splitSubstance[Constants.SUBSTANCE_CAS_CODE_INDEX], errorLineNumber));
    }

    if (isValidEUIndexCode(splitSubstance) == false) {
      throw new InvalidFieldException(
          Messages.invalidSubstanceEUCodeField(
              splitSubstance[Constants.SUBSTANCE_EU_CODE_INDEX], errorLineNumber));
    }

    if (isValidEinecsOrElincsCode(splitSubstance) == false) {
      throw new InvalidFieldException(
          Messages.invalidSubstanceEinecsOrElincsCodeField(
              splitSubstance[Constants.SUBSTANCE_EINECS_ELINCS_CODE_INDEX], errorLineNumber));
    }

    if (isValidDutyToDeclareField(splitSubstance) == false) {
      throw new InvalidFieldException(
          Messages.invalidSubstanceDutyToDeclareField(
              splitSubstance[Constants.SUBSTANCE_DUTY_TO_DECLARE_INDEX], errorLineNumber));
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

    String duty = splitSubstance[Constants.SUBSTANCE_DUTY_TO_DECLARE_INDEX];
    return duty != null && (duty.equals("0") || duty.equals("1"));

  }
}
