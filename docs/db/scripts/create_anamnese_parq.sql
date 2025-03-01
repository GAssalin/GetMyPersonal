CREATE TABLE anamnese_perguntas_parq (
    id SERIAL PRIMARY KEY,
    pergunta TEXT NOT NULL,
    tipo_resposta VARCHAR(20) NOT NULL CHECK (tipo_resposta IN ('Texto', 'Múltipla Escolha', 'Sim/Não', 'Numérico')),
    opcoes_resposta TEXT NULL
);