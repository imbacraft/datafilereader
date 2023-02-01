package utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import constants.ItemConstants;
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
        return ItemConstants.NOT_AVAILABLE;
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


public static boolean isValidDate(String date, DateTimeFormatter dateFormatter) {

    try {
        // Try to parse the date string using the defined pattern
        LocalDate.parse(date, dateFormatter);
        return true;
    } catch (DateTimeParseException e) {
        // Return false if the parsing fails
        return false;
    }
}

  public static boolean isValidTime(String time, DateTimeFormatter timeFormatter) {

    try {
        // Try to parse the time string using the defined pattern
        LocalTime.parse(time, timeFormatter);
        return true;
    } catch (DateTimeParseException e) {
        // Return false if the parsing fails
        return false;
    }
}



public static double parseDoubleWithComma(String doubleString) {
    try {
        // Replace the comma with a dot
        doubleString = doubleString.replace(',', '.');


        // Try to parse the string into a double
        return Double.parseDouble(doubleString);
    } catch (NumberFormatException e) {
        // Return 0 if the parsing fails
        return 0.0;
    }
}

}
