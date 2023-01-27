package Library;

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

  public static short parseStringToThreeValuedBoolean(String string) {

    int parseResult = Integer.parseInt(string);

    if (parseResult == 0) {
      return 0;
    }

    if (parseResult == 1) {
      return 0;
    }

    if (parseResult == -1) {
      return -1;
    }

    throw new IllegalArgumentException("Parsed value is neither 0 nor 1 nor -1.");
  }

  public static String checkForFieldAvailability(String field) {

    for (String emptyIdentifier : Constants.emptyIdentifierList) {

      if (field.equals(emptyIdentifier)) {
        return Constants.NOT_AVAILABLE;
      }
    }
    return field;
  }
}
