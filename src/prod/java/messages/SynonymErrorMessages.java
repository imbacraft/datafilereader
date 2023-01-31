package messages;

import constants.SynonymConstants;

public class SynonymErrorMessages {

  public static String invalidRecordIdentifier(String string, long errorLineNumber) {

    return "At least the Synonym Record Identifier of the synonym entry at line: "
        + errorLineNumber
        + " is malformed. Expected "
        + SynonymConstants.RECORD_IDENTIFIER_MAX_CHAR_NUMBER
        + " char but got: "
        + string
        + ".";
  }

  public static String invalidNodeID(String string, long errorLineNumber) {

    return "At least the Synonym Node ID of the synonym entry at line: "
        + errorLineNumber
        + " is malformed. Expected maximum "
        + SynonymConstants.NODEID_MAX_DIGITS
        + " digits but got: "
        + string
        + ".";
  }

  public static String invalidSynonymID(String string, long errorLineNumber) {

    return "At least the Synonym ID of the synonym entry at line: "
        + errorLineNumber
        + " is malformed. Expected maximum "
        + SynonymConstants.SYNONYM_ID_MAX_DIGITS
        + " digits but got: "
        + string
        + ".";
  }

  public static String invalidISOLanguage(String string, long errorLineNumber) {

    return "At least the Synonym ISO Language of the synonym entry at line: "
        + errorLineNumber
        + " is malformed. Expected maximum "
        + SynonymConstants.ISO_LANGUAGE_MAX_CHARACTERS
        + " characters but got: "
        + string
        + ".";
  }

  public static String invalidSynonymName(
      String string, long errorLineNumber) {

    return "At least the Synonym Name of the synonym entry at line: "
        + errorLineNumber
        + " is malformed. Expected maximum "
        + SynonymConstants.SYNONYM_NAME_MAX_CHARACTERS
        + " characters but got: "
        + string
        + ".";
  }


}
