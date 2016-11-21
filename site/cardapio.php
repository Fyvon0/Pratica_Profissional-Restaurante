<?php
session_start();

if (!(isset($_SESSION['logado']))) {
    header ('Location:login.php');
    exit();
}
if (!(isset($_SESSION['codCliente'])))
    $_SESSION['codCliente'] = 0;

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
    
    if (isset ($_GET['aba']))
    {
        $_SESSION['aba'] = $_GET['aba'];   
    } else {
        if (!(isset($_SESSION['aba'])))
            $_SESSION['aba'] = 'Entrada';
    }

    $aba = $_SESSION['aba'];
    if (isset($_POST['cancelar']))
             $_SESSION['pedido'] = array();
   
    

        
        
	?>
    <!--<img src="topo.png" style="width:98%;">-->
    <form action="cardapio.php" method="get" style="position:relative;top:-70px;">
        <input type="submit" name="aba" value="Entrada">
        <input type="submit" name="aba" value="Pratos">
        <input type="submit" name="aba" value="Sobremesa">
        <input type="submit" name="aba" value="Bebidas">
    </form>
    
    
    ?>

    <div id="principal" style="overflow-y:auto;">
    <?php
        include 'conexaoRestaurante.php';
        $con = EstabeleceConexao();
             $sql = "SELECT * from Prato where classificacao='$aba'";
             $stmt = sqlsrv_query($con, $sql);
        
         if ($aba == 'Bebidas')
        {
             while ($linha = sqlsrv_fetch_array($stmt)){
             echo "<img src='Imagens/$linha[0].jpg' id='imgBeb'>";
             echo "<div id='v'>";
             echo "<x1>Nome: ", utf8_encode($linha[4]),"</x1><br>";
             echo "<x1>Preço: R$",number_format($linha[5], 2),"</x1>";
             echo "<div id='pedido'>";
              echo "<form action='cardapio.php' method='post'>";
             echo "<br> <label>Quantidade: </label><input id='qtde' type='number' name='qtde' min=0 value=0> <input type='submit' id='adicionar' value='Adicionar'>";
              echo "<input type='hidden' name='adicionar' value =" . $linha['codPrato'] . ">";    
             echo "</form>";
             echo "</div>";
             echo "</div>";
             echo "<hr style='width:97%';>";
                 
             }
        } else {
         while ($linha = sqlsrv_fetch_array($stmt)){
             
             echo "<img src='Imagens/$linha[0].jpg' id='img' >";
             echo "<x>Nome: ", utf8_encode($linha[4]),"</x><br>";
             echo "<x>Ingredientes: ", utf8_encode($linha[1]),"</x><br>";
             echo "<x>Preço: R$",number_format($linha[5], 2),"</x><br>";
             echo "<x>Descrição: ", utf8_encode($linha[2]),"</x><br><br>";
             echo "<div id='pedido'>";
             echo "<form action='cardapio.php' method='post'>";
             echo "<label>Quantidade:</label><input id='qtde' name='qtde' type='number' min=0 value=0> <input type='submit'  id='adicionar' value='Adicionar'>";
             echo "<input type='hidden' name='adicionar' value =" . $linha['codPrato'] . ">";
             echo "</form>";
             echo "</div>";
            echo "<hr style='width:97%';>";
             
             
        }
         }
        $sql10 = "Select codCliente from Cliente where userLogin='".$_SESSION['user']."'";
        $stmt10 = sqlsrv_query($con, $sql10);
         if($linha = sqlsrv_fetch_array($stmt10))
             $_SESSION['codCliente'] = $linha[0];

        
        
        ?>
       
    </div>
     <div id="a" style="overflow-y:auto;">
        <?php 
        if (!(isset($_SESSION['pedido'])))
            $_SESSION['pedido'] = array();
        if ((isset($_POST['adicionar']))&&(isset($_POST['qtde'])))
           if ($_POST['qtde'] != 0) {
                $sql  = "SELECT * from Prato where codPrato='".$_POST['adicionar']."'";
                $stmt = sqlsrv_query($con, $sql);
               
               
               $repetido = false;
               $i = 0;
               for ($i = 0; $i < sizeof($_SESSION['pedido']); $i++)
                   if ($_POST['adicionar'] == $_SESSION['pedido'][$i][2]){
                       $repetido = true;
                       break;
                   }

               if ($repetido) {
                    $_SESSION['pedido'][$i][1] += $_POST['qtde'];
                    $_SESSION['pedido'][$i][4] = $_SESSION['pedido'][$i][3]*$_SESSION['pedido'][$i][1];
               }
               else 
                    if ($linha = sqlsrv_fetch_array($stmt))
                        $_SESSION['pedido'][] = array(utf8_encode($linha[4]),$_POST['qtde'], $_POST['adicionar'],$linha[5],($linha[5]*$_POST['qtde']));
           }


                $soma = 0;
                for ($i = 0; $i< count($_SESSION['pedido']); $i++){
                    $soma += $_SESSION['pedido'][$i][4];
                    echo "Nome: ". $_SESSION['pedido'][$i][0];
                    echo "<br>";
                    echo "Quantidade: ".$_SESSION['pedido'][$i][1];
                    echo "<br>";
                    echo "Preço: R$".number_format($_SESSION['pedido'][$i][4],2);
                    echo "<br><br>";
                  }
                if ($soma != 0) {
                    echo "Total: R$".number_format($soma,2);
                    echo "<form action='pedido.php' method='POST'>";
                    echo "<input type='submit' name='pedido1'><br>";
                    echo "</form>";
                    echo "<form action='cardapio.php' method='POST'>";
                    echo "<input type='submit' name='cancelar' value ='Cancelar'><br>";
                    echo "</form>";
               }
          
        
                
               
            ?>
        
        
        </div>
</body>
</html>