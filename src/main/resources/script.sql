-- Database: to-do-list-db

-- DROP DATABASE IF EXISTS "to-do-list-db";

CREATE DATABASE "to-do-list-db"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

create table users (
   userId serial,
   name varchar(255),
   gitHubUsername varchar(255),
   email varchar(255) not null unique,
   password varchar(255) not null,
   CONSTRAINT pk_users PRIMARY KEY(userId)
);

create table tasks (
   taskId serial,
   title varchar(255),
   deadline date not null,
   created date not null,
   priority int not null,
   CONSTRAINT pk_tasks PRIMARY KEY(taskId)
);

create table users_tasks (
     userId int not null,
     taskId int not null,
     CONSTRAINT fk_users_userstasks FOREIGN KEY(userId) REFERENCES users(userId),
     CONSTRAINT fk_tasks_userstasks FOREIGN KEY(taskId) REFERENCES tasks(taskId),
     CONSTRAINT pk_userstasks PRIMARY KEY(userId,taskId)
);

insert into users(name, gitHubUsername, email, password) values
 ('Bolonyi Andreea', 'AndreeaBolonyi', 'andreea@yahoo.com', 'andreea'),
 ('Burduleanu Flavius', 'FlaviusB', 'flavius@yahoo.com', 'flavius');

insert into tasks(title, deadline, created, priority) values
  ('MA Lab', '2021-11-21', '2021-11-07', 1),
  ('PPD Lab', '2021-11-21', '2021-11-15', 2),
  ('LFTC Lab', '2021-11-30', '2021-11-07', 1),
  ('curs contitutional tema', '2021-11-21', '2021-11-07', 1);

insert into users_tasks(userId,taskId) values (1,1), (1,2), (1,3), (2,4);