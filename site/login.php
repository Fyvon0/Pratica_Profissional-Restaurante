<?php
    session_start();

    if (!(isset($_SESSION['user'])))
        $_SESSION['user'] = '';

    if (!(isset($_SESSION['combinErrado'])))
        $_SESSION['combinErrado'] = '';

    if ($_GET['limpar']='ok')
    {
        session_destroy();
    }
?>
<html>
<head>
    <title>Haru no Hana - Login</title>
    <link rel="stylesheet" type="text/css" href="buttons.css">
    <link href="https://fonts.googleapis.com/css?family=Montez|Poiret+One" rel="stylesheet">
    <meta charset="utf-8">
    <script type="text/javascript">
    function submitForm(action)
    {
        document.getElementById('form1').action = action;
        document.getElementById('form1').submit();
    }
    </script>
    <style>
        body{
            font-family: 'Montez', cursive;
        }
        
        .login_bg{
            position: absolute;
            top: 25%;
            left: 33%;
        }
        
        #login{
            font-family: 'Poiret One', cursive;
            font-size: 20px;
            position: absolute;
            top: 34%;
            left: 41%;
            text-align: center;
        }
        
        .bt_login{
            font-family: 'Poiret One', cursive;
            background: #fff;
            border: 3px solid #cc1f00;
            display: inline-block;
            padding: 5px 15px;
            text-align: center;
            text-shadow: none;
            font-size: 17px;
        }

        .aviso {
            position: absolute;
            font-family: 'Poiret One', cursive;
            font-size: 20px;
            height: auto + 10;
            width: auto + 10;
            border: solid 3px #cc1f00;
            left: 37.1%;
            top: 23%;
        }
    </style>    
</head>
<body>
    <img src='topo.png'>

    <img src='login_bg.png' class="login_bg">
    
    <?php 
        if ($_SESSION['combinErrado'])
            echo "<div class='aviso'>Combinação de Usuário e Senha incorretos</div>";
    ?>
    
    <div id='login'>
        <form action="redirecionaAcesso.php" method="POST" id="form1">
            <label for="user">Usuário:</label>
            <input type="text" maxlength="25" value=<?php echo "'".$_SESSION['user']."'" ?> name="user">
            <br>
            <label for="pword">Senha: </label>
            <input type="password" minlength="7" maxlength="30" name="pword">
            <br>
            <input type="button" value="Login" class="bt_login" onclick="submitForm('verificaLogin.php');" style='margin:7px;'>
            <input type="button" value="Não Tenho Conta" onclick="submitForm('cadastro.php');" class="bt_login">
            <br>
            <input type="button" value="Limpar" onclick="submitForm('login.php?limpar=ok');" class="bt_login">
        </form>
    </div>
    
</body>
</html>