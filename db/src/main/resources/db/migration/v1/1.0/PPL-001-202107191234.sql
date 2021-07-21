CREATE SCHEMA healthtech;

CREATE TABLE healthtech.speciality (
    id INTEGER PRIMARY KEY,
    title VARCHAR(50)
);

CREATE TABLE healthtech.user (
    id INTEGER PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    mid_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

CREATE SEQUENCE user_seq START 10;

ALTER TABLE healthtech.user ALTER COLUMN id SET DEFAULT nextval('user_seq');

CREATE TABLE healthtech.administrator (
    id INTEGER PRIMARY KEY
) INHERITS (healthtech.user);

CREATE TABLE healthtech.patient (
    id INTEGER PRIMARY KEY
) INHERITS (healthtech.user);

CREATE TABLE healthtech.doctor (
    id INTEGER PRIMARY KEY,
    speciality_id INTEGER REFERENCES healthtech.speciality (id)
) INHERITS (healthtech.user);

CREATE TABLE healthtech.record_time (
    id INTEGER PRIMARY KEY,
    doctor_id INTEGER REFERENCES healthtech.doctor (id),
    date DATE,
    start_time TIME,
    end_time TIME
);

CREATE TABLE healthtech.appointment (
    id INTEGER PRIMARY KEY,
    is_taken BOOLEAN,
    patient_id INTEGER REFERENCES healthtech.patient (id),
    record_time_id INTEGER REFERENCES healthtech.record_time (id),
    date DATE
);