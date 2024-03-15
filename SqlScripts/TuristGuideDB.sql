CREATE DATABASE IF NOT EXISTS Turist_Guide;
USE Turist_Guide;
CREATE TABLE attractions (
	id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    description varchar(255)NOT NULL DEFAULT ' ',
    city varchar(20) NOT NULL DEFAULT ' ');

CREATE TABLE attraction_tag (
	attractions_id int ,
    tag_id int);
    
CREATE TABLE tags (
	id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(30) NOT NULL);
