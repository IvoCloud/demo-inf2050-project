package inf2050;

import inf2050.IO.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JSONReaderTest {

  String jsonTest = "{\"arrondissements\": [\"Ahuntsic-Cartierville\",\"Verdun\",\"Ville-Marie\",\"Villeray–Saint-Michel–Parc-Extension\"]}";

  @Test
  void testJsonToArray() {
    String[] resultatAttendu = new String[] { "Ahuntsic-Cartierville", "Verdun", "Ville-Marie",
        "Villeray–Saint-Michel–Parc-Extension" };
    try {
      assertArrayEquals(resultatAttendu, JSONReader.jsonToArray(jsonTest, "arrondissements"));
    } catch (Exception e) {

    }
  }

  @Test
  void testJsonToArray_JsonVide() {
    String err = "";
    try {
      JSONReader.jsonToArray("", "arrondissements");
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertEquals("String Json est invalide!", err);
  }

  @Test
  void testJsonToArray_ChampVide() {
    String err = "";
    try {
      JSONReader.jsonToArray(jsonTest, "");
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertEquals("Le champ est vide!", err);
  }

  @Test
  void testJsonToArray_JsonEtChampVides() {
    String err = "";
    try {
      JSONReader.jsonToArray("", "");
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertEquals("String Json est invalide!", err);
  }
}
