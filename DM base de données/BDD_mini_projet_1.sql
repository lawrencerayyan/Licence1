#De Lawrence Al Rayyan et Ettis Mohamed

#Q1 le nom des lieux et le nombre de matchs joués dans chaque lieu ;

SELECT places.place_name ,count(matches.place) FROM places INNER JOIN matches on matches.place = places.place_id GROUP BY places.place_name;

#Dans cette question on cherche le nom du lieu et le nombre de match joué dans ce lieudans 2 tables qui sont matches et places qui sont liés grace à la clé étrangére qui est place dans la table matches et une clé primaire qui est place_id dans la table place  et on les regroupe grace à group by en fonction des noms des lieux

#Q2 le nom de chaque équipe et le nom des membres aujourdhui 

SELECT teams.team_name, memberships.player, players.first_name FROM teams INNER JOIN memberships on memberships.team = teams.team_id INNER JOIN players on players.player_id = memberships.player GROUP BY teams.team_name, memberships.player;

#Dans cette question on cherche à afficher le nom de léquipe, et le membre présent dans léquipe aujourdhui, ici on va chercher les données dans 3 tables , la talbe membership, teams et enfin la table players grace à inner join on pourra alors liés les 3 tables et aprés on va les regrouper avec les noms déquipes et par joueurs.

#Q3 le nom des équipes gagnantes, le lieu et la date du match ;

SELECT teams.team_name , matches.place , places.place_name , matches.match_date FROM matches INNER JOIN teams on matches.winner = teams.team_id INNER JOIN places ON matches.place = places.place_id WHERE matches.winner > 0;

#Dans cette question on cherche à afficher les équipes gagnantes, le lieu et la date du match pour cela on va chercher dans 3 tables qui sont matches , places et teams et on utilise 2 inner join pour pouvoir afficher le léquipes gagnante et le lieu et on utilise une condition qui est matches.winner > 0 pour afficher toutes les équipes qui ont au moins gagné un match

#Q4 le nom de toutes les équipes et les dates où elles ont gagné des matchs

SELECT teams.team_name, matches.match_date FROM matches LEFT JOIN places ON (place = place_id) RIGHT JOIN teams ON (winner = team_id);

#Dans ce cas on va afficher les dates de matches dans la tables de gauche et dans la table de droite on affiche les gagnants 

#Q5 le nom des équipes qui nont pas gagné de match 

SELECT teams.team_name FROM matches INNER JOIN teams on matches.winner = teams.team_id WHERE EXISTS (SELECT matches.winner FROM matches WHERE matches.winner = 0);

#Dans ce cas on utiliser 2 tables qui sont teams et matches mais aussi on a utilisé la sous requete avec exists qui renvoie true si la condition dans la sous requete est vrai.

#Q6 le nom des équipes ayant au moins gagné 2 matchs ;

SELECT teams.team_name FROM teams INNER JOIN matches ON teams.team_id = matches.winner GROUP BY teams.team_name HAVING COUNT(matches.winner) >= 2;

#Dans ce cas on va utiliser 2 tables qui sont teams et matches et on va utiliser la commande group by pour les affichers par nom déquipes et on utilise having count pour afficher les équipes qui ont gangé 2 ou plus de 2 matches


#Q7 le nom de léquipe et le  nombre de matchs gagnés par chaque équipe ;

SELECT teams.team_name , COUNT(matches.winner) FROM matches INNER JOIN teams on matches.winner = teams.team_id WHERE matches.winner > 0 GROUP BY teams.team_name;

#Dans ce cas on va afficher le nom des équipes avec le nombre de matches quils ont gagné pour cela on va utilisé la commande count qui nous permettra de compter le nombre de matchs gagné et ensuite on va utilise la commande group by pour les afficher par noms 

#Q8 le nom des équipes ayant gagné le plus de matchs ;

SELECT teams.team_name FROM teams INNER JOIN matches on matches.winner = teams.team_id WHERE matches.winner = (SELECT MAX(matches.winner) FROM matches );

#Dans ce cas on va afficher le nom des équipes et grace à la sous requete on va afficher léquipe qui a gagné le plus grand nombre de matches

#Q9 le nom des équipes qui nont pas joué lannée dernière ;

SELECT DISTINCT teams.team_name FROM matches INNER JOIN teams on matches.winner = teams.team_id WHERE NOT EXISTS (SELECT match_id FROM `matches` WHERE match_date BETWEEN 2021-12-31 AND 2021-01-01);

#On va utiliser une sous requete pour cette question avec not exists pour afficher les équipes qui ont joué en dehors de la date présent dans la sous requete

#Q10 le nom des équipes qui ont perdu contre léquipe Alpha.

SELECT team2 FROM matches INNER JOIN teams on teams.team_id=matches.winner WHERE team1=1 AND winner=1;

#Dans ce cas on va afficher team2 car la team 1 est présente dans léquipe 1 à chaque fois et aprés on rajoute la condition pour dire que la team1 doit etre la team 1 et que winner doit etre la team 1  


#PARTIE B 

#Ici nous avons créés 2 tables. Championships avec une clé primary championships_id et clé étrangere team qui la lie avec la table teams on team_id,
#et la table coach avec un clé primary coach_id et clé étrangere team qui la lie avec la table teams on teams id.
#Puis nous avons rajouter une colonne (taille) à la table players en suite nous avons inseré des valeur en utilisant la code suivante :

 #CREATE TABLE championships(
    #championships_id INT NOT NULL AUTO_INCREMENT,
    #championships_name VARCHAR(50),
    #team int ,
    #champion INT ,
    #PRIMARY KEY (championships_id),
    #FOREIGN key (team) REFERENCES teams(team_id)
    
  #);

 #CREATE TABLE coach(
  #coach_id INT NOT NULL AUTO_INCREMENT,
  #coach_name VARCHAR(50),
  #nationalité VARCHAR (50),
  #team INT,
  #PRIMARY KEY (coach_id),
  #FOREIGN KEY (team) REFERENCES teams(team_id)
 #);



#Q1 : les noms des équipes , le nom de compétitions et combien de fois lequipe la gagné .

SELECT teams.team_name ,championships.championships_name, championships.champion FROM teams INNER JOIN championships on teams.team_id=championships.team;

#INNER JOIN nous permet de lier les 2 table de gauche et de droite  #>

#Q2 : les noms des équipes qui ont gagné le UCL plus que 5 fois 

SELECT teams.team_name FROM teams INNER JOIN championships on teams.team_id=championships.team WHERE championships_name = 'ucl' AND champion > 5;

#  INNER JOIN nous permet de lier les 2 table de gauche et de droite  #>

#Q3 : le nom déquipe qui a gagné le plus de chamiponnat 

SELECT teams.team_name , max(champion)  FROM teams INNER JOIN championships on teams.team_id=championships.team;


# MAX(champion)nous donne le maximume et INNER JOIN nous permet de lier les 2 table de gauche et de droite  #>


#Q4 : le nom de cahque coach avec son équipe  

SELECT coach_name , teams.team_name FROM `coach` INNER JOIN teams on coach.team=teams.team_id;


#  INNER JOIN nous permet de lier les 2 table de gauche et de droite  #>


#Q5 : le nom de coach , son équipe et les championnats quils ont gagnés 

SELECT coach_name , teams.team_name , championships.championships_name FROM `coach` INNER JOIN teams on coach.team=teams.team_id INNER JOIN championships on championships.team = teams.team_id;


#Ici nous avons eu besoin de 3 tables afin de trouver les infomration demandées, nous avons utilisé INNER JOIN pour pouvoir les lier  #>


#Q6 : chaque nationalité avec le nombre de coach qui a cette nationalité 

SELECT nationalité,count(nationalité) FROM coach GROUP BY nationalité;


#Dans cette requéte on va utiliser COUNT ça nous donne le nombre de nationalité, GROUP BY ça regroupe la resutlat de notre requetes

#Q7 : la taille moyenne de tous les joueur
 
SELECT AVG(players.taille) from players;

#Dans cette question on va utiliser AVG ça nous donne la moyenne des tailles des joueurs.

#Q8 : La date de chaque match  dans Santiago Bernabeu

SELECT match_date FROM `matches` INNER JOIN places ON matches.place=places.place_id WHERE places.place_name = 'Santiago Bernabeu';

#On va afficher la date de chaque match et avec inner join pour lier les 2 tables et on rajoute une condition pour afficher les matches dans Santiago Bernabeu

#Q9 : La moyenne de victoire de chauqe équipe

SELECT AVG(matches.winner),teams.team_name FROM matches INNER JOIN teams ON matches.team1 = teams.team_id OR matches.team2= teams.team_id GROUP BY teams.team_name;

#Dans cette requete on va utiliser la commande AVG pour trouver la moyenne de victoire et on va utiliser la commande inner join pour lier les tables et aprés on achoute la condition or pour pouvoir choisir entre team1 ou team 2.

#Q10 : les noms des équipes et le nom de compétitions à la quelle elles participent 

SELECT teams.team_name ,championships.championships_name FROM teams INNER JOIN championships on teams.team_id=championships.team GROUP BY championships.championships_name , teams.team_name;

#Dans cette requete on affiche les noms des équies et le nom des compétitions quils ont gagné grace à la commande inner on pourra alors relié les table et aprés on va les regrouper avec la group by pour afficher le nom du championnat et le nom de léquipe











