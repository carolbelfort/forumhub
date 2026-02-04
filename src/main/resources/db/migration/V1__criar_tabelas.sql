-- =========================
-- TABELA PERFIL
-- =========================
CREATE TABLE perfil (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);

-- =========================
-- TABELA USUARIO
-- =========================
CREATE TABLE usuario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

-- =========================
-- TABELA USUARIO_PERFIL (N:N)
-- =========================
CREATE TABLE usuario_perfil (
    usuario_id BIGINT NOT NULL,
    perfil_id BIGINT NOT NULL,

    PRIMARY KEY (usuario_id, perfil_id),

    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);

-- =========================
-- TABELA CURSO
-- =========================
CREATE TABLE curso (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    categoria VARCHAR(150) NOT NULL
);

-- =========================
-- TABELA TOPICO
-- =========================
CREATE TABLE topico (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,

    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,

    FOREIGN KEY (autor_id) REFERENCES usuario(id),
    FOREIGN KEY (curso_id) REFERENCES curso(id)
);

-- =========================
-- TABELA RESPOSTA
-- =========================
CREATE TABLE resposta (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    mensagem TEXT NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    solucao BOOLEAN NOT NULL,

    autor_id BIGINT NOT NULL,
    topico_id BIGINT NOT NULL,

    FOREIGN KEY (autor_id) REFERENCES usuario(id),
    FOREIGN KEY (topico_id) REFERENCES topico(id)
);
