drop table if exists PEOPLE;
drop table if exists PLACE;
CREATE TABLE PEOPLE(
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    person_name VARCHAR(20),
    about VARCHAR(250)
);
insert into PEOPLE(person_name,about) values('HITLER','Adolf Hitler was the leader of Nazi Germany from 1934 to 1945');
insert into PEOPLE(person_name,about) values('LENIN','Lenin was kicked out of college');
CREATE TABLE PLACE(
    PLACE_ID BIGINT IDENTITY NOT NULL PRIMARY KEY,
    PLACE_NAME VARCHAR(20),
    about VARCHAR(250)
);
insert into PLACE(PLACE_NAME,about) values('PATNA','In the ancient times (about 2000 years back)  Patna was  a place of great scholars');
insert into PLACE(PLACE_NAME,about) values('HYDERABAD','Hyderabad city is the capital city of the Indian state of Andhra Pradesh');
