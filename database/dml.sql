-- Dados de exemplo
INSERT INTO produto (codigo, nome, quantidade, preco_unitario, localizacao, unidade_medida)
VALUES 
('00001', 'Luva', 35, 10.00, 'H57', 'UN');

-- Inserts de usuários
INSERT INTO usuario (username, senha, nome_completo, ativo)
VALUES 
('jose.silva', 'HASH_SENHA_JOSE', 'José da Silva', TRUE),
('maria.souza', 'HASH_SENHA_MARIA', 'Maria de Souza', TRUE),
('ana.lima', 'HASH_SENHA_ANA', 'Ana Lima', TRUE),
('lucas.almeida', 'HASH_SENHA_LUCAS', 'Lucas Almeida', FALSE),  -- Usuário inativo
('carla.mendes', 'HASH_SENHA_CARLA', 'Carla Mendes', TRUE);

-- Substitua 'HASH_SENHA_*' pelos hashes reais gerados pelo BCrypt ou outro algoritmo seguro

-- Inserts de produtos
INSERT INTO produto (codigo, nome, quantidade, preco_unitario, localizacao, unidade_medida)
VALUES 
('00002', 'Capacete de Segurança', 20, 45.00, 'A12', 'UN'),
('00003', 'Óculos de Proteção', 50, 15.50, 'B15', 'UN'),
('00004', 'Protetor Auricular', 75, 5.00, 'B20', 'UN'),
('00005', 'Máscara Respiratória', 30, 20.00, 'C05', 'UN'),
('00006', 'Avental de PVC', 40, 25.00, 'D10', 'UN'),
('00007', 'Bota de Segurança', 25, 60.00, 'D12', 'PAR'),
('00008', 'Cinto de Segurança', 15, 80.00, 'E07', 'UN'),
('00009', 'Luva Térmica', 50, 12.00, 'F03', 'PAR'),
('00010', 'Fita de Demarcação', 100, 8.50, 'G02', 'ROLO');
