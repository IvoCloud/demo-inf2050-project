/**
 * @author Ivaylo Ivanov
 * IVAI08039506
 */

package inf2050;

import java.util.*;

import java.io.*;

/**
 * Class App
 */
public class App {
    
    /**
     * Méthode main du projet. 
     * _Main_ gère aussi les exceptions lancées par les autre méthodes.
     * @param args args[0] - La destination de lecture.
     * @param args args[1] - La destination de l'écriture.
     */
    public static void main(String[] args){

        try{
            validerLongueurTableau(args,2);
            String nomFichierIn = args[0];
            String nomFichierOut = args[1];

            String texteSortie = "Arrondissement, Nombre d'interventions, Nombre de parcs\n";

            System.out.println(nomFichierIn);
            System.out.println(nomFichierOut);

            Plaintes plaintes = new Plaintes(nomFichierIn);
            Statistiques statistiques = new Statistiques();

            for (Plainte plainte : plaintes.getPlaintes()) {
                statistiques.ajouterPlainteDansStatistiques(plainte);
            }

            Collections.sort(statistiques.getStatistiques());


            for (Statistique stats : statistiques.getStatistiques()) {
                texteSortie = texteSortie.concat(stats+"\n");
            }

            FileWriter writer = new FileWriter(nomFichierOut);
            writer.write(texteSortie);
            writer.close();
            System.out.println("Statistique enregistre");

        
        }catch(Exception e){
            System.out.print("Erreur: ");
            System.out.println(e.getMessage());
        }

    }

    /**
     * Cet méthode verifie si la longueur d'un tableau est égal à une longueur spécifiée.
     * @param args Le tableau dont ont verifie la longueur.
     * @param longueur  La longueur à verifier.
     * @throws Exception Le message d'exception jeté par la méthode.
     */
    static void validerLongueurTableau(String[] array, int longueur)throws Exception{
        if(array.length != longueur){
            throw new Exception("Longueur des args[] n'est pas 2");
        }
    }
}