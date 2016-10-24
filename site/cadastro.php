<?php
    session_start();
    if (strpos($_SERVER['HTTP_REFERER'], 'login.php') !== FALSE)
    {
        $_SESSION['user']=$_POST['user'];
        $_SESSION['pword']=$_POST['pword'];
        $_SESSION['incompleto'] = false;
        $_SESSION['nome']='';
        $_SESSION['celular']='';
        $_SESSION['celExiste']=false;
        $_SESSION['userExiste']=false;
    }
?>
<html>                                                           
<head>
	<title>Haru no Hana - Cadastro</title>
    <link rel="stylesheet" type="text/css" href="buttons.css">
    <link href="https://fonts.googleapis.com/css?family=Montez|Poiret+One" rel="stylesheet">   
    <meta charset="utf-8">
    <script type="text/javascript">
        document.getElementById('submit').disabled = true;

    	function validaSenha (input){ 
		    if (input.value != document.getElementById('pword').value) {
    		    document.getElementById('confirmaSenha').innerHTML = 'As senhas inseridas diferem';
                document.getElementById('submit').disabled=true;
		  } else {
    		    document.getElementById('confirmaSenha').innerHTML = '';
                document.getElementById('submit').disabled=false;
		  }
		}

        function verificaForm (input) {
            if (input.value = '')
                document.getElementById('submit').disabled = true;
            else
                document.getElementById('submit').disabled = false;
        }

	    //function verificaForm()
	    //{

	    //}} 

    </script>

    <style type="text/css">
        #confirmaSenha {
            position: absolute;
            font-family: 'Poiret One', cursive;
            font-size: 20px;
            border: 2px solid #cc1f00;
            height:auto;
            width:auto;
            left:60%;
            top:30%;
        }

        .form {
            position:absolute;
            text-align:center;
            border: solid 2px #cc1f00;
            width:300px;
            height:auto;
            left:40%;
        }

        h2 {
            text-align: center;
            color: #cc1f00;
            font-family: 'Poiret One', cursive;
        }
    </style>
</head>

<body>
    <img src='topo.png'>

    <?php
        if ($_SESSION['incompleto'])
            echo '<h2>Preencha todos os campos</h2>';
    ?>

    <div id='confirmaSenha'></div>

    <form action='redirecionaAcesso.php' method='POST' class='form'>
    	<table>
            <tr>
                <td><label for='nome'>Nome: </label></td>
            	<td><input type='text' name='nome' value=<?php echo $_SESSION['nome'] ?>></td>
            </tr>
            <tr>
            	<td><label for='user'>Usuário: </label></td>
            	<td><input type='text' name='user' value= <?php echo $_SESSION['user'] ?>></td>
            </tr>
            <?php
                if ($_SESSION['userExiste'])
                    echo "<tr><td colspan='2'><p id='alerta'>'Esse usuário já foi cadastrado'</p></td></tr>"
            ?>
            <tr>
            	<td><label for='pword'>Senha: </label></td>
            	<td><input type='password' name='pword' id='pword' value=<?php echo $_SESSION['pword'] ?>></td>
            </tr>
            <tr>
        	   <td><label for='confPword'>Confirme a Senha: </label></td>
        	   <td><input type='password' name='confPword' oninput="validaSenha(this)"></td>
            </tr>



            <tr>
        	   <td><label for='celular'>Celular: </label></td>
        	   <td><input type='tel' pattern='[\(]\d{2}[\)]\d{5}[\-]?\d{4}' name='celular' placeholder="(99)99999-9999" value=<?php echo "'".$_SESSION['celular']."'"?> ></td>
            </tr>
            <?php
                if ($_SESSION['celExiste'])
                    echo "<tr><td><p id='alerta'>'Esse celular já foi cadastrado'</p></td></tr>"
            ?>
            <tr>
        	   <td><input type='submit' id='submit' value='Cadastrar'></td>
            </tr>
    </table>
    </form>
</body>
</html>