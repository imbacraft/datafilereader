package entities;

import Library.HelperMethods;
import Library.ReaderInterface;
import java.util.List;

public class Substance implements ReaderInterface<Substance> {

  private static char recordIdentifier;
  private long nodeID;
  private String casCode;
  private String euIndexCode;
  private String einecsOrElincsCode;
  private boolean dutyToDeclare;
  private short isUnwanted;
  private boolean isProhibited;
  private boolean isReach;
  private boolean isDeleted;
  private boolean isHidden;

  private List<Synonym> synonymList;


  public Substance() {
}

public Substance(
      long nodeID,
      String casCode,
      String euIndexCode,
      String einecsOrElincsCode,
      boolean dutyToDeclare,
      short isUnwanted,
      boolean isProhibited,
      boolean isReach,
      boolean isDeleted,
      boolean isHidden) {

    this.nodeID = nodeID;
    this.casCode = casCode;
    this.euIndexCode = euIndexCode;
    this.einecsOrElincsCode = einecsOrElincsCode;
    this.dutyToDeclare = dutyToDeclare;
    this.isUnwanted = isUnwanted;
    this.isProhibited = isProhibited;
    this.isReach = isReach;
    this.isDeleted = isDeleted;
    this.isHidden = isHidden;
  }

  public static char getRecordIdentifier() {
    return recordIdentifier;
  }

  public static void setRecordIdentifier(char recordIdentifier) {
    Substance.recordIdentifier = recordIdentifier;
  }

  public long getNodeID() {
    return nodeID;
  }

  public void setNodeID(long nodeID) {
    this.nodeID = nodeID;
  }

  public String getCasCode() {
    return casCode;
  }

  public void setCasCode(String casCode) {
    this.casCode = casCode;
  }

  public String getEuIndexCode() {
    return euIndexCode;
  }

  public void setEuIndexCode(String euIndexCode) {
    this.euIndexCode = euIndexCode;
  }

  public String getEinecsOrElincsCode() {
    return einecsOrElincsCode;
  }

  public void setEinecsOrElincsCode(String einecsOrElincsCode) {
    this.einecsOrElincsCode = einecsOrElincsCode;
  }

  public boolean isDutyToDeclare() {
    return dutyToDeclare;
  }

  public void setDutyToDeclare(boolean dutyToDeclare) {
    this.dutyToDeclare = dutyToDeclare;
  }

  public short getIsUnwanted() {
    return isUnwanted;
  }

  public void setIsUnwanted(short isUnwanted) {
    this.isUnwanted = isUnwanted;
  }

  public boolean isProhibited() {
    return isProhibited;
  }

  public void setProhibited(boolean isProhibited) {
    this.isProhibited = isProhibited;
  }

  public boolean isReach() {
    return isReach;
  }

  public void setReach(boolean isReach) {
    this.isReach = isReach;
  }

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public boolean isHidden() {
    return isHidden;
  }

  public void setHidden(boolean isHidden) {
    this.isHidden = isHidden;
  }

  @Override
  public String toString() {
    return "Substance [casCode="
        + casCode
        + ", dutyToDeclare="
        + dutyToDeclare
        + ", einecsOrElincsCode="
        + einecsOrElincsCode
        + ", euIndexCode="
        + euIndexCode
        + ", isDeleted="
        + isDeleted
        + ", isHidden="
        + isHidden
        + ", isProhibited="
        + isProhibited
        + ", isReach="
        + isReach
        + ", isUnwanted="
        + isUnwanted
        + ", nodeID="
        + nodeID
        + "]";
  }

  @Override
  public boolean hasAllRequiredFields(String[] splitItemLine) {

    if (splitItemLine.length == 11) {

      return true;
    }

    return false;
  }

  @Override
  public Substance process(String[] splitBlock) {
    // The first line of the block corresponds to Substance.
    // Therefore, split the first line and get the individual fields of the Substance.
    String[] splitSubstance = splitBlock[0].split("\t");

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
}
