-- =============================================
-- V2__insert_seed_data.sql
-- =============================================

-- =============================================
-- BREAKING BAD - Tabela PERSON (base)
-- =============================================
INSERT INTO person (social_security, name, email, gender, birth_date, profile_picture_url) VALUES
('BB-001-WW', 'Walter White',     'heisenberg@bb.com',       'Male',   '1959-09-07', NULL),
('BB-002-JP', 'Jesse Pinkman',    'jesse.pinkman@bb.com',    'Male',   '1984-09-24', NULL),
('BB-003-GF', 'Gustavo Fring',    'gus.fring@lospollos.com', 'Male',   '1958-03-17', NULL),
('BB-004-TS', 'Tuco Salamanca',   'tuco.s@cartel.com',       'Male',   '1975-06-10', NULL),
('BB-005-HS', 'Hector Salamanca', 'hector.s@cartel.com',     'Male',   '1940-04-01', NULL),
('BB-006-ME', 'Mike Ehrmantraut', 'mike.e@bb.com',           'Male',   '1945-11-07', NULL),
('BB-007-TA', 'Todd Alquist',     'todd.a@bb.com',           'Male',   '1990-08-15', NULL),
('BB-008-JW', 'Jack Welker',      'jack.w@nazis.com',        'Male',   '1955-03-20', NULL),
('BB-009-LR', 'Lydia Rodarte',    'lydia.r@madrigal.com',    'Female', '1975-07-22', NULL),
('BB-010-K8', 'Krazy-8',          'krazy8@cartel.com',       'Male',   '1982-02-14', NULL),
('BB-011-DE', 'Don Eladio',       'don.eladio@cartel.com',   'Male',   '1945-01-30', NULL),
('BB-012-MA', 'Marco Salamanca',  'marco@cartel.com',        'Male',   '1978-05-05', NULL),
('BB-013-LE', 'Leonel Salamanca', 'leonel@cartel.com',       'Male',   '1978-05-05', NULL);

-- =============================================
-- BREAKING BAD - Tabela INMATE (subquery no id)
-- =============================================
INSERT INTO inmate (id, commited_crime, arrest_date, sentenced_years) VALUES
((SELECT id FROM person WHERE social_security = 'BB-001-WW'), 'Drug Manufacturing and Distribution', '2008-01-01', 'life'),
((SELECT id FROM person WHERE social_security = 'BB-002-JP'), 'Drug Distribution',                   '2008-06-01', '5 years'),
((SELECT id FROM person WHERE social_security = 'BB-003-GF'), 'Drug Trafficking, Money Laundering',  '2012-01-01', 'life'),
((SELECT id FROM person WHERE social_security = 'BB-004-TS'), 'Drug Trafficking, Murder',            '2009-03-01', 'life'),
((SELECT id FROM person WHERE social_security = 'BB-005-HS'), 'Drug Trafficking, Murder',            '1980-01-01', 'life'),
((SELECT id FROM person WHERE social_security = 'BB-006-ME'), 'Murder, Obstruction of Justice',      '2012-06-01', '30 years'),
((SELECT id FROM person WHERE social_security = 'BB-007-TA'), 'Murder, Drug Manufacturing',          '2013-01-01', 'life'),
((SELECT id FROM person WHERE social_security = 'BB-008-JW'), 'Murder, Kidnapping, Drug Trafficking','2013-05-01', 'life'),
((SELECT id FROM person WHERE social_security = 'BB-009-LR'), 'Drug Trafficking, Money Laundering',  '2013-07-01', '25 years'),
((SELECT id FROM person WHERE social_security = 'BB-010-K8'), 'Drug Distribution',                   '2008-02-01', '10 years'),
((SELECT id FROM person WHERE social_security = 'BB-011-DE'), 'Drug Trafficking, Murder',            '1990-01-01', 'life'),
((SELECT id FROM person WHERE social_security = 'BB-012-MA'), 'Murder, Drug Trafficking',            '2009-08-01', 'life'),
((SELECT id FROM person WHERE social_security = 'BB-013-LE'), 'Murder, Drug Trafficking',            '2009-08-01', 'life');

-- =============================================
-- CHAPOLIN - Tabela PERSON (base)
-- =============================================
INSERT INTO person (social_security, name, email, gender, birth_date, profile_picture_url) VALUES
('CH-001-TS', 'Tripa Seca',       'tripa.seca@viloes.com',     'Male',   '1940-05-01', NULL),
('CH-002-QN', 'Quase Nada',       'quase.nada@viloes.com',     'Male',   '1942-08-01', NULL),
('CH-003-AN', 'Alma Negra',       'alma.negra@piratas.com',    'Male',   '1935-03-01', NULL),
('CH-004-RC', 'Racha Cuca',       'racha.cuca@oeste.com',      'Male',   '1938-07-01', NULL),
('CH-005-DL', 'Dr. Lobstein',     'lobstein@ciencia.com',      'Male',   '1930-11-01', NULL),
('CH-006-SS', 'Super Sam',        'supersam@usa.com',          'Male',   '1945-07-04', NULL),
('CH-007-CT', 'Conde Terra Nova', 'conde.terranova@viloes.com','Male',   '1928-01-01', NULL);

-- =============================================
-- CHAPOLIN - Tabela INMATE
-- =============================================
INSERT INTO inmate (id, commited_crime, arrest_date, sentenced_years) VALUES
((SELECT id FROM person WHERE social_security = 'CH-001-TS'), 'Contraband, Assault, Robbery',          '1965-03-10', '20 years'),
((SELECT id FROM person WHERE social_security = 'CH-002-QN'), 'Armed Robbery, Assault',                '1967-06-15', '15 years'),
((SELECT id FROM person WHERE social_security = 'CH-003-AN'), 'Piracy, Murder, Kidnapping',            '1960-09-20', 'life'),
((SELECT id FROM person WHERE social_security = 'CH-004-RC'), 'Armed Robbery, Stagecoach Assault',     '1962-04-05', '25 years'),
((SELECT id FROM person WHERE social_security = 'CH-005-DL'), 'Illegal Experiments, Kidnapping',       '1958-12-01', '30 years'),
((SELECT id FROM person WHERE social_security = 'CH-006-SS'), 'Extortion, International Fraud',        '1970-07-04', '10 years'),
((SELECT id FROM person WHERE social_security = 'CH-007-CT'), 'Grand Theft, Fraud, Impersonation',     '1955-08-20', '20 years');

-- =============================================
-- CHAVES - Tabela PERSON (moradores da vila)
-- =============================================
INSERT INTO person (social_security, name, email, gender, birth_date, profile_picture_url) VALUES
('CV-001-CH', 'Chaves',              'chaves@vila.com',            'Male',   '1964-01-01', NULL),
('CV-002-QC', 'Quico',               'quico@vila.com',             'Male',   '1963-03-15', NULL),
('CV-003-CQ', 'Chiquinha',           'chiquinha@vila.com',         'Female', '1963-06-20', NULL),
('CV-004-SM', 'Seu Madruga',         'seu.madruga@vila.com',       'Male',   '1935-09-10', NULL),
('CV-005-DF', 'Dona Florinda',       'dona.florinda@vila.com',     'Female', '1938-04-22', NULL),
('CV-006-DC', 'Dona Clotilde',       'bruxa71@vila.com',           'Female', '1936-10-31', NULL),
('CV-007-PG', 'Professor Girafales', 'girafales@escolinha.com',    'Male',   '1934-02-14', NULL),
('CV-008-SB', 'Senhor Barriga',      'sr.barriga@cobraluguel.com', 'Male',   '1933-11-05', NULL),
('CV-009-NH', 'Nhonho',              'nhonho@vila.com',            'Male',   '1962-07-08', NULL),
('CV-010-JM', 'Jaiminho',            'jaiminho@correio.com',       'Male',   '1940-12-01', NULL);

-- =============================================
-- ENDEREÇOS - Breaking Bad
-- =============================================
INSERT INTO address (street, address_complement, city, state, country, person_id) VALUES
('308 Negra Arroyo Lane',   'House',         'Albuquerque', 'NM', 'USA',    (SELECT id FROM person WHERE social_security = 'BB-001-WW')),
('9809 Margo St',           'Apt 2',         'Albuquerque', 'NM', 'USA',    (SELECT id FROM person WHERE social_security = 'BB-002-JP')),
('12000 Vista Del Mar',     'Suite 1',       'Albuquerque', 'NM', 'USA',    (SELECT id FROM person WHERE social_security = 'BB-003-GF')),
('6353 Juan Tabo Blvd',     'Unit A',        'Albuquerque', 'NM', 'USA',    (SELECT id FROM person WHERE social_security = 'BB-004-TS')),
('Cartel Compound',         NULL,            'Juarez',      'CH', 'Mexico', (SELECT id FROM person WHERE social_security = 'BB-005-HS')),
('4 Vista del Rio',         'Apt 3',         'Albuquerque', 'NM', 'USA',    (SELECT id FROM person WHERE social_security = 'BB-006-ME')),
('Neo-Nazi Compound',       NULL,            'Albuquerque', 'NM', 'USA',    (SELECT id FROM person WHERE social_security = 'BB-007-TA')),
('Nazi Ranch',              NULL,            'Albuquerque', 'NM', 'USA',    (SELECT id FROM person WHERE social_security = 'BB-008-JW')),
('Madrigal Houston Office', 'Floor 12',      'Houston',     'TX', 'USA',    (SELECT id FROM person WHERE social_security = 'BB-009-LR')),
('Salamanca Trap House',    NULL,            'Albuquerque', 'NM', 'USA',    (SELECT id FROM person WHERE social_security = 'BB-010-K8')),
('Hacienda Eladio',         NULL,            'Juarez',      'CH', 'Mexico', (SELECT id FROM person WHERE social_security = 'BB-011-DE')),
('Salamanca Border House',  NULL,            'El Paso',     'TX', 'USA',    (SELECT id FROM person WHERE social_security = 'BB-012-MA')),
('Salamanca Border House',  NULL,            'El Paso',     'TX', 'USA',    (SELECT id FROM person WHERE social_security = 'BB-013-LE'));

-- =============================================
-- ENDEREÇOS - Chapolin
-- =============================================
INSERT INTO address (street, address_complement, city, state, country, person_id) VALUES
('Velho Oeste',         NULL,            'Cidade Caótica', 'MX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CH-001-TS')),
('Covil dos Bandidos',  NULL,            'Cidade Caótica', 'MX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CH-002-QN')),
('Mar do Caribe',       'Navio Pirata',  'Caribe',         'CB', 'Mexico', (SELECT id FROM person WHERE social_security = 'CH-003-AN')),
('Fazenda Racha Cuca',  NULL,            'Velho Oeste',    'MX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CH-004-RC')),
('Laboratório Lobstein',NULL,            'Cidade Caótica', 'MX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CH-005-DL')),
('Consulado Americano', NULL,            'Cidade Caótica', 'MX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CH-006-SS')),
('Mansão Terra Nova',   NULL,            'Cidade Caótica', 'MX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CH-007-CT'));

-- =============================================
-- ENDEREÇOS - Chaves
-- =============================================
INSERT INTO address (street, address_complement, city, state, country, person_id) VALUES
('Avenida Insurgentes', 'Apt 8 / O Barril',   'Cidade do México', 'CDMX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CV-001-CH')),
('Avenida Insurgentes', 'Apt 14',             'Cidade do México', 'CDMX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CV-002-QC')),
('Avenida Insurgentes', 'Apt 14',             'Cidade do México', 'CDMX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CV-003-CQ')),
('Avenida Insurgentes', 'Apt 72',             'Cidade do México', 'CDMX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CV-004-SM')),
('Avenida Insurgentes', 'Apt 14',             'Cidade do México', 'CDMX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CV-005-DF')),
('Avenida Insurgentes', 'Apt 71',             'Cidade do México', 'CDMX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CV-006-DC')),
('Avenida Insurgentes', 'Escola da Vila',      'Cidade do México', 'CDMX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CV-007-PG')),
('Avenida Insurgentes', 'Escritório do Dono', 'Cidade do México', 'CDMX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CV-008-SB')),
('Avenida Insurgentes', 'Apt Nhonho',         'Cidade do México', 'CDMX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CV-009-NH')),
('Avenida Insurgentes', 'Apt Jaiminho',       'Cidade do México', 'CDMX', 'Mexico', (SELECT id FROM person WHERE social_security = 'CV-010-JM'));