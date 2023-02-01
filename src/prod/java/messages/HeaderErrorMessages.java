package messages;

import constants.HeaderConstants;

public class HeaderErrorMessages {

      public static String invalidRecordIdentifier(String string, long errorLineNumber) {

    return "At least the Header Record Identifier of the header at line: "
        + errorLineNumber
        + " is malformed. Expected "
        + HeaderConstants.RECORD_IDENTIFIER
        + " char but got: "
        + string
        + ".";
  }

  public static String invalidDate(String string, long errorLineNumber) {

    return "At least the Date of the Header entry at line: "
        + errorLineNumber
        + " is malformed. Expected a date of the format DD.MM.YYYY "
        + "but got: "
        + string
        + ".";
  }

  public static String invalidTime(String string, long errorLineNumber) {

    return "At least the Time of the Header entry at line: "
        + errorLineNumber
        + " is malformed. Expected a time of the format HH:MM:SS "
        + "but got: "
        + string
        + ".";
  }

public static String invalidSpecificationVersion(String string, long errorLineNumber) {

    return "At least the Specification Version of the Header entry at line: "
        + errorLineNumber
        + " is malformed. Expected a double with max 5 digits before decimal point and 2 digits after decimal point "
        + "but got: "
        + string
        + ".";
  }

}
