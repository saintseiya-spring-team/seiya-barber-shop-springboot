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

CREATE TABLE public.barbeiros_servicos (
	barbeiro_id int8 NOT NULL,
	servico_id int8 NOT NULL,
	CONSTRAINT uk_85b3w1vbiv1samnbv2gtdnquu UNIQUE (servico_id),
	CONSTRAINT uk_l8xqpy6q268lax37x8p6r45d3 UNIQUE (servico_id),
	CONSTRAINT fk25srj17fr3tv4xi8p9yd80gna FOREIGN KEY (barbeiro_id) REFERENCES public.barbeiros(id),
	CONSTRAINT fko0mwwqrnd3u1whsxbl118c6ir FOREIGN KEY (servico_id) REFERENCES public.servicos(id)
);

CREATE TABLE agendamentos (
	id bigserial NOT NULL,
	dia int4 NULL,
	horario varchar(255) NULL,
	barbeiro_id int8 NULL,
	cliente_id int8 NULL,
	servico_id int8 NULL,
	CONSTRAINT agendamentos_pkey PRIMARY KEY (id),
	CONSTRAINT fkhi2c1ld155hsb4ybomwx9ieat FOREIGN KEY (servico_id) REFERENCES servicos(id),
	CONSTRAINT fkmnyoncbc9dic1sb8awa0y64d5 FOREIGN KEY (barbeiro_id) REFERENCES barbeiros(id),
	CONSTRAINT fkmyowslj1th8d9j6j3wlbwrtoe FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);