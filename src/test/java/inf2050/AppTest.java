package inf2050;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour App.
 */
class AppTest {

  String fichierIn = "fichier.csv";

  @Test
  void testZeroArgsMain(){
    String[] args = new String[]{};
    String err = "";
    try {
      App.validerLongueurTableau(args,2);
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertEquals("Longueur des args[] n'est pas 2",err);
  }

  @Test
  void testUnArgsMain(){
    String[] args = new String[]{"fichier.txt"};
    String err = "";
    try {
      App.validerLongueurTableau(args,2);
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertEquals("Longueur des args[] n'est pas 2",err);
  }

  @Test
  void testDeuxArgsMain(){
    String[] args = new String[]{"fichierIn.txt","fichierOut.txt"};
    String err = "";
    try {
      App.validerLongueurTableau(args,2);
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertNotEquals("Longueur des args[] n'est pas 2",err);
  }

  @Test
  void testTroisArgsMain(){
    String[] args = new String[]{"fichierIn.txt","fichierOut.txt","texte"};
    String err = "";
    try {
      App.validerLongueurTableau(args,2);
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertEquals("Longueur des args[] n'est pas 2",err);
  }


  // @Test
  // void testValiderSizePlaintes() {
  //   ArrayList<Plainte> plaintes = Plainte.lirePlaintes(fichierIn);
  //   assertEquals(plaintes.size(),6);
  // }

  // @Test
  // void testListeStatistiques() {
  //   ArrayList<Plainte> plaintes = Plainte.lirePlaintes(fichierIn);
  //   assertNotNull(Statistique.creerListeStatistiques(plaintes));
  // }

  // @Test
  // void testVerifierDetails() {
  //   assertFalse(Plainte.verifierDetails("Manifestation illégale","arrondissements"));
  //   assertTrue(Plainte.verifierDetails("Manifestation illégale","intervention_policiere"));
  // }

  // @Test
  // void testValiderLignes() {
  //   ArrayList<String> erreurs = new ArrayList<String>();

  //   erreurs = Plainte.validerLigne(new String[]{"2020-09-12","13:11","Parc Carignan","Pierrefonds-Roxboro","Bagarre"});
  //   assertEquals(erreurs.size(),0);

  //   erreurs = Plainte.validerLigne(new String[]{"2020-09-12","13:11","Parc Carignan","Laval","Bagarre"});
  //   assertEquals(erreurs.size(),1);

  //   erreurs = Plainte.validerLigne(new String[]{"2020-09-12","13:11","Parc Carignan","Laval","Bruit"});
  //   assertEquals(erreurs.size(),2);
  // }
}
