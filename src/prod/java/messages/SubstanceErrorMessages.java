package messages;

import constants.SubstanceConstants;

public class SubstanceErrorMessages {

  public static String invalidRecordIdentifier(String string, long errorLineNumber) {

    return "At least the Substance Record Identifier of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected "
        + SubstanceConstants.RECORD_IDENTIFIER_CHAR_NUMBER
        + " char but got: "
        + string
        + ".";
  }

  public static String invalidNodeID(String string, long errorLineNumber) {

    return "At least the Substance Node ID of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected maximum "
        + SubstanceConstants.NODEID_DIGITS
        + " digits but got: "
        + string
        + ".";
  }

  public static String invalidCASCode(String string, long errorLineNumber) {

    return "At least the Substance CAS Code of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected maximum "
        + SubstanceConstants.CAS_CODE_MAX_CHARACTERS
        + " characters but got: "
        + string
        + ".";
  }

  public static String invalidEUCode(String string, long errorLineNumber) {

    return "At least the Substance EU Index Code of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected maximum "
        + SubstanceConstants.EU_CODE_MAX_CHARACTERS
        + " characters but got: "
        + string
        + ".";
  }

  public static String invalidEinecsOrElincsCode(
      String string, long errorLineNumber) {

    return "At least the Substance EINECS or ELINCS Code of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected maximum "
        + SubstanceConstants.EINECS_ELINCS_CODE_MAX_CHARACTERS
        + " characters but got: "
        + string
        + ".";
  }

  public static String invalidDutyToDeclare(String string, long errorLineNumber) {

    return "At least the Substance dutyToDeclare field of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected zero or one, but got: "
        + string
        + ".";
  }

  public static String invalidIsUnwanted(String string, long errorLineNumber) {

    return "At least the Substance isUnwanted field of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected zero or one or minus one, but got: "
        + string
        + ".";
  }

  public static String invalidIsProhibited(String string, long errorLineNumber) {

    return "At least the Substance isProhibited field of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected zero or one, but got: "
        + string
        + ".";
  }

  public static String invalidIsReach(String string, long errorLineNumber) {

    return "At least the Substance isReach field of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected zero or one, but got: "
        + string
        + ".";
  }

  public static String invalidIsDeleted(String string, long errorLineNumber) {

    return "At least the Substance isDeleted field of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected zero or one, but got: "
        + string
        + ".";
  }

  public static String invalidIsHidden(String string, long errorLineNumber) {

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
