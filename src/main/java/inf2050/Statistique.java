package inf2050;

import java.util.*;

import java.io.*;

import inf2050.Plainte;


/**
 * Class Planinte enregistre chaque ligne du fichier en entree 
 * dans un nouveau objet plainte.
 */

/**
 * Classe Statistique enregistre les intervention dans chaque arrondissement
 * @param arrondissement - Lieu de l'intervention
 * @param intervention - Quantite des interventions
 */
public class Statistique implements Comparable<Statistique>{
    
  private String arrondissement;
  private int intervention=1;

  public Statistique(String arrondissement){
      this.arrondissement = arrondissement;
  };

  public String getArrondissement() {
      return arrondissement;
  }
  public int getIntervention() {
      return intervention;
  }
  public void setIntervention(int intervention) {
      this.intervention = intervention;
  }

  public int compareTo(Statistique statistique) {
    return arrondissement.compareTo(statistique.arrondissement);
  }

  void incrementerIntervention(){
      ++intervention;
  }

  public String toString(){
    return arrondissement;
  }

  static ArrayList<Statistique> creerListeStatistiques(ArrayList<Plainte> plaintes){
    ArrayList<Statistique> statistiques = new ArrayList<>();

    plaintes.forEach((plainte)->{
      if(statistiques.size()==0) {
          Statistique statistique = new Statistique(plainte.getArrondissement());
          statistiques.add(statistique);
      }else{
        boolean existe = false;
        for(Statistique statistique: statistiques){
          if(statistique.getArrondissement().toLowerCase().equals(plainte.getArrondissement().toLowerCase())) {
              statistique.incrementerIntervention();
              existe=true;
          }
        }
        if(!existe){
            Statistique statistique = new Statistique(plainte.getArrondissement());
            statistiques.add(statistique);
        }
      }
    });

  return statistiques;
  }

  static boolean ecrireStatistiques(ArrayList<Statistique> statistiques, String nomFichierOut){
    String sortie = "Arrondissement,Nombre d'interventions,Nombre de parcs\n";
    boolean success = false;
    
    Collections.sort(statistiques);
    for(Statistique statistique: statistiques){
      sortie = sortie.concat(statistique.getArrondissement() + "," + statistique.getIntervention()+"\n");
    }

    System.out.println(sortie);
    try{
      FileWriter writer = new FileWriter("tets.csv");
      writer.write(sortie);
      writer.close();
      System.out.println("Statistique enregistre");
      success = true;
    }catch(IOException e){
      System.out.println("Erreur d'ecriture: " + e);
      success = false;
    }
  return success;
  }
}