package factories;

import Library.Constants;
import Library.HelperMethods;
import entities.Substance;

public class SubstanceFactory implements FactoryInterface<Substance> {

  @Override
  public Substance create(String[] splitBlock) {

    return createSubstance(splitBlock);
  }

  public static Substance createSubstance(String[] splitBlock) {
    // The first line of the block corresponds to Substance.
    // Therefore, split the first line and get the individual fields of the Substance.
    String[] splitSubstance = splitBlock[0].split("\t");

    //Check if all the required fields for Substance are present.
    //If not, throw exception.
        SubstanceFactory substanceFactory = new SubstanceFactory();

        if(!substanceFactory.hasAllRequiredFields(splitBlock)){
            throw new IllegalArgumentException("Missing required fields");
        }


    // Build Substance object
    char substanceIdentifier = splitSubstance[0].charAt(0);
    Substance.setRecordIdentifier(substanceIdentifier);

    long substanceNodeID = Long.parseLong(splitSubstance[1]);
    String casCode = HelperMethods.checkForFieldAvailability(splitSubstance[2]);
    String euIndexCode = HelperMethods.checkForFieldAvailability(splitSubstance[3]);
    String einecsOrElincsCode = HelperMethods.checkForFieldAvailability(splitSubstance[4]);
    boolean dutyToDeclare = HelperMethods.parseStringToBoolean(splitSubstance[5]);
    short isUnwanted = HelperMethods.parseStringToThreeValuedBoolean(splitSubstance[6]);
    boolean isProhibited = HelperMethods.parseStringToBoolean(splitSubstance[7]);
    boolean isReach = HelperMethods.parseStringToBoolean(splitSubstance[8]);
    boolean isDeleted = HelperMethods.parseStringToBoolean(splitSubstance[9]);
    boolean isHidden = HelperMethods.parseStringToBoolean(splitSubstance[10]);

    Substance substance =
        new Substance(
            substanceNodeID,
            casCode,
            euIndexCode,
            einecsOrElincsCode,
            dutyToDeclare,
            isUnwanted,
            isProhibited,
            isReach,
            isDeleted,
            isHidden);

    return substance;
  }

  @Override
  public boolean hasAllRequiredFields(String[] splitItemLine) {

    if (splitItemLine.length == Constants.SUBSTANCE_FIELDS) {
      return true;
    }

    return false;
  }
}
