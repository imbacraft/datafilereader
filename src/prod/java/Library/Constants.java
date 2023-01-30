package Library;

public class Constants {

    //GENERAL
    public static String[] emptyIdentifierList = {" ", "-"};
    public static String NOT_AVAILABLE = "notAvailable";

    //Index of record identifier for all possible items
    public static short RECORD_IDENTIFIER_INDEX = 0;

    //=========
    //SUBSTANCE
    //=========
    public static short SUBSTANCE_FIELDS = 11;
    //index numbers
    public static short SUBSTANCE_NODE_ID_INDEX = 1;
    public static short SUBSTANCE_CAS_CODE_INDEX = 2;
    public static short SUBSTANCE_EU_CODE_INDEX = 3;
    public static short SUBSTANCE_EINECS_ELINCS_CODE_INDEX = 4;
    public static short SUBSTANCE_DUTY_TO_DECLARE_INDEX = 5;
    public static short SUBSTANCE_IS_UNWANTED_INDEX = 6;
    public static short SUBSTANCE_IS_PROHIBITED_INDEX = 7;
    public static short SUBSTANCE_IS_REACH_INDEX = 8;
    public static short SUBSTANCE_IS_DELETED_INDEX = 9;
    public static short SUBSTANCE_IS_HIDDEN_INDEX = 10;


    //Field qualifications
    public static short SUBSTANCE_RECORD_IDENTIFIER_CHAR_NUMBER = 1;
    public static short SUBSTANCE_NODEID_DIGITS = 18;
    public static short SUBSTANCE_CAS_CODE_MAX_DIGITS = 20;



}
