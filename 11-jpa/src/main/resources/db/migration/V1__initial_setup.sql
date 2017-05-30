CREATE TABLE jmp_user (
    id SERIAL,
    name VARCHAR(100) NOT NULL,
    CONSTRAINT pk_jpm_user_id PRIMARY KEY (id),
    CONSTRAINT uk_jpm_user_name UNIQUE (name)
);


CREATE TABLE jmp_role (
    id SERIAL,
    name VARCHAR(100) NOT NULL,
    CONSTRAINT pk_jmp_role_id PRIMARY KEY (id)
);

CREATE TABLE jmp_user_role (
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    CONSTRAINT pk_jmp_user_role PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_jmp_user_role_user_id FOREIGN KEY (user_id) REFERENCES jmp_user (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_jmp_user_role_role_id FOREIGN KEY (role_id) REFERENCES jmp_role (id) ON DELETE CASCADE ON UPDATE CASCADE
);
