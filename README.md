# Projet_Mobile

### _Application Age Of Empire 2_


C'est une application développé dans le cadre du projet mobile de 3A.
Elle met en place un RecyclerView pour afficher une liste de civilisations tirés du jeu Age Of Empire 2 avec un détail de ces civilisations.
Ces données sont récupérés de l'API [Age of Empire](https://github.com/aalises/age-of-empires-II-api) et sont stockés en cache via le cache HTTP.


# Elements obligatoires et bonus

* Écran avec une liste d'éléments
* Écran avec le détail d'un élément
* Appel WebService à une API Rest
* Stockage de données en cache
* Gitflow
* Singletons
* Lecture des images en local

# Screenshots
Lorsque l'on lance l'application, elle va effectuer un appel serveur vers l'api Age of Empire et récupérer les civilisations,  
puis va stockées les données dans le cache de l'application.

![](https://github.com/Totito91/Projet_Mobile/blob/master/app/ScreenShots/capture1.PNG)

L'utilisateur peut appuyer sur l'image ou le nom de la civilisation, il arrivera donc sur l'écran de détail de cette civilisation. Il peut aussi appuyer
sur le bouton *Menu* pour revenir à la liste des civilisations.


![](https://github.com/Totito91/Projet_Mobile/blob/master/app/ScreenShots/capture2.PNG)

Comme on peut le voir en haut le mode avion est activé donc les données sont bien stockées en cache.

![](https://github.com/Totito91/Projet_Mobile/blob/master/app/ScreenShots/capture3.PNG)
