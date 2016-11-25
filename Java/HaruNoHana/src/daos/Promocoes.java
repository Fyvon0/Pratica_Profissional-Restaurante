package daos;

import java.sql.*;
import Core.*;
import banco.de.dados.*;
import dbos.Promocao;

public class Promocoes {
	
	/**
	 * Procura pelo registro com o código passado por parâmetro no banco de dados e informa se ele existe ou não.
	 * 
	 * @param codigo	código de promoção a ser procurado no banco de dados
	 * @return	<code>true</code> se houver registro com o código informado e <code>false</code> caso contrário
	 * @throws Exception	se ocorrer algum erro ao contatar o banco de dados
	 */
	public boolean cadastrado (int codigo) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql = "SELECT * FROM Promocao WHERE codPromocao=?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery ();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar promoção");
        }

        return retorno;
    }
	
	/**
	 * Inclui um novo registro de promoção no banco de dados
	 *
	 * @param promocao	uma instância da classe Promoção cujos valores das variáveis serão inseridos no banco de dados
	 * @throws Exception	se a promoção fornecida for nula
	 */
	public void incluir (Promocao promocao) throws Exception
    {
        if (promocao==null)
            throw new Exception ("Promoção nao fornecida");

        try
        {
            String sql = "INSERT INTO Promocao VALUES (?,?,?,?)";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setString (1, promocao.getDescricao());
            DAOs.getBD().setString (2, promocao.getNome());
            DAOs.getBD().setInt	   (3, promocao.getDesconto());
            DAOs.getBD().setString (4, promocao.getCondicao());

            DAOs.getBD().executeUpdate ();
            DAOs.getBD().commit();
            
            sql = "SELECT MAX(codPromocao) FROM Promocao";
            DAOs.getBD().prepareStatement(sql);
            MeuResultSet promo = (MeuResultSet)DAOs.getBD().executeQuery();
            int codPromocao = promo.getInt("codPromocao");
            
            sql = "SELECT codCliente FROM cliente WHERE ?";
            DAOs.getBD().prepareStatement(sql);
            DAOs.getBD().setString(1, promocao.getCondicao());
            MeuResultSet clientes = (MeuResultSet)DAOs.getBD().executeQuery();
            
            while (clientes.next()) {
            	sql = "INSERT INTO clientePromocao VALUES (?,?)";
            	DAOs.getBD().prepareStatement(sql);
            	DAOs.getBD().setInt(1, clientes.getInt("codCliente"));
            	DAOs.getBD().setInt(2, codPromocao);
            	DAOs.getBD().executeUpdate();
            	DAOs.getBD().commit();
            }
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir promocao");
        }
    }
	
	/**
	 * Exclui do banco de dados um registro de promoção.
	 *
	 * @param codigo	o código da promoção que será excluida do banco de dados
	 * @throws Exception	se não houver registro com o código passado por parâmetro ou ocorrer algum erro ao contatar o banco de dados
	 */
	public void excluir (int codigo) throws Exception
    {
        if (!cadastrado (codigo))
            throw new Exception ("Nao cadastrado");

        try
        {
        	String sql = "DELETE FROM clientePromocao where codPromocao = ?";
        	DAOs.getBD().prepareStatement(sql);
        	DAOs.getBD().setInt(1,codigo);
        	DAOs.getBD().executeUpdate();
        	DAOs.getBD().commit();
        	
            sql = "DELETE FROM Promocao WHERE codPromocao=?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt (1, codigo);

            DAOs.getBD().executeUpdate ();
            
            DAOs.getBD().commit();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir promocao");
        }
    }
	
	/**
	 * Altera um registro de promoção no banco de dados
	 * 
	 * @param mesa	uma instância da classe Promoção que servirá de referência para as alterações a serem feitas no banco de dados
	 * @throws Exception	se a promoção fornecida for nula ou não houver um registro com o código de promoção da instância
	 */
	public void alterar (Promocao promocao) throws Exception
    {
        if (promocao==null)
            throw new Exception ("Promocao nao fornecida");

        if (!cadastrado (promocao.getCodPromocao()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE Promocao set descricao = ?, nome = ?, desconto = ?, condicao = ?  WHERE codPromocao = ?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setString (1, promocao.getDescricao());
            DAOs.getBD().setString (2, promocao.getNome());
            DAOs.getBD().setInt	   (3, promocao.getDesconto());
            DAOs.getBD().setString (4, promocao.getCondicao());
            DAOs.getBD().setInt    (5, promocao.getCodPromocao());

            DAOs.getBD().executeUpdate ();
            
            DAOs.getBD().commit();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados de promocao");
        }
    }
	
	/**
    * Retorna as informações da promoção com o código informado
    * 
    * @param codigo	o código da promoção que será procurado no banco de dados
    * @return	uma instância da classe Promoção cujo código seja igual ao parâmetro
    * @throws Exception	se não houver promoção com o código fornecido ou ocorrer algum erro ao conectar com o banco de dados
    */
	public Promocao getPromocao (int codigo) throws Exception
    {
        Promocao promocao = null;

        try
        {
            String sql = "SELECT * FROM Promocao WHERE codPromocao = ?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            promocao = new Promocao (resultado.getInt("codPromocao"), resultado.getInt("desconto"), resultado.getString("descricao"), resultado.getString("nome"), resultado.getString("condicao"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar promocao");
        }

        return promocao;
    }
	
    /**
     * Retorna todas as promoções do banco de dados
     * 
     * @return	uma instância de MeuResultSet com todas as promoções do banco de dados
     * @throws Exception	se ocorrer algum erro ao conectar com o banco de dados
     */
	public MeuResultSet getPromocoes () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql = "SELECT * FROM Promocao";

            DAOs.getBD().prepareStatement (sql);

            resultado = (MeuResultSet)DAOs.getBD().executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar promocoes");
        }

        return resultado;
    }
}
