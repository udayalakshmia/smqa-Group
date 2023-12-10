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

create table mcqa.users
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

INSERT INTO mcqa.questions (id, question, option1, option2, option3, option4, correct_option) VALUES (1, '1. What is the capital city of France?', 'Madrid', 'Rome', 'Berlin', 'Paris', 4);
INSERT INTO mcqa.questions (id, question, option1, option2, option3, option4, correct_option) VALUES (2, '2. Which planet is known as the Red Planet', 'Jupiter', 'Mars', 'Venus', 'Saturn', 2);
INSERT INTO mcqa.questions (id, question, option1, option2, option3, option4, correct_option) VALUES (3, '3. Which is the closest planet to the sun?', 'Earth', 'Mercury', 'Jupiter', 'Saturn', 2);
INSERT INTO mcqa.questions (id, question, option1, option2, option3, option4, correct_option) VALUES (4, '4. What is the largest mammal in the world?', 'Elephant', 'Giraffe', 'Blue Whale', 'Gorilla', 3);
INSERT INTO mcqa.questions (id, question, option1, option2, option3, option4, correct_option) VALUES (5, '5. Who wrote the play Romeo and Juliet?', 'Charles Dickens', 'William Shakespeare', 'Jane Austen', 'Mark Twain', 2);
INSERT INTO mcqa.questions (id, question, option1, option2, option3, option4, correct_option) VALUES (6, '6. Which famous scientist developed the theory of general relativity?', 'Isaac Newton', ' Albert Einstein', 'Stephen Hawking', ' Galileo Galilei', 2);
INSERT INTO mcqa.questions (id, question, option1, option2, option3, option4, correct_option) VALUES (7, '7. In what year did the Titanic sink?', '1905', '1912', '1920', '1931', 2);
INSERT INTO mcqa.questions (id, question, option1, option2, option3, option4, correct_option) VALUES (8, '8. What is the currency of Japan?', 'Yuan', 'Won', 'Yen', 'Ringgit', 3);
INSERT INTO mcqa.questions (id, question, option1, option2, option3, option4, correct_option) VALUES (9, '9. What is the largest ocean on Earth?', 'Atlantic Ocean', ' Indian Ocean', 'Southern Ocean', 'Pacific Ocean', 4);
INSERT INTO mcqa.questions (id, question, option1, option2, option3, option4, correct_option) VALUES (10, '10. Which is the largest planet?', 'Earth', 'Mercury', 'Jupiter', 'Saturn', 3);


INSERT INTO mcqa.users (id, first_name, last_name, email, password, role, score) VALUES (1, 'Nick', 'Fury', 'nick.fury@gmail.com', 'pass1', 'ADMIN', null);
INSERT INTO mcqa.users (id, first_name, last_name, email, password, role, score) VALUES (2, 'Charles', 'Xavier', 'charles.xavier@gmail.com', 'pass2', 'EDUCATOR', null);
INSERT INTO mcqa.users (id, first_name, last_name, email, password, role, score) VALUES (3, 'John', 'Doe', 'john.doe@gmail.com', 'pass3', 'STUDENT', 7);
INSERT INTO mcqa.users (id, first_name, last_name, email, password, role, score) VALUES (4, 'Peter', 'Parker', 'perter.parker@gmail.com', 'pass4', 'STUDENT', 6);
INSERT INTO mcqa.users (id, first_name, last_name, email, password, role, score) VALUES (5, 'Diana', 'Prince', 'diana.prince@gmail.com', 'pass5', 'STUDENT', 5);
INSERT INTO mcqa.users (id, first_name, last_name, email, password, role, score) VALUES (6, 'Wade', 'Wikson', 'wade.wilson@gmail.com', 'pass6', 'STUDENT', 4);
