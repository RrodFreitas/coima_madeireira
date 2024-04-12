INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Julia', 'Lellis', 'julia@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Rodrigo', 'Freitas', 'rodrigo@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Raul', 'Melo', 'raul@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Beatriz', 'Souza', 'beatriz@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 2);

INSERT INTO tb_category (name, created_At) VALUES ('Mesa', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Armario', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Brinquedos', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Cadeira', NOW());

INSERT INTO tb_fornecedor (cnpj, nome, endereco, telefone) VALUES ('93796217000130', 'Compensados Drabecki', 'Rua Júlio Afonso Vieira Lopes, 432', '55(42)34571730');
INSERT INTO tb_fornecedor (cnpj, nome, endereco, telefone) VALUES ('20973937000150', 'Madeireira Thomasi', 'Rua Marechal Deodoro, 3244', '55(42)3522-4048');
INSERT INTO tb_fornecedor (cnpj, nome, endereco, telefone) VALUES ('50538887000144', 'Agroindustrial Sul Pinus', 'Rodovia RST 101, s/n - Km 1.5', '55(51)98080430');
INSERT INTO tb_fornecedor (cnpj, nome, endereco, telefone) VALUES ('72735768000114', 'Formaplan Formas Planejadas', 'Rua André Ampére, 153', '55(11)51053151');
INSERT INTO tb_fornecedor (cnpj, nome, endereco, telefone) VALUES ('16014526000160', 'Piomade Indústria de Madeiras', 'Estrada para Vila Rica, s/n', '55(54)34587066');

INSERT INTO tb_funcionario (cpf, matricula, nome, endereco, telefone, email) VALUES ('53630873081', '10203041', 'Jorge Filho', 'Cruzeiro - Brasilia-DF', '(61)986547231', 'jorge@gmail.com');
INSERT INTO tb_funcionario (cpf, matricula, nome, endereco, telefone, email) VALUES ('23287048082', '10203042', 'Sandro Golveia', 'Vila Buriti Quadra 7 Conjunto A Casa 20, Planaltina - Brasilia-DF', '(61)985203647', 'sandro@gmail.com');
INSERT INTO tb_funcionario (cpf, matricula, nome, endereco, telefone, email) VALUES ('36521776061', '10203043',  'Anelise Borges', 'Quadra 7 Conjunto A Casa 20, Candangolandia - Brasilia-DF', '(61)999831206', 'anelise@gmail.com');

INSERT INTO tb_client (cpf, nome, endereco, telefone, email) VALUES ('53630873081', 'Fernando Pereira', 'Rua Igapó, Recanto Tropical - Cascavel-PR', '(68)38919779', 'fernando@gmail.com');
INSERT INTO tb_client (cpf, nome, endereco, telefone, email) VALUES ('23287048082', 'Janaina da Silva', 'Rua L2, Santa Maria - Aracaju-SE', '(28)32971247', 'janaina@gmail.com');
INSERT INTO tb_client (cpf, nome, endereco, telefone, email) VALUES ('36521776061', 'Orlando Oliveira', 'Rua Peixoto Gomide, Jardim Paulista - São Paulo-SP', '(63)25879129', 'orlando@gmail.com');
INSERT INTO tb_client (cpf, nome, endereco, telefone, email) VALUES ('95602609016', 'Sandra Villa', 'Rua Dez, Residencial Ouroville - Taubaté-SP', '(65)35171236', 'sandra@gmail.com');
INSERT INTO tb_client (cpf, nome, endereco, telefone, email) VALUES ('10880902060', 'Claudia Santos', 'Rua Francisca Elizângela M Filgueira, Alto da Conceição - Mossoró-RN', '(97)21986227', 'claudia@gmail.com');

INSERT INTO tb_product (name, price, date, description) VALUES ('Mesa de Churrasco com dois bancos', 530.0, TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
INSERT INTO tb_product (name, price, date, description) VALUES ('Playground de Madeira', 2390.5, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
INSERT INTO tb_product (name, price, date, description) VALUES ('Banquetas de Madeira', 250.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
INSERT INTO tb_product (name, price, date, description) VALUES ('Livreiro / Prateleira', 750.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
INSERT INTO tb_product (name, price, date, description) VALUES ('Banco com três Assentos', 599.9, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
INSERT INTO tb_product (name, price, date, description) VALUES ('Armário com Adaptação de Vidro', 799.9, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
INSERT INTO tb_product (name, price, date, description) VALUES ('Espreguiçadeira', 449.9, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
INSERT INTO tb_product (name, price, date, description) VALUES ('Sofá 3 lugares de Madeira Maciça', 3752.1, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
INSERT INTO tb_product (name, price, date, description) VALUES ('Mesa de Jantar Madeira Pés Torneados Flora Oregon', 2129.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
INSERT INTO tb_product (name, price, date, description) VALUES ('Poltrona de Madeira Maciça Estofada Sofia', 2222.1, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
INSERT INTO tb_product (name, price, date, description) VALUES ('Poltrona de Madeira Entalhada Luis XV Medalhão', 2413.14, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
INSERT INTO tb_product (name, price, date, description) VALUES ('Cadeira de Mdeira Estofada', 519.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');

INSERT INTO tb_venda(valor_Total, valor_Entrada, qtd_Itens, qts_Vezes, data_Venda, forma_Pagamento, matricula, cpf) VALUES (1019.9, 100.00, 2, 1, '2024-03-11T20:15:00Z', 'Dinheiro', 10203041, '53630873081');
INSERT INTO tb_venda(valor_Total, valor_Entrada, qtd_Itens, qts_Vezes, data_Venda, forma_Pagamento, matricula, cpf) VALUES (8103.2, 0.00, 3, 1, '2024-04-12T14:30:00Z', 'Cartão de Débito', 10203042, '23287048082');
INSERT INTO tb_venda(valor_Total, valor_Entrada, qtd_Itens, qts_Vezes, data_Venda, forma_Pagamento, matricula, cpf) VALUES (449.9, 0.00, 1, 1, '2024-04-08T13:45:00Z', 'Boleto', 10203043, '95602609016');
INSERT INTO tb_venda(valor_Total, valor_Entrada, qtd_Itens, qts_Vezes, data_Venda, forma_Pagamento, matricula, cpf) VALUES (2390.5, 80.00, 1, 1, '2024-04-05T09:15:00Z', 'Pix', 10203041, '10880902060');

INSERT INTO tb_venda_produto (venda_id, product_id) VALUES (1, 4);
INSERT INTO tb_venda_produto (venda_id, product_id) VALUES (1, 5);
INSERT INTO tb_venda_produto (venda_id, product_id) VALUES (2, 8);
INSERT INTO tb_venda_produto (venda_id, product_id) VALUES (2, 9);
INSERT INTO tb_venda_produto (venda_id, product_id) VALUES (2, 10);
INSERT INTO tb_venda_produto (venda_id, product_id) VALUES (3, 7);
INSERT INTO tb_venda_produto (venda_id, product_id) VALUES (4, 2);

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 4);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 4);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 4);
INSERT INTO tb_product_category (product_id, category_id) VALUES (6, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (7, 4);
INSERT INTO tb_product_category (product_id, category_id) VALUES (8, 4);
INSERT INTO tb_product_category (product_id, category_id) VALUES (9, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (10, 4);
INSERT INTO tb_product_category (product_id, category_id) VALUES (11, 4);
INSERT INTO tb_product_category (product_id, category_id) VALUES (12, 4);