CREATE TABLE "auth_rule"
(
    name       varchar(64) NOT NULL PRIMARY KEY,
    data       bytea,
    created_at timestamp,
    updated_at timestamp
);

CREATE TABLE "auth_item"
(
    name        varchar(64) NOT NULL PRIMARY KEY,
    type        smallint    NOT NULL,
    description text,
    rule_name   varchar(64),
    data        bytea,
    created_at  timestamp,
    updated_at  timestamp,
    FOREIGN KEY (rule_name) REFERENCES auth_rule (name) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE INDEX "idx-auth_item-type" ON auth_item (type);

CREATE TABLE "auth_item_child"
(
    parent varchar(64) NOT NULL,
    child  varchar(64) NOT NULL,
    PRIMARY KEY (parent, child),
    FOREIGN KEY (parent) REFERENCES auth_item (name) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (child) REFERENCES auth_item (name) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE "auth_assignment"
(
    item_name  varchar(64) NOT NULL,
    user_id    integer     NOT NULL,
    created_at timestamp,
    PRIMARY KEY (item_name, user_id),
    FOREIGN KEY (item_name) REFERENCES auth_item (name) ON DELETE CASCADE ON UPDATE CASCADE
);