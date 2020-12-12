package inf2050;

import java.time.*;

import java.io.*;

import java.nio.charset.StandardCharsets;

import java.util.*;

public class Plaintes{

  private ArrayList<Plainte> plaintes;
  private String texteBrut;
  private String[] entetes;
  private String[] lignesPlaintes;

  public Plaintes(){
    this.texteBrut = "";
  }

  public Plaintes(String nomFichierIn)throws Exception{
    texteBrut = lireFichier(nomFichierIn);
    entetes = extraireChampsEntetes(texteBrut);
    entetes = validerChampsEntetes(entetes);
    lignesPlaintes = extraireLignesPlaintes(texteBrut);
  }

  public ArrayList<Plainte> getPlaintes(){
    return plaintes;
  }

  public void setPlaintes(ArrayList<Plainte> plaintes){
    this.plaintes = plaintes;
  }

  public String getTexteBrut(){
    return texteBrut;
  }

  public void setTexteBrut(String texteBrut){
    this.texteBrut = texteBrut;
  }

  String lireFichier(String nomFichierIn)throws Exception{
    String data="";
    try{
      File fichier = new File("./src/main/ressources/"+nomFichierIn);
      Scanner scanner = new Scanner(fichier, StandardCharsets.UTF_8.name());
      while(scanner.hasNextLine()){
        data += scanner.nextLine() + '\n';
      }
      scanner.close();
    }catch(FileNotFoundException e){
      throw new Exception("Le fichier d'entrée n'existe pas.");
    }
    if(data==""){
      throw new Exception("Le fichier d'entrée est vide");
    }
    return data;
  }

  String[] extraireChampsEntetes(String texteBrut)throws Exception{
    String ligneEntete = texteBrut.split("\n")[0];
    String[] entetes = ligneEntete.split(",");
    if(entetes.length != 5){
      throw new Exception("Il n'y a pas suffisamment des champs d'entête");
    }
    return entetes;
  }
  
  String[] validerChampsEntetes(String[] entetes)throws Exception{
    String[] contrainteEntetes = {"Date","Heure","Parc","Arrondissement","Description"};
    for (String string : entetes) {
      string = string.trim();
    }
    if(Arrays.compare(entetes, contrainteEntetes)!=0){
      throw new Exception("Les champs d'entête ne sont pas valides");
    }
    return entetes;
  }
  
  String[] extraireLignesPlaintes(String texteBrut)throws Exception{
    String[] lignesPlaintes = texteBrut.split("\n");
    if(lignesPlaintes.length<2){
      throw new Exception("Il n'y a pas des plaintes");
    }
    lignesPlaintes = Arrays.copyOfRange(lignesPlaintes,1,lignesPlaintes.length);
    return lignesPlaintes;
  } 
  
  // String[] validerLignesPlaintes(String[] tableauPlaintes, String[] contrainteArrondissements, String[] contrainteInterventions)throws Exception{

  //   String path = "./src/main/ressources/json/"+fileName;
  // }

  // ArrayList<Plaintes> separerTSexteCsvEnListePlaintes(String texteBrutes){
  //   ArrayList<Plaintes> listePlaintes = new ArrayList<>();


  //   return listePlaintes;
  // }
  // ArrayList<Plainte> convertir(String nomFichierIn){
  //   try{
  //       int numeroLigne = 1;
  //       File fichier = new File("./src/main/ressources/"+nomFichierIn);
  //       Scanner scanner = new Scanner(fichier, StandardCharsets.UTF_8.name());
  //       if(scanner.hasNext()) scanner.next();
  //       while(scanner.hasNextLine()){
  //         String ligne = scanner.nextLine();
  //         if(!ligne.equals("")){
  //             String[] elements = ligne.split(",");
  //             ArrayList<String> erreurs = validerLigne(elements);
  //             if(erreurs.size() == 0){
  //                 plaintes.add(new Plainte(elements[0], elements[1], elements[2], elements[3], elements[4]));
  //             }else{
  //                 messageErreur(nomFichierIn, numeroLigne, erreurs);
  //                 System.exit(0);
  //             }
  //         }
  //         numeroLigne++;
  //       }
  //       scanner.close();
  //   }catch(FileNotFoundException e){
  //       System.out.println("Erreur de lecture du fichier: " +e);
  //       System.exit(0);
  //   }
  //   return plaintes;
  // }
}