# 🎮 JEU DE COMBAT RPG

## 📋 Description

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

### Compilation
```bash
javac -cp "src/main/java" src/main/java/fr/diginamic/combat/*.java
```

### Lancement
```bash
java -cp "src/main/java" fr.diginamic.combat.Jeu
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

## 📄 Licence

Projet éducatif - Lheureux Matthieu Java POO

---

*Bon jeu ! Essayez d'obtenir le meilleur score possible ! 🏆*