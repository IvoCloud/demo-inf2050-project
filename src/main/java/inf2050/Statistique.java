package inf2050;

/**
 * Class Planinte enregistre chaque ligne du fichier en entree 
 * dans un nouveau objet plainte.
 */

/**
 * Classe Statistique enregistre les intervention dans chaque arrondissement
 * @param arrondissement - Lieu de l'intervention
 * @param intervention - Quantite des interventions
 */
public class Statistique{
    
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

  void incrementerIntervention(){
      ++intervention;
  }
}