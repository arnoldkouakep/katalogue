# OCR Bancaire

Ce projet est une solution pour le kata **OCR Bancaire**, présenté pour la première fois à la conférence XP2006 par Emmanuel Gaillot et Christophe Thibaut.

## Contenu

- [Description du problème](#description-du-problème)
  - [Histoire d'utilisateur 1 : Lecture de numéros de compte](#histoire-dutilisateur-1--lecture-de-numéros-de-compte)
  - [Histoire d'utilisateur 2 : Validation de la somme de contrôle](#histoire-dutilisateur-2--validation-de-la-somme-de-contrôle)
  - [Histoire d'utilisateur 3 : Production de rapports d'erreurs](#histoire-dutilisateur-3--production-de-rapports-derreurs)
  - [Histoire d'utilisateur 4 : Correction des erreurs de reconnaissance](#histoire-dutilisateur-4--correction-des-erreurs-de-reconnaissance)
- [Indices et conseils](#indices-et-conseils)
- [Cas de test suggérés](#cas-de-test-suggérés)
- [Ressources](#ressources)
- [Commentaires et apprentissages](#commentaires-et-apprentissages)

---

## Description du problème

### Histoire d'utilisateur 1 : Lecture de numéros de compte
Une banque utilise une machine qui scanne et lit les documents envoyés par les succursales. Chaque document contient un numéro de compte représenté par des barres verticales (`|`) et des traits de soulignement (`_`), structurés en 4 lignes de 27 caractères :


Ce code représente un numéro de compte de 9 chiffres, avec une entrée typique comportant environ 500 numéros.

**Objectif** : Développer un programme pour lire et interpréter ces numéros.

### Histoire d'utilisateur 2 : Validation de la somme de contrôle
La machine peut parfois mal interpréter les caractères. Un numéro de compte valide doit respecter une règle de somme de contrôle, calculée ainsi :

- Numéro de compte : `3 4 5 8 8 2 8 6 5`
- Calcul de la somme de contrôle : `(d1 + 2*d2 + ... + 9*d9) % 11 = 0`

**Objectif** : Implémenter un système pour valider les numéros de compte en fonction de cette somme de contrôle.

### Histoire d'utilisateur 3 : Production de rapports d'erreurs
Produire un rapport contenant chaque numéro de compte lu, suivi d'un indicateur d'erreur si le numéro est invalide :


- `ERR` indique une somme de contrôle invalide.
- `ILL` indique un caractère illisible (`?` remplace les caractères indéterminés).

### Histoire d'utilisateur 4 : Correction des erreurs de reconnaissance
Pour les numéros marqués comme `ERR` ou `ILL`, le programme doit suggérer une correction en ajustant un caractère (barre verticale ou trait de soulignement) et recalculer la somme de contrôle. Le statut peut alors être :

- **Numéro valide** : corrigé
- **AMB** : ambigu, avec plusieurs possibilités
- **ILL** : toujours indéterminé

---

## Indices et conseils

- Organisez les caractères en cellules de 3x3 pour chaque chiffre. Cela facilite la lecture et la modification des chiffres.
- Christophe et Emmanuel ont utilisé une solution basée sur la récursivité, mais une approche itérative est aussi possible.
- Attention aux erreurs courantes, comme le calcul incorrect de la somme de contrôle ou l’oubli de toutes les variantes possibles pour les chiffres.

---

## Cas de test suggérés

Voici quelques exemples de cas de test avec leurs entrées et sorties attendues. Ils sont présentés sous forme de lignes de caractères et devraient être copiés avec les espaces pour éviter les erreurs de lecture.

Exemples :

Voir la section "Cas de test suggérés" dans la description complète pour des exemples plus détaillés.

---

## Ressources

Des ressources pour commencer avec ce kata dans différents langages :

- **Ruby** : Minitest et RSpec fournis par le groupe Barcelona on Rails.
- **Java** : Projet de base avec configuration des tests.
- **Python** : Projet de base et configuration des tests.
- **Kotlin** : Projet de base et configuration des tests.

---

## Commentaires et apprentissages

Vous pouvez ajouter ici vos réflexions sur la résolution de ce kata, vos approches, ainsi que des exemples de code ou des liens vers des pages spécifiques si vous avez développé une solution particulière. Ces notes sont utiles pour documenter les décisions et choix techniques faits au cours du projet.

---
