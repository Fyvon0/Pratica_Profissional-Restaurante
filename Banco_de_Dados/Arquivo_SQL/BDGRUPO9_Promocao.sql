sp_help Promocao

/*== MUDANÇAS ==*/
/*
* Adicionados campos nome e desconto
* nome		- indica o nome da promoção para que o cliente a identifique
* desconto	- int que indica a porcentagem que deve ser retirada do total
*/

alter table Promocao add nome varchar(30) not null
alter table Promocao add desconto int not null