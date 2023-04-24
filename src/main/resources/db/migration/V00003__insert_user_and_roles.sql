INSERT INTO auth_item (name, type, description, rule_name, created_at, updated_at)
VALUES ('admin', 1, 'Администратор системы', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO auth_item (name, type, description, rule_name, created_at, updated_at)
VALUES ('user', 1, 'Пользователь с ограниченными правами', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO auth_item (name, type, description, rule_name, created_at, updated_at)
VALUES ('operator', 1, 'Оператор системы', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO auth_item_child (parent, child) VALUES ('admin', 'operator');