# Bibliothèque Java Program

Ce programme Java modélise les éléments d'une bibliothèque, y compris les livres et les magazines. Chaque élément a des propriétés telles que le titre, l'auteur et l'année de publication, et les sous-classes spécifient des attributs supplémentaires pour les livres et les magazines.

## Caractéristiques

- Gestion des éléments de la bibliothèque, y compris les livres et les magazines.
- Affichage des détails des éléments de la bibliothèque.
- Comptage du nombre total de livres créés.

## Structure des Classes

### Classe `BibliothequeElement`

#### Variables

- `titre`: Le titre de l'élément.
- `auteur`: L'auteur de l'élément.
- `anneePublication`: L'année de publication de l'élément.

#### Méthodes

- `BibliothequeElement(String titre, String auteur, int anneePublication)`: Constructeur pour initialiser un élément de la bibliothèque.
- `setTitre(String titre)`: Définit le titre de l'élément.
- `getTitre()`: Retourne le titre de l'élément.
- `setAuteur(String auteur)`: Définit l'auteur de l'élément.
- `getAuteur()`: Retourne l'auteur de l'élément.
- `setAnneePublication(int anneePublication)`: Définit l'année de publication de l'élément.
- `getAnneePublication()`: Retourne l'année de publication de l'élément.
- `afficherDetails()`: Affiche les détails de l'élément.

### Classe `Livre`

#### Variables

- `nombrePages`: Le nombre de pages du livre.
- `genre`: Le genre du livre.
- `nombreDeLivreCrees`: Compteur statique du nombre total de livres créés.

#### Méthodes

- `Livre(String titre, String auteur, int anneePublication, int nombrePages, String genre)`: Constructeur pour initialiser un livre.
- `setNombrePages(int nombrePages)`: Définit le nombre de pages du livre.
- `getNombrePages()`: Retourne le nombre de pages du livre.
- `setGenre(String genre)`: Définit le genre du livre.
- `getGenre()`: Retourne le genre du livre.
- `afficherDetails()`: Affiche les détails du livre en incluant les détails de l'élément de la bibliothèque.

### Classe `Magazine`

#### Variables

- `editeur`: L'éditeur du magazine.
- `frequencePublication`: La fréquence de publication du magazine.

#### Méthodes

- `Magazine(String titre, String auteur, int anneePublication, String editeur, String frequencePublication)`: Constructeur pour initialiser un magazine.
- `setEditeur(String editeur)`: Définit l'éditeur du magazine.
- `getEditeur()`: Retourne l'éditeur du magazine.
- `setFrequencePublication(String frequencePublication)`: Définit la fréquence de publication du magazine.
- `getFrequencePublication()`: Retourne la fréquence de publication du magazine.
- `afficherDetails()`: Affiche les détails du magazine en incluant les détails de l'élément de la bibliothèque.

## Classe `Main`

La classe `Main` démontre l'utilisation des classes `Livre` et `Magazine` en créant des instances de chaque et en affichant leurs détails.

### Exemple

```java
package main;

import java.util.ArrayList;
import models.*;

public class Main {
    public static void main(String[] args) {
        Livre livre1 = new Livre("Petit prince", "AST", 1943, 96, "Conte");
        Livre livre2 = new Livre("Grand prince", "ASM", 1944, 100, "Conte");

        Magazine magazine1 = new Magazine("NIIT MAG", "NIIT", 2024, "L2/GL", "Semestrielle");
        Magazine magazine2 = new Magazine("LKA MAG", "NIIT", 2024, "L2/GL", "Semestrielle");

        ArrayList<Livre> livres = new ArrayList<Livre>();
        livres.add(livre1);
        livres.add(livre2);

        ArrayList<Magazine> magazines = new ArrayList<Magazine>();
        magazines.add(magazine1);
        magazines.add(magazine2);

        for (Livre livre : livres) {
            livre.afficherDetails();
        }

        for (Magazine magazine : magazines) {
            magazine.afficherDetails();
        }

        System.out.println("Le nombre de livres créés est: " + Livre.nombreDeLivreCrees);
    }
}
```

Cet exemple montre comment créer des instances des classes `Livre` et `Magazine`, les ajouter à des listes, afficher leurs détails et afficher le nombre total de livres créés.

## License

Ce projet est sous licence MIT. Voir le fichier LICENSE pour plus de détails.

## Contribuer

Les contributions sont les bienvenues ! Veuillez ouvrir une issue ou soumettre une pull request pour toute modification ou amélioration.

## Contact

Pour toute question ou demande, veuillez contacter [Moi](mailto:lka.dev02@gmail.com).
