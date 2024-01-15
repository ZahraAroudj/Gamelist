USE GameList;

INSERT INTO ROLES(libelle_role)
VALUES 
	("Administrateur"), 
	("Utilisateur")
;

INSERT INTO CATEGORIES(libelle_categorie)
VALUES
	("ps5"), 
	("ps4"), 
	("ps3"), 
	("ps1"), 
	("Xbox_serie_x"), 
	("xbox_one"), 
	("xbox_360"), 
	("xbox"), 
	("wii"), 
	("wii_u"), 
	("switch"), 
	("pc"), 
	("mobile"), 
	("Ds"), 
	("3ds"), 
	("Atari"), 
	("Borne_Arcade") 

;

INSERT INTO CATEGORIES(libelle_categorie)
VALUES
	("Fantaisy"), 
	("3D"), 
	("Simmulation"), 
	("MMORPG"), 
	("Manga"), 
	("Science-fiction"), 
	("Monde_Ouvert"), 
	("VR"), 
	("Thriller"), 
	("FPS"), 
	("Stratégie")
	
;

INSERT INTO GAMES(titre_games, description_games, affiche_games, lien_games, duree_games)
VALUES 
("Street Fighter 6 (2023)", "Street Fighter 6 instaure un système de combat nommé « Drive », se déclinant sous plusieurs formes différentes : « Drive Impact », « Drive Parry », « Drive Rush » et « Drive Reversal », toutes les quatre étant des fonctionnalités classiques de la franchise Street Fighter.
Capcom propose deux types de commandes, classique et moderne. Le type classique garde la configuration à 6 touches pour les coups de poing et coups de pied typique de la franchise, inauguré 30 ans plus tôt. Le type moderne se compose de trois touches pour les coups faibles, moyens et forts, et facilite les manipulations pour les coups spéciaux qui peuvent s'exécuter en pressant un seul bouton uniquement. Les gâchettes sont quant à elles réservées pour les projections, « Drive Impact » et « Drive Parry ».
En ligne, le jeu propose du cross-play ainsi qu'un rollback netcode.", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.playstation.com%2Ffr-fr%2Fgames%2Fstreet-fighter-6%2F&psig=AOvVaw3pcYFp5M_q9LzZEmW7tMIa&ust=1692290236719000&source=images&cd=vfe&opi=89978449&ved=0CBAQjRxqFwoTCMivi8XO4YADFQAAAAAdAAAAABAE","https://www.streetfighter.com/6/fr","100"),
("Resident Evil (2017)","Ethan Winters est à la recherche de sa femme, Mia, disparue maintenant depuis plus de 3 ans. Ses recherches le conduisent vers une plantation abandonnée, où il finit par retrouver sa femme retenue prisonnière dans une maison apparemment abandonnée elle aussi. Cependant, Ethan va très vite être attaqué, et il fera la rencontre de la famille Baker, une famille étrange et dangereuse, pratiquant le cannibalisme.","https://image.api.playstation.com/vulcan/ap/rnd/202206/0207/V6IViuKogBMRtajqjnYrcj0e.png","https://www.playstation.com/fr-fr/games/resident-evil-7-biohazard/","30" )
;

