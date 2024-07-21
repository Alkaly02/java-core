# FileHandler

## Description

`FileHandler` est une classe Java qui permet de démontrer la gestion des fichiers et des flux de données. Cette classe lit le contenu d'un fichier texte (`readable.txt`) situé dans le répertoire `models` et copie ce contenu dans un autre fichier texte (`destination.txt`) dans le même répertoire. Pendant ce processus, le contenu du fichier source est également affiché dans la console.

## Fonctionnalités

- Lecture d'un fichier texte ligne par ligne.
- Écriture du contenu lu dans un autre fichier texte.
- Affichage du contenu lu dans la console.
- Utilisation des flux de caractères (Reader et Writer) et des tampons (BufferedReader et BufferedWriter) pour une gestion efficace des fichiers.

### Prérequis

- Java Development Kit (JDK) installé.
- Fichiers `readable.txt` et `destination.txt` dans le répertoire `src/models`.

### Notes

- Assurez-vous que le fichier `readable.txt` contient des données avant d'exécuter la méthode `handle`.
- Le fichier `destination.txt` sera écrasé s'il existe déjà. Si ce comportement n'est pas souhaité, ajustez le code en conséquence.
