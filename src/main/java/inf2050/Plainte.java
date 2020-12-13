package inf2050;

import java.time.*;
import java.util.Arrays;

public class Plainte {
  private LocalDate date;
  private String heure;
  private String parc;
  private String arrondissement;
  private String description;

  

  // 2020-09-01,20:41,Parc Camille,Ahuntsic-Cartierville,Vente de drogues

  public Plainte(){

  }
  
  public Plainte(String[] elementsPlainte) throws Exception {

    this.date = LocalDate.parse(elementsPlainte[0]);
    this.heure = elementsPlainte[1];
    this.parc = elementsPlainte[2];
    this.arrondissement = elementsPlainte[3];
    this.description = elementsPlainte[4];

  }

  public Plainte(String date, String heure, String parc, String arrondissement, String description) {

    this.date = LocalDate.parse(date);
    this.heure = heure;
    this.parc = parc;
    this.arrondissement = arrondissement;
    this.description = description;

  }

  public String getArrondissement() {
    return arrondissement;
  }

  public LocalDate getDate() {
    return date;
  }

  public String getDescription() {
    return description;
  }

  public String getHeure() {
    return heure;
  }

  public String getParc() {
    return parc;
  }

  public String toString() {
    return (date + " " + heure + " " + parc + " " + arrondissement + " " + description);
  }

  public boolean validerSiExisteDansTableau(String texte, String[] possibilitesValides){
    return Arrays.stream(possibilitesValides).anyMatch(texte::equals);
  }

  // // Date,Heure,Parc,Arrondissement,Description
  // public Plainte creerPlainteAvecValidation(String[] elementsPlainte, String[] arrondissementsValides, String[] descriptionsValides) throws Exception{
  //   final String LE_CHAMPS = "Le champs ";
  //   final String PAS_VALIDE = " n'est pas valide.";
  //   final String EST_VIDE = " est vide.";
  //   if (elementsPlainte[0] == "") {
  //     throw new Exception(LE_CHAMPS+"date"+EST_VIDE);
  //   }
  //   if (elementsPlainte[1] == "") {
  //     throw new Exception(LE_CHAMPS+"heure"+EST_VIDE);
  //   }
  //   if (elementsPlainte[2] == "") {
  //     throw new Exception(LE_CHAMPS+"parc"+EST_VIDE);
  //   }
  //   if (elementsPlainte[3] == "") {
  //     throw new Exception(LE_CHAMPS+"arrondissement"+EST_VIDE);
  //   }
  //   if(validerSiExisteDansTableau(elementsPlainte[3], arrondissementsValides)){
  //     throw new Exception(LE_CHAMPS+"arrondissement"+PAS_VALIDE);
  //   }
  //   if (elementsPlainte[4] == "") {
  //     throw new Exception(LE_CHAMPS+"description"+EST_VIDE);
  //   }
  //   if(validerSiExisteDansTableau(elementsPlainte[4], descriptionsValides)){
  //     throw new Exception(LE_CHAMPS+"description"+PAS_VALIDE);
  //   }

  //   Plainte plainte = new Plainte(elementsPlainte);
  //   return plainte;
  // }

  // static boolean verifierDetails(String description, String champ){
  // String data = "";
  // String nomFichier =
  // champ.equals("arrondissements")?"arrondissements.json":"interventions.json";
  // try{
  // File fichier = new File("./src/main/ressources/json/"+nomFichier);
  // Scanner scanner = new Scanner(fichier, StandardCharsets.UTF_8.name());
  // while (scanner.hasNextLine()) {
  // data += scanner.nextLine();
  // }
  // scanner.close();
  // } catch (FileNotFoundException e) {
  // System.out.println("Erreur de lecture du fichier"+nomFichier);
  // e.printStackTrace();
  // }
  // JSONObject jsonFile = new JSONObject();
  // jsonFile = (JSONObject)JSONSerializer.toJSON(data);
  // JSONArray arrDetails = (JSONArray)jsonFile.get(champ);
  // return arrDetails.contains(description);
  // }

  // static void messageErreur(String fichier, int numeroLigne, ArrayList<String>
  // erreurs){
  // for(String erreur:erreurs){
  // System.out.println("Erreur dans le fichier "+ fichier +" à la ligne " +
  // numeroLigne + " : Le champ " + erreur + " est manquant.");
  // }
  // }

  // static ArrayList<String> validerLigne(String[] elements){
  // ArrayList<String> erreurs = new ArrayList<String>();
  // if(!verifierDetails(elements[3], "arrondissements")){
  // erreurs.add("Arrondissement");
  // }
  // if(!verifierDetails(elements[4], "intervention_policiere")){
  // erreurs.add("Description");
  // }
  // return erreurs;
  // }
}