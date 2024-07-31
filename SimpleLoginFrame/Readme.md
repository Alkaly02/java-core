# Login GUI Application

Cette application Java crée une interface graphique simple pour un formulaire de connexion.

## Description

Le fichier `MainActivity.java` contient le code pour créer une fenêtre de connexion avec Java Swing. Cette fenêtre comprend :

- Un champ de texte pour le nom d'utilisateur.
- Un champ de mot de passe pour le mot de passe.
- Un bouton de connexion.

### Fonctionnalités

- **Fenêtre principale** : Une fenêtre de 500x400 pixels avec le titre "Login".
- **Formulaire de connexion** : Composé d'un label et d'un champ de texte pour l'utilisateur, d'un label et d'un champ de mot de passe pour le mot de passe, et d'un bouton de connexion.

### Structure du Code

1. **Main Method** : La méthode `main` initialise la fenêtre principale (`JFrame`) et un panneau (`JPanel`), puis ajoute les composants nécessaires au panneau avant de rendre la fenêtre visible.

2. **addComponentsToPanel Method** : Cette méthode ajoute les labels, champs de texte, champ de mot de passe et bouton de connexion au panneau.

### Exécution

Pour exécuter cette application, compilez le fichier `MainActivity.java` et exécutez la classe `MainActivity`.

```bash
javac main/MainActivity.java
java main.MainActivity
