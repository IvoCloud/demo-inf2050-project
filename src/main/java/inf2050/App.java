/**
 * @author Ivaylo Ivanov
 * IVAI08039506
 */

package inf2050;

import inf2050.IO.*;

/**
 * Class App
 */
public class App {
    
    /**
     * Fonction main du projet
     * @param args args[0] - La destination de lecture.
     * @param args args[1] - La destination de l'écriture.
     */
    public static void main(String[] args){

        try{
            validerLongueurTableau(args,2);
            String nomFichierIn = args[0];
            String nomFichierOut = args[1];

            System.out.println(nomFichierIn);
            System.out.println(nomFichierOut);

            Plaintes plaintes = new Plaintes(nomFichierIn);

            for (Plainte plainte : plaintes.getPlaintes()) {
                

            }
        
        }catch(Exception e){
            System.out.print("Erreur: ");
            System.out.println(e.getMessage());
        }


            // FileWriter writer = new FileWriter("test.csv");
            // // writer.write(plaintes.getTexteBrut());
            // writer.close();
            // System.out.println("Statistique enregistre");



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