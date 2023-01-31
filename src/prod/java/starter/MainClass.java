package starter;

import constants.FilePaths;
import filereader.DataFileReader;

public class MainClass {
    public static void main( String[] args ) {

        DataFileReader reader = new DataFileReader();

        reader.readDataFileAndExtractEntities(FilePaths.SubstancesFilePath);

    }
}
