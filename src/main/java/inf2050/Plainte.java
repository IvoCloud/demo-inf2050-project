package inf2050;

import java.time.*;

import java.io.*;

import java.util.*;

import net.sf.json.*;

import java.nio.charset.StandardCharsets;

public class Plainte{
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