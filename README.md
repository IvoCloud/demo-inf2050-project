`Ivaylo Ivanov IVAI08039506`

## TP 3 INF2050

  Ceci est un projet qui lit un fichier `.CSV` et analyze les données afin d'écrire un fichier de sortie `.CSV`.

  Le programme lit le premier _args_ de `main` et ecris dans un fichier spécifié dans le deuxième _args_ de `main`. Une liste de object `Plainte` est crée à la lecture et est transformée en object `Statistique`.

  - Les classes `Plaintes` et `Statistiques` contiennent des _ArrayList_ des object `Plainte` et `Statistique`.

  - Le programme compare aussi les champs _Arrondissement_ et _Intervention_ et valide les données à partir de deux fichiers `json`: _`arrondissements.json`_ et _`interventions.json`_


  ### Bogues

  - Le module `json-lib` cause une erreur de _`NoClassDefFoundError: net/sf/json/JSONObject`_ quand le programme est lancé à partir du _.jar_ . <br>
  Les test dans _`JSONReaderTest.java`_ passent avec succès, mais le programme ne lance pas. <br>**Fixe Temporaire:** Copier les données des fichiers _`.json`_ et les initialiser dans des _String_.