CREATE TABLE dept(
  ND int(11) NOT NULL,
  NOM varchar(14),
  VILLE varchar(13),
  PRIMARY KEY(ND)
) ;
CREATE TABLE emp (
  NE int(11) NOT NULL,
  NOM varchar(10),
  JOB varchar(9),
  DATEMB date,
  SAL float(7,2),
  COMM float(7,2),
  ND int(11),
  NEchef int(11),
  PRIMARY KEY(NE),
  FOREIGN KEY(ND) REFERENCES dept(ND),
  FOREIGN KEY(NEchef) REFERENCES emp(NE)

);