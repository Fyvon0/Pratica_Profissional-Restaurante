package daos;

import java.sql.*;
import Core.*;
import banco.de.dados.*;
import dbos.Pedido;

public class Pedidos {
	public boolean cadastrado (int codigo) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql = "SELECT * FROM Pedido WHERE codPedido=?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery ();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar pedido");
        }

        return retorno;
    }
	
	public Pedido getPedido (int codigo) throws Exception
    {
        Pedido pedido = null;

        try
        {
            String sql = "SELECT * FROM Pedido WHERE codPedido = ?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            pedido= new Pedido(resultado.getInt("codPedido"),resultado.getInt("quantidade"),resultado.getInt("codCliente"),resultado.getInt("codPrato"),resultado.getTimestamp("horario"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar livro");
        }

        return pedido;
    }
	
	public MeuResultSet getPedidos () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql = "SELECT * FROM Pedido";

            DAOs.getBD().prepareStatement (sql);

            resultado = (MeuResultSet)DAOs.getBD().executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar pedidos");
        }

        return resultado;
    }
}