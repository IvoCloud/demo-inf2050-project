package inf2050.IO;

import java.nio.charset.StandardCharsets;

import java.io.*;

import java.util.*;

public class Fichier {
  

  public static String lireFichier(String nomFichierIn) throws Exception{
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
}
