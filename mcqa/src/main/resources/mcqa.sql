drop database mcqa;

create database mcqa;

create table mcqa.questions
(
    id             int auto_increment
        primary key,
    question       text         not null,
    option1        varchar(255) not null,
    option2        varchar(255) not null,
    option3        varchar(255) not null,
    option4        varchar(255) not null,
    correct_option int          not null
);

create table users
(
    id         int auto_increment
        primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    email      varchar(255) not null,
    password   varchar(255) not null,
    role       varchar(255) not null,
    score      int          null
);

INSERT INTO mcqa.questions (id, question, option1, option2, option3, option4, correct_option) VALUES (1, 'Which is the largest planet?', 'Earth', 'Mercury', 'Jupiter', 'Saturn', 3);
INSERT INTO mcqa.questions (id, question, option1, option2, option3, option4, correct_option) VALUES (2, 'How many moons does earth have?', '3', '1', '0', '2', 2);
INSERT INTO mcqa.questions (id, question, option1, option2, option3, option4, correct_option) VALUES (3, 'Which is the closest planet to the sun?', 'Earth', 'Mercury', 'Jupiter', 'Saturn', 2);

INSERT INTO mcqa.users (id, first_name, last_name, email, password, role, score) VALUES (1, 'Nick', 'Fury', 'nick.fury@gmail.com', 'pass1', 'ADMIN', null);
INSERT INTO mcqa.users (id, first_name, last_name, email, password, role, score) VALUES (2, 'Charles', 'Xavier', 'charles.xavier@gmail.com', 'pass2', 'EDUCATOR', null);
INSERT INTO mcqa.users (id, first_name, last_name, email, password, role, score) VALUES (3, 'John', 'Doe', 'john.doe@gmail.com', 'pass3', 'STUDENT', null);
INSERT INTO mcqa.users (id, first_name, last_name, email, password, role, score) VALUES (4, 'Peter', 'Parker', 'perter.parker@gmail.com', 'pass4', 'STUDENT', null);
INSERT INTO mcqa.users (id, first_name, last_name, email, password, role, score) VALUES (5, 'Diana', 'Prince', 'diana.prince@gmail.com', 'pass5', 'STUDENT', null);
INSERT INTO mcqa.users (id, first_name, last_name, email, password, role, score) VALUES (6, 'Wade', 'Wikson', 'wade.wilson@gmail.com', 'pass6', 'STUDENT', null);
