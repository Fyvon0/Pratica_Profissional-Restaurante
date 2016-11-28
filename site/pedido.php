<?php
 include 'conexaoRestaurante.php';
        $con = EstabeleceConexao();
session_start();
	if (!(isset($_SESSION['logado']))) {
    header ('Location:login.php');
    exit();
    }
    if (!(isset($_SESSION['pedidoFinal'])))
        $_SESSION['pedidoFinal'] = array();
    if (isset($_SESSION['pedido'])){
        for ($i = 0; $i< count($_SESSION['pedido']); $i++) {
            $sql1 = "Insert into Pedido values (".$_SESSION['pedido'][$i][1].",GETDATE(),".$_SESSION['codCliente'].",".$_SESSION['pedido'][$i][2].")";              
            $stmt1 = sqlsrv_query($con, $sql1);
            $_SESSION['pedidoFinal'][]= array($_SESSION['pedido'][$i][0],$_SESSION['pedido'][$i][1],$_SESSION['pedido'][$i][2],
                                              $_SESSION['pedido'][$i][3],$_SESSION['pedido'][$i][4]);
        }
        unset ($_SESSION['pedido']);
    }
if (!(isset($_SESSION['totalPromo'])))
    $_SESSION['totalPromo'] = 0;
 

if (isset($_POST['promocoes']))
{
    $_SESSION['porcentagem'] = (100 - $_POST['promocoes'])/100;
    $_SESSION['codCliPromo'] = $_POST['codCliPromo'];
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
    <script>
        function insivel()
        {
            document.getElementById("PromocoesDiv").style.visibility = "hidden";
        }
        </script>
    </head>
        
    <body>
        <?php
        include ('topo.php');

       
        
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
        $_SESSION['total'] = 0;
        for ($i = 0; $i< count($_SESSION['pedidoFinal']); $i++){
            $_SESSION['total'] += $_SESSION['pedidoFinal'][$i][4];
                    echo "Prato: <b>". $_SESSION['pedidoFinal'][$i][0]."</b>";
                    echo "<br>";
                    echo "Quantidade: <label style='color: blue'>".$_SESSION['pedidoFinal'][$i][1]."</label>";
                    echo "<br>";
                    echo "Preço: <label style='color: red'>R$".number_format($_SESSION['pedidoFinal'][$i][4],2)."</label>";
                    echo "<br><br>";
                    echo "<hr>";
        }
            if (isset($_SESSION['porcentagem']))
        echo "<label style='color: red; size: 70px'>Valor Total: R$".number_format($_SESSION['total'],2)*$_SESSION['porcentagem']."</label>";
        else
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
            
                    $sql = "Update Mesa set valorTotal = ".number_format($_SESSION['total'],2)." where codMesa= ".$_SESSION['mesas']."";
                    $stmt = sqlsrv_query($con,$sql);
            
                    $sql = "SELECT mediaGasta FROM Cliente WHERE userLogin='".$_SESSION['user']."'";
                    $stmt = sqlsrv_query($con,$sql);
                    if($linha = sqlsrv_fetch_array($stmt,SQLSRV_FETCH_NUMERIC))
                    $mediaGasta = $linha[0];
                    
                    $sql = "SELECT valorTotal FROM Mesa WHERE codMesa=".$_SESSION['mesas']."";
                    $stmt = sqlsrv_query($con,$sql);
                    if($linha = sqlsrv_fetch_array($stmt,SQLSRV_FETCH_NUMERIC))
                    $valorTotal = $linha[0];
                    $total = (($_SESSION['qtdVisitas'] - 1) * $mediaGasta) + $valorTotal;
                    $mediaGasta = $total / $_SESSION['qtdVisitas'];
                    
                    $sql = "Update Cliente set mediaGasta = $mediaGasta where userLogin='".$_SESSION['user']."'";
                    $stmt = sqlsrv_query($con,$sql);
            
                    header ('Location:questionario.php');
            }
            
    ?>
        
         
        </div>
        <?php
        echo '<form action="pedido.php" method="post">';
        echo "<div id='PromocoesDiv' style='position:absolute;top:200px;right:120px;'>";
        echo "<label>Suas promoções</label><Br>";
        echo"<label>Descontos</label><br>";
        $sql = "Select * from ClientePromocao where codCliente in(select codCliente from Cliente where userLogin='".$_SESSION['user']."')";
                    $stm = sqlsrv_query($con,$sql);
                    if($linha = sqlsrv_fetch_array($stm))
                    {
                    $sql = "select * from Promocao where codPromocao =".$linha[2]."";
                    $stm = sqlsrv_query($con,$sql);
                    echo "<input type='hidden' name='codCliPromo' value =$linha[0]>"; 
                    echo "<select name='promocoes'>";
                    while ($linha = sqlsrv_fetch_array($stm))
                    echo "<option>$linha[3]</option>";
                    echo "</select><br>";
                    echo"<input type='submit' name='promo' value='Confirmar'>" ;
        echo"</div>";
                    }
                if (isset($_SESSION['porcentagem']))
{
                    echo $_SESSION['porcentagem'];
    echo "<script>document.getElementById('PromocoesDiv').style.visibility = 'hidden'</script>";
    $sql = "delete from ClientePromocao where codClientePromocao =".$_SESSION['codCliPromo'];
    $stmt = sqlsrv_query($con,$sql);
    if (!$stmt) {echo "deu ruim ";}
}
        
        ?>
    </body>
        </html>