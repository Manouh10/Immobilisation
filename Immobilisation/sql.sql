create database immo;
use immo;

create table responsable (
    id integer not null auto_increment primary key,
    nom_responsable varchar(30)
)engine=innodb;
insert into responsable values(0,'Tony Larren'),(0,'Jaheem Harris'),(0,'Mamy Lahatra Hajaina');

create table article(
    id integer not null auto_increment primary key,
    nom_artcile varchar(30)
)engine=innodb;
insert into article values(0,'Informatique'),(0,'Bureau'),(0,'Transport');

create table immobilisation(
    id integer not null auto_increment primary key,
    nom varchar(30),
    article integer,
    foreign key(article)references article(id),
    prix_aquisation decimal,
    date_achat date,
    date_service date,
    responsable integer,
    foreign key(responsable) references responsable(id) ,
    duree_ammortissement integer
)engine=innodb;

create view viewImmo as (
    select i.id,i.nom,i.prix_aquisation,i.date_achat,i.date_service,i.duree_ammortissement,
    a.nom_artcile,r.nom_responsable 
    from immobilisation i join article a on a.id=i.article
    join responsable r on r.id=i.responsable
);
 