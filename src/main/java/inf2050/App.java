/**
 * @author Ivaylo Ivanov
 * IVAI08039506
 */

package inf2050;

import java.util.*;

import java.io.*;

import inf2050.Plainte;

import inf2050.Statistique;

import net.sf.json.*;

import java.nio.charset.StandardCharsets;

/**
 * Class App
 */
public class App {
    
    /**
     * Fonction main du projet
     * @param args args[0] - La destination ou le nom du fichier.
     */
    public static void main(String[] args) {
        String path = args[0];

        String sortie = "Arrondissement,Nombre d'interventions\n";
        
        List<Plainte> plaintes = new ArrayList<>();
        List<Statistique> statistiques = new ArrayList<>();

        try{
            File fichier = new File(path);
            Scanner scanner = new Scanner(fichier);
            if(scanner.hasNext()) scanner.next();
            while(scanner.hasNextLine()){
                String ligne = scanner.nextLine();
                if(!ligne.equals("")){
                    String[] elements = ligne.split(",");
                    validerLigne(elements);
                    Plainte plainte = new Plainte(elements[0], elements[1], elements[2], elements[3], elements[4]);
                    plaintes.add(plainte);
                }
            }
            scanner.close();
            
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

            for(Statistique statistique: statistiques){
                sortie = sortie.concat(statistique.getArrondissement() + "," + statistique.getIntervention()+"\n");
            };
            try{
                FileWriter writer = new FileWriter("sortie.csv");
                writer.write(sortie);
                writer.close();
                System.out.println("Fichier enregistre");
            }catch(IOException e){
                System.out.println("Erreur d'ecriture: " + e);
            }
        }catch(FileNotFoundException e){
            System.out.println("Erreur de lecture du fichier: " +e);
        }
    }

    static boolean verifierArrondissement(String arrondissement){
        String data = "";
        try{
          File fichierArrondissement = new File("./src/main/ressources/json/arrondissements.json");
          Scanner scanner = new Scanner(fichierArrondissement, StandardCharsets.UTF_8.name());
          while (scanner.hasNextLine()) {
            data += scanner.nextLine();
          }
          scanner.close();
        } catch (FileNotFoundException e) {
          System.out.println("Erreur de lecture du fichier arrondissements.json");
          e.printStackTrace();
        }
        JSONObject jsonFile = new JSONObject();
        jsonFile = (JSONObject)JSONSerializer.toJSON(data);
        JSONArray arrondissements = (JSONArray)jsonFile.get("arrondissements");
    
        return arrondissements.contains(arrondissement);
    }

    static boolean verifierIntervention(String intervention){
        String data = "";
        try{
          File fichierIntervention = new File("./src/main/ressources/json/interventions.json");
          Scanner scanner = new Scanner(fichierIntervention, StandardCharsets.UTF_8.name());
          while (scanner.hasNextLine()) {
            data += scanner.nextLine();
          }
          scanner.close();
        } catch (FileNotFoundException e) {
          System.out.println("Erreur de lecture du fichier interventions.json");
          e.printStackTrace();
        }
        JSONObject jsonFile = new JSONObject();
        jsonFile = (JSONObject)JSONSerializer.toJSON(data);
        JSONArray interventions = (JSONArray)jsonFile.get("intervention_policiere");

        return interventions.contains(intervention);
    }

    static String messageErreur(String fichier, int numeroLigne, String champs){
        return "Erreur dans le fichier "+ fichier +" à la ligne " + numeroLigne + " : Le champ " + champs + " est manquant.";
    }

    static ArrayList<String> validerLigne(String[] elements){
        ArrayList<String> erreurs = new ArrayList<String>();

        if(!verifierArrondissement(elements[3])){
            erreurs.add(elements[3]);
        }
        if(!verifierIntervention(elements[4])){
            erreurs.add(elements[4]);
        }
        return erreurs;
    }
}