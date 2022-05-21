# Projet : TP Web.-Serveur

Vous pouvez démarrer avec la commande `./gradlew run`.

+ d'infos sur https://unicorn.artheriom.fr/

-----------------------------------------------------------
``Fonctionnalités rajoutées en + :``
+ Hachage de mot de passe (c.f. package ``security`` → ``HashPasswordSecurity``)
+ Redirection vers le formulaire de connexion si utilisateur non-connecté + Redirection vers la page consultée avant la redirection vers le formulaire

-----------------------------------------------------------

N.B. : mot de passe des professeurs :
- brunojouv : bbj15
- myrmirei  : myr15
- julframb  : jufram15

-----------------------------------------------------------

# Stickers
Par défaut, les stickers sont :

🟢 : ``Bon travail``

🔵 : ``Bonne participation / investissement``

🔴 : ``Mauvais comportement ``

# URIs
```/index```   : accéder à l'index.

```/students```: obtenir les étudiants.

```/stickers```: obtenir les stickers du système.

```/students-stickers```: obtenir les élèves ayant reçus des stickers.

```/students-stickers``` : accéder à la page de visualisation de l'historique des stickers.

```/teachers```: obtenir les professeurs.

```/login```   : accéder à la page de connexion/authentification.

```/disconnect``` : se déconnecter (autorisé seulement si un utilisateur est connecté).

+ Seulement si utilisateur -user- connecté :

```/put-stickers```: accès à la page permettant de mettre une gommette de couleur à un élève avec un commentaire.

```/put-students```: accès à la page permettant de mettre/modifier/ajouter un élève.

```/consult-student-stickers```: consulter les stickers d'un élève en particulier 
++ ```/consult-student-stickers/idstudent``` 


```/update-student```: changer la classe d'un élève (changer sa classe)

```/add-student```: ajouter un élève.

```/delete-student/id```: enlever un élève.

```delete-student-sticker/id_student/id```: enlever un élève dans l'historique des stickers.

```/modify-stickers```: modifier un sticker existant.

```/add-sticker```: ajouter un nouveau sticker.

```/delete-sticker/id```: enlever un sticker.

```/add-classroom```: ajouter une classe.

```/update-classes```: mettre à jour une classe.
