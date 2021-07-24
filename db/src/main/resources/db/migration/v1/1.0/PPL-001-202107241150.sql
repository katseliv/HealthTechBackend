CREATE SCHEMA healthtech;

CREATE TABLE healthtech.speciality
(
    speciality_id SERIAL PRIMARY KEY,
    name          VARCHAR(50)
);

CREATE TABLE healthtech.user
(
    user_id  SERIAL PRIMARY KEY,
    first_name   VARCHAR(50) NOT NULL,
    mid_name     VARCHAR(50) NOT NULL,
    last_name    VARCHAR(50) NOT NULL,
    phone_number VARCHAR(11) NOT NULL,
    password VARCHAR(50)  NOT NULL,
    email    VARCHAR(100) NOT NULL
);

--CREATE SEQUENCE user_seq START 10;

--ALTER TABLE healthtech.user ALTER COLUMN id SET DEFAULT nextval('user_seq');

CREATE TABLE healthtech.allergies
(
    allergy_id   SERIAL PRIMARY KEY,
    allergy_name VARCHAR(100) NOT NULL
);

CREATE TABLE healthtech.patient
(
    patient_id   INTEGER PRIMARY KEY,
    age          INTEGER     NOT NULL,
    sex          BOOLEAN     NOT NULL,
    allergies    INTEGER REFERENCES healthtech.allergies (allergy_id),
    diseases     INTEGER, --REFERENCES healthtech.diseases (disease_id),
    appointments INTEGER  --REFERENCES healthtech.appointment (appointment_id)
) INHERITS (healthtech.user);

CREATE TABLE healthtech.appointment
(
    appointment_id INTEGER PRIMARY KEY,
    is_taken       BOOLEAN,
    patient_id     INTEGER REFERENCES healthtech.patient (patient_id) NOT NULL,
    timetable_id   INTEGER, --REFERENCES healthtech.timetable (id)       NOT NULL,
    datetime       TIMESTAMPTZ                                        NOT NULL
);

CREATE TABLE healthtech.diseases
(
    disease_id SERIAL PRIMARY KEY,
    patient_id INTEGER REFERENCES healthtech.patient (patient_id),
    name       VARCHAR(100) NOT NULL,
    start_date DATE         NOT NULL,
    end_date   DATE
);

CREATE TABLE healthtech.administrator
(
    admin_id INTEGER PRIMARY KEY
);

CREATE TABLE healthtech.doctor
(
    id            INTEGER PRIMARY KEY,
    speciality_id INTEGER REFERENCES healthtech.speciality (speciality_id) NOT NULL,
    sex           BOOLEAN,
    rating        FLOAT                                                    NOT NULL,
    timetable_id  INTEGER --REFERENCES healthtech.timetable (id)
) INHERITS (healthtech.user);

CREATE TABLE healthtech.timetable
(
    timetable_id INTEGER PRIMARY KEY,
    doctor_id    INTEGER REFERENCES healthtech.doctor (id),
    date         DATE,
    start_time   TIME,
    end_time     TIME
);

CREATE TABLE healthtech.comment
(
    id         SERIAL PRIMARY KEY,
    doctor_id  INTEGER REFERENCES healthtech.doctor (id),
    patient_id INTEGER REFERENCES healthtech.patient (patient_id),
    data       DATE    NOT NULL,
    mark       INTEGER NOT NULL,
    comment    VARCHAR(500)
);

ALTER TABLE healthtech.patient
    ADD CONSTRAINT disease_fk FOREIGN KEY (diseases) REFERENCES healthtech.diseases (disease_id);

ALTER TABLE healthtech.patient
    ADD CONSTRAINT appointment_fk FOREIGN KEY (appointments) REFERENCES healthtech.appointment (appointment_id);

ALTER TABLE healthtech.doctor
    ADD CONSTRAINT timetable_fk FOREIGN KEY (timetable_id) REFERENCES healthtech.timetable (timetable_id);

ALTER TABLE healthtech.appointment
    ADD CONSTRAINT timetable_fk FOREIGN KEY (timetable_id) REFERENCES healthtech.timetable (timetable_id);


-- прочитать про inherits
-- контроллеры - принимают и отдают
-- сервисы - бизнес-логика, если бизнес-логики много, в работу включаются facade
-- мапперы - преобразуют модели из одной в другую, у них есть зависимости
-- провайдеры - достают данные откуда-нибудь
-- репозитории привязываются к какому-нибудь хранилищу данных
--