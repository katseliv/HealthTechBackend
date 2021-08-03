INSERT INTO healthtech.users
VALUES (1, '1234', 'katseliv', 'katseliv@yandex.ru'),
       (2, '5678', 'doctorwho', 'doctorwho@gmail.ru'),
       (3, 'admin', 'admin', 'admin@admin.ru');

INSERT INTO healthtech.patients
VALUES (1, 19, 'F', 89081432043, 'Ekaterina', 'Aleksandrovna', 'Selivanova');

INSERT INTO healthtech.doctors
VALUES (2, 5, 'Ivan', 'Ivanovich', 'Ivanov');

INSERT INTO healthtech.administrators
VALUES (3);

INSERT INTO healthtech.allergies
VALUES (1, 'pineapple'),
       (2, 'dust');

INSERT INTO healthtech.time_records
VALUES (1, 2, '2021-08-02', '01:00:00', '02:00:00');

INSERT INTO healthtech.appointments
VALUES (1, 1, 1, true, '2021-08-03T10:33:18.479321800Z', '', '');

INSERT INTO healthtech.comments
VALUES (1, 2, 1, '2021-08-03T10:33:18.479321800Z', 5, 'Thanks for help');

INSERT INTO healthtech.specialities
VALUES (1, 'orthodontist');

INSERT INTO healthtech.doctors_specialities
VALUES (2, 1, '2021-08-02');
