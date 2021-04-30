DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS course;

CREATE TABLE student
(
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    jmbag VARCHAR (10) NOT NULL,
    dateofbirth TIMESTAMP NOT NULL,
    numberofects INT NOT NULL
);

CREATE TABLE course
(
    course_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    numberofects INT NOT NULL
);

CREATE TABLE student_course
(
    student_id int(11) NOT NULL,
    course_id int(11) NOT NULL,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES student (student_id),
    FOREIGN KEY (course_id) REFERENCES course (course_id)
);

CREATE TABLE IF NOT EXISTS user
(
    id IDENTITY ,
    username VARCHAR (100) NOT NULL,
    password VARCHAR (250) NOT NULL,
    first_name VARCHAR (250) NOT NULL,
    last_name VARCHAR (250) NOT NULL
);

CREATE TABLE IF NOT EXISTS authority
(
    id IDENTITY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_authority
(
    user_id bigint NOT NULL,
    authority_id bigint NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT fk_authority FOREIGN KEY (authority_id) REFERENCES authority(id)
);