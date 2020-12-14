package inf2050;

import java.time.*;
import java.util.*;

public class Plainte {
    private LocalDate date;
    private String heure;
    private String parc;
    private String arrondissement;
    private String description;


    /**
     * Classe Plainte est un objet pour chaque plainte.
     * La classe contient les détails de chaque ligne plainte et les valeurs CSV.
     */
    public Plainte() {

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

    @Override
    public boolean equals(Object plainte) { 
    
        if (plainte == this) { 
            return true; 
        } 
  
        if (!(plainte instanceof Plainte)) { 
            return false; 
        } 
          
        Plainte plainte2 = (Plainte) plainte;
        if(this.getArrondissement().equals(plainte2.getArrondissement())){
            return true;
        }
        return false;
    } 


    /**
     * Cet méthode retrouve si un texte se trouve dans un tableau de texte.
     * Retourne true si le texte existe dans le tableau.
     * @param texte Texte qui sera recherché.
     * @param possibilitesValides Tableau dont la recherche sera faite.
     */
    public static boolean validerSiExisteDansTableau(String texte, String[] possibilitesValides) {
        return Arrays.stream(possibilitesValides).anyMatch(texte::equals);
    }

    /**
     * Cet méthode prends un tableau d'elements et crée un object Plainte.
     * Retourne l'objet crée.
     * @param elementsPlainte Elements utilisés pour créer l'objet.
     * @param champsEntete Le champs d'entete utilisé pour indiquer quel champs manque dans le cas d'un erreur.
     * @param arrondissementsValides Tableau d'arrondissements utilisés pour valider le champ d'arrondissement
     * @param descriptionsValides Tableau d'interventions/déscriptions utilisés pour valider le champ d'interventions/déscriptions
     * @throws Exception Le message d'exception jeté par la méthode.
     */
    public static Plainte creerPlainteAvecValidation(String[] elementsPlainte, String[] champsEntete,
            String[] arrondissementsValides, String[] descriptionsValides) throws Exception {
        final String LE_CHAMPS = "Le champs ";
        final String PAS_VALIDE = " n'est pas valide.";
        final String EST_VIDE = " est vide.";
        for (int i = 0; i < elementsPlainte.length; i++) {
            if (elementsPlainte[i] == "") {
                throw new Exception(LE_CHAMPS + champsEntete[i] + EST_VIDE);
            }
        }
        if (!validerSiExisteDansTableau(elementsPlainte[3], arrondissementsValides)) {
            throw new Exception(LE_CHAMPS + "Arrondissement" + PAS_VALIDE);
        }

        if (!validerSiExisteDansTableau(elementsPlainte[4], descriptionsValides)) {
            throw new Exception(LE_CHAMPS + "Description" + PAS_VALIDE);
        }

        Plainte plainte = new Plainte(elementsPlainte);
        return plainte;
    }
}