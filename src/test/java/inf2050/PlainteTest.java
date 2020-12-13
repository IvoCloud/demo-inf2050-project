package inf2050;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlainteTest {
  Plainte plainte = new Plainte();
  final String[] ARRONDISSEMENTS = new String[]{
    "Ahuntsic-Cartierville",
    "Anjou",
    "Côte-des-Neiges—Notre-Dame-de-Grâce",
    "Lachine",
    "LaSalle",
    "Le Plateau-Mont-Royal",
    "Le Sud-Ouest",
    "L'Île-Bizard–Sainte-Geneviève",
    "Mercier–Hochelaga-Maisonneuve",
    "Montréal-Nord",
    "Outremont",
    "Pierrefonds-Roxboro",
    "Rivière-des-Prairies–Pointe-aux-Trembles",
    "Rosemont–La Petite-Patrie",
    "Saint-Laurent",
    "Saint-Léonard",
    "Verdun",
    "Ville-Marie",
    "Villeray–Saint-Michel–Parc-Extension"
  };

  final String[] INTERVENTIONS = new String [] {
    "Vol de véhicule à moteur",
    "Méfait",
    "Vols qualifiés",
    "Vol dans / sur véhicule à moteur",
    "Introduction",
    "Infractions entrainant la mort",
    "Vente de drogues",
    "Bagarre",
    "Manifestation illégale",
    "Possession / consommation de stupéfiant",
    "Port d'arme prohibée"
  };

  final String[] champsEntete = new String[]{"Date","Heure","Parc","Arrondissement","Description"};
  final String LE_CHAMPS = "Le champs ";
  final String PAS_VALIDE = " n'est pas valide.";
  final String EST_VIDE = " est vide.";

  @Test
  void testValiderSiExisteDansTableau_Valide(){
    assertTrue(plainte.validerSiExisteDansTableau("Verdun", ARRONDISSEMENTS));
  }

  @Test
  void testValiderSiExisteDansTableau_PasDansListe(){
    assertFalse(plainte.validerSiExisteDansTableau("Montreal", ARRONDISSEMENTS));
  }

  @Test
  void testValiderSiExisteDansTableau_Vide(){
    assertFalse(plainte.validerSiExisteDansTableau("", ARRONDISSEMENTS));
  }

  @Test
  void testValiderSiExisteDansTableau_TabVide(){
    assertFalse(plainte.validerSiExisteDansTableau("Verdun", new String[]{}));
  }

  @Test
  void testValiderSiExisteDansTableau_Vide2(){
    assertTrue(plainte.validerSiExisteDansTableau("Ahuntsic-Cartierville", ARRONDISSEMENTS));
  }


  @Test
  void testCreerPlainteAvecValidation_Valide(){
    Plainte plainteAttendue = new Plainte("2020-09-01","20:41","Parc Camille","Ahuntsic-Cartierville","Vente de drogues");

    String[] elementsPlainte = new String[]{"2020-09-01","20:41","Parc Camille","Ahuntsic-Cartierville","Vente de drogues"};
    try {
      Plainte resultatPlainte = plainte.creerPlainteAvecValidation(elementsPlainte, champsEntete,ARRONDISSEMENTS, INTERVENTIONS);
      assertEquals(plainteAttendue.getHeure(), resultatPlainte.getHeure());
      assertEquals(plainteAttendue.getDate(), resultatPlainte.getDate());
      assertEquals(plainteAttendue.getParc(), resultatPlainte.getParc());
      assertEquals(plainteAttendue.getArrondissement(), resultatPlainte.getArrondissement());
      assertEquals(plainteAttendue.getDescription(), resultatPlainte.getDescription());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  void testCreerPlainteAvecValidation_ChampDateVide(){
    String errAttendue = LE_CHAMPS + "Date" + EST_VIDE;
    String[] elementsPlainte = new String[]{"","20:41","Parc Camille","Ahuntsic-Cartierville","Vente de drogues"};
    String errResultat="";
    try {
      plainte.creerPlainteAvecValidation(elementsPlainte, champsEntete,ARRONDISSEMENTS, INTERVENTIONS);
    } catch (Exception e) {
      errResultat = e.getMessage();
    }
    assertEquals(errAttendue, errResultat);
  }

  @Test
  void testCreerPlainteAvecValidation_ChampArrondInvalide(){
    String errAttendue = LE_CHAMPS + "Arrondissement" + PAS_VALIDE;
    String[] elementsPlainte = new String[]{"2020-09-01","20:41","Parc Camille","Montreal","Vente de drogues"};
    String errResultat="";
    try {
      plainte.creerPlainteAvecValidation(elementsPlainte, champsEntete,ARRONDISSEMENTS, INTERVENTIONS);
    } catch (Exception e) {
      errResultat = e.getMessage();
    }
    assertEquals(errAttendue, errResultat);
  }
  
}
