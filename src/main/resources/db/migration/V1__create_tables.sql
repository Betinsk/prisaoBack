CREATE TABLE IF NOT EXISTS person (
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    social_security     VARCHAR(255) NOT NULL UNIQUE,
    name                VARCHAR(255),
    email               VARCHAR(255),
    gender              VARCHAR(255),
    birth_date          DATE,
    profile_picture_url VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS inmate (
    id              BIGINT PRIMARY KEY,
    commited_crime  VARCHAR(255),
    arrest_date     DATE,
    sentenced_years VARCHAR(255),
    CONSTRAINT fk_inmate_person FOREIGN KEY (id) REFERENCES person(id)
);

CREATE TABLE IF NOT EXISTS address (
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    street              VARCHAR(255),
    address_complement  VARCHAR(255),
    city                VARCHAR(255),
    state               VARCHAR(255),
    country             VARCHAR(255),
    person_id           BIGINT,
    CONSTRAINT fk_address_person FOREIGN KEY (person_id) REFERENCES person(id)
);