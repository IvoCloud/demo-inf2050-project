package inf2050;


import java.util.*;

public class Statistiques {
  private ArrayList<Statistique> statistiques = new ArrayList<>();


  public ArrayList<Statistique> getStatistiques(){
    return statistiques;
  }

  public Statistiques(){
  }

  void ajouterPlainteDansStatistiques(Plainte plainte){
    boolean existe = false;
    if(statistiques.size()==0){
      statistiques.add(new Statistique(plainte));
    }else{
      for(int i=0;i<statistiques.size();i++){
        if(statistiques.get(i).getArrondissement().equals(plainte.getArrondissement())){
          statistiques.get(i).incrementerIntervention();
          statistiques.get(i).ajouterParc(plainte.getParc());
          existe = true;
        }
      }
      if(!existe){
        statistiques.add(new Statistique(plainte.getArrondissement(), plainte.getParc()));
      }
    }
  }
}
