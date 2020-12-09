package inf2050;

import java.time.*;

import java.io.*;

import java.nio.charset.StandardCharsets;

import java.util.*;

import net.sf.json.*;


public class Plaintes{

  private ArrayList<Plainte> plaintes;
  private String plaintesRaw;

  public Plaintes(String nomFichierIn)throws Exception{
    this.plaintesRaw = lireFichier(nomFichierIn);
  }

  public ArrayList<Plainte> getPlaintes(){
    return plaintes;
  }

  public void setPlaintes(ArrayList<Plainte> plaintes){
    this.plaintes = plaintes;
  }

  public String getPlaintesRaw(){
    return plaintesRaw;
  }

  public void setPlaintesRaw(String plaintesRaw){
    this.plaintesRaw = plaintesRaw;
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
    return data;
  }

  
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