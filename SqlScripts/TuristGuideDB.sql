CREATE SCHEMA IF NOT EXISTS Turist_Guide;
CREATE TABLE IF NOT EXISTS attractions (
	id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    description varchar(255)NOT NULL DEFAULT ' ',
    city varchar(20) NOT NULL DEFAULT ' ');

CREATE TABLE IF NOT EXISTS attraction_tag (
	attractions_id int ,
    tag_name varchar(30) not null );
