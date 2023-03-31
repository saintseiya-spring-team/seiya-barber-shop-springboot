ALTER TABLE agendamentos
    DROP CONSTRAINT fkmnyoncbc9dic1sb8awa0y64d5;
    
ALTER TABLE barbeiros_servicos
    DROP CONSTRAINT fk25srj17fr3tv4xi8p9yd80gna;

ALTER TABLE barbeiros
    ALTER COLUMN id TYPE CHAR(11);
    
ALTER TABLE barbeiros
    RENAME COLUMN id TO cpf;
    
    
ALTER TABLE agendamentos
    ALTER COLUMN barbeiro_id TYPE CHAR(11);
    
ALTER TABLE agendamentos 
	RENAME COLUMN barbeiro_id TO barbeiro_cpf;

ALTER TABLE agendamentos
    ADD CONSTRAINT fk_agendamentos_barbeiros
    FOREIGN KEY (barbeiro_cpf) REFERENCES barbeiros (cpf);



ALTER TABLE barbeiros_servicos
    ALTER COLUMN barbeiro_id TYPE CHAR(11);
    
ALTER TABLE barbeiros_servicos
    RENAME COLUMN barbeiro_id TO barbeiro_cpf;

ALTER TABLE barbeiros_servicos
    ADD CONSTRAINT fk_barbeiros_servicos_barbeiros
    FOREIGN KEY (barbeiro_cpf) REFERENCES barbeiros (cpf);


