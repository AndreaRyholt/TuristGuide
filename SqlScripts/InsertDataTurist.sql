USE Turist_Guide;

INSERT INTO attractions (name, description, city) VALUES ("Tivoli", "Stor forlystelsespark i midten af København.", "København");
INSERT INTO attractions (name, description, city) VALUES ("Den Lille Havfrue", "En havfrue på en sten, fra H. C. Andersens kendte eventyr 'Den lille Havfrue'.", "København");
INSERT INTO attractions (name, description, city) VALUES ("Djurs Sommerland", "Forlystelsespark for børn.", "Nimtofte");
INSERT INTO attractions (name, description, city) VALUES ("Glyptoteket", "Kunstmuseum i København.","København");
INSERT INTO attractions (name, description, city) VALUES ("Bakken", "Danmarks ældste forlystelsespark.","Klampenborg");

INSERT INTO tags (name) VALUES ('FORLYSTELSESPARK');
INSERT INTO tags (name) VALUES ('PARK');
INSERT INTO tags (name) VALUES ('SPISESTEDER');
INSERT INTO tags (name) VALUES ('UDENDØRS');
INSERT INTO tags (name) VALUES ('HC_ANDERSEN');
INSERT INTO tags (name) VALUES ('EVENTYR');
INSERT INTO tags (name) VALUES ('BØRN');
INSERT INTO tags (name) VALUES ('KUNST');
INSERT INTO tags (name) VALUES ('MUSEUM');
INSERT INTO tags (name) VALUES ('INDENDØRS');
-- attraction_id , tag_id --
INSERT INTO attraction_tag VALUES (1, 1);
INSERT INTO attraction_tag VALUES (1, 4);
INSERT INTO attraction_tag VALUES (1, 7);
INSERT INTO attraction_tag VALUES (2, 4);
INSERT INTO attraction_tag VALUES (2, 8);
INSERT INTO attraction_tag VALUES (3, 1);
INSERT INTO attraction_tag VALUES (3, 4);
INSERT INTO attraction_tag VALUES (3, 7);
INSERT INTO attraction_tag VALUES (4, 8);
INSERT INTO attraction_tag VALUES (4, 9);
INSERT INTO attraction_tag VALUES (4, 10);
INSERT INTO attraction_tag VALUES (5, 1);
INSERT INTO attraction_tag VALUES (5, 2);
INSERT INTO attraction_tag VALUES (5, 3);

