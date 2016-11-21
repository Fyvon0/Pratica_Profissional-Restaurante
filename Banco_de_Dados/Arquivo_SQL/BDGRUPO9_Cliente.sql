/*== MUDAN�AS ==*/
/*
* Adicionado campo qtdVisitas
* qtdVisitas - indica a quantidade de vezes que determinado cliente j� visitou o restaturante.
*			   �til para determinar a m�dia gasta e a frequ�ncia
*/

alter table Cliente add qtdVisitas int

select * from Cliente

-- Como nem todos os clientes tinham qtdVisitas definidas, tem que iniciar o campo para defin�-lo n�o nulo
update Cliente set qtdVisitas = 0

alter table Cliente alter column qtdVisitas int not null