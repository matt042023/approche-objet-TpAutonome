# 📚 APPLICATIONS JAVA POO - TP AUTONOME

## 📋 Description générale

Collection d'applications Java développées en programmation orientée objet dans le cadre d'exercices pédagogiques. Le projet comprend plusieurs modules indépendants : jeu RPG, analyse de recensement, gestion de théâtre, utilitaires divers.

---

# 🎮 1. JEU DE COMBAT RPG

Application Java de jeu de combat RPG développée en programmation orientée objet. Le joueur incarne un personnage qui peut combattre différentes créatures pour obtenir le meilleur score possible.

## 🎯 Objectif du jeu

L'objectif est d'atteindre le score le plus élevé possible en combattant des créatures tout en gardant votre personnage en vie. Plus vous battez de créatures puissantes, plus votre score augmente !

## 🕹️ Règles du jeu

### Création du personnage
- **Force** : entre 12 et 18 (générée aléatoirement)
- **Points de santé** : entre 20 et 50 (générés aléatoirement)
- **Score initial** : 0
- **Inventaire de départ** : 3 potions
  - 1 Potion de soin
  - 1 Potion d'attaque mineure
  - 1 Potion de robustesse

### Combat
- Le combat n'est possible que si votre personnage a des points de santé > 0
- À chaque tour, les deux protagonistes calculent leur attaque : **force + nombre aléatoire (1-10)**
- Celui qui a l'attaque la plus forte remporte le tour
- Les dégâts infligés = **différence entre les deux attaques**
- Le combat continue jusqu'à ce qu'un des protagonistes tombe à 0 PV ou moins

### Créatures du bestiaire
| Créature | Force | Points de santé | Score si victoire |
|----------|-------|----------------|------------------|
| 🐺 **Loup** | 3-8 | 5-10 | +1 point |
| 👹 **Gobelin** | 5-10 | 10-15 | +2 points |
| 🧌 **Troll** | 10-15 | 20-30 | +5 points |

### Potions
Les potions ne peuvent être utilisées qu'**entre les combats** (pas pendant).

| Type de potion | Effet |
|----------------|-------|
| 🧪 **Potion de soin** | Restaure 5 à 10 points de santé |
| ⚔️ **Potion d'attaque mineure** | +3 d'attaque pendant 1 combat |
| 💪 **Potion d'attaque majeure** | +5 d'attaque pendant 2 combats |
| 🛡️ **Potion de robustesse** | +5 à 10 points de santé maximum |

### Récompenses
Après chaque victoire, vous avez **50% de chance** d'obtenir une récompense :
- Potion de soin
- Potion d'attaque mineure
- Potion d'attaque majeure
- +5 points de score bonus

## 🚀 Installation et lancement

### Prérequis
- Java 21 ou supérieur
- Terminal/Console

### Lancement avec Maven
```bash
# Compilation du projet
mvn compile

# Lancement du jeu RPG
mvn exec:java -Dexec.mainClass="fr.diginamic.combat.Jeu"

# Lancement de l'application de recensement
mvn exec:java -Dexec.mainClass="fr.diginamic.recensement.ApplicationRecensement"
```

### Lancement manuel
```bash
# Compilation
javac -cp "src/main/java" src/main/java/fr/diginamic/combat/*.java
javac -cp "src/main/java" src/main/java/fr/diginamic/recensement/*.java

# Lancement du jeu RPG
java -cp "src/main/java" fr.diginamic.combat.Jeu

# Lancement de l'application de recensement
java -cp "src/main/java" fr.diginamic.recensement.ApplicationRecensement
```

## 🎮 Guide d'utilisation

### Menu principal
1. **👤 Créer un personnage** - Génère un nouveau personnage avec des statistiques aléatoires
2. **⚔️ Combattre une créature** - Lance un combat contre une créature aléatoire
3. **🧪 Prendre une potion** - Utilise une potion de votre inventaire
4. **🏆 Afficher le score** - Affiche vos statistiques actuelles
5. **🚪 Quitter** - Ferme l'application

### Stratégies de jeu
- Utilisez les potions d'attaque avant les combats difficiles
- Gérez votre santé avec les potions de soin
- Les potions de robustesse augmentent votre santé maximum définitivement
- Évitez les combats quand vous êtes faible en santé

## 🏗️ Architecture du code

### Classes principales
- **`Jeu`** : Point d'entrée et menu principal
- **`Personnage`** : Représente le joueur avec ses statistiques et inventaire  
- **`Creature`** : Classe abstraite pour toutes les créatures
- **`Combat`** : Gère la logique de combat
- **`Potion`** : Interface pour tous les types de potions

### Hiérarchie des créatures
```
Creature (abstraite)
├── Loup
├── Gobelin
└── Troll
```

### Types de potions
```
Potion (interface)
├── PotionSoin
├── PotionAttaqueMineure
├── PotionAttaqueMajeure
└── PotionRobustesse
```

## 🔧 Fonctionnalités techniques

- **Génération aléatoire** des statistiques selon les règles
- **Polymorphisme** pour les créatures et potions
- **Encapsulation** des données avec getters/setters
- **Interface utilisateur** en console avec émojis
- **Gestion d'état** du personnage et inventaire
- **Calculs équilibrés** pour un gameplay intéressant

## 🐛 Gestion des erreurs

- Vérification que le personnage est vivant avant combat
- Contrôle de saisie pour éviter les erreurs utilisateur
- Messages d'erreur explicites en français
- Gestion des cas limites (inventaire vide, etc.)

---

# 📊 2. APPLICATION DE RECENSEMENT

Application d'analyse de données démographiques françaises basée sur un fichier CSV de recensement.

## 🎯 Fonctionnalités

### Menu principal
1. **🏙️ Population d'une ville donnée** - Recherche par nom de ville
2. **🏛️ Population d'un département donné** - Recherche par code/nom de département  
3. **🗺️ Population d'une région donnée** - Recherche par nom de région
4. **🏆 Top 10 des régions** - Classement par population
5. **🏆 Top 10 des départements** - Classement par population
6. **🏆 Top 10 villes d'un département** - Villes les plus peuplées par département
7. **🏆 Top 10 villes d'une région** - Villes les plus peuplées par région
8. **🏆 Top 10 villes de France** - Villes les plus peuplées du pays

## 🏗️ Architecture

### Classes principales
- **`ApplicationRecensement`** : Point d'entrée et menu principal
- **`Recensement`** : Gestionnaire des données de recensement
- **`Ville`**, **`Departement`**, **`Region`** : Entités géographiques
- **`MenuService`** : Interface pour les services de recherche

### Services de recherche
```
MenuService (interface)
├── RecherchePopulationVille
├── RecherchePopulationDepartement  
├── RecherchePopulationRegion
├── Top10RegionsPop
├── Top10DepartementsPop
├── Top10VillesDepartement
├── Top10VillesRegion
└── Top10VillesFrance
```

## 📁 Source de données
- **Fichier** : `src/main/resources/recensement.csv`
- **Format** : CSV avec colonnes ville, département, région, population
- **Traitement** : Lecture automatique au démarrage de l'application

---

# 🎭 3. GESTION DE THÉÂTRE

Module de gestion d'un théâtre avec système de réservation et tarification.

## 🎯 Fonctionnalités
- **Inscription** avec gestion du nombre de clients et prix
- **Contrôle de capacité** avec exceptions personnalisées
- **Calcul automatique** du total des inscriptions et du chiffre d'affaires

## 🏗️ Classes principales
- **`Theatre`** : Entité principale avec nom, capacité max, inscriptions
- **`TestTheatre`** : Classe de test avec scénarios d'utilisation

---

# 🏠 4. GESTION DE MAISON

Système de modélisation d'une maison avec différents types de pièces et calculs de superficie.

## 🏗️ Architecture

### Hiérarchie des pièces
```
Piece (classe abstraite)
├── Chambre
├── Cuisine  
├── SalleDeBain
├── Salon
└── WC
```

### Classe principale
- **`Maison`** : Conteneur de pièces avec calculs de superficie totale

---

# 🔧 5. UTILITAIRES ET SERVICES

## 🧮 Opérations mathématiques (`fr.diginamic.operations`)
- **`Operations`** : Calculatrice avec opérations de base
- **`CalculMoyenne`** : Calcul de moyennes sur tableaux

## 📄 Gestion de fichiers (`fr.diginamic.fichier`)  
- **`CreerFichier`** : Création et écriture de fichiers  
- **`LectureFichier`** : Lecture de fichiers texte
- **`Ville`** : Entité ville pour manipulation de données

## 🔤 Manipulation de chaînes (`fr.diginamic.chaines`)
- **`ManipulationChaine`** : Utilitaires pour traitement de texte

## 🧪 Tests et essais (`fr.diginamic.essais`)
- **`TestMaison`** : Tests du système de maison
- **`TestMoyenne`** : Tests des calculs de moyenne  
- **`TestOperations`** : Tests des opérations mathématiques
- **`TestTheatre`** : Tests du système de théâtre

---

## 📄 Licence

Projet éducatif - Lheureux Matthieu Java POO

---

*Bon développement ! 🚀*