package inf2050;

import java.util.*;
import java.io.*;
import java.time.*;

/**
 * Hello world!
 */
public final class App {
    
    /**
     * 
     * @param args 
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
                        if(statistique.getArrondissement().equals(plainte.getArrondissement())) {
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
}

class Plainte{
    private LocalDate date;
    private String heure;
    private String parc;
    private String arrondissement;
    private String description;

    public Plainte(String date, String heure, String parc,String arrondissement,String description){
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
};

class Statistique{
    
    private String arrondissement;
    private int intervention=1;

    public Statistique(String arrondissement){
        this.arrondissement = arrondissement;
    };

    public String getArrondissement() {
        return arrondissement;
    }
    public int getIntervention() {
        return intervention;
    }
    public void setIntervention(int intervention) {
        this.intervention = intervention;
    }

    void incrementerIntervention(){
        ++intervention;
    }
}