package Library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import entities.Substance;

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

                    //TODO: Process StringbBuilder into class object
                    String[] splitBlock = block.toString().split("\n");


                    String[] splitSubstance = splitBlock[0].split("\t");

                    char recordIdentifier = splitSubstance[0].charAt(0);
                    Substance.setRecordIdentifier(recordIdentifier);

                    long nodeID = Long.parseLong(splitSubstance[1]);
                    String casCode = splitSubstance[2];
                    String euIndexCode = splitSubstance[3];
                    String einecsOrElincsCode = splitSubstance[4];
                    boolean dutyToDeclare = HelperMethods.parseStringToBoolean(splitSubstance[5]);
                    short isUnwanted = HelperMethods.parseStringToThreeValuedBoolean(splitSubstance[6]);
                    boolean isProhibited = HelperMethods.parseStringToBoolean(splitSubstance[7]);
                    boolean isReach = HelperMethods.parseStringToBoolean(splitSubstance[8]);
                    boolean isDeleted = HelperMethods.parseStringToBoolean(splitSubstance[9]);
                    boolean isHidden = HelperMethods.parseStringToBoolean(splitSubstance[10]);


                    Substance substance = new Substance(nodeID, casCode, euIndexCode, einecsOrElincsCode, dutyToDeclare, isUnwanted, isProhibited, isReach, isDeleted, isHidden);

                    System.out.println(substance.toString());


                    //Move to the next block
                    id = id2;

                    //Clear the previous block
                    block.setLength(0);

                    //Append next block
                    block.append(ln + "\n");
                }



            }

            reader.close();

        } catch (IOException ex) {

            ex.printStackTrace();
        }


    }

}
