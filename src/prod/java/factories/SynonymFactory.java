package factories;

import java.util.ArrayList;
import java.util.List;

import constants.SynonymConstants;
import entities.Synonym;
import exceptions.InvalidFieldException;
import exceptions.MissingFieldException;
import messages.SynonymErrorMessages;
import utils.HelperMethods;

public class SynonymFactory implements FactoryInterface<List<Synonym>> {

  public List<Synonym> allSynonyms = new ArrayList<>();

  @Override
  public List<Synonym> create(String[] splitBlock, long lineNumber) {

    List<Synonym> synonymList = new ArrayList<>();
    Synonym synonym = null;
    long errorLineNumber;

    // Split each line that corresponds to a Synonym. Start from index 1 because index 0 was
    // processed as Substance.
    for (int index = 1; index < splitBlock.length; index++) {

      String[] splitSynonym = splitBlock[index].split("\t");

      errorLineNumber = lineNumber - splitBlock.length + 1 + index;

      // Check if all the required fields for Synonym are present, according to FileSpec.
      // If not, throw exception.
      if (hasAllRequiredFields(splitSynonym) == false) {
        throw new MissingFieldException(
            "A field is missing from the Synonym record at line: "
                + errorLineNumber
                + "Please verify the completess of the"
                + " record."
                + splitSynonym);
      }

      if (allFieldsAreValid(splitSynonym, errorLineNumber)) {

        // Build Synonym Object
        String synonymIdentifier = splitSynonym[0];
        Synonym.setRecordIdentifier(synonymIdentifier);

        long synonymNodeID = Long.parseLong(splitSynonym[1]);
        short synonymID = Short.parseShort(splitSynonym[2]);
        String isoLanguage = splitSynonym[3];
        String synonymName = splitSynonym[4];

        synonym = new Synonym(synonymNodeID, synonymID, isoLanguage, synonymName);

        synonymList.add(synonym);
      }
    }

    return synonymList;
  }

  @Override
  public boolean hasAllRequiredFields(String[] splitItemLine) {

    //Especially, for the first record line with nodeID = -1, skip this check because it is still a "header line"
    if (splitItemLine[SynonymConstants.NODE_ID_INDEX].equals("-1")){
      return true;
    }

    if (splitItemLine.length == SynonymConstants.TOTAL_FIELDS) {
      return true;
    }

    return false;
  }

  @Override
  public void addToItemList(List<Synonym> item) {

    for (Synonym syn : item) {

      this.allSynonyms.add(syn);
    }
  }

  @Override
  public boolean allFieldsAreValid(String[] splitSynonym, long errorLineNumber) {

    if (isValidRecordIdentifier(splitSynonym) == false) {

      throw new InvalidFieldException(
          SynonymErrorMessages.invalidRecordIdentifier(
              splitSynonym[SynonymConstants.RECORD_IDENTIFIER_INDEX], errorLineNumber));
    }

    if (isValidNodeID(splitSynonym) == false) {

      throw new InvalidFieldException(
          SynonymErrorMessages.invalidNodeID(
              splitSynonym[SynonymConstants.NODE_ID_INDEX], errorLineNumber));
    }

    if (isValidSynonymID(splitSynonym) == false) {
      throw new InvalidFieldException(
          SynonymErrorMessages.invalidSynonymID(
              splitSynonym[SynonymConstants.SYNONYM_ID_INDEX], errorLineNumber));
    }

    if (isValidSynonymISOLanguage(splitSynonym) == false) {
      throw new InvalidFieldException(
          SynonymErrorMessages.invalidISOLanguage(
              splitSynonym[SynonymConstants.ISO_LANGUAGE_INDEX], errorLineNumber));
    }

    if (isValidSynonymName(splitSynonym) == false) {
      throw new InvalidFieldException(
          SynonymErrorMessages.invalidSynonymName(
              splitSynonym[SynonymConstants.SYNONYM_NAME_INDEX], errorLineNumber));
    }

    return true;
  }

  private boolean isValidSynonymName(String[] splitSynonym) {
    if (splitSynonym[SynonymConstants.SYNONYM_NAME_INDEX].length()
        <= SynonymConstants.SYNONYM_NAME_MAX_CHARACTERS) {

      return true;
    }

    return false;
  }

  private boolean isValidSynonymISOLanguage(String[] splitSynonym) {

    for (String language : SynonymConstants.ISO_LANGUAGES) {

      if (language.equals(splitSynonym[SynonymConstants.ISO_LANGUAGE_INDEX]) == true) {

        return true;
      }
    }

    return false;
  }

  private boolean isValidSynonymID(String[] splitSynonym) {
    if (HelperMethods.stringIsNotNullorEmptyAndContainsOnlyDigits(
            splitSynonym[SynonymConstants.SYNONYM_ID_INDEX])
        == false) {

      return false;
    }

    if (splitSynonym[SynonymConstants.SYNONYM_ID_INDEX].length() > SynonymConstants.SYNONYM_ID_MAX_DIGITS) {

      return false;
    }

    return true;
  }

  private boolean isValidNodeID(String[] splitSynonym) {
    if (HelperMethods.stringIsNotNullorEmptyAndContainsOnlyDigits(
            splitSynonym[SynonymConstants.NODE_ID_INDEX])
        == false) {

      return false;
    }

    if (splitSynonym[SynonymConstants.NODE_ID_INDEX].length()
        > SynonymConstants.NODEID_MAX_DIGITS) {

      return false;
    }

    return true;
  }

  private boolean isValidRecordIdentifier(String[] splitSynonym) {

    if (splitSynonym[SynonymConstants.RECORD_IDENTIFIER_INDEX].length()
        != SynonymConstants.RECORD_IDENTIFIER_MAX_CHAR_NUMBER) {

      return false;
    }

    return true;
  }
}
