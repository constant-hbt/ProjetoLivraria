CREATE TABLE pessoa(
	pes_idPessoa SERIAL NOT NULL,
	pes_obs VARCHAR(200), 
	pes_cidade VARCHAR(20) NOT NULL,
	pes_cep VARCHAR (11) NOT NULL,
	pes_bairro VARCHAR(20) NOT NULL,
	pes_rua VARCHAR (30) NOT NULL,
	pes_nro VARCHAR(5) NOT NULL,
	pes_complemento VARCHAR (20),
	pes_estado VARCHAR(2) NOT NULL,
        pes_email VARCHAR (30), 
	CONSTRAINT pk_pessoa PRIMARY KEY (pes_idPessoa));

CREATE TABLE pessoa_telefone(
        ptel_id SERIAL NOT NULL,
	ptel_idPessoa INTEGER NOT NULL,
	ptel_numtel  INTEGER NOT NULL,
	ptel_dddtel INTEGER NOT NULL,
	ptel_tipotel VARCHAR(20),
	CONSTRAINT fk_ptel_pes FOREIGN KEY (ptel_idPessoa) REFERENCES pessoa,
        CONSTRAINT pk_pes_tel PRIMARY KEY (ptel_id)
);

CREATE TABLE funcionario(
	func_idPessoa INTEGER NOT NULL,
	func_login VARCHAR (20) NOT NULL,
	func_senha VARCHAR (15) NOT NULL,
	func_nome VARCHAR (30) NOT NULL,
	func_cargo VARCHAR (20) NOT NULL,
	func_sexo VARCHAR(9) NOT NULL,
	func_cpf VARCHAR(14) NOT NULL,
	func_rg VARCHAR (12) NOT NULL,
	func_datanasc DATE NOT NULL,
	CONSTRAINT pk_funcionario PRIMARY KEY (func_idPessoa),
	CONSTRAINT fk_func_pes FOREIGN KEY (func_idPessoa) REFERENCES pessoa
);

CREATE TABLE cliente(
        cli_id INTEGER NOT NULL,
        CONSTRAINT fk_cli_pes FOREIGN KEY (cli_id) REFERENCES pessoa,
        CONSTRAINT pk_cliente PRIMARY KEY (cli_id)
);

CREATE TABLE cli_fisico(
	clif_idPessoa INTEGER NOT NULL,
	clif_nome VARCHAR(30) NOT NULL,
	clif_cpf VARCHAR (14) NOT NULL,
	clif_rg VARCHAR (12),
	clif_datanasc DATE,
	clif_sexo VARCHAR (9),
	CONSTRAINT pk_clifisico PRIMARY KEY (clif_idPessoa),
	CONSTRAINT fk_clifisico_cli FOREIGN KEY (clif_idPessoa) REFERENCES cliente
);

CREATE TABLE cli_juridico(
	clij_idPessoa INTEGER NOT NULL,
	clij_cnpj VARCHAR(18) NOT NULL,
	clij_nomefantasia VARCHAR (30) NOT NULL,
	clij_razaosocial VARCHAR (30) NOT NULL,
	CONSTRAINT pk_clijuridico PRIMARY KEY (clij_idPessoa),
	CONSTRAINT fk_clijuri_cli FOREIGN KEY (clij_idPessoa) REFERENCES cliente
);

CREATE TABLE situacao(
        sit_id SERIAL NOT NULL,
        sit_desc VARCHAR (50) NOT NULL,
        CONSTRAINT pk_situacao PRIMARY KEY (sit_id)
);

CREATE TABLE midia(
	mid_idMidia SERIAL NOT NULL,
        mid_idSituacao INTEGER NOT NULL,
	mid_ano INTEGER,
	mid_titulo VARCHAR (30) NOT NULL,
	mid_descricao VARCHAR (200),
	mid_quant INTEGER NOT NULL,
        mid_custo NUMERIC (7,2) NOT NULL, 
	mid_precounit NUMERIC (7,2) NOT NULL,
	CONSTRAINT pk_midia PRIMARY KEY (mid_idMidia),
        CONSTRAINT fk_mid_sit FOREIGN KEY (mid_idSituacao) REFERENCES situacao
);

CREATE TABLE livro(
	li_idMidia SERIAL NOT NULL,
	li_quantpag INTEGER NOT NULL,
	li_isbn INTEGER,
	li_larg NUMERIC (5,2),
	li_alt NUMERIC (5,2),
	li_prof NUMERIC (5,2),
	li_idioma VARCHAR (20),
	CONSTRAINT pk_livro PRIMARY KEY (li_idMidia),
	CONSTRAINT fk_livro_mid FOREIGN KEY (li_idMidia) REFERENCES midia
);

CREATE TABLE dvd (
	dvd_idMidia INTEGER NOT NULL,
	dvd_duracao TIME,
	CONSTRAINT pk_dvd PRIMARY KEY (dvd_idMidia),
	CONSTRAINT fk_dvd_mid FOREIGN KEY (dvd_idMidia) REFERENCES midia
);

CREATE TABLE cd(
	cd_idMidia INTEGER NOT NULL,
	cd_quantmusicas INTEGER,
	cd_duracao TIME,
	CONSTRAINT pk_cd PRIMARY KEY (cd_idMidia),
	CONSTRAINT fk_cd_mid FOREIGN KEY (cd_idMidia) REFERENCES midia
);

CREATE TABLE revista(
	rev_idMidia INTEGER NOT NULL,
	rev_quantpag INTEGER,
	CONSTRAINT pk_revista PRIMARY KEY (rev_idMidia),
	CONSTRAINT fk_rev_mid FOREIGN KEY (rev_idMidia) REFERENCES midia
);

CREATE TABLE compra(
	c_idCompra SERIAL NOT NULL,
	c_idCli INTEGER NOT NULL,
	c_idFuncionario INTEGER NOT NULL,
	c_data DATE NOT NULL,
	c_hora TIME NOT NULL,
        c_desconto NUMERIC (8,2),
	c_valortotal NUMERIC (8,2) NOT NULL,
	c_formapag VARCHAR(20) NOT NULL,
	CONSTRAINT pk_compra PRIMARY KEY (c_idCompra),
	CONSTRAINT fk_compraf_cli FOREIGN KEY (c_idCli) REFERENCES cliente,
	CONSTRAINT fk_compra_fun FOREIGN KEY (c_idFuncionario) REFERENCES funcionario
);

CREATE TABLE itens_compra(
        ic_idItem SERIAL NOT NULL,
	ic_idCompra INTEGER NOT NULL,
	ic_idMidia INTEGER NOT NULL,
	ic_quant INTEGER NOT NULL,
        ic_preco NUMERIC (7,2) NOT NULL, 
	ic_valorparcial NUMERIC (8,2),
	CONSTRAINT pk_itensc PRIMARY KEY (ic_idItem),
	CONSTRAINT fk_itensc_cli FOREIGN KEY (ic_idcompra) REFERENCES compra,
	CONSTRAINT fk_itensc_mid FOREIGN KEY (ic_idMidia) REFERENCES midia
);


    




