/*== MUDANÇAS ==*/
/*
* Adicionado campo qtdVisitas
* qtdVisitas - indica a quantidade de vezes que determinado cliente já visitou o restaturante.
*			   Útil para determinar a média gasta e a frequência
*/

alter table Cliente add qtdVisitas int

select * from Cliente

-- Como nem todos os clientes tinham qtdVisitas definidas, tem que iniciar o campo para definí-lo não nulo
update Cliente set qtdVisitas = 0

alter table Cliente alter column qtdVisitas int not null