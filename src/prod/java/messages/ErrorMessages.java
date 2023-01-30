package messages;

import Library.Constants;

public class ErrorMessages {

  public static String invalidSubstanceRecordIdentifierField(String string, long errorLineNumber) {

    return "At least the Substance Record Identifier of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected "
        + Constants.SUBSTANCE_RECORD_IDENTIFIER_CHAR_NUMBER
        + " char but got: "
        + string
        + ".";
  }

  public static String invalidSubstanceNodeIDField(String string, long errorLineNumber) {

    return "At least the Substance Node ID of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected maximum "
        + Constants.SUBSTANCE_NODEID_DIGITS
        + " digits but got: "
        + string
        + ".";
  }

  public static String invalidSubstanceCASCodeField(String string, long errorLineNumber) {

    return "At least the Substance CAS Code of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected maximum "
        + Constants.SUBSTANCE_CAS_CODE_MAX_CHARACTERS
        + " characters but got: "
        + string
        + ".";
  }

  public static String invalidSubstanceEUCodeField(String string, long errorLineNumber) {

    return "At least the Substance EU Index Code of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected maximum "
        + Constants.SUBSTANCE_EU_CODE_MAX_CHARACTERS
        + " characters but got: "
        + string
        + ".";
  }

  public static String invalidSubstanceEinecsOrElincsCodeField(
      String string, long errorLineNumber) {

    return "At least the Substance EINECS or ELINCS Code of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected maximum "
        + Constants.SUBSTANCE_EINECS_ELINCS_CODE_MAX_CHARACTERS
        + " characters but got: "
        + string
        + ".";
  }

  public static String invalidSubstanceDutyToDeclareField(String string, long errorLineNumber) {

    return "At least the Substance dutyToDeclare field of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected zero or one, but got: "
        + string
        + ".";
  }

  public static String invalidSubstanceIsUnwantedField(String string, long errorLineNumber) {

    return "At least the Substance isUnwanted field of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected zero or one or minus one, but got: "
        + string
        + ".";
  }

  public static String invalidSubstanceIsProhibitedField(String string, long errorLineNumber) {

    return "At least the Substance isProhibited field of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected zero or one, but got: "
        + string
        + ".";
  }

  public static String invalidSubstanceIsReachField(String string, long errorLineNumber) {

    return "At least the Substance isReach field of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected zero or one, but got: "
        + string
        + ".";
  }

  public static String invalidSubstanceIsDeletedField(String string, long errorLineNumber) {

    return "At least the Substance isDeleted field of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected zero or one, but got: "
        + string
        + ".";
  }

  public static String invalidSubstanceIsHiddenField(String string, long errorLineNumber) {

    return "At least the Substance isHidden field of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected zero or one, but got: "
        + string
        + ".";
    }

  public static String bothIsDeletedAndIsHiddenAreTrue(long errorLineNumber) {

    return "The isHidden and isDeleted fields of the substance entry at line: "
        + errorLineNumber
        + " are both true (1). Either “IsDeleted” or “IsHidden” can possess value “1”, never both at the same time (but both can be “0” of course).";
    }



}
