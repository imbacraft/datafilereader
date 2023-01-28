package factories;

import java.util.ArrayList;
import java.util.List;

import entities.Synonym;

public class SynonymFactory implements FactoryInterface<List<Synonym>> {

  @Override
  public List<Synonym> create(String[] splitBlock) {
    return createSynonymList(splitBlock);
  }

  public static List<Synonym> createSynonymList(String[] splitBlock) {

      List<Synonym> synonymList = new ArrayList<>();

    // Split each line that corresponds to a Synonym. Start from index 1 because index 0 was
    // processed as Substance.
    for (int index = 1; index < splitBlock.length; index++) {

      String[] splitSynonym = splitBlock[index].split("\t");

      // Build Synonym Object
      String synonymIdentifier = splitSynonym[0];
      Synonym.setRecordIdentifier(synonymIdentifier);
      long synonymNodeID = Long.parseLong(splitSynonym[1]);
      short synonymID = Short.parseShort(splitSynonym[2]);
      String isoLanguage = splitSynonym[3];
      String synonymName = splitSynonym[4];

      Synonym synonym = new Synonym(synonymNodeID, synonymID, isoLanguage, synonymName);

      synonymList.add(synonym);

    }

    return synonymList;
  }

  @Override
  public boolean hasAllRequiredFields(String[] splitItemLine) {
    // TODO Auto-generated method stub
    return false;
  }
}
