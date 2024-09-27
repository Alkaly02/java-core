# Service RMI de Calculatrice
Ce projet consiste en la création d'un service RMI (Remote Method Invocation) permettant d'effectuer des opérations mathématiques simples telles que l'addition, la soustraction, la multiplication et la division. Le client envoie deux nombres et choisit l'opération, tandis que le serveur effectue le calcul et renvoie le résultat.

## Prérequis
- Java Development Kit (JDK) 8+
- Connaissances de base sur RMI

## Prise en main du projet en local
Avec les versions recentes, RMI est deprecie, toutefois on peut l'utiliser pour apprendre.
Le probleme reside sur le developpement. Pour eviter certaines erreurs, voici ce que vous devez faire :

Dans votre fichier module-info.java, ajoutez ceci:
```java
module CorrectionExercice1RMI {
	requires java.rmi;
	exports interfaces to java.rmi;
}
```
Ici, `interfaces` est le nom de notre package qui contient l'interface RMI
