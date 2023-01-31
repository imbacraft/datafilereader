package factories;

import Library.Constants;
import Library.HelperMethods;
import entities.Synonym;
import exceptions.InvalidFieldException;
import exceptions.MissingFieldException;
import java.util.ArrayList;
import java.util.List;
import messages.SynonymErrorMessages;

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

    if (splitItemLine.length == Constants.SYNONYM_FIELDS) {
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
              splitSynonym[Constants.RECORD_IDENTIFIER_INDEX], errorLineNumber));
    }

    if (isValidNodeID(splitSynonym) == false) {

      throw new InvalidFieldException(
          SynonymErrorMessages.invalidNodeID(
              splitSynonym[Constants.SYNONYM_NODE_ID_INDEX], errorLineNumber));
    }

    if (isValidSynonymID(splitSynonym) == false) {
      throw new InvalidFieldException(
          SynonymErrorMessages.invalidSynonymID(
              splitSynonym[Constants.SYNONYM_ID_INDEX], errorLineNumber));
    }

    if (isValidSynonymISOLanguage(splitSynonym) == false) {
      throw new InvalidFieldException(
          SynonymErrorMessages.invalidISOLanguage(
              splitSynonym[Constants.SYNONYM_ISO_LANGUAGE_INDEX], errorLineNumber));
    }

    if (isValidSynonymName(splitSynonym) == false) {
      throw new InvalidFieldException(
          SynonymErrorMessages.invalidSynonymName(
              splitSynonym[Constants.SYNONYM_NAME_INDEX], errorLineNumber));
    }

    return true;
  }

  private boolean isValidSynonymName(String[] splitSynonym) {
    if (splitSynonym[Constants.SYNONYM_NAME_INDEX].length()
        <= Constants.SYNONYM_NAME_MAX_CHARACTERS) {

      return true;
    }

    return false;
  }

  private boolean isValidSynonymISOLanguage(String[] splitSynonym) {

    for (String language : Constants.SYNONYM_ISO_LANGUAGES) {

      if (language.equals(splitSynonym[Constants.SYNONYM_ISO_LANGUAGE_INDEX]) == true) {

        return true;
      }
    }

    return false;
  }

  private boolean isValidSynonymID(String[] splitSynonym) {
    if (HelperMethods.stringIsNotNullorEmptyAndContainsOnlyDigits(
            splitSynonym[Constants.SYNONYM_ID_INDEX])
        == false) {

      return false;
    }

    if (splitSynonym[Constants.SYNONYM_ID_INDEX].length() > Constants.SYNONYM_ID_MAX_DIGITS) {

      return false;
    }

    return true;
  }

  private boolean isValidNodeID(String[] splitSynonym) {
    if (HelperMethods.stringIsNotNullorEmptyAndContainsOnlyDigits(
            splitSynonym[Constants.SYNONYM_NODE_ID_INDEX])
        == false) {

      return false;
    }

    if (splitSynonym[Constants.SYNONYM_NODE_ID_INDEX].length()
        > Constants.SYNONYM_NODEID_MAX_DIGITS) {

      return false;
    }

    return true;
  }

  private boolean isValidRecordIdentifier(String[] splitSynonym) {

    if (splitSynonym[Constants.RECORD_IDENTIFIER_INDEX].length()
        != Constants.SYNONYM_RECORD_IDENTIFIER_MAX_CHAR_NUMBER) {

      return false;
    }

    return true;
  }
}
