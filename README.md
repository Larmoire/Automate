# Automate Analyzer

## Qui, Quoi, Quand, Où

- **Qui** : Ce projet a été réalisé par Julien EVRARD.
- **Quoi** : Il s'agit d'un analyseur d'automates finis déterministes (AFD) écrit en Kotlin.
- **Quand** : Le projet a été développé en 2023.
- **Où** : Le projet est hébergé sur GitHub et peut être utilisé dans n'importe quel environnement qui supporte Kotlin
  et Gradle.

## Introduction

Ce projet est une réalisation d'un analyseur d'automates finis déterministes (AFD). Les automates sont des modèles
mathématiques qui permettent de représenter et de manipuler des ensembles de chaînes de caractères selon des règles
précises. Ils sont largement utilisés en informatique théorique et dans de nombreux domaines d'application tels que l'
analyse lexicale, la reconnaissance de formes, la conception de circuits numériques, etc.

## Réalisation

Dans ce travail pratique (TP), j'ai développé un analyseur d'automates qui peut accepter ou rejeter des chaînes de
caractères en fonction de la configuration de l'automate. J'ai encodé et testé plusieurs types d'automates,
notamment pour la reconnaissance de smileys, d'heures, de dates et de polynômes.

Pour assurer la fiabilité de cet
analyseur, j'ai mis en place une série de tests unitaires. Ces tests vérifient le comportement de l'analyseur pour
différentes entrées et configurations d'automates. Par exemple, pour l'automate "smiley", je teste si
l'analyseur accepte correctement des chaînes comme ";-)" et rejette des chaînes comme ":-(".
J'ai également testé des cas limites, comme des chaînes vides ou des chaînes contenant des caractères non valides.

L'architecture logicielle
de l'application est organisée autour de deux classes principales : Automate et Etat. La classe Automate représente un
automate fini déterministe et contient une liste d'états, un alphabet, un état initial, une liste d'états finaux et une
fonction de transition. La classe Etat représente un état dans l'automate et contient un ensemble de transitions vers d'
autres états. Cette architecture permet une grande flexibilité et facilite l'ajout de nouveaux types d'automates.

## Utilisation

Pour un non-informaticien, l'utilisation du fichier JAR pour exécuter le code est assez simple.
Un fichier JAR (Java
Archive) est un format de fichier qui permet de regrouper plusieurs fichiers en un seul.

Dans notre cas, il contient
l'ensemble du code de l'application, ce qui permet de l'exécuter facilement. Pour exécuter le fichier JAR, vous devez
avoir Java installé sur votre ordinateur. Si ce n'est pas le cas, vous pouvez le télécharger et l'installer à partir du
site officiel de Java.

Une fois que Java est installé, vous pouvez exécuter le fichier JAR en utilisant la ligne de
commande. Voici comment faire :

Ouvrez une fenêtre de ligne de commande. Sur Windows, vous pouvez le faire en appuyant sur les touches Win + R, en
tapant cmd et en appuyant sur Entrée.

Naviguez jusqu'au répertoire contenant le fichier JAR. Vous pouvez le faire en utilisant la commande cd. Par exemple, si
votre fichier JAR est dans le répertoire C:\MonProjet, vous pouvez taper cd C:\MonProjet et appuyer sur Entrée.

Une fois que vous êtes dans le bon répertoire, vous pouvez exécuter le fichier JAR en tapant:

```java -jar monAppli.jar```

et en appuyant sur Entrée.

C'est tout ! Votre application devrait maintenant s'exécuter.

## API

En ce qui concerne l'API, le code est empaqueté dans un fichier JAR pour être utilisé comme une bibliothèque dans
d'autres projets. Les développeurs peuvent importer les classes Automate et Etat et utiliser leurs méthodes publiques
pour créer et analyser des automates. Cela permet une réutilisation facile du code et une intégration dans d'autres
applications.

## Limitations

Ce projet a quelques limitations. Il ne supporte que les automates finis déterministes et ne peut pas gérer les
automates non déterministes ou les automates à pile. De plus, il ne fournit pas de fonctionnalités pour visualiser
graphiquement les automates.

## Conclusion

Ce projet est une réalisation concrète d'un analyseur d'automates finis déterministes. Il démontre comment les concepts
théoriques des automates peuvent être appliqués dans un contexte pratique pour analyser et reconnaître des chaînes de
caractères selon des règles précises. Bien que le projet ait certaines limitations, il offre une base solide pour
explorer davantage les applications des automates en informatique. Les perspectives futures pourraient inclure l'ajout
de support pour d'autres types d'automates, l'amélioration de l'interface utilisateur, et l'ajout de fonctionnalités
pour visualiser graphiquement les automates.



## Sources
Ce README a été rédigé avec l'aide de Github Copilot, un outil d'IA développé par OpenAI. Il a généré automatiquement
une grande partie du texte en fonction des informations que j'ai fournies sur le projet. J'ai ensuite modifié et
complété le texte pour le rendre plus clair et plus précis.

Une partie des tests unitaires a été générée par Github Copilot. Ces tests me permettent de vérifier le bon
fonctionnement de l'analyseur pour différentes configurations d'automates et d'entrées. J'ai également écrit des tests
supplémentaires pour couvrir d'autres cas de figure.

Le code complet comprenant les tests est disponible [ici](https://github.com/Larmoire/Automate/).
