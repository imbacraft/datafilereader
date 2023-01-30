package factories;

import Library.Constants;
import Library.HelperMethods;
import entities.Substance;
import exceptions.InvalidFieldException;
import exceptions.MissingFieldException;
import java.util.ArrayList;
import java.util.List;
import messages.ErrorMessages;

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
          ErrorMessages.invalidSubstanceRecordIdentifierField(
              splitSubstance[Constants.RECORD_IDENTIFIER_INDEX], errorLineNumber));
    }

    if (isValidNodeID(splitSubstance) == false) {

      throw new InvalidFieldException(
          ErrorMessages.invalidSubstanceNodeIDField(
              splitSubstance[Constants.SUBSTANCE_NODE_ID_INDEX], errorLineNumber));
    }

    if (isValidCASCode(splitSubstance) == false) {
      throw new InvalidFieldException(
          ErrorMessages.invalidSubstanceCASCodeField(
              splitSubstance[Constants.SUBSTANCE_CAS_CODE_INDEX], errorLineNumber));
    }

    if (isValidEUIndexCode(splitSubstance) == false) {
      throw new InvalidFieldException(
          ErrorMessages.invalidSubstanceEUCodeField(
              splitSubstance[Constants.SUBSTANCE_EU_CODE_INDEX], errorLineNumber));
    }

    if (isValidEinecsOrElincsCode(splitSubstance) == false) {
      throw new InvalidFieldException(
          ErrorMessages.invalidSubstanceEinecsOrElincsCodeField(
              splitSubstance[Constants.SUBSTANCE_EINECS_ELINCS_CODE_INDEX], errorLineNumber));
    }

    if (isValidDutyToDeclareField(splitSubstance) == false) {
      throw new InvalidFieldException(
          ErrorMessages.invalidSubstanceDutyToDeclareField(
              splitSubstance[Constants.SUBSTANCE_DUTY_TO_DECLARE_INDEX], errorLineNumber));
    }

    if (isValidIsUnwantedField(splitSubstance) == false) {
      throw new InvalidFieldException(
          ErrorMessages.invalidSubstanceIsUnwantedField(
              splitSubstance[Constants.SUBSTANCE_IS_UNWANTED_INDEX], errorLineNumber));
    }

    if (isValidIsProhibitedField(splitSubstance) == false) {
      throw new InvalidFieldException(
          ErrorMessages.invalidSubstanceIsProhibitedField(
              splitSubstance[Constants.SUBSTANCE_IS_PROHIBITED_INDEX], errorLineNumber));
    }

    if (isValidIsReachField(splitSubstance) == false) {
      throw new InvalidFieldException(
          ErrorMessages.invalidSubstanceIsReachField(
              splitSubstance[Constants.SUBSTANCE_IS_REACH_INDEX], errorLineNumber));
    }

    if (isValidIsDeletedField(splitSubstance) == false) {
      throw new InvalidFieldException(
          ErrorMessages.invalidSubstanceIsDeletedField(
              splitSubstance[Constants.SUBSTANCE_IS_DELETED_INDEX], errorLineNumber));
    }

    if (isValidIsHiddenField(splitSubstance) == false) {
      throw new InvalidFieldException(
          ErrorMessages.invalidSubstanceIsHiddenField(
              splitSubstance[Constants.SUBSTANCE_IS_HIDDEN_INDEX], errorLineNumber));
    }

    if (isDeletedAndIsHiddenAreNotBothTrue(
            splitSubstance[Constants.SUBSTANCE_IS_DELETED_INDEX],
            splitSubstance[Constants.SUBSTANCE_IS_HIDDEN_INDEX])
        == false) {
      throw new InvalidFieldException(
          ErrorMessages.bothIsDeletedAndIsHiddenAreTrue(errorLineNumber));
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

  private boolean isDeletedAndIsHiddenAreNotBothTrue(String isDeleted, String isHidden) {

    return !(isDeleted.equals("1") && isHidden.equals("1"));
  }
}
