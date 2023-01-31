package constants;

public class SynonymConstants extends Constants {

  public static final short TOTAL_FIELDS = 5;
  public static final String[] ISO_LANGUAGES = {"EN","DE"}; //More ISO languages can be added later

  //indexes
  public static final short NODE_ID_INDEX = 1;
  public static final short SYNONYM_ID_INDEX = 2;
  public static final short ISO_LANGUAGE_INDEX = 3;
  public static final short SYNONYM_NAME_INDEX = 4;

  // Field qualifications
  public static final short RECORD_IDENTIFIER_MAX_CHAR_NUMBER = 2;
  public static final short NODEID_MAX_DIGITS = 18;
  public static final short SYNONYM_ID_MAX_DIGITS = 4;
  public static final short ISO_LANGUAGE_MAX_CHARACTERS = 2;
  public static final short SYNONYM_NAME_MAX_CHARACTERS = 250;



}
