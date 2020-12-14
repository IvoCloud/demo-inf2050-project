# Liste des exigences

- TP 3.1 Le programme doit accepter le nom du fichier d'entrée dans le premier argument du `main`.
- TP 3.2 Le programme doit accepter le nom du fichier de sortie dans le deuxième argument du `main`.
- TP 3.3 : Le fichier d'entrée doit avoir l'extention `.csv`.
- TP 3.4 : Le fichier d'entrée doit être dans un format `.csv` valide.  
  C'est-à-dire que les valeurs dans le fichier doivent être separés pas des virgulues.
- TP 3.5 Le fichier d'entrée doit avoir les champs suivant: `Date, Heure, Parc,Arrondissement,Description`.
- TP 3.6 Un fichier `JSON` avec la liste des arrondissements à Montréal dans un répertoire `json` à la racine du projet.
- TP 3.7 Le programme doit se treminer et afficher un message d'erreur si l'arrondissement n'est pas présent dans la liste du fichier `JSON`.
- TP 3.8 Un fichier `JSON` avec la liste des decriptions possibles dans un répertoire `json` à la racine du projet.
- TP 3.9 Le programme doit se treminer et afficher un message d'erreur si la decription n'est pas présente dans la liste du fichier `JSON`.
- TP 3.10 La liste des arrondissements doit être triée et sauvegardée en ordre alphabétique.
- TP 3.11 Le champ date doit être dans le format `AAAA-MM-JJ` en format `ISO 8601`.
- TP 3.12 Le champ heure doit être dans le format `HH-MM` en format `ISO 8601`.
- TP 3.13 Le champ `Parc` ne doit pas être une chaine vide.
- TP 3.14 Le champ `Arrondissement` ne doit pas être une chaine vide.
- TP 3.15 Le champ `Description` ne doit pas être une chaine vide.

# Plan de tests

| N.  | Fonctionnalité | Résultat attendu                     | Description                                                           | Données                                                                                             |
| :-- | :------------: | :----------------------------------- | :-------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------- |
| C1  | TP 3.1, TP 3.2 | Message d'erreur. Arrêt du programme | Nombre d'arguments passés au _main_ - 0                               | 0 paramètres passés à _main_                                                                        |
| C2  | TP 3.1, TP 3.2 | Message d'erreur. Arrêt du programme | Nombre d'arguments passés le _main_ - 1                               | 1 paramètres passé à _main_                                                                         |
| C3  | TP 3.1, TP 3.2 | Message d'erreur. Arrêt du programme | Nombre d'arguments passés le _main_ - 2                               | 2 paramètres passés à _main_                                                                        |
| C4  |     TP 3.3     | Message d'erreur. Arrêt du programme | Format du fichier d'entrée                                            | Fichier d'entrée different de _.csv_                                                                |
| C5  |     TP 3.4     | Message d'erreur. Arrêt du programme | Les valeur du fichier d'entrée ne sont pas separées pas `,`           | Fichier d'entrée du format _.csv_. Valeurs séparées par un autre symbole que `,`                    |
| C6  |     TP 3.5     | Message d'erreur. Arrêt du programme | Champ `Date` manquant dans le fichier d'entrée.                       | Fichier d'entrée complèt. Champ `Date` manquant.                                                    |
| C7  |     TP 3.5     | Message d'erreur. Arrêt du programme | Champ `Heure` manquant dans le fichier d'entrée.                      | Fichier d'entrée complèt. Champ `Heure` manquant.                                                   |
| C8  |     TP 3.5     | Message d'erreur. Arrêt du programme | Champ `Parc` manquant dans le fichier d'entrée.                       | Fichier d'entrée complèt. Champ `Parc` manquant.                                                    |
| C9  |     TP 3.5     | Message d'erreur. Arrêt du programme | Champ `Arrondissement` manquant dans le fichier d'entrée.             | Fichier d'entrée complèt. Champ `Arrondissement` manquant.                                          |
| C10 |     TP 3.5     | Message d'erreur. Arrêt du programme | Champ `Description` manquant dans le fichier d'entrée.                | Fichier d'entrée complèt. Champ `Description` manquant.                                             |
| C11 |     TP 3.5     | Message d'erreur. Arrêt du programme | Champ `Description` manquant dans le fichier d'entrée.                | Fichier d'entrée complèt. Champ `Description` manquant.                                             |
| C12 |     TP 3.6     | Message d'erreur. Arrêt du programme | Fichier `arrondissements.json` existe dans le répertoire **json**     | Fichier d'entrée complèt. Fichier `arrondissements.json` n'existe pas     |
| C13 |     TP 3.6     | Message d'erreur. Arrêt du programme | Fichier `arrondissements.json` est vide                               | Fichier d'entrée complèt. Fichier `arrondissements.json` est vide                                   |
| C14 |     TP 3.6     | Message d'erreur. Arrêt du programme | Fichier `arrondissements.json` n'est pas du format `JSON`             | Fichier d'entrée complèt. Fichier `arrondissements.json` n'est pas du format `JSON` valide          |
| C15 |     TP 3.7     | Message d'erreur. Arrêt du programme | L'arrondissement du fichier d'entrée n'est pas dans le fichier _json_ | Fichier d'entrée complèt. L'arrondissement ne fais pas partie de la liste de `arrondissements.json` |
