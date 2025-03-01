CREATE TABLE anamnese_perguntas_padrao (
    id SERIAL PRIMARY KEY,
    tipo_anamnese VARCHAR(20) NOT NULL CHECK (tipo_anamnese IN ('PADRAO', 'PARQ')),
    pergunta TEXT NOT NULL,
    tipo_resposta VARCHAR(20) NOT NULL CHECK (tipo_resposta IN ('Texto', 'Múltipla Escolha', 'Sim/Não', 'Numérico')),
    opcoes_resposta TEXT NULL
);