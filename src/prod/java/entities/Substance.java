package entities;

import java.util.ArrayList;
import java.util.List;

public class Substance {

  private static char recordIdentifier;
  private long nodeID;
  private String casCode;
  private String euIndexCode;
  private String einecsOrElincsCode;
  private boolean dutyToDeclare;
  private String isUnwanted;
  private boolean isProhibited;
  private boolean isReach;
  private boolean isDeleted;
  private boolean isHidden;

  private List<Synonym> synonymList = new ArrayList<>();

  public Substance(
      long nodeID,
      String casCode,
      String euIndexCode,
      String einecsOrElincsCode,
      boolean dutyToDeclare,
      String isUnwanted,
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

  public String getIsUnwanted() {
    return isUnwanted;
  }

  public void setIsUnwanted(String isUnwanted) {
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

  public void addSynonym(Synonym synonym) {

    this.synonymList.add(synonym);
  }

  public List<Synonym> getSynonymList() {
    return synonymList;
  }

  public void setSynonymList(List<Synonym> synonymList) {
    this.synonymList = synonymList;
  }

  @Override
  public String toString() {
    return "Substance [recordIdentifier="
        + recordIdentifier
        + ", nodeID="
        + nodeID
        + ", casCode="
        + casCode
        + ", euIndexCode="
        + euIndexCode
        + ", einecsOrElincsCode="
        + einecsOrElincsCode
        + ", dutyToDeclare"
        + dutyToDeclare
        + ", isUnwanted="
        + isUnwanted
        + ", isProhibited="
        + isProhibited
        + ", isReach="
        + isReach
        + ", isDeleted="
        + isDeleted
        + ", isHidden="
        + isHidden
        + ", synonymList="
        + synonymList
        + "]";
  }
}
