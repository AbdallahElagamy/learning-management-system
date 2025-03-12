CREATE DATABASE IF NOT EXISTS lms_db;

USE lms_db;

create table user
(
    id                  bigint auto_increment
        primary key,
    contact_information varchar(255)                            null,
    email               varchar(255)                            null,
    password            varchar(255)                            null,
    profile_picture_url varchar(255)                            null,
    registration_date   datetime(6)                             null,
    username            varchar(255)                            null,
    role                enum ('ADMIN', 'INSTRUCTOR', 'STUDENT') null
);

create table student
(
    id bigint not null
        primary key,
    constraint FK_student_user
        foreign key (id) references user (id)
);

create table instructor
(
    id bigint not null
        primary key,
    constraint FK_instructor_user
        foreign key (id) references user (id)
);

create table course
(
    id            bigint auto_increment
        primary key,
    category      varchar(255)   null,
    description   varchar(255)   null,
    price         decimal(38, 2) null,
    rating        double         not null,
    title         varchar(255)   null,
    instructor_id bigint         null,
    constraint FK_course_instructor
        foreign key (instructor_id) references instructor (id)
);

create table enrollment
(
    id              bigint auto_increment
        primary key,
    course_id       bigint null,
    enrollment_date date   null,
    student_id      bigint not null,
    constraint FK_enrollment_course
        foreign key (course_id) references course (id),
    constraint FK_enrollment_student
        foreign key (student_id) references student (id)
);

create table rating
(
    id         bigint auto_increment
        primary key,
    course_id  bigint null,
    student_id bigint null,
    score      double not null,
    constraint FK_rating_student
        foreign key (student_id) references student (id),
    constraint FK_rating_course
        foreign key (course_id) references course (id)
);



