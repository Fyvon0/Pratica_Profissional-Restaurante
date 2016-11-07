<?php
session_start();
	if (!(isset($_SESSION['logado']))) {
    header ('Location:login.php');
    exit();
    }
    if (!(isset($_SESSION['pedido']))) {
    $_SESSION['total'] = 0;
}
     if (!(isset($_SESSION['total']))) {
    $_SESSION['total'] = 0;  
}

?>
<html>
    <head>
        <title>Haru no Hana - Informações de Pedido</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="cardapio.css">
        <link rel="stylesheet" type="text/css" href="buttons.css">
       <link href="https://fonts.googleapis.com/css?family=Montez|Poiret+One" rel="stylesheet">  
    <link rel="icon" href="logo.ico">
    </head>
        
    <body>
        <?php
        include ('topo.php');
        include 'conexaoRestaurante.php';
        $con = EstabeleceConexao();
        
        if (isset($_POST['x'])){
            $_SESSION['x'] = $_POST['x'];
        }
        else{
            if(!(isset($_SESSION['x'])))
                $_SESSION['x'] = 'Pedidos';
        }
        
        $aba = $_SESSION['x'];
        
        ?>
        
        <!--<img src="topo.png" style="width:98%;">-->
    <form action="pedido.php" method="post" style="position:relative;top:-70px;">
        <input type="submit" name="x" value="Pedidos"> 
        <input type="submit" name="x" value="FecharConta">    
    </form>
    
   
    
    <div id="principal" style="overflow-y:auto;">
    <?php
        if ($aba == 'Pedidos')
        {
        echo "<label style='color: blue'>Usuário:</label> <b>".$_SESSION['user']."</b><br>";
        echo "Mesa:".$_SESSION['mesas'];
       
        echo "<BR>";
        echo "<hr>";
        echo "<b>Pedidos: </b>";
        echo "<BR>";
        echo "<BR>";
        for ($i = 0; $i< count($_SESSION['pedido']); $i++){
            $_SESSION['total'] += $_SESSION['pedido'][$i][4];
                    echo "Prato: <b>". $_SESSION['pedido'][$i][0]."</b>";
                    echo "<br>";
                    echo "Quantidade: <label style='color: blue'>".$_SESSION['pedido'][$i][1]."</label>";
                    echo "<br>";
                    echo "Preço: <label style='color: red'>R$".number_format($_SESSION['pedido'][$i][4],2)."</label>";
                    echo "<br><br>";
                    echo "<hr>";
        }
        echo "<label style='color: red; size: 70px'>Valor Total: R$".number_format($_SESSION['total'],2)."</label>";
        }
        if ($aba=='FecharConta')
        {
            echo "<label style='color: blue'>Usuário:</label> <b>".$_SESSION['user']."</b><Br><br>";
            
            echo "<label>Formas de Pagamento: </label><br><br>";
            echo '<form action="pedido.php" method="post">
                    <input type="radio" name="pag" value="Credito">Crédito
                    <input type="radio" name="pag" value="Debito">Débito<br><br>
                    <input type="submit" name="fechar" value = Fechar>
    </form>';
        }
        if (isset($_POST['pag']) && (isset($_POST['fechar'])))
            {
                
                    $pagamento = $_POST['pag'];
                    echo $pagamento;
            
                    $sql = "Update Mesa set statusMesa = 0 where codMesa=".$_SESSION['mesas']."";
                    $stmt = sqlsrv_query($con,$sql);
            
                    $sql = "Update Mesa set horaFechamento = GETDATE() where codMesa =".$_SESSION['mesas']."";
                    $stmt = sqlsrv_query($con, $sql);  
            
                    $sql = "Update Mesa set formaPagamento ='$pagamento' where codMesa=".$_SESSION['mesas']."";
                    $stmt = sqlsrv_query($con,$sql);
            
                    $sql = "Update Mesa set valorTotal =". number_format($_SESSION['total'],2)."  where codMesa=".$_SESSION['mesas']."'";
                    $stmt = sqlsrv_query($con,$sql);
            
                    session_destroy();
                    header ('Location:login.php');
            }
            
    ?></div>
    </body>
        </html>