package Library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import entities.Substance;
import entities.Synonym;
import factories.SubstanceFactory;

public class Library {

    public void readDatFile(String filename) {

        FileReader file;

        try {

            //Load file. If file is not found, throw IOException.
            file = new FileReader(filename);

            BufferedReader reader = new BufferedReader(file);
            StringBuilder block = new StringBuilder();

            //First line is the header of the data file, so read it to move to the blocks.
            String header = reader.readLine();

            String ln;
            ln = reader.readLine();
            block.append(ln + "\n");

            String[] splitLine = ln.split("\t");
            String id = splitLine[1];

            while ((ln = reader.readLine()) != null){

                splitLine = ln.split("\t");

                String id2 = splitLine[1];

                if (id.equals(id2)) {

                    block.append(ln + "\n");

                } else {

                    //Split block to get all the lines of the block
                    String[] splitBlock = block.toString().split("\n");

                    //Create Substance object from the first line of the block
                    SubstanceFactory substanceFactory = new SubstanceFactory();
                    Substance substance = substanceFactory.create(splitBlock);
                    //Add each substance to the Substance List
                    substanceFactory.addToItemList(substance);






                    // System.out.println(substance.toString());


                    //Move to the next block
                    id = id2;

                    //Clear the previous block for memory efficiency.
                    block.setLength(0);

                    //Append next block
                    block.append(ln + "\n");
                }



            }

            //Close the BufferedReader and the file.
            reader.close();
            file.close();

        } catch (IOException ex) {

            ex.printStackTrace();
        }


    }

}
