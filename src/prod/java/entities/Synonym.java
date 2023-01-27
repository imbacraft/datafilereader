package entities;

public class Synonym {

  private static char[] recordIdentifier;
  private long nodeID;
  private short synonymID;
  private char[] isoLanguage;
  private String synonymName;

  public Synonym() {}

  public Synonym(
      char[] recordIdentifier,
      long nodeID,
      short synonymID,
      char[] isoLanguage,
      String synonymName) {

    this.recordIdentifier = recordIdentifier;
    this.nodeID = nodeID;
    this.synonymID = synonymID;
    this.isoLanguage = isoLanguage;
    this.synonymName = synonymName;
  }
}
