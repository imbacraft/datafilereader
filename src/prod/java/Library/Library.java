package Library;

import entities.Substance;
import factories.SubstanceFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Library {

  public void readDatFile(String fileName) {

    FileReader file;
    long lineNumber = 0;

    try {

      // Load file. If file is not found, throw IOException.
      file = new FileReader(fileName);

      BufferedReader reader = new BufferedReader(file);
      StringBuilder block = new StringBuilder();

      // First line is the header of the data file.
      String header = reader.readLine();
      lineNumber++;

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
          // Add each substance to the Substance List
          substanceFactory.addToItemList(substance);

          System.out.println(substance);

          // System.out.println(substance.toString());

          // Move to the next block
          id = id2;

          // Clear the previous block for memory efficiency.
          block.setLength(0);

          // Append next block
          block.append(line + "\n");

        }

        lineNumber++;

      }

      // Close the BufferedReader and the file.
      reader.close();
      file.close();

    } catch (IOException ex) {

      ex.printStackTrace();
    }
  }
}
