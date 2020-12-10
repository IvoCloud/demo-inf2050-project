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

  @Test
  void testExtraireEntete_ChampsIncomplets(){
    String texteBrut = "";
    String err="";
    Plaintes plaintes = new Plaintes();
    try{
      plaintes.extraireChampsEntetes(texteBrut);
    }catch(Exception e){
      err = e.getMessage();
    }
    assertEquals("Il n'y a pas suffisamment des champs d'entête",err);
  }

  @Test
  void testExtraireEntete_ChampsComplets(){
    String texteBrut = "Date, Heure, Desc, Arrondiss, Parc \n 23-01,22:10,Bruit,";
    String err="";
    Plaintes plaintes = new Plaintes();
    try{
      plaintes.extraireChampsEntetes(texteBrut);
    }catch(Exception e){
      err = e.getMessage();
    }
    assertNotEquals("Il n'y a pas suffisamment des champs d'entête",err);
  }

  @Test
  void testExtraireEnteteEntete_EntetesInvalides(){
    String[] entetes = {"Déscription", "Champ", "Date", "_Text_", "Pays"};
    Plaintes plaintes = new Plaintes();
    String err = "";
    try{
      plaintes.validerChampsEntetes(entetes);
    }catch(Exception e){
      err = e.getMessage();
    }
    assertEquals("Les champs d'entête ne sont pas valides", err);
  }

  @Test
  void testExtraireEnteteEntete_EntetesValides(){
    String[] entetes = {"Date","Heure","Parc","Arrondissement","Description"};
    String[] resultats = new String[]{};
    Plaintes plaintes = new Plaintes();
    String err = "";
    try{
      resultats = plaintes.validerChampsEntetes(entetes);
    }catch(Exception e){
      err = e.getMessage();
    }
    assertArrayEquals(new String[]{"Date","Heure","Parc","Arrondissement","Description"}, resultats);
  }

  @Test
  void testExtraireLignesPlaintes_LignesPlaintesVides(){
    String texteBrut = "Date, Heure \n";
    String[] resultats = new String[]{};
    Plaintes plaintes = new Plaintes();
    String err = "";
    try{
      resultats = plaintes.extraireLignesPlaintes(texteBrut);
    }catch(Exception e){
      err = e.getMessage();
    }
    assertEquals(0, resultats.length);
  }


  @Test
  void testExtraireLignesPlaintes_UneLignePlaintes(){
    String texteBrut = "Date, Heure \n Plainte";
    String[] resultats = new String[]{};
    Plaintes plaintes = new Plaintes();
    String err = "";
    try{
      resultats = plaintes.extraireLignesPlaintes(texteBrut);
    }catch(Exception e){
      err = e.getMessage();
    }
    assertEquals(1, resultats.length);
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
