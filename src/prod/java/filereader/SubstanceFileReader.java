package filereader;

import constants.SubstanceConstants;
import entities.Substance;
import entities.Synonym;
import factories.SubstanceFactory;
import factories.SynonymFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SubstanceFileReader implements DataFileReaderInterface<List<Substance>> {

  @Override
  public List<Substance> readDataFileAndExtractEntities(String filePath) {

    FileReader file;
    long lineNumber = 0;

    // Create SubstanceFactory
    SubstanceFactory substanceFactory = new SubstanceFactory();

    try {

      // Load file. If file is not found, throw IOException.
      file = new FileReader(filePath);

      // Create reader and block
      BufferedReader reader = new BufferedReader(file);
      StringBuilder block = new StringBuilder();

      // First line is the header of the data file.
      // Read it and increment line number
      String header = reader.readLine();
      lineNumber++;

      // Read the second line of the file
      String line;
      line = reader.readLine();
      lineNumber++;
      block.append(line + "\n");

      String[] splitLine = line.split("\t");

      // Get the NodeID of the second line.
      // As long as the NodeID stays the same, we are dealing with the same block.
      String id = splitLine[SubstanceConstants.NODE_ID_INDEX];

      while ((line = reader.readLine()) != null) {

        splitLine = line.split("\t");

        // Get the NodeID of the second line
        String id2 = splitLine[SubstanceConstants.NODE_ID_INDEX];

        // If the nodeID of the second line and the third line are the same, it means we are in the
        // same block, so append the next line.
        if (id.equals(id2)) {

          block.append(line + "\n");

        } else {

          // NOTE:
          // If the nodeID of the second line and the third line are NOT the same, it means we have
          // changed block.
          // Therefore, the previous block is completed and requires processing, which is done here.

          // Split block to get all the lines of the block
          String[] splitBlock = block.toString().split("\n");

          // Create Substance object from the first line of the block
          Substance substance = substanceFactory.create(splitBlock, lineNumber);

          // Get the Synonyms from the rest of the lines of the block.
          SynonymFactory synonymFactory = new SynonymFactory();
          List<Synonym> synonymList = synonymFactory.create(splitBlock, lineNumber);

          // Add the Synonyms to the Substance
          for (Synonym syn : synonymList) {

            substance.addSynonym(syn);
          }

          // Add each substance to the Substance List
          substanceFactory.addToItemList(substance);

          // Move to the next block
          id = id2;

          // Clear the previous block for memory efficiency.
          block.setLength(0);

          // Append next block
          block.append(line + "\n");
        }


        // increment line number
        lineNumber++;
      }

      //If the line read becomes null, it means we have the last block of the file ready to be processed,
      //but we have exited the previous while loop. Therefore, the last block must be processed here.
      if (line == null) {

          // Split block to get all the lines of the block
          String[] splitBlock = block.toString().split("\n");

          // Create Substance object from the first line of the block
          Substance substance = substanceFactory.create(splitBlock, lineNumber);

          // Get the Synonyms from the rest of the lines of the block.
          SynonymFactory synonymFactory = new SynonymFactory();
          List<Synonym> synonymList = synonymFactory.create(splitBlock, lineNumber);

          // Add the Synonyms to the Substance
          for (Synonym syn : synonymList) {

            substance.addSynonym(syn);
          }

          // Add each substance to the Substance List
          substanceFactory.addToItemList(substance);

      }

      // Remove the first Substance created because it is not a real substance entry, but still kind
      // of a header and the hasAllRequiredFields() of the SynonymFactory class reports (rightly)
      // an error of missing fields:
      // R	-1	*********	*********	*********	0	0	0	0	0	1
      // RN	-1	0	DE	Vertrauliche Reinstoffe
      // RN	-1	0	EN	Confidential Substances

      substanceFactory.substanceList.remove(0);

      // Close the BufferedReader and the file when finished.
      reader.close();
      file.close();

    } catch (IOException ex) {

      ex.printStackTrace();
    }

    return substanceFactory.getSubstanceList();
  }
}
