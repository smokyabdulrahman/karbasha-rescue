CREATE TYPE post_type AS ENUM ('ADOPTION', 'FOSTERING', 'RESCUE');

DROP TABLE IF EXISTS post;
CREATE TABLE IF NOT EXISTS post (
    id uuid Primary Key,
    type post_type NOT NULL,
    user_id uuid REFERENCES user_profile NOT NULL,
    pet_id uuid REFERENCES pet NOT NULL,
    title varchar(650) NOT NULL,
    description varchar(650) NOT NULL,
    location_url varchar(1000) NOT NULL,
    image_url varchar(1000),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);
