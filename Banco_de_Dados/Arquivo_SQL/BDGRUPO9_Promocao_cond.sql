sp_help Promocao

/*== MUDAN�AS ==*/
/*
* Adicionado campo condicao
* condicao - indica a condicao para que o cliente concorrar a promo��o
*/

alter table Promocao add condicao varchar(50) not null