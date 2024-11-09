-- Criação do banco de dados
CREATE DATABASE estoque;

-- Conectar ao banco de dados 'estoque' (no pgAdmin, selecione o banco de dados após criá-lo)

-- Criação da tabela 'produto'
CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    codigo VARCHAR(10) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario NUMERIC(10, 2) NOT NULL,
    localizacao VARCHAR(50),
    unidade_medida VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Trigger e função para atualização automática do campo 'updated_at'
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_updated_at
BEFORE UPDATE ON produto
FOR EACH ROW
EXECUTE FUNCTION update_updated_at_column();


-- Criação da tabela 'usuario'
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL, -- Armazenar a senha de forma hash
    nome_completo VARCHAR(100),
    ativo BOOLEAN DEFAULT TRUE,   -- Indica se o usuário está ativo
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Trigger e função para atualização automática do campo 'updated_at'
CREATE OR REPLACE FUNCTION update_usuario_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_usuario_updated_at
BEFORE UPDATE ON usuario
FOR EACH ROW
EXECUTE FUNCTION update_usuario_updated_at_column();

