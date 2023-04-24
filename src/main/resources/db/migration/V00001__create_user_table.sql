CREATE TABLE "user"
(
    id       serial PRIMARY KEY,
    username varchar(20) NOT NULL UNIQUE,
    name     varchar(255),
    email    varchar(255),
    theme    varchar(20),
    status   boolean      default false,
    created  timestamp default now()
);