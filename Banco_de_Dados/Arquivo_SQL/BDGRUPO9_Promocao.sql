sp_help Promocao

/*== MUDAN�AS ==*/
/*
* Adicionados campos nome e desconto
* nome		- indica o nome da promo��o para que o cliente a identifique
* desconto	- int que indica a porcentagem que deve ser retirada do total
*/

alter table Promocao add nome varchar(30) not null
alter table Promocao add desconto int not null