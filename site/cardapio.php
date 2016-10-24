<?php
session_start();

if (!(isset($_SESSION['logado']))) {
    header ('Location:login.php');
    exit();
}

?>
<html>
<head>
    <title>Haru no Hana - Cardápio</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="cardapio.css">
    <link rel="stylesheet" type="text/css" href="buttons.css">
    <link href="https://fonts.googleapis.com/css?family=Montez|Poiret+One" rel="stylesheet">   
    <link rel="icon" href="logo.ico">
</head>

<body>
    <?php
	include('topo.php');
    
    if (isset ($_GET['pra']))
    {
        $aba = 'Pratos';
    } else
        if (isset ($_GET['sob']))
            {
                $aba = 'Sobremesa';
            } else
                if (isset ($_GET['beb']))
                    {
                        $aba = 'Bebidas';
                    } else
                        $aba = 'Entrada';
        
        
	?>
    <!--<img src="topo.png" style="width:98%;">-->
    <form action="cardapio.php" method="get" style="position:relative;top:-70px;">
        <input type="submit" name="ent" value="Entrada">
        <input type="submit" name="pra" value="Pratos">
        <input type="submit" name="sob" value="Sobremesa">
        <input type="submit" name="beb" value="Bebidas">
    </form>
    
    
    ?>

    <div id="principal" style="overflow-y:auto;">
    <?php
        include 'conexaoRestaurante.php';
        $con = EstabeleConexao();
             $sql = "SELECT * from Prato where classificacao='$aba'";
             $stmt = sqlsrv_query($con, $sql);
        
         if ($aba == 'Bebidas')
        {
             while ($linha = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_NUMERIC)){
             echo "<img src='Imagens/$linha[0].jpg' id='imgBeb'>";
             echo "<div id='v'>";
             echo "<x1>Nome: ", utf8_encode($linha[4]),"</x1><br>";
             echo "<x1>Preço: R$",number_format($linha[5], 2),"</x1>";
             echo "<div id='pedido'>";
              echo "<form action='' method='get'>";
             echo "<br> <label>Quantidade:</label><input id='qtde' type='number' min=0 value=0> <input type='submit' id='adicionar' value='Adicionar'>";
             echo "</form>";
             echo "</div>";
             echo "</div>";
             echo "<hr style='width:97%';>";
                 
             }
        } else {
         while ($linha = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_NUMERIC)){
             
             echo "<img src='Imagens/$linha[0].jpg' id='img' >";
             echo "<x>Nome: ", utf8_encode($linha[4]),"</x><br>";
             echo "<x>Ingredientes: ", utf8_encode($linha[1]),"</x><br>";
             echo "<x>Preço: R$",number_format($linha[5], 2),"</x><br>";
             echo "<x>Descrição: ", utf8_encode($linha[2]),"</x><br><br>";
             echo "<div id='pedido'>";
             echo "<form action='' method='get'>";
             echo "<label>Quantidade:</label><input id='qtde' type='number' min=0 value=0> <input type='submit' id='adicionar' value='Adicionar'>";
             echo "</form>";
             echo "</div>";
            echo "<hr style='width:97%';>";
             
             
        }
         }
  

        
        
        ?>
       
    </div>
     <div id="a">
        <?php 
           echo "Aqui vemo os pratos pedidos";
            
            ?>
            
        
        
        </div>
</body>
</html>