package inf2050;

import java.util.*;

/**
 * Classe Statistiques est une liste des objets Statistique.
 * 
 * @param arrondissement - Lieu de l'intervention
 * @param interventions  - Quantite des interventions
 */
public class Statistiques {
    private ArrayList<Statistique> statistiques = new ArrayList<>();

    public ArrayList<Statistique> getStatistiques() {
        return statistiques;
    }

    public Statistiques() {
    }

    /**
     * Cet méthode ajoute un objet Plainte dans la liste statistiques.
     * Si l'objet existe dans la liste, l'intervention sera incrementée.
     * Si le parc du meme arrondissement existe dans la liste, le nombre des parcs sera incrementé.
     * 
     * @param plainte Plainte qui sera ajouté dans la liste statistiques.
     */
    void ajouterPlainteDansStatistiques(Plainte plainte) {
        boolean existe = false;
        if (statistiques.size() == 0) {
            statistiques.add(new Statistique(plainte));
        } else {
            for (int i = 0; i < statistiques.size(); i++) {
                if (statistiques.get(i).getArrondissement().equals(plainte.getArrondissement())) {
                    statistiques.get(i).incrementerIntervention();
                    statistiques.get(i).ajouterParc(plainte.getParc());
                    existe = true;
                }
            }
            if (!existe) {
                statistiques.add(new Statistique(plainte.getArrondissement(), plainte.getParc()));
            }
        }
    }
}
