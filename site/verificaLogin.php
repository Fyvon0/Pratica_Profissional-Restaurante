<?php
	session_start();

	$_SESSION['user'] = $_POST['user'];
	$_SESSION['pword'] = $_POST['pword'];

	include 'conexao.php';
	$con = EstabeleceConexao();

	$sql = "SELECT * FROM Cliente WHERE userLogin='".$_SESSION['user']."' and Senha='".$_SESSION['pword']."'";
	$stmt = sqlsrv_query($con,$sql);
	if ($linha = sqlsrv_fetch_array($stmt,SQLSRV_FETCH_NUMERIC)) {
		$_SESSION['logado'] = true;
		header('Location:cardapio.php');
		exit();
	}

	$_SESSION['combinErrado'] = true;
	header('Location:login.php');
?>