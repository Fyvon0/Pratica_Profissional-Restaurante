<?php
function EstabeleceConexao(){
    
    $serverName = 'Regulus';
    $uid        = 'BDGRUPO9';
    $pwd        = 'BDGRUPO9';
    $database   = 'BDGRUPO9';
    
    $dados = array("UID"=>$uid,
                  "PWD"=>$pwd,
                  "Database"=>$database);
    $conexao = sqlsrv_connect($serverName,$dados);
    
     if ($conexao === false){
        die("Falha na conexão com o BD");
    }
    return $conexao;
}
?>