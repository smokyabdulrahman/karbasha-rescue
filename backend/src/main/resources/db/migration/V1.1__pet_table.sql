CREATE TABLE IF NOT EXISTS pet (
    id uuid Primary Key,
    owner_id uuid,
    name varchar(255),
    age smallint,
    gender varchar(255),
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