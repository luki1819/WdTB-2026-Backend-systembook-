-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('ola@student.merito.pl',   'Ola',   'USER',    current_timestamp),
    ('kuba@student.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

-- LAB 01: Wasze konta (zmieńcie na swoje dane, rola USER)
-- insert into user_account (email, display_name, role, created_at) values
--     ('imie.nazwisko@student.merito.pl', 'Imię', 'USER', current_timestamp);
insert into user_account (email, display_name, role, created_at) values
    ('lukasz.kluczny@student.merito.pl',   'Łukasz',   'USER',    current_timestamp),
    ('vlas.doliba-iaboi@student.merito.pl',  'Vlas',  'USER',    current_timestamp),
    ('vladyslav.demianko@student.merito.pl',   'Vladyslav',   'USER',    current_timestamp);

-- ===== LAB 02 · conference_room =====
insert into conference_room (name, capacity, floor_number, hourly_rate, has_projector) values
                                                                                           ('Sala Odra',    8, 1, 120.00, true),
                                                                                           ('Sala Ślęża',  20, 2, 250.00, true),
                                                                                           ('Sala Rynek',   4, 1,  80.00, false);

-- ===== LAB 02 · client =====
insert into client (company_name, contact_person, email, phone, street, city, postal_code) values
                                                                                               ('Nowak Consulting', 'Marek Nowak',    'marek@nowak-consulting.pl', '600111222', 'Świdnicka 10',  'Wrocław', '50-066'),
                                                                                               ('Studio Pixel',     'Anna Zielińska', 'anna@studiopixel.pl',       null,        'Ruska 5/2',     'Wrocław', '50-079'),
                                                                                               ('Freelancer Piotr', 'Piotr Lis',      'piotr.lis@example.com',     '600333444', null,            null,      null);

-- ===== LAB 02 · booking =====
insert into booking (title, status, attendees, created_at, start_time, end_time) values
                                                                                     ('Spotkanie zarządu',     'CONFIRMED', 6,  '2026-11-10 09:00:00', '2026-11-18 10:00:00', '2026-11-18 12:00:00'),
                                                                                     ('Warsztat projektowy',   'PENDING',   15, '2026-11-11 08:30:00', '2026-11-20 13:00:00', '2026-11-20 17:00:00'),
                                                                                     ('Rozmowa rekrutacyjna',  'CANCELLED', 3,  '2026-11-09 14:15:00', '2026-11-19 09:00:00', '2026-11-19 10:00:00');