package inf2050;

import inf2050.IO.*;

import java.util.*;


/**
 * Classe Plaintes s'occupe à transformer un texte en format CSV
 * et séparer les élements dans des tableaux.
 * Classe Plaintes crée aussi des instances de l'objet Plainte pour chaque ligne du texte reçue.
 */
public class Plaintes {

    private ArrayList<Plainte> plaintes;
    private String[] entetes;
    private String[] lignesPlaintes;

    public Plaintes() {
        plaintes = new ArrayList<>();
    }

    public Plaintes(String nomFichierIn) throws Exception {
        String texteBrut = Fichier.lireFichier(nomFichierIn);
        String[] arrondissementsValides = JSONReader.retourneArrondissements();
        String[] descriptionsValides = JSONReader.retourneInterventions();

        entetes = extraireChampsEntetes(texteBrut);
        entetes = validerChampsEntetes(entetes);
        lignesPlaintes = extraireLignesPlaintes(texteBrut);
        plaintes = creerListePlainte(lignePlainteEnTableau(lignesPlaintes),entetes,arrondissementsValides,descriptionsValides);
    }

    public ArrayList<Plainte> getPlaintes() {
        return plaintes;
    }

    public void addPlaintes(Plainte plainte) {
        plaintes.add(plainte);
    }

    /**
     * Cet méthode retourne le premier champs d'un texte en format CSV.
     * Retourne un table avec les valeurs de la première ligne.
     * La méthode retourne 5 champs d'entête sinon retourne Exception.
     * @param texteBrut Texte en format CSV
     * @throws Exception Le message d'exception jeté par la méthode.
     */
    static String[] extraireChampsEntetes(String texteBrut) throws Exception {
        String ligneEntete = texteBrut.split("\n")[0];
        String[] entetes = ligneEntete.split(",");
        if (entetes.length != 5) {
            throw new Exception("Il n'y a pas suffisamment des champs d'entête");
        }
        return entetes;
    }

    /**
     * Cet méthode valide un tableau avec un tableau determiné.
     * @param entetes Tableau qui sera comparé avec le tableau determiné.
     * @throws Exception Le message d'exception jeté par la méthode.
     */
    static String[] validerChampsEntetes(String[] entetes) throws Exception {
        String[] contrainteEntetes = { "Date", "Heure", "Parc", "Arrondissement", "Description" };
        for (String entete : entetes) {
            entete = entete.trim();
        }
        if (Arrays.compare(entetes, contrainteEntetes) != 0) {
            throw new Exception("Les champs d'entête ne sont pas valides");
        }
        return entetes;
    }

    /**
     * Cet méthode sépare un texte et retourne les lignes dans un tableau.
     * @param texteBrut texte qui sera separé dans un tableau
     * @throws Exception Le message d'exception jeté par la méthode.
     */
    static String[] extraireLignesPlaintes(String texteBrut) throws Exception {
        String[] lignesPlaintes = texteBrut.split("\n");
        if (lignesPlaintes.length < 2) {
            throw new Exception("Il n'y a pas des plaintes");
        }
        lignesPlaintes = Arrays.copyOfRange(lignesPlaintes, 1, lignesPlaintes.length);
        return lignesPlaintes;
    }

    /**
     * Cet méthode sépare une ligne en format CSV et les returne dans un nouveau tableau
     * Retourne un tableau 2d de chaque ligne et les valeurs dans la ligne.
     * @param tableauLignesPlaintes texte qui sera separé dans un tableau
     * @throws Exception Le message d'exception jeté par la méthode.
     */
    static String[][] lignePlainteEnTableau(String[] tableauLignesPlaintes) throws Exception {
        int longueur = tableauLignesPlaintes.length;
        String[][] tableauPlaintesSepares = new String[longueur][5];

        for (int i = 0; i < longueur; i++) {
            String[] tableauChaquePlainte = tableauLignesPlaintes[i].split(",");
            if (tableauChaquePlainte.length < 5 || tableauChaquePlainte.length > 5) {
                throw new Exception("Erreur à la ligne " + (i + 1) + ".\n Il n'y a pas 5 valeurs dans la ligne.");
            }
            for (int k = 0; k < tableauChaquePlainte.length; k++) {
                tableauPlaintesSepares[i][k] = tableauChaquePlainte[k].trim();
            }
        }
        return tableauPlaintesSepares;
    }

    /**
     * Cet méthode prends un tableau 2d d'elements et crée une liste des objects Plainte.
     * Retourne ArrayList<Plainte>.
     * Les champs champsEntete, arrondissementsValides et descriptionsValides seront passés en argument à la
     * méthode Plainte.creerPlainteAvecValidation.
     * 
     * @param tableuPlaintes Elements utilisés pour créer la liste.
     * @param champsEntete Le champs d'entete utilisé pour indiquer quel champs manque dans le cas d'un erreur.
     * @param arrondissementsValides Tableau d'arrondissements utilisés pour valider le champ d'arrondissement
     * @param descriptionsValides Tableau d'interventions/déscriptions utilisés pour valider le champ d'interventions/déscriptions
     * @throws Exception Le message d'exception jeté par la méthode.
     */
    static ArrayList<Plainte> creerListePlainte(String[][] tableuPlaintes, String[] entetes,String[] arrondissementsValides, String[] descriptionsValides) throws Exception {
        ArrayList<Plainte> listePlaintes = new ArrayList<>();
        for (int i = 0; i < tableuPlaintes.length; i++) {
            try {
                Plainte plainte = Plainte.creerPlainteAvecValidation(tableuPlaintes[i], entetes, arrondissementsValides, descriptionsValides);
                listePlaintes.add(plainte);
            } catch (Exception e) {
                String errMsg = "Erreur à la ligne " + (i + 1) + ". " + e.getMessage();
                throw new Exception(errMsg);
            }
        }
        return listePlaintes;
    }
}