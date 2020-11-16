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
    public static void main(String[] args) {
        String nomFichierIn = args[0];
        String nomFichierOut = args[1];

        ArrayList<Plainte> plaintes = new ArrayList<>();
        ArrayList<Statistique> statistiques = new ArrayList<>();

        plaintes = Plainte.lirePlaintes(nomFichierIn);
        statistiques = Statistique.creerListeStatistiques(plaintes);
        Statistique.ecrireStatistiques(statistiques, nomFichierOut);
    }
}