package daos;

import java.sql.*;
import Core.*;
import banco.de.dados.*;
import dbos.Pedido;

public class Pedidos {
	
	/**
	 * Procura pelo registro com o c�digo passado por par�metro no banco de dados e informa se ele existe ou n�o.
	 * 
	 * @param codigo	c�digo de pedido a ser procurado no banco de dados
	 * @return	<code>true</code> se houver registro com o c�digo informado e <code>false</code> caso contr�rio
	 * @throws Exception	se ocorrer algum erro ao contatar o banco de dados
	 */
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
	
	/**
	 * Exclui do banco de dados um registro de pedido.
	 *
	 * @param codigo	o c�digo do pedido que ser� excluido do banco de dados
	 * @throws Exception	se n�o houver registro com o c�digo passado por par�metro ou ocorrer algum erro ao contatar o banco de dados
	 */
	public void excluir (int codigo) throws Exception
    {
        if (!cadastrado (codigo))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql = "DELETE FROM Pedido WHERE codPedido=?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt (1, codigo);

            DAOs.getBD().executeUpdate ();
            DAOs.getBD().commit();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir pedido");
        }
    }
	
    /**
     * Retorna as informa��es do pedido com o c�digo informado
     * 
     * @param codigo	o c�digo do pedido que ser� procurado no banco de dados
     * @return	uma inst�ncia da classe Pedido cujo c�digo seja igual ao par�metro
     * @throws Exception	se n�o houver pedido com o c�digo fornecido ou ocorrer algum erro ao conectar com o banco de dados
     */
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
            throw new Exception ("Erro ao procurar pedido");
        }

        return pedido;
    }
	
    /**
     * Retorna todos os pedidos do banco de dados
     * 
     * @return	uma inst�ncia de MeuResultSet com todas os pedidos do banco de dados
     * @throws Exception	se houver algum erro ao conectar com o banco de dados
     */
	public synchronized MeuResultSet getPedidos () throws Exception
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
	
    /**
     * Retorna todos os pedidos do banco de dados em ordem decrescente
     * 
     * @return	uma inst�ncia de MeuResultSet com todas os pedidos do banco de dados
     * @throws Exception	se houver algum erro ao conectar com o banco de dados
     */
	public synchronized MeuResultSet getPedidosDesc () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql = "SELECT * FROM Pedido ORDER BY codPedido DESC";

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
