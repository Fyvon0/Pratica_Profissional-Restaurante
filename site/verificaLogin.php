<?php
	session_start();
    if (!(isset($_SESSION['codCliente'])))
    $_SESSION['qtdVisitas'] = 0;


	$_SESSION['user'] = $_POST['user'];
	$_SESSION['pword'] = $_POST['pword'];
    $_SESSION['mesas'] = $_POST['mesas'];

	include 'conexaoRestaurante.php';
	$con = EstabeleceConexao();
    

	$sql = "SELECT * FROM Cliente WHERE userLogin='".$_SESSION['user']."' and Senha='".$_SESSION['pword']."'";
	$stmt = sqlsrv_query($con,$sql);
	if ($linha = sqlsrv_fetch_array($stmt,SQLSRV_FETCH_NUMERIC)) {
		$_SESSION['logado'] = true;
        $sql = "Update Mesa set statusMesa = 1 where codMesa='".$_SESSION['mesas']."'";
        $stmt = sqlsrv_query($con,$sql);
        $sql = "Update Mesa set horario = GETDATE() where codMesa ='".$_SESSION['mesas']."'";
        $stmt = sqlsrv_query($con, $sql);
        $sql = "Update Cliente set ultimaVisita = GETDATE() where userLogin ='".$_SESSION['user']."'";
        $stmt = sqlsrv_query($con, $sql); 
        $sql = "SELECT qtdVisitas FROM Cliente WHERE userLogin='".$_SESSION['user']."'";
        $stmt = sqlsrv_query($con,$sql);
        if($linha = sqlsrv_fetch_array($stmt,SQLSRV_FETCH_NUMERIC))
        $_SESSION['qtdVisitas'] = $linha[0] + 1;
        $sql = "UPDATE Cliente set qtdVisitas=".$_SESSION['qtdVisitas']." where userLogin='".$_SESSION['user']."'";
        $stmt = sqlsrv_query($con,$sql);
		header('Location:cardapio.php');
		exit();
	}

	$_SESSION['combinErrado'] = true;
	header('Location:login.php');
?>