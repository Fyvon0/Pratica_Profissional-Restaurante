sp_help Promocao

/*== MUDANÇAS ==*/
/*
* Adicionado campo condicao
* condicao - indica a condicao para que o cliente concorrar a promoção
*/

alter table Promocao add condicao varchar(50) not null