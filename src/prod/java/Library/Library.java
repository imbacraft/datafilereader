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

            file = new FileReader(filename);

            BufferedReader reader = new BufferedReader(file);
            StringBuilder block = new StringBuilder();

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
                    Substance substance = SubstanceFactory.createSubstance(splitBlock);





                    // System.out.println(substance.toString());


                    //Move to the next block
                    id = id2;

                    //Clear the previous block
                    block.setLength(0);

                    //Append next block
                    block.append(ln + "\n");
                }



            }

            //Close the BufferedReader
            reader.close();

        } catch (IOException ex) {

            ex.printStackTrace();
        }


    }

}
