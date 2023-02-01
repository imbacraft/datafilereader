package constants;

import java.time.format.DateTimeFormatter;

public class HeaderConstants extends ItemConstants {

    public static final short TOTAL_FIELDS = 7;
    public static final String RECORD_IDENTIFIER = "#";
    public static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    //indexes
    public static final short DATA_FILE_IDENTIFIER_INDEX = 1;
    public static final short SPECIFICATION_VERSION_INDEX = 2;
    public static final short DATE_OF_FILE_GENERATION_INDEX = 3;
    public static final short TIME_OF_FILE_GENERATION_INDEX = 4;
    public static final short START_DATE_INDEX = 5;
    public static final short END_DATE_INDEX = 6;
	public class dateFormatter {
	}


}
