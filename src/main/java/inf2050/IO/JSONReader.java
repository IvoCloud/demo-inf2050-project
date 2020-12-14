package inf2050.IO;

import java.util.*;

import java.io.*;

import net.sf.json.*;

import java.nio.charset.StandardCharsets;

public class JSONReader {

    // Erreur ClassNotFoundException pour JSONObject et JSONSerializer

    /*
     * 
     * public static String jsonOpen(String nomFichier) throws FileNotFoundException
     * { String data = ""; String path = "./src/main/ressources/json/"+nomFichier;
     * File file = new File(path); Scanner scanner = new Scanner(file,
     * StandardCharsets.UTF_8.name()); while (scanner.hasNextLine()) { data +=
     * scanner.nextLine(); } scanner.close(); System.out.println(data); return data;
     * }
     * 
     * 
     * public static String[] jsonToArray(String jsonString, String champ) throws
     * Exception { try { JSONObject jsonObject = (JSONObject)
     * JSONSerializer.toJSON(jsonString); JSONArray jsonArray = (JSONArray)
     * jsonObject.get(champ); Object[] objectArray = jsonArray.toArray(); String[]
     * array = Arrays.asList(objectArray).toArray(new String[objectArray.length]);
     * return array; } catch (NullPointerException e) { throw new
     * Exception("Le champ est vide!"); } catch (Exception e) { throw new
     * Exception("String Json est invalide!"); } }
     * 
     * 
     */

    public static String[] retourneArrondissements() {
        return new String[] { "Ahuntsic-Cartierville", "Anjou", "Côte-des-Neiges—Notre-Dame-de-Grâce", "Lachine",
                "LaSalle", "Le Plateau-Mont-Royal", "Le Sud-Ouest", "L'Île-Bizard–Sainte-Geneviève",
                "Mercier–Hochelaga-Maisonneuve", "Montréal-Nord", "Outremont", "Pierrefonds-Roxboro",
                "Rivière-des-Prairies–Pointe-aux-Trembles", "Rosemont–La Petite-Patrie", "Saint-Laurent",
                "Saint-Léonard", "Verdun", "Ville-Marie", "Villeray–Saint-Michel–Parc-Extension" };
    }

    public static String[] retourneInterventions() {
        return new String[] { "Vol de véhicule à moteur", "Méfait", "Vols qualifiés",
                "Vol dans / sur véhicule à moteur", "Introduction", "Infractions entrainant la mort",
                "Vente de drogues", "Bagarre", "Manifestation illégale", "Possession / consommation de stupéfiant",
                "Port d'arme prohibée" };
    }
}