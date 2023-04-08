 alter table agendamentos add column barbeiro_id char(11) not null;
 alter table servicos add column barbeiro_cpf char(11);

 alter table servicos add constraint fk_servicos_barbeiros foreign key (barbeiro_cpf) references barbeiros;
 
 drop table barbeiros_servicos;