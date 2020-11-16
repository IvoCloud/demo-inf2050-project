package inf2050;

import java.time.*;

import java.io.*;

import java.util.*;

import net.sf.json.*;

import java.nio.charset.StandardCharsets;

public class Plainte{
  private LocalDate date;
  private String heure;
  private String parc;
  private String arrondissement;
  private String description;

  public Plainte(String date, String heure, String parc,String arrondissement,String description){

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

  public String toString(){
    return (date + " " + heure + " " + parc + " " + arrondissement + " " + description);
  }

  static ArrayList<Plainte> lirePlaintes(String nomFichierIn){
    ArrayList<Plainte> plaintes = new ArrayList<>();
    try{
        int numeroLigne = 1;
        File fichier = new File(nomFichierIn);
        Scanner scanner = new Scanner(fichier, StandardCharsets.UTF_8.name());
        if(scanner.hasNext()) scanner.next();
        while(scanner.hasNextLine()){
          String ligne = scanner.nextLine();
          if(!ligne.equals("")){
              String[] elements = ligne.split(",");
              ArrayList<String> erreurs = validerLigne(elements);
              if(erreurs.size() == 0){
                  plaintes.add(new Plainte(elements[0], elements[1], elements[2], elements[3], elements[4]));
              }else{
                  messageErreur(nomFichierIn, numeroLigne, erreurs);
                  System.exit(0);
              }
          }
          numeroLigne++;
        }
        scanner.close();
    }catch(FileNotFoundException e){
        System.out.println("Erreur de lecture du fichier: " +e);
        System.exit(0);
    }
    return plaintes;
  }

  static boolean verifierDetails(String description, String champ){
    String data = "";
    String nomFichier = champ.equals("arrondissements")?"arrondissements.json":"interventions.json";
    try{
      File fichier = new File("./src/main/ressources/json/"+nomFichier);
      Scanner scanner = new Scanner(fichier, StandardCharsets.UTF_8.name());
      while (scanner.hasNextLine()) {
        data += scanner.nextLine();
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Erreur de lecture du fichier"+nomFichier);
      e.printStackTrace();
    }
    JSONObject jsonFile = new JSONObject();
    jsonFile = (JSONObject)JSONSerializer.toJSON(data);
    JSONArray arrDetails = (JSONArray)jsonFile.get(champ);
    return arrDetails.contains(description);
  }

  static void messageErreur(String fichier, int numeroLigne, ArrayList<String> erreurs){
      for(String erreur:erreurs){
          System.out.println("Erreur dans le fichier "+ fichier +" à la ligne " + numeroLigne + " : Le champ " + erreur + " est manquant.");
      }
  }

  static ArrayList<String> validerLigne(String[] elements){
      ArrayList<String> erreurs = new ArrayList<String>();
      if(!verifierDetails(elements[3], "arrondissements")){
          erreurs.add("Arrondissement");
      }
      if(!verifierDetails(elements[4], "intervention_policiere")){
          erreurs.add("Description");
      }
      return erreurs;
  }
}