insert into user (username, password, role) values ('Apa', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'ROLE_ADMIN');
insert into user (username, password, role) values ('Sanyi', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'ROLE_USER');
insert into user (username, password, role) values ('Janka', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'ROLE_USER');

insert into transaction (user_id, title, amount, created_at, updated_at) values (1, 'vasarlas', '-100', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into transaction (user_id, title, amount, created_at, updated_at) values (1, 'vasarlas', '-1000', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into transaction (user_id, title, amount, created_at, updated_at) values (2, 'fizetes', '20000', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into transaction (user_id, title, amount, created_at, updated_at) values (2, 'zsebpenz', '100', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

insert into message (transaction_id, text) values (1, 'vettem egy snickerst');
insert into message (transaction_id, text) values (1, 'vettem pekarut');
insert into message (transaction_id, text) values (2, 'elmentem megtankolni a kocsit');
insert into message (transaction_id, text) values (3, 'megkaptam a fizetesem');

insert into type (text) values ('elelmiszer');
insert into type (text) values ('ruha');
insert into type (text) values ('uzemanyag');
insert into type (text) values ('fizetes');

insert into transaction_types (transactions_id, types_id) values (1, 1);
insert into transaction_types (transactions_id, types_id) values (1, 2);
insert into transaction_types (transactions_id, types_id) values (2, 1);
insert into transaction_types (transactions_id, types_id) values (2, 4);
insert into transaction_types (transactions_id, types_id) values (3, 3);
insert into transaction_types (transactions_id, types_id) values (3, 4);
