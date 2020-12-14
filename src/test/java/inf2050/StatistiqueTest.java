package inf2050;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class StatistiqueTest {

    // @Test
    // void testParcExiteDansStatistiques_Valide(){
    //   String parc = "Parc Camille";

    //   Statistiques statistiques = new Statistiques("Ahuntsic-Cartierville", parc);
    //   assertTrue(statistiques.parcExiteDansStatistique("Parc Camille"));

    // }

    @Test
  void creerListePlainte_ValideRepetitionArrondissement(){
    Plainte plainte1 = new Plainte("2020-05-05", "22:30", "Parc Carignan", "Outremont", "Bagarre");
    Plainte plainte2 = new Plainte("2020-05-05", "22:30", "Parc Carignan", "Lachine", "Manifestation illégale");
    Plainte plainte3 = new Plainte("2020-05-05", "22:30", "Parc Carignan", "Pierrefonds-Roxboro","Vente de drogues");
    Plainte plainte4 = new Plainte("2020-05-05", "22:30", "Parc Carignan", "Lachine", "Bagarre");

    Plaintes plaintes = new Plaintes();
    Statistiques statistiques = new Statistiques();

    plaintes.addPlaintes(plainte1);
    plaintes.addPlaintes(plainte2);
    plaintes.addPlaintes(plainte3);
    plaintes.addPlaintes(plainte4);

    for (Plainte plainte : plaintes.getPlaintes()) {
      statistiques.ajouterPlainteDansStatistiques(plainte);
    }
    
    
    assertEquals(3,statistiques.getStatistiques().size());
  }
  
  @Test
  void creerListePlainte_ValideRepetitionParc(){
    Plainte plainte1 = new Plainte("2020-05-05", "22:30", "Parc Carignan", "Outremont", "Bagarre");
    Plainte plainte2 = new Plainte("2020-05-05", "22:30", "Parc Carignan", "Lachine", "Manifestation illégale");
    Plainte plainte3 = new Plainte("2020-05-05", "22:30", "Parc Carignan", "Pierrefonds-Roxboro","Vente de drogues");
    Plainte plainte4 = new Plainte("2020-05-05", "22:30", "Parc Camille", "Lachine", "Bagarre");

    Plaintes plaintes = new Plaintes();
    Statistiques statistiques = new Statistiques();

    plaintes.addPlaintes(plainte1);
    plaintes.addPlaintes(plainte2);
    plaintes.addPlaintes(plainte3);
    plaintes.addPlaintes(plainte4);

    for (Plainte plainte : plaintes.getPlaintes()) {
      statistiques.ajouterPlainteDansStatistiques(plainte);
    }
    
    assertEquals(1,statistiques.getStatistiques().get(0).getParcs().size());
    assertEquals(2,statistiques.getStatistiques().get(1).getParcs().size());
    assertEquals(1,statistiques.getStatistiques().get(2).getParcs().size());
  }


//   @Test
//   void testParcExiteDansStatistiqueParArrondissement_NomParcPasDansListe(){
//     String parc = "Parc Camille";

//     StatistiqueParArrondissement StatistiqueParArrondissement = new StatistiqueParArrondissement("Ahuntsic-Cartierville", parc);
//     assertFalse(StatistiqueParArrondissement.parcExiteDansStatistique("Parc Olympique"));
//   }

//   @Test
//   void testAjouterParc_NouveauParcIsTrue(){
//     String parc = "Parc Camille";

//     StatistiqueParArrondissement StatistiqueParArrondissement = new StatistiqueParArrondissement("Ahuntsic-Cartierville", parc);
//     assertTrue(StatistiqueParArrondissement.ajouterParc("Parc Olympique"));
//   }

//   @Test
//   void testAjouterParc_DeuxParcs(){
//     String parc = "Parc Camille";

//     StatistiqueParArrondissement StatistiqueParArrondissement = new StatistiqueParArrondissement("Ahuntsic-Cartierville", parc);
//     StatistiqueParArrondissement.ajouterParc("Parc Olympique");
//     assertEquals(2,StatistiqueParArrondissement.getParcs().size());
//   }

//   @Test
//   void testParc_ConstructuerDeuxParamsValides(){
//     StatistiqueParArrondissement StatistiqueParArrondissement = new StatistiqueParArrondissement("Ahuntsic-Cartierville", "Parc Camille");

//     String villeAttendue = "Ahuntsic-Cartierville";
//     String parcAttendu = "Parc Camille";
//     int nombreParcsAttendu = 1;
    
//     assertEquals(villeAttendue,StatistiqueParArrondissement.getArrondissement());
//     assertEquals(nombreParcsAttendu,StatistiqueParArrondissement.getNombreParcs());
//     assertEquals(nombreParcsAttendu,StatistiqueParArrondissement.getParcs().size());
//     assertEquals(parcAttendu,StatistiqueParArrondissement.getParcs().get(0));
//   }

//   @Test
//   void testCreerListeStatistiqueParArrondissements_DeuxStatsValides(){
//     Plainte plainte = new Plainte("2020-05-05", "22:30", "Parc Carignan", "Outremont", "Bagarre");
//     Plainte plainte2 = new Plainte("2020-05-05", "22:30", "Parc Carignan", "Lachine", "Manifestation illégale");

//     StatistiqueParArrondissement statistiqueParArrondissement = new StatistiqueParArrondissement(plainte);
//     StatistiqueParArrondissement statistiqueParArrondissement2 = new StatistiqueParArrondissement(plainte2);

//     assertEquals(2, StatistiqueParArrondissement.getStatistiquesEnregistrees().size());
//   }
}
