package inf2050;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlaintesTest {

  Plaintes plaintes = new Plaintes();

  @Test
  void testExtraireEntete_ChampsIncomplets() {
    String texteBrut = "";
    String err = "";

    try {
      plaintes.extraireChampsEntetes(texteBrut);
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertEquals("Il n'y a pas suffisamment des champs d'entête", err);
  }

  @Test
  void testExtraireEntete_ChampsComplets() {
    String texteBrut = "Date, Heure, Desc, Arrondiss, Parc \n 23-01,22:10,Bruit,";
    String err = "";

    try {
      plaintes.extraireChampsEntetes(texteBrut);
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertNotEquals("Il n'y a pas suffisamment des champs d'entête", err);
  }

  @Test
  void testExtraireEnteteEntete_EntetesInvalides() {
    String[] entetes = { "Déscription", "Champ", "Date", "_Text_", "Pays" };

    String err = "";
    try {
      plaintes.validerChampsEntetes(entetes);
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertEquals("Les champs d'entête ne sont pas valides", err);
  }

  @Test
  void testExtraireEnteteEntete_EntetesValides() {
    String[] entetes = { "Date", "Heure", "Parc", "Arrondissement", "Description" };
    String[] resultats = new String[] {};

    String err = "";
    try {
      resultats = plaintes.validerChampsEntetes(entetes);
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertArrayEquals(new String[] { "Date", "Heure", "Parc", "Arrondissement", "Description" }, resultats);
  }

  @Test
  void testExtraireLignesPlaintes_LignesPlaintesVides() {
    String texteBrut = "Date, Heure \n";
    String[] resultats = new String[] {};

    String err = "";
    try {
      resultats = plaintes.extraireLignesPlaintes(texteBrut);
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertEquals(0, resultats.length);
  }

  @Test
  void testExtraireLignesPlaintes_UneLignePlaintes() {
    String texteBrut = "Date, Heure \n Plainte";
    String[] resultats = new String[] {};

    String err = "";
    try {
      resultats = plaintes.extraireLignesPlaintes(texteBrut);
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertEquals(1, resultats.length);
  }

}
