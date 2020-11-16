package inf2050;

import org.junit.jupiter.api.Test;

// import jdk.nashorn.internal.parser.JSONParser;

import static org.junit.jupiter.api.Assertions.*;

import inf2050.App;

import java.io.Console;

import java.io.*;

import java.util.*;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
      assertEquals(1, 1);
    }
    // @Test
    // void testArrondissement() {
    //   assertTrue(App.verifierArrondissement("Mercier–Hochelaga-Maisonneuve"));
    //   assertFalse(App.verifierArrondissement("Brossard"));
    //   assertTrue(App.verifierArrondissement("Villeray–Saint-Michel–Parc-Extension"));
    //   assertTrue(App.verifierArrondissement("Côte-des-Neiges—Notre-Dame-de-Grâce"));
    //   assertFalse(App.verifierArrondissement("Côte-des-Neiges-Notre-Dame-de-Grâce"));
    // }

    // @Test
    // void testMain() {
    //   String[] fichier = {"fichier.csv"};
    //   App.main(fichier);
    // }

    @Test
    void testImprimerErr() {
      assertNotNull(App.messageErreur("fichier", 10, "champs"));
    }

    @Test
    void testValiderLigne() {
      ArrayList<String> erreurs = new ArrayList<String>();
      erreurs = App.validerLigne(new String[]{"2020-09-12","13:11","Parc Carignan","Lachine","Bagarre"});
      assertEquals(erreurs.size(),0);

      erreurs = App.validerLigne(new String[]{"2020-09-12","13:11","Parc Carignan","Laval","Bagarre"});
      assertEquals(erreurs.size(),1);

      erreurs = App.validerLigne(new String[]{"2020-09-12","13:11","Parc Carignan","Laval","Bruit"});
      assertEquals(erreurs.size(),2);
    }
}
