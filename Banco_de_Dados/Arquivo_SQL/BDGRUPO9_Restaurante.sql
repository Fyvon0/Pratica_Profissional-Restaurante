create table Cliente(
	codCliente int identity primary key,
	userLogin varchar(25) not null,
	Frequencia float not null,
	Senha varchar(30) not null,
	Nome varchar(50) not null,
	ultimaVisita datetime not null,
	dataCadastro datetime not null,
	mediaGasta float not null,
	Celular varchar(15) not null
)
create table Mesa(
	codMesa int primary key,
	reserva int not null,
	horario datetime not null,
	horaPrevista datetime  null,
	formaPagamento varchar(17) null,
	valorTotal money not null,
	horaFechamento datetime,
	statusMesa int not null,
	codCliente int not null,
	constraint fkCodCliente foreign key (codCliente) references Cliente(codCliente)
)
create table Prato(
	codPrato int primary key,
	ingredientes ntext not null,
	preco money not null,
	classificacao int not null,
	descricao ntext not null
)
create table Pedido(
	codPedido int identity primary key,
	quantidade int not null,
	horario datetime not null,
	codCliente int not null,
	codPrato int not null,
	constraint fkCodCliente1 foreign key (codCliente) references Cliente(codCliente),
	constraint fkCodPrato foreign key (codPrato) references Prato(codPrato)
)
create table PratoCliente(
	codPratoCliente int identity primary key,
	codCliente int not null,
	codPrato int not null,
	constraint fkCodCliente2 foreign key (codCliente) references Cliente(codCliente),
	constraint fkCodPrato1 foreign key (codPrato) references Prato(codPrato)
)
create table Questionario(
	codQuest int identity primary key,
	qualidadeComida float not null,
	atendimento float not null,
	observacoes ntext,
	tempoEspera float not null,
	codCliente int not null,
	constraint fkCodCliente3 foreign key (codCliente) references Cliente(codCliente)
)
create table PratoQuestionario(
	codPratoQuestionario int identity primary key,
	nota float not null,
	observacoes ntext,
	codQuest int not null,
	codPrato int not null,
	constraint fkCodQuest foreign key (codQuest) references Questionario(codQuest),
	constraint fkCodPrato2 foreign key (codPrato) references Prato(codPrato)
)

create table Promocao(
	codPromocao int identity primary key,
	descricao varchar(200) not null
)
create table ClientePromocao(
	codClientePromocao int identity primary key,
	vencimento datetime not null,
	codCliente int not null,
	codPromocao int not null,
	constraint fkCodCliente4 foreign key (codCliente) references Cliente(codCliente),
	constraint fkCodPromocao foreign key (codPromocao) references Promocao(codPromocao)
)
