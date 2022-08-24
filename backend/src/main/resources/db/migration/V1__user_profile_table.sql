DROP TABLE IF EXISTS user_profile;
CREATE TABLE IF NOT EXISTS user_profile (
    id uuid PRIMARY KEY,
    username VARCHAR (100) UNIQUE NOT NULL,
    name VARCHAR ( 150 ) NOT NULL,
    age smallint,
    email VARCHAR ( 255 ) UNIQUE NOT NULL,
    phone VARCHAR ( 50 ),
    neighborhood VARCHAR ( 50 ),
    city VARCHAR ( 50 ),
    has_kids boolean,
    monthly_income decimal,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);