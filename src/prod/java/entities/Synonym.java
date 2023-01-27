package entities;


public class Synonym {

  private static String recordIdentifier;
  private long nodeID;
  private short synonymID;
  private String isoLanguage;
  private String synonymName;

  public Synonym() {}

  public Synonym(long nodeID, short synonymID, String isoLanguage, String synonymName) {
    this.nodeID = nodeID;
    this.synonymID = synonymID;
    this.isoLanguage = isoLanguage;
    this.synonymName = synonymName;
  }

  public static String getRecordIdentifier() {
    return recordIdentifier;
  }

  public static void setRecordIdentifier(String recordIdentifier) {
    Synonym.recordIdentifier = recordIdentifier;
  }

  public long getNodeID() {
    return nodeID;
  }

  public void setNodeID(long nodeID) {
    this.nodeID = nodeID;
  }

  public short getSynonymID() {
    return synonymID;
  }

  public void setSynonymID(short synonymID) {
    this.synonymID = synonymID;
  }

  public String getIsoLanguage() {
    return isoLanguage;
  }

  public void setIsoLanguage(String isoLanguage) {
    this.isoLanguage = isoLanguage;
  }

  public String getSynonymName() {
    return synonymName;
  }

  public void setSynonymName(String synonymName) {
    this.synonymName = synonymName;
  }

  @Override
  public String toString() {
    return "Synonym [isoLanguage="
        + isoLanguage
        + ", nodeID="
        + nodeID
        + ", synonymID="
        + synonymID
        + ", synonymName="
        + synonymName
        + "]";
  }
}
