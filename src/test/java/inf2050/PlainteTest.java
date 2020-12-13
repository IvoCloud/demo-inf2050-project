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
}
