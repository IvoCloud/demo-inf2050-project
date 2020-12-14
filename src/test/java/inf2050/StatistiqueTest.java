package inf2050;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatistiqueTest {

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

}