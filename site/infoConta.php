<?php
	session_start();
	if (!(isset($_SESSION['logado']))) {
    header ('Location:login.php');
    exit();
}
?>
<html>
<head>
    <title>Haru no Hana - Conta</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="cardapio.css">
    <link rel="stylesheet" type="text/css" href="buttons.css">
    <link href="https://fonts.googleapis.com/css?family=Montez|Poiret+One" rel="stylesheet">   
    <link rel="icon" href="logo.ico">
    <style type="text/css">
    	#info {
    		height: auto;
    		width: auto;
            border: solid 2px #cc1f00;
            font-size: 20px;
    	}

    	input {
    		border-color: #cc1f00;
            font-size: 20px;
    	}
    </style>
</head>

<body>
	<?php
	include('topo.php');
    
    include 'conexaoRestaurante.php';
    
    $con = estabeleceConexao();
    
    $sql = "SELECT * FROM Cliente where userLogin = '".$_SESSION['user']."'";
    
    $stmt = sqlsrv_query($con, $sql);
    
    if ($linha = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_NUMERIC)) {
        $nome = $linha[3];
        $celular = $linha[7];
    }
	?>

    <center>
	<table id='info'>
		<tr>
			<td>Nome: </td>
			<td><input type="text" value = <?php print "'".$nome."'" ?></td>
		</tr>
        <tr>
            <td>Usuário: </td>
            <td><input type="text" value = <?php print "'".$_SESSION['user']."'" ?></td>
        </tr>
		<tr>
			<td>Senha: </td>
			<td><input type="password" value = <?php print "'".$_SESSION['pword']."'" ?></td>
		</tr>
		<tr>
			<td>Celular: </td>
			<td><input type="text" value = <?php print "'".$celular."'" ?></td>
		</tr>
	</table>
    </center>


</body>
</html>