package Library;

public class Constants {

  // GENERAL
  // Based on FileSpec_1.1.pdf, section 3.1: "Empty text fields contain no character, even no
  // spaces." Therefore one emptyIdentifier is "".
  // Based on Substances.dat file, another way to denote that a field is notAvailable is dash (-)
  // e.g. in CAS Code, EU Index Code etc.
  public static final String[] emptyIdentifierList = {"", "-"};
  public static final String NOT_AVAILABLE = "notAvailable";

  // Index of record identifier for all possible items
  public static final short RECORD_IDENTIFIER_INDEX = 0;

  // =========
  // SUBSTANCE
  // =========
  public static final short SUBSTANCE_FIELDS = 11;

  // indexes
  public static final short SUBSTANCE_NODE_ID_INDEX = 1;
  public static final short SUBSTANCE_CAS_CODE_INDEX = 2;
  public static final short SUBSTANCE_EU_CODE_INDEX = 3;
  public static final short SUBSTANCE_EINECS_ELINCS_CODE_INDEX = 4;
  public static final short SUBSTANCE_DUTY_TO_DECLARE_INDEX = 5;
  public static final short SUBSTANCE_IS_UNWANTED_INDEX = 6;
  public static final short SUBSTANCE_IS_PROHIBITED_INDEX = 7;
  public static final short SUBSTANCE_IS_REACH_INDEX = 8;
  public static final short SUBSTANCE_IS_DELETED_INDEX = 9;
  public static final short SUBSTANCE_IS_HIDDEN_INDEX = 10;

  // isUnwanted unspecified
  // In section 3.3.2 of the FileSpec 1.1 it is stated that: "In 2001 the field "IsUnwanted" has
  // been removed from the ILRS (former VDA) classifications. For that reason newer substances have
  // an "IsUnwanted" value of "-1" (unspecified)."
  public static final String IS_UNWANTED_UNSPECIFIED = "unspecified";

  // Field qualifications
  public static final short SUBSTANCE_RECORD_IDENTIFIER_CHAR_NUMBER = 1;
  public static final short SUBSTANCE_NODEID_DIGITS = 18;
  public static final short SUBSTANCE_CAS_CODE_MAX_CHARACTERS = 20;
  public static final short SUBSTANCE_EU_CODE_MAX_CHARACTERS = 20;
  public static final short SUBSTANCE_EINECS_ELINCS_CODE_MAX_CHARACTERS = 20;
}
