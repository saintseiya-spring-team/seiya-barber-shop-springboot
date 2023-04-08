CREATE TABLE barbeiros (
	id bigserial NOT NULL,
	email varchar(255) NULL,
	nome varchar(255) NULL,
	telefone varchar(255) NULL,
	CONSTRAINT barbeiros_pkey PRIMARY KEY (id)
);

CREATE TABLE clientes (
	id bigserial NOT NULL,
	email varchar(255) NULL,
	nome varchar(255) NULL,
	status bool NULL,
	telefone varchar(255) NULL,
	CONSTRAINT clientes_pkey PRIMARY KEY (id)
);

CREATE TABLE servicos (
	id bigserial NOT NULL,
	duracao timestamp(6) NULL,
	servico_tipo varchar(255) NULL,
	preco float8 NULL,
	CONSTRAINT servicos_pkey PRIMARY KEY (id)
);

CREATE TABLE barbeiros_servicos (
    barbeiro_id int8 NOT NULL,
    servico_id int8 NOT NULL,
    CONSTRAINT uk_barbeiros_servicos_unique_servico_id UNIQUE (servico_id),
    CONSTRAINT fk_barbeiros_servicos_barbeiro_id FOREIGN KEY (barbeiro_id) REFERENCES barbeiros(id),
    CONSTRAINT fk_barbeiros_servicos_servico_id FOREIGN KEY (servico_id) REFERENCES servicos(id)
);

CREATE TABLE agendamentos (
    id bigserial NOT NULL,
    dia int4 NULL,
    horario varchar(255) NULL,
    barbeiro_id int8 NULL,
    cliente_id int8 NULL,
    servico_id int8 NULL,
    CONSTRAINT pk_agendamentos PRIMARY KEY (id),
    CONSTRAINT fk_agendamentos_servico_id FOREIGN KEY (servico_id) REFERENCES servicos(id),
    CONSTRAINT fk_agendamentos_barbeiro_id FOREIGN KEY (barbeiro_id) REFERENCES barbeiros(id),
    CONSTRAINT fk_agendamentos_cliente_id FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);
