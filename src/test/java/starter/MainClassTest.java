package starter;

import entities.Substance;
import entities.Synonym;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {

  MainClass mainClass;

  @Test
  public void printSubstancesENLocale() {

    Locale.setDefault(Locale.ENGLISH);
    System.out.println("The default locale has been set to: " + Locale.getDefault());

    String[] args = null;

    MainClass.main(args);

    for (Substance substance : MainClass.substanceList) {

      // get EN locale synonyms
      List<Synonym> filteredSynonymList =
          substance.getSynonymList().stream()
              .filter(syn -> syn.getIsoLanguage().equalsIgnoreCase(Locale.getDefault().toString()))
              .collect(Collectors.toList());

      // First Synonym of the current locale (EN)
      Synonym firstSynonymOfENLocale = filteredSynonymList.get(0);

      // Print substances according to the Assignment specifications
      System.out.println(substance.getCasCode() + ", " + firstSynonymOfENLocale.getSynonymName());
    }

    // Check if Last Substance synonym name is "TestE", accordingly with the EN locale.
    Substance lastSubstance = MainClass.substanceList.get(MainClass.substanceList.size() - 1);
    String expected = "TestE";
    List<Synonym> filteredLastSubstanceSynonymList =
        lastSubstance.getSynonymList().stream()
            .filter(syn -> syn.getIsoLanguage().equalsIgnoreCase(Locale.getDefault().toString()))
            .collect(Collectors.toList());

    Assert.assertEquals(expected, filteredLastSubstanceSynonymList.get(0).getSynonymName());
  }

  @Test
  public void printSubstancesDELocale() {

    Locale.setDefault(Locale.GERMAN);
    System.out.println("The default locale has been set to: " + Locale.getDefault());

    String[] args = null;

    MainClass.main(args);

    for (Substance substance : MainClass.substanceList) {

      // get EN locale synonyms
      List<Synonym> filteredSynonymList =
          substance.getSynonymList().stream()
              .filter(syn -> syn.getIsoLanguage().equalsIgnoreCase(Locale.getDefault().toString()))
              .collect(Collectors.toList());

      // First Synonym of the current locale (EN)
      Synonym firstSynonymOfDELocale = filteredSynonymList.get(0);

      // Print substances according to the Assignment specifications
      System.out.println(substance.getCasCode() + ", " +
      firstSynonymOfDELocale.getSynonymName());

    }

    // Check if Last Substance synonym name is "TestD", accordingly with the DE locale.
    Substance lastSubstance = MainClass.substanceList.get(MainClass.substanceList.size() - 1);
    String expected = "TestD";
    List<Synonym> filteredLastSubstanceSynonymList =
        lastSubstance.getSynonymList().stream()
            .filter(syn -> syn.getIsoLanguage().equalsIgnoreCase(Locale.getDefault().toString()))
            .collect(Collectors.toList());

    Assert.assertEquals(expected, filteredLastSubstanceSynonymList.get(0).getSynonymName());
  }
}
