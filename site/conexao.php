<?php
function EstabeleceConexao() {
	$serverName = 'regulus';
	$uid = 'BDGRUPO9';
	$pwd = 'BDGRUPO9';
	$database = 'BDGRUPO9';

	//criar array para conexao
	$dados = array("UID"=>$uid,
				   "PWD"=>$pwd,
				   "Database"=>$database);

	//estabelecer conexao
	$conexao = sqlsrv_connect($serverName,$dados);

	if ($conexao === false) {
		die ("Falha na conexão com o BD");
	}

	return $conexao;
}
?>