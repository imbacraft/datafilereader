package starter;

import java.util.List;

import constants.FilePaths;
import entities.Substance;
import filereader.SubstanceFileReader;

public class MainClass {
    public static void main( String[] args ) {

        SubstanceFileReader reader = new SubstanceFileReader();
        List<Substance> substanceList = reader.readDataFileAndExtractEntities(FilePaths.SubstancesFilePath);

        //Loading of substances on a list and printing them is done for presentation purposes.
        // substanceList.forEach(substance -> System.out.println(substance));

    }
}
