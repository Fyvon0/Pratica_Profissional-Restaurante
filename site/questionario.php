<?php 
session_start();



?>
<html>
    <head> 
        <title>Haru no Hana - Questionário</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="buttons.css">
        <link href="https://fonts.googleapis.com/css?family=Montez|Poiret+One" rel="stylesheet">  
        <link rel="icon" href="logo.ico">
        <style>
        input[type="submit"] {
        background-color: #CE3323; 
        width:150px;
        height: 30px;
        border: 1px solid white;
        font-family: 'Poiret One', 'cursive';
        color: white;
        font-size: 20px;
    }

input[type="submit"]:hover {
    background-color: #e7393c; 
    width:150px;
    height: 30px;
    border: 1px solid white;
    font-family: 'Poiret One', 'cursive';
    color: white;
    font-size: 20px;
}
        </style>
    </head>
<body>
    
    <form action="questionario.php" method="post">
    <fieldset>
        <legend><h1>Questionário</h1></legend>
    <label>Como estava a comida?</label><br>   
        <input type="number" min="0" max="10" name="comida" placeholder="Coloque sua nota"><br>
        <br>
    <hr>
        <br>
    <label>Como foi o atendimento?</label><br>
        <input type="number" min="0" max="10" name="atendimento" placeholder="Coloque sua nota"><br>
        <br>
    <hr>
    <label>Foi demorado o preparo da comida?</label><br>
        <input type="number" min="0" max="10" name="demora" placeholder="Coloque sua nota"><br>
        <br>
    <hr>
    <label>Sugestões</label><br>
        <textarea cols="100" rows="15" name="sugestao"> 
        </textarea>
    <input type="submit" value="Finalizar" name="finalizar">
    </fieldset>
    </form>
    </body>
    <?php 
    
    include 'conexaoRestaurante.php';
    $conexao = EstabeleceConexao();
     $sql10 = "Select codCliente from Cliente where nome='".$_SESSION['user']."'";
        $stmt10 = sqlsrv_query($conexao, $sql10);
         if($linha = sqlsrv_fetch_array($stmt10))
             $_SESSION['codCliente'] = $linha[0];
    if (isset($_POST['finalizar']) && isset($_POST['comida']) && isset($_POST['atendimento']) && isset($_POST['demora']) && isset($_POST['sugestao']))
    {
        $comida = $_POST['comida'];
        $atendimento =  $_POST['atendimento'];
        $demora = $_POST['demora'];
        $sugestao = $_POST['sugestao'];
        $sql = "Insert into Questionario values ($comida,$atendimento,'$sugestao',$demora,".$_SESSION['codCliente'].")";
        $stmt = sqlsrv_query($conexao,$sql);
        session_destroy();
        header ('Location:login.php');
    }
        
    
    ?>
</html>