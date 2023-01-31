package constants;

public class SubstanceConstants extends Constants {

  // GENERAL
  // Based on FileSpec_1.1.pdf, section 3.1: "Empty text fields contain no character, even no
  // spaces." Therefore one emptyIdentifier is "".
  // Based on Substances.dat file, another way to denote that a field is notAvailable is dash (-)
  // e.g. in CAS Code, EU Index Code etc.
  public static final String[] emptyIdentifierList = {"", "-"};


  public static final short TOTAL_FIELDS = 11;

  // indexes
  public static final short NODE_ID_INDEX = 1;
  public static final short CAS_CODE_INDEX = 2;
  public static final short EU_CODE_INDEX = 3;
  public static final short EINECS_ELINCS_CODE_INDEX = 4;
  public static final short DUTY_TO_DECLARE_INDEX = 5;
  public static final short IS_UNWANTED_INDEX = 6;
  public static final short IS_PROHIBITED_INDEX = 7;
  public static final short IS_REACH_INDEX = 8;
  public static final short IS_DELETED_INDEX = 9;
  public static final short IS_HIDDEN_INDEX = 10;

  // isUnwanted unspecified
  // In section 3.3.2 of the FileSpec 1.1 it is stated that: "In 2001 the field "IsUnwanted" has
  // been removed from the ILRS (former VDA) classifications. For that reason newer substances have
  // an "IsUnwanted" value of "-1" (unspecified)."
  public static final String IS_UNWANTED_UNSPECIFIED = "unspecified";

  // Field qualifications
  public static final short RECORD_IDENTIFIER_CHAR_NUMBER = 1;
  public static final short NODEID_DIGITS = 18;
  public static final short CAS_CODE_MAX_CHARACTERS = 20;
  public static final short EU_CODE_MAX_CHARACTERS = 20;
  public static final short EINECS_ELINCS_CODE_MAX_CHARACTERS = 20;



}
