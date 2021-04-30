INSERT INTO student (first_name, last_name, jmbag, dateofbirth, numberofects) VALUES
( 'Damir','Smrtić','0256423323', '1997-06-15 00:10:01', '105' ),
( 'Đuro','Mirić-Vukašinović','0256423324', '1996-01-11 10:11:20', '173' ),
( 'Ivo','Sanader','0246069994', '1994-04-20 10:11:20', '112' ),
( 'Mirko','Marić','1209876453', '1997-08-14 10:11:20', '168' ),
( 'Edi','Marfi','3880071909', '1990-10-31 10:11:20', '200' );

INSERT INTO course (name, numberofects) VALUES
( 'Programiranje u jeziku java', '5' ),
( 'Programiranje u jeziku C++', '7' ),
( 'Programiranje u jeziku C', '7' ),
( 'Web dizajn', '4' ),
( 'Matematika I', '5' ),
( 'Matematika II', '5' ),
( 'Umjetna inteligencija', '3' );

INSERT INTO student_course(student_id, course_id) VALUES
( '1', '5' ),
( '1', '6' ),
( '2', '7' ),
( '3', '1' ),
( '3', '2' ),
( '3', '3' ),
( '4', '4' ),
( '4', '2' ),
( '5', '3' );

insert into user (id, username, password, first_name, last_name) values (1, 'admin', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'admin', 'admin');
insert into user (id, username, password, first_name, last_name) values (2, 'user', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'user', 'user');
insert into user (id, username, password, first_name, last_name) values (3, 'creator', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'creator', 'creator');
insert into authority (id, name) values (1, 'ROLE_ADMIN');
insert into authority (id, name) values (2, 'ROLE_USER');
insert into authority (id, name) values (3, 'ROLE_CREATOR');
insert into user_authority (user_id, authority_id) values (1, 1);
insert into user_authority (user_id, authority_id) values (2, 2);
insert into user_authority (user_id, authority_id) values (3, 3);