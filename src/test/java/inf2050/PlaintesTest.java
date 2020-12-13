package inf2050;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class PlaintesTest {

  final String[] ENTETES = new String[]{ "Date", "Heure", "Parc", "Arrondissement", "Description" };
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
  void testExtraireEntete_ChampsIncomplets() {
    String texteBrut = "";
    String err = "";

    try {
      Plaintes.extraireChampsEntetes(texteBrut);
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
      Plaintes.extraireChampsEntetes(texteBrut);
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
      Plaintes.validerChampsEntetes(entetes);
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
      resultats = Plaintes.validerChampsEntetes(entetes);
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
      resultats = Plaintes.extraireLignesPlaintes(texteBrut);
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
      resultats = Plaintes.extraireLignesPlaintes(texteBrut);
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertEquals(1, resultats.length);
  }

  @Test
  void testExtraireLignesPlaintes_DeuxLignesPlaintes() {
    String texteBrut = "Date, Heure \n Plainte, Vol \n Bruit, 22:30, Montreal";
    String[] resultats = new String[] {};

    String err = "";
    try {
      resultats = Plaintes.extraireLignesPlaintes(texteBrut);
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertEquals(2, resultats.length);
  }

  @Test
  void testlignePlainteEnTableau_Valide() {
    String[] tableauLignesPlaintes = new String[]{
      "2020-05-05, 22:30, Parc Carignan, Montreal, Vol",
      "2020-11-25, 15:00, Parc Carignan, Montreal, Bruit",
      "2020-08-15, 9:20, Parc Carignan, Montreal, Bagarre"
    };
    String[][] resultatAttendu = {
      { "2020-05-05", "22:30", "Parc Carignan", "Montreal", "Vol" },
      {"2020-11-25", "15:00", "Parc Carignan", "Montreal", "Bruit"},
      {"2020-08-15", "9:20", "Parc Carignan", "Montreal", "Bagarre"},
    };

    String[][] resultats = new String[][]{};
    String err = "";
    try {
      resultats = Plaintes.lignePlainteEnTableau(tableauLignesPlaintes);
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertArrayEquals(resultatAttendu, resultats);
  }

  @Test
  void testlignePlainteEnTableau_QuatreValeurs() {
    String[] tableauLignesPlaintes = new String[]{
      "2020-05-05, 22:30, Parc Carignan, Montreal",
      "2020-11-25, 15:00, Parc Carignan, Montreal, Bruit",
    };
    String msgErrAttendu = "Erreur à la ligne 1.\n Il n'y a pas 5 valeurs dans la ligne.";

    String[][] resultats = new String[][]{};
    String err = "";
    try {
      resultats = Plaintes.lignePlainteEnTableau(tableauLignesPlaintes);
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertEquals(msgErrAttendu, err);
  }

  @Test
  void testlignePlainteEnTableau_ValeurVide() {
    String[] tableauLignesPlaintes = new String[]{
      "",
      "2020-11-25, 15:00, Parc Carignan, Montreal, Bruit",
    };
    String msgErrAttendu = "Erreur à la ligne 1.\n Il n'y a pas 5 valeurs dans la ligne.";

    String[][] resultats = new String[][]{};
    String err = "";
    try {
      resultats = Plaintes.lignePlainteEnTableau(tableauLignesPlaintes);
    } catch (Exception e) {
      err = e.getMessage();
    }
    assertEquals(msgErrAttendu, err);
  }

  @Test
  void testCreerListePlainte_Valide() {
    String[][] tableuPlaintes = {
      { "2020-05-05", "22:30", "Parc Carignan", "Outremont", "Bagarre" },
    };

    ArrayList<Plainte> listePlaintesAttendue = new ArrayList<>();
    listePlaintesAttendue.add(new Plainte("2020-05-05", "22:30", "Parc Carignan", "Outremont", "Bagarre"));

    ArrayList<Plainte> resultats = new ArrayList<>();

    try {
      resultats = Plaintes.creerListePlainte(tableuPlaintes,ENTETES,ARRONDISSEMENTS,INTERVENTIONS);
    } catch (Exception e) {
      e.getMessage();
    }
    
    assertEquals(listePlaintesAttendue.get(0).getDate(), resultats.get(0).getDate());
    assertEquals(listePlaintesAttendue.get(0).getHeure(), resultats.get(0).getHeure());
    assertEquals(listePlaintesAttendue.get(0).getParc(), resultats.get(0).getParc());
    assertEquals(listePlaintesAttendue.get(0).getArrondissement(), resultats.get(0).getArrondissement());
    assertEquals(listePlaintesAttendue.get(0).getDescription(), resultats.get(0).getDescription());
  
  }


  @Test
  void testCreerListePlainte_Valide2() {
    String[][] tableuPlaintes = {
      { "2020-05-05", "22:30", "Parc Carignan", "Le Sud-Ouest", "Vols qualifiés" },
      {"2020-05-05", "22:30", "Parc Carignan", "Outremont", "Bagarre"},
    };

    ArrayList<Plainte> listePlaintesAttendue = new ArrayList<>();
    listePlaintesAttendue.add(new Plainte("2020-05-05", "22:30", "Parc Carignan", "Le Sud-Ouest", "Vols qualifiés"));
    listePlaintesAttendue.add(new Plainte("2020-05-05", "22:30", "Parc Carignan", "Outremont", "Bagarre"));

    ArrayList<Plainte> resultats = new ArrayList<>();

    String err = "";
    try {
      resultats = Plaintes.creerListePlainte(tableuPlaintes,ENTETES,ARRONDISSEMENTS,INTERVENTIONS);
    } catch (Exception e) {
      err = e.getMessage();
    }
    
    assertEquals(listePlaintesAttendue.get(0).getDate(), resultats.get(0).getDate());
    assertEquals(listePlaintesAttendue.get(0).getHeure(), resultats.get(0).getHeure());
    assertEquals(listePlaintesAttendue.get(0).getParc(), resultats.get(0).getParc());
    assertEquals(listePlaintesAttendue.get(0).getArrondissement(), resultats.get(0).getArrondissement());
    assertEquals(listePlaintesAttendue.get(0).getDescription(), resultats.get(0).getDescription());

    assertEquals(listePlaintesAttendue.get(1).getDate(), resultats.get(1).getDate());
    assertEquals(listePlaintesAttendue.get(1).getHeure(), resultats.get(1).getHeure());
    assertEquals(listePlaintesAttendue.get(1).getParc(), resultats.get(1).getParc());
    assertEquals(listePlaintesAttendue.get(1).getArrondissement(), resultats.get(1).getArrondissement());
    assertEquals(listePlaintesAttendue.get(1).getDescription(), resultats.get(1).getDescription());
  
  }

  @Test
  void testCreerListePlainte_DescInvalide() {
    String[][] tableuPlaintes = {
      { "2020-05-05", "22:30", "Parc Carignan", "Outremont", "Vol" },
    };

    String errAttendue = "Erreur à la ligne 1. Le champs Description n'est pas valide.";
    String errResultat = "";

    try {
      Plaintes.creerListePlainte(tableuPlaintes,ENTETES,ARRONDISSEMENTS,INTERVENTIONS);
    } catch (Exception e) {
      errResultat = e.getMessage();
    }
    
    assertEquals(errAttendue, errResultat);
  }

  @Test
  void testCreerListePlainte_ArrondInvalide() {
    String[][] tableuPlaintes = {
      { "2020-05-05", "22:30", "Parc Carignan", "Montreal", "Bagarre" },
    };

    String errAttendue = "Erreur à la ligne 1. Le champs Arrondissement n'est pas valide.";
    String errResultat = "";

    try {
      Plaintes.creerListePlainte(tableuPlaintes,ENTETES,ARRONDISSEMENTS,INTERVENTIONS);
    } catch (Exception e) {
      errResultat = e.getMessage();
    }
    
    assertEquals(errAttendue, errResultat);
  }

  @Test
  void testCreerListePlainte_ParcVide() {
    String[][] tableuPlaintes = {
      { "2020-05-05", "22:30", "", "Montreal", "Bagarre" },
    };

    String errAttendue = "Erreur à la ligne 1. Le champs Parc est vide.";
    String errResultat = "";

    try {
      Plaintes.creerListePlainte(tableuPlaintes,ENTETES,ARRONDISSEMENTS,INTERVENTIONS);
    } catch (Exception e) {
      errResultat = e.getMessage();
    }
    
    assertEquals(errAttendue, errResultat);
  }

}
