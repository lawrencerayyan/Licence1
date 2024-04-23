CREATE TABLE players(
  player_id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  birth_date DATE,
  PRIMARY KEY (player_id)
);

INSERT INTO `players` (`player_id`, `first_name`, `last_name`, `birth_date`) VALUES 

(NULL, 'lionel' , 'messi' ,'1985-05-14'),
(NULL, 'cristiano' ,'ronaldo','1982-02-10'),
(NULL, 'Ngolo' ,'kanté' ,'1988-08-19'),
(NULL, 'neymar' ,'dasilva','1996-08-14'),
(NULL, 'kylian' ,'mpapé','2000-10-05');

CREATE TABLE places(
  place_id INT NOT NULL AUTO_INCREMENT,
  place_name VARCHAR(50),
  PRIMARY KEY (place_id)
 );

 INSERT INTO `places` (`place_id`, `place_name`) VALUE
 (NULL,'San Siro'),
 (NULL, 'Camp Nou'),
 (NULL,'Old Trafford'),
 (NULL,'Wanda Metropolitano Madrid'),
 (NULL,'Le Parc De Princes'),
 (NULL,'Allianz Arena'),
 (NULL,'Anfield'),
 (NULL,'Stade Giuseppe-Meazza'),
 (NULL,'Signal Iduna Park'),
 (NULL,'Amesterdam Arena'),
 (NULL,'Stamford Bridge'),
 (NULL,'Santiago Bernabeu');

 
CREATE TABLE teams(
  team_id INT NOT NULL AUTO_INCREMENT,
  team_name VARCHAR(50),
  PRIMARY KEY (team_id)
);  
INSERT INTO `teams` (`team_id`,`team_name`) VALUE
(NULL,'Reall Madrid'),
(NULL,'Milan'),
(NULL,'Liverpool'),
(NULL,'Bayern'),
(NULL,'Barcelona'),
(NULL,'Juventus'),
(NULL,'Man United'),
(NULL,'Atletico Madird'),
(NULL,'Ajax'),
(NULL,'Dortmund'),
(NULL,'Paris Saitn German'),
(NULL,'Chelsea');

CREATE TABLE matches(
  match_id INT NOT NULL AUTO_INCREMENT,
  match_date DATE,
  team1 INT,
  team2 INT,
  winner INT,
  score VARCHAR(50),
  place INT,
  PRIMARY KEY (match_id),
  FOREIGN KEY (team1) REFERENCES teams(team_id),
  FOREIGN KEY (team2) REFERENCES teams(team_id),
  FOREIGN KEY (winner) REFERENCES teams(team_id),
  FOREIGN KEY (place) REFERENCES places(place_id)
);

INSERT INTO `matches` (`match_id`,`match_date`,`team1`,`team2`,`winner`,`score`,`place`)VALUE
(NULL, '2018-01-01 ', 1 , 3,1 , '3-0' ,12),
(NULL,'2019-02-02',1, 3,1 , '2-1' ,8 ),
(NULL,'2011-03-03',4 ,5,4 ,'6-1', 6),
(NULL,'2012-04-04',4,5,4 , '3-0', 2),
(NULL,'2014-05-05',1, 4 , 1 , '2-1' , 12),
(NULL,'2020-06-06',1 ,4 ,1 , '2-0' , 6),
(NULL,'2020-06-07',9 ,12 ,9 , '1-0' ,12),
(NULL,'2021-07-08', 11 ,7 ,11 ,' 2-0' , 11),
(NULL,'2017-08-09' ,10 ,4 ,10 , '1-0' , 10),
(NULL,'2019-09-10' , 6,2,6 , '3-2' ,1 ),
(NULL,'2020-10-20', 7 ,12 ,7, '2-0' ,3),
(NULL,'2016-11-30', 1 , 8 ,1 ,'3-1', 12),
(NULL,'2015-12-11',5 ,12 ,5 ,'3-1', 2),
(NULL,'2018-02-12',1 ,11,1 ,'3-0',5),
(NULL,'2017-05-13', 6 ,8,6, '3-0',1),
(NULL,'2019-07-15', 3 ,2 ,3, '2-1',8),
(NULL,'2020-08-22', 9, 10 , 9 ,'1-0' , 11),
(NULL,'2016-04-23', 7 ,12 ,7, '2-0' ,3),
(NULL,'2020-02-19', 11, 9 ,11 ,'4-3', 5);


CREATE TABLE memberships(

  membership_id  INT NOT NULL AUTO_INCREMENT,
  team INT,
  player INT,
  join_date DATE,
  leave_date DATE,
  PRIMARY KEY (membership_id),
  FOREIGN KEY (team) REFERENCES teams(team_id),
  FOREIGN KEY (player) REFERENCES players(player_id)
);
  INSERT INTO  `memberships` (`membership_id`,`team`,`player`,`join_date`,`leave_date`) VALUE 
  (NULL,5,1,'2006-10-4','2021-06-23'),
  (NULL,1,2,'2009-08-12','2019-05-11'),
  (NULL,12,3,'2015-03-13','2021-02-17'),
  (NULL,11,4,'2017-05-02','2019-08-01'),
  (NULL,11,5,'2015-07-06','2021-04-15');




