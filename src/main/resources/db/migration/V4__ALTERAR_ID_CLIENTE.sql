ALTER TABLE agendamentos
    DROP CONSTRAINT fk_agendamentos_cliente_id;

ALTER TABLE clientes RENAME COLUMN id TO cpf;

ALTER TABLE clientes ALTER COLUMN cpf TYPE char(11) USING cpf::char;

ALTER TABLE agendamentos ALTER COLUMN cliente_id TYPE char(11) USING cliente_id::char;

ALTER TABLE agendamentos
	ADD CONSTRAINT fk_agendamentos_cliente_id FOREIGN KEY (cliente_id) REFERENCES clientes(cpf);
