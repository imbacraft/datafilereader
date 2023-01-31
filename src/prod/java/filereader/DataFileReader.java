package filereader;

import entities.Substance;
import entities.Synonym;
import factories.SubstanceFactory;
import factories.SynonymFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataFileReader {

  public void readDataFileAndExtractEntities(String fileName) {

    FileReader file;
    long lineNumber = 0;

    try {

      // Load file. If file is not found, throw IOException.
      file = new FileReader(fileName);

      //Create reader and block
      BufferedReader reader = new BufferedReader(file);
      StringBuilder block = new StringBuilder();

      // First line is the header of the data file.
      // Read it and increment line number
      String header = reader.readLine();
      lineNumber++;

      //Read the next line of the file
      String line;
      line = reader.readLine();
      lineNumber++;
      block.append(line + "\n");

      String[] splitLine = line.split("\t");
      String id = splitLine[1];

      while ((line = reader.readLine()) != null) {

        splitLine = line.split("\t");

        String id2 = splitLine[1];

        if (id.equals(id2)) {

          block.append(line + "\n");


        } else {

          // Split block to get all the lines of the block
          String[] splitBlock = block.toString().split("\n");

          // Create Substance object from the first line of the block
          SubstanceFactory substanceFactory = new SubstanceFactory();
          Substance substance = substanceFactory.create(splitBlock, lineNumber);

          //Get the Synonyms from the rest of the lines of the block.
          SynonymFactory synonymFactory = new SynonymFactory();
          List<Synonym> synonymList = synonymFactory.create(splitBlock, lineNumber);

          //Add the Synonyms to the Substance
          for (Synonym syn : synonymList) {

            substance.addSynonym(syn);
          }

          System.out.println(substance);
          // Add each substance to the Substance List
          substanceFactory.addToItemList(substance);

          // Move to the next block
          id = id2;

          // Clear the previous block for memory efficiency.
          block.setLength(0);

          // Append next block
          block.append(line + "\n");

        }

        //increment line number
        lineNumber++;

      }

      // Close the BufferedReader and the file when finished.
      reader.close();
      file.close();

    } catch (IOException ex) {

      ex.printStackTrace();
    }
  }
}
