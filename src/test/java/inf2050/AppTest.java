package inf2050;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import inf2050.App;

import inf2050.Plainte;

import inf2050.Statistique;

import java.io.Console;

import java.io.*;

import java.util.*;

/**
 * Unit test for simple App.
 */
class AppTest {

  String fichierIn = "fichier.csv";

  @Test
  void testValiderSizePlaintes() {
    ArrayList<Plainte> plaintes = Plainte.lirePlaintes(fichierIn);
    assertEquals(plaintes.size(),6);
  }

  @Test
  void testListeStatistiques() {
    ArrayList<Plainte> plaintes = Plainte.lirePlaintes(fichierIn);
    assertNotNull(Statistique.creerListeStatistiques(plaintes));
  }

  @Test
  void testVerifierDetails() {
    assertFalse(Plainte.verifierDetails("Manifestation illégale","arrondissements"));
    assertTrue(Plainte.verifierDetails("Manifestation illégale","intervention_policiere"));
  }

  @Test
  void testValiderLignes() {
    ArrayList<String> erreurs = new ArrayList<String>();

    erreurs = Plainte.validerLigne(new String[]{"2020-09-12","13:11","Parc Carignan","Pierrefonds-Roxboro","Bagarre"});
    assertEquals(erreurs.size(),0);

    erreurs = Plainte.validerLigne(new String[]{"2020-09-12","13:11","Parc Carignan","Laval","Bagarre"});
    assertEquals(erreurs.size(),1);

    erreurs = Plainte.validerLigne(new String[]{"2020-09-12","13:11","Parc Carignan","Laval","Bruit"});
    assertEquals(erreurs.size(),2);
  }
}
