package inf2050;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour App.java
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

}
