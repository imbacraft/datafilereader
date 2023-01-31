package utils;

import constants.Constants;
import constants.SubstanceConstants;

public class HelperMethods {

  public static boolean parseStringToBoolean(String string) {

    int parseResult = Integer.parseInt(string);

    if (parseResult == 0) {
      return false;
    }

    if (parseResult == 1) {
      return true;
    }

    throw new IllegalArgumentException("Parsed value is neither 0 nor 1.");
  }

  public static String checkForFieldAvailability(String field) {

    for (String emptyIdentifier : SubstanceConstants.emptyIdentifierList) {

      if (field.equals(emptyIdentifier)) {
        return Constants.NOT_AVAILABLE;
      }
    }
    return field;
  }

  public static boolean stringIsNotNullorEmptyAndContainsOnlyDigits(String string) {
    return string != null && !string.isEmpty() && string.matches("-?\\d+");
  }

  public static boolean stringIsNotNullorEmpty(String string){
    return string != null && !string.isEmpty();
  }
}
