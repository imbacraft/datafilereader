package messages;

import Library.Constants;

public class Messages {

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

  public static String invalidSubstanceDutyToDeclareField (
      String string, long errorLineNumber) {

    return "At least the Substance dutyToDeclare field of the substance entry at line: "
        + errorLineNumber
        + " is malformed. Expected zero or one, but got: "
        + string
        + ".";
  }

}
