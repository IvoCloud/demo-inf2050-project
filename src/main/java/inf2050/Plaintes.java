package inf2050;

import inf2050.IO.*;

import java.time.*;

import java.util.*;

public class Plaintes {

    private ArrayList<Plainte> plaintes;
    private String[] entetes;
    private String[] lignesPlaintes;

    public Plaintes() {

    }

    public Plaintes(String nomFichierIn) throws Exception {
        String texteBrut = Fichier.lireFichier(nomFichierIn);
        String[] arrondissementsValides = JSONReader.jsonToArray(JSONReader.jsonOpen("arrondissements.json"), "arrondissements");
        String[] descriptionsValides = JSONReader.jsonToArray(JSONReader.jsonOpen("interventions.json"), "intervention_policiere");

        entetes = extraireChampsEntetes(texteBrut);
        entetes = validerChampsEntetes(entetes);
        lignesPlaintes = extraireLignesPlaintes(texteBrut);
        plaintes = creerListePlainte(lignePlainteEnTableau(lignesPlaintes),entetes,arrondissementsValides,descriptionsValides);
    }

    public ArrayList<Plainte> getPlaintes() {
        return plaintes;
    }

    public void setPlaintes(ArrayList<Plainte> plaintes) {
        this.plaintes = plaintes;
    }

    static String[] extraireChampsEntetes(String texteBrut) throws Exception {
        String ligneEntete = texteBrut.split("\n")[0];
        String[] entetes = ligneEntete.split(",");
        if (entetes.length != 5) {
            throw new Exception("Il n'y a pas suffisamment des champs d'entête");
        }
        return entetes;
    }

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

    static String[] extraireLignesPlaintes(String texteBrut) throws Exception {
        String[] lignesPlaintes = texteBrut.split("\n");
        if (lignesPlaintes.length < 2) {
            throw new Exception("Il n'y a pas des plaintes");
        }
        lignesPlaintes = Arrays.copyOfRange(lignesPlaintes, 1, lignesPlaintes.length);
        return lignesPlaintes;
    }

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