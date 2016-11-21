<?php
	session_start();
    $_SESSION['user']=$_POST['user'];
    $_SESSION['pword']=$_POST['pword'];
    $_SESSION['nome']=$_POST['nome'];
    $_SESSION['celular']=$_POST['celular'];
    

	include 'conexaoRestaurante.php';
	$con = EstabeleceConexao();

	if (!(isset($_POST['nome']) && isset($_POST['user']) && isset($_POST['pword']) &&
		isset($_POST['confPword']) && isset($_POST['celular']))) 
	{
		$_SESSION['incompleto'] = true;
		header('Location:cadastro.php');
		exit();
	} else {
		$_SESSION['incompleto'] = false;
		$_SESSION['userExiste'] = false;
		$_SESSION['celExiste'] = false;

		if (empty($_POST['nome']) || empty($_POST['user']) || empty($_POST['pword']) ||
		empty($_POST['confPword']) || empty($_POST['celular']))
		{
			$_SESSION['incompleto'] = true;
			header('Location:cadastro.php');
			exit();
		}

		$sql = "SELECT * FROM Cliente WHERE userLogin='".$_SESSION['user']."'";
		$stmt=sqlsrv_query($con,$sql);
		if ($linha = sqlsrv_fetch_array($stmt,SQLSRV_FETCH_NUMERIC)){
			$_SESSION['userExiste']=true;
		}
		$sql = "SELECT * FROM Cliente WHERE Celular = '".$_SESSION['celular']."'";
		if ($linha = sqlsrv_fetch_array($stmt,SQLSRV_FETCH_NUMERIC)){
			$_SESSION['celExiste']=true;
		}

		if ($_SESSION['userExiste'] || $_SESSION['celExiste'])
        {
			header('Location:cadastro.php');
           
        }
        
		$sql = "INSERT INTO Cliente VALUES ('".$_SESSION['user']."',0,'".$_SESSION['pword']."','".$_POST['nome']."',GETDATE(),GETDATE(),0,'".$_SESSION['celular']."',0)";

		$stmt = sqlsrv_query($con,$sql);
        
        

		if ($stmt) {
			$_SESSION['logado']  = true;
			$_SESSION['incompleto'] = false;
	        $_SESSION['celExiste'] = false;
	        $_SESSION['userExiste'] = false;
			header('Location:cardapio.php');
			exit();
		}
	}
 
 
 
?>	