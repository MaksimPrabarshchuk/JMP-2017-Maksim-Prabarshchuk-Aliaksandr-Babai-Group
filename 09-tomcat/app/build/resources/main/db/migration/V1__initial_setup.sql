CREATE TABLE post (
    id SERIAL,
    text VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    CONSTRAINT pk_post_id PRIMARY KEY (id)
);
