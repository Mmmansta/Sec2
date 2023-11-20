DROP TABLE IF EXIST users_roles;
DROP TABLE IF EXIST users;
DROP TABLE IF EXIST roles;
CREATE TABLE users (
    id int not null primary key,
    name varchar(255) not null,
    age int,
    email varchar(255),
    password varchar(255)
);

CREATE TABLE roles (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) not null
);

CREATE TABLE users_roles (
    id int NOT NULL AUTO_INCREMENT ,
    user_id int,
    role_id int,
    FOREIGN KEY (user_id)  REFERENCES users (Id),
    FOREIGN KEY (role_id)  REFERENCES roles (Id)
);

