package inf2050;

import java.util.*;


/**
 * Classe Statistique enregistre les intervention dans chaque arrondissement
 * @param arrondissement - Lieu de l'intervention
 * @param interventions - Quantite des interventions
 */
public class Statistique implements Comparable<Statistique>{

  private String arrondissement;
  private int interventions = 0;
  private int nombreParcs = 0;
  private ArrayList<String> parcs = new ArrayList<>();

  public Statistique(Plainte plainte){
    this.arrondissement = plainte.getArrondissement();
    this.ajouterParc(plainte.getParc());
    this.interventions++;
  }

  public Statistique(String arrondissement,String parc){
    this.arrondissement = arrondissement;
    this.interventions++;
    this.nombreParcs++;
    this.parcs.add(parc);
  }

  public boolean parcExiteDansStatistique(String nomParc){
    return parcs.contains(nomParc);
  }

  public boolean ajouterParc(String nomParc){
    boolean ajoute = false;
    if(!parcExiteDansStatistique(nomParc)){
      parcs.add(nomParc);
      nombreParcs++;
      ajoute = !ajoute;
    }
    return ajoute;
  }

  public String getArrondissement() {
      return arrondissement;
  }
  public int getInterventions() {
      return interventions;
  }
  public int getNombreParcs() {
    return nombreParcs;
  }
  public ArrayList<String> getParcs() {
    return parcs;
  }
  public void setInterventions(int intervention) {
      this.interventions = intervention;
  }

  public void incrementerIntervention(){
    interventions++;
  }

  @Override
  public int compareTo(Statistique statistique) {
    return arrondissement.compareTo(statistique.arrondissement);
  }

  @Override
  public String toString(){
    return arrondissement + ", " + interventions + ", " + nombreParcs;
  }
}