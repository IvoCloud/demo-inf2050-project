/**
 * @author Ivaylo Ivanov
 * IVAI08039506
 */

package inf2050;

import java.util.*;

import inf2050.Plainte;

import inf2050.Statistique;

import net.sf.json.*;

/**
 * Class App
 */
public class App {
    
    /**
     * Fonction main du projet
     * @param args args[0] - La destination de lecture.
     * @param args args[1] - La destination de l'écriture.
     */
    public static void main(String[] args)throws Exception{
        // String nomFichierIn = args[0];
        // String nomFichierOut = args[1];

        validerLongueurTableau(args,2);



        System.out.println("Next");

        // ArrayList<Plainte> plaintes = new ArrayList<>();
        // ArrayList<Statistique> statistiques = new ArrayList<>();

        // plaintes = Plainte.lirePlaintes(nomFichierIn);
        // statistiques = Statistique.creerListeStatistiques(plaintes);
        // Statistique.ecrireStatistiques(statistiques, nomFichierOut);
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