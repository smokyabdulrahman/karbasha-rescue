CREATE TYPE gender_type AS ENUM ('MALE', 'FEMALE');

DROP TABLE IF EXISTS pet;
CREATE TABLE IF NOT EXISTS pet (
    id uuid Primary Key,
    owner_id uuid REFERENCES user_profile,
    name varchar(255),
    age smallint,
    gender gender_type NOT NULL,
    picture varchar(255),
    health_condition varchar(255),
    vaccinated boolean,
    neutered boolean,
    personality_description varchar(255),
    country varchar(255),
    city varchar(255),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);
