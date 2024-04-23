#Q1 le nom des lieux et le nombre de matchs joués dans chaque lieu ;

#Dans cette question on cherche le nom du lieu et le nombre de match joué dans ce lieu dans 2 tables qui sont matches et places qui sont liés grace à la clé étrangére qui est place dans la table matches et une clé primaire qui est place_id dans la table place et on les regroupe grace à group by en fonction des noms des lieux, COUNT ça calcule et ça ne donne le nombre de matches 

SELECT places.place_name ,count(matches.place) FROM places INNER JOIN matches on matches.place = places.place_id GROUP BY places.place_name ;



#Q2 le nom de chaque équipe et le nom des membres aujourdhui ;

#Dans cette question on cherche à afficher le nom de léquipe, et le membre présent dans léquipe aujourdhui, ici on va chercher les données dans 3 tables , la talbe membership, teams et enfin la table players grace aux Jointures on pourra alors liés les 3 tables et aprés on va les regrouper avec les noms d équipes et par joueurs.

SELECT teams.team_name, memberships.player, players.first_name FROM teams INNER JOIN memberships on memberships.team = teams.team_id INNER JOIN players on players.player_id = memberships.player GROUP BY teams.team_name, memberships.player ;



#Q3 le nom des équipes gagnantes, le lieu et la date du match ;

#Dans cette question on cherche à afficher les équipes gagnantes, le lieu et la date du match pour cela on va chercher dans 3 tables qui sont matches , places et teams et on utilise 2 inner join pour pouvoir afficher l équipes gagnante et le lieu et on utilise une condition qui est matches.winner > 0 pour afficher toutes les équipes qui ont au moins gagné un match 

SELECT teams.team_name , matches.place , places.place_name , matches.match_date FROM matches INNER JOIN teams on matches.winner = teams.team_id INNER JOIN places ON matches.place = places.place_id WHERE matches.winner > 0 ;



#Q4 le nom de toutes les équipes et les dates où elles ont gagné des matchs 

#Dans ce cas on va afficher les dates de matches dans la tables de gauche et dans la table de droite on affiche les gagnants. LEFT JOIN ça retourne toutes les lignes de la table de gauche, même s il n y a pas de correspondance dans la table de droite. RIGHT JOIN ça retourne toutes les lignes de la table de droite, même sil n y a pas de correspondance dans la table de gauche.

SELECT teams.team_name, matches.match_date FROM matches LEFT JOIN places ON (place = place_id) RIGHT JOIN teams ON (winner = team_id) ;



#Q5 le nom des équipes qui n ont pas gagné de match 

#Dans ce cas on utiliser 2 tables qui sont teams et matches, et avec notre left join ça nous retoune toutes les lignes de la table de gauche .N oublions pas que quand on utilise group by on ne peut pas rajouter de condition en utilisant la clause where cependant on peut utiliser la clause HAVING apres le group by.

SELECT teams.team_name FROM teams LEFT JOIN matches ON teams.team_id = matches.winner GROUP BY team_name HAVING COUNT(winner) = 0 ;



#Q6 le nom des équipes ayant au moins gagné 2 matchs ;

#Dans ce cas on va utiliser 2 tables qui sont teams et matches et on va utiliser la commande group by pour les affichers par nom d équipes et on utilise having count pour afficher les équipes qui ont gangé 2 ou plus de 2 matches

SELECT teams.team_name FROM teams INNER JOIN matches ON teams.team_id = matches.winner GROUP BY teams.team_name HAVING COUNT(matches.winner) >= 2 ;




#Q7 le nom de l équipe et le  nombre de matchs gagnés par chaque équipe ;

#Dans ce cas on va afficher le nom des équipes avec le nombre de matches qu ils ont gagné pour cela on va utilisé la commande count qui nous permettra de compter le nombre de matchs gagné et ensuite on va utilise la commande group by pour les afficher par noms 

SELECT teams.team_name , COUNT(matches.winner) FROM matches INNER JOIN teams on matches.winner = teams.team_id WHERE matches.winner > 0 GROUP BY teams.team_name ;



#Q8 le nom des équipes ayant gagné le plus de matchs ;

#Dans ce cas on va afficher le nom des équipes qui a gagné le plus. On va utiliser la commande group by pour les regrouper par nom d équipes et on utilise having MAX pour afficher les équipes qui ont gangé le plus , la clause order by ça les affiche par ordre alphabétique ducoup on l inverse en utilisant le DESC et on affiche que les premier equipes avec la limit 2 .

SELECT teams.team_name FROM teams LEFT JOIN matches ON teams.team_id = matches.winner GROUP BY team_name HAVING MAX(winner) ORDER BY teams.team_name DESC LIMIT 2 ;



#Q9 le nom des équipes qui n ont pas joué l année dernière ;

#On va utiliser une sous requete pour cette question avec not exists qui renvoie true si la condition dans la sous requete est vrai et false sinon pour afficher les équipes qui ont joué en dehors de la date présent dans la sous requete

SELECT DISTINCT teams.team_name FROM matches INNER JOIN teams on matches.winner = teams.team_id WHERE NOT EXISTS (SELECT match_id FROM `matches` WHERE match_date BETWEEN '2021-12-31' AND '2021-01-01') ;



#Q10 le nom des équipes qui ont perdu contre l équipe Alpha.

#Dans ce cas on va afficher team2 car la team 1 est présente dans l équipe 1 à chaque fois et aprés on rajoute la condition pour dire que la team1 doit etre la team 1 et que winner doit etre la team 1  

SELECT team2 FROM matches INNER JOIN teams on teams.team_id=matches.winner WHERE team1=1 AND winner=1 ;


#____________________________________________________________________________________________________________________________________


#PARTIE B 

#Ici nous avons créés 2 tables. Championships avec une clé primary championships_id et clé étrangere team qui la lie avec la table teams on team_id,
#et la table coach avec un clé primary coach_id et clé étrangere team qui la lie avec la table teams on teams id.
#Puis nous avons rajouter une colonne (taille) à la table players en suite nous avons inseré des valeur en utilisant la code suivante :

 CREATE TABLE championships(
    championships_id INT NOT NULL AUTO_INCREMENT,
    championships_name VARCHAR(50),
    team int ,
    champion INT ,
    PRIMARY KEY (championships_id),
    FOREIGN key (team) REFERENCES teams(team_id) 
    
  );

 CREATE TABLE coach(
  coach_id INT NOT NULL AUTO_INCREMENT,
  coach_name VARCHAR(50),
  nationalité VARCHAR (50),
  team INT,
  PRIMARY KEY (coach_id),
  FOREIGN KEY (team) REFERENCES teams(team_id)
 );

ALTER TABLE players ADD taille double ; 
UPDATE players SET taille = 2 WHERE players.player_id = 1 ;
UPDATE players SET taille = 2.10 WHERE players.player_id = 2 ;
UPDATE players SET taille = 2.05 WHERE players.player_id = 3 ;
UPDATE players SET taille = 1.85 WHERE players.player_id = 4 ;
UPDATE players SET taille = 1.95 WHERE players.player_id = 5 ;



#Q1 : les noms des équipes , le nom de compétitions et combien de fois l equipe l a gagné .

#  INNER JOIN nous permet de lier les 2 table de gauche et de droite  #>

SELECT teams.team_name ,championships.championships_name, championships.champion FROM teams INNER JOIN championships on teams.team_id=championships.team ;



#Q2 : les noms des équipes qui ont gagné le UCL plus que 5 fois 

#  INNER JOIN nous permet de lier les 2 table de gauche et de droite  #>

SELECT teams.team_name FROM teams INNER JOIN championships on teams.team_id=championships.team WHERE championships_name = 'ucl' AND champion > 5 ;



#Q3 : le nom d équipe qui a gagné le plus de chamiponnat 

# MAX(champion)nous donne le maximume et INNER JOIN nous permet de lier les 2 table de gauche et de droite  #>

SELECT teams.team_name , max(champion)  FROM teams INNER JOIN championships on teams.team_id=championships.team ;





#Q4 : le nom de cahque coach avec son équipe  

#  INNER JOIN nous permet de lier les 2 table de gauche et de droite  #>

SELECT coach_name , teams.team_name FROM `coach` INNER JOIN teams on coach.team=teams.team_id ;





#Q5 : le nom de coach , son équipe et les championnats qu ils ont gagnés 

#Ici nous avons eu besoin de 3 tables afin de trouver les infomration demandées, nous avons utilisé INNER JOIN pour pouvoir les lier  #>

SELECT coach_name , teams.team_name , championships.championships_name FROM `coach` INNER JOIN teams on coach.team=teams.team_id INNER JOIN championships on championships.team = teams.team_id ;





#Q6 : chaque nationalité avec le nombre de coach qui a cette nationalité 

#Dans cette requéte on va utiliser COUNT ça nous donne le nombre de nationalité, GROUP BY ça regroupe la resutlat de notre requetes

SELECT nationalité,count(nationalité) FROM coach GROUP BY nationalité; 




#Q7 : la taille moyenne de tous les joueur

#Dans cette question on va utiliser AVG ça nous donne la moyenne des tailles des joueurs.
 
SELECT AVG(players.taille) from players ;



#Q8 : La date de chaque match  dans Santiago Bernabeu

#On va afficher la date de chaque match et avec inner join pour lier les 2 tables et on rajoute une condition pour afficher les matches dans Santiago Bernabeu

SELECT match_date FROM `matches` INNER JOIN places ON matches.place=places.place_id WHERE places.place_name = 'Santiago Bernabeu' ;



#Q9 : La moyenne de victoire de chauqe équipe

#Dans cette requete on va utiliser la commande AVG pour trouver la moyenne de victoire et on va utiliser la commande inner join pour lier les tables et aprés on achoute la condition or pour pouvoir choisir entre team1 ou team 2.

SELECT AVG(matches.winner),teams.team_name FROM matches INNER JOIN teams ON matches.team1 = teams.team_id OR matches.team2= teams.team_id GROUP BY teams.team_name ;



#Q10 : les noms des équipes et le nom de compétitions à la quelle elles participent 

#Dans cette requete on affiche les noms des équies et le nom des compétitions qu ils ont gagné grace à la commande inner on pourra alors relié les table et aprés on va les regrouper avec la group by pour afficher le nom du championnat et le nom de l équipe

SELECT teams.team_name ,championships.championships_name FROM teams INNER JOIN championships on teams.team_id=championships.team GROUP BY championships.championships_name , teams.team_name ;













