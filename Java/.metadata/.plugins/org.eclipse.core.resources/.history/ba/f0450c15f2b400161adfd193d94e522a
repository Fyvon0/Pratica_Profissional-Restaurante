package daos;

import java.sql.*;
import Core.*;
import banco.de.dados.*;
import dbos.Prato;

public class Pratos {
	
	/**
	 * Procura pelo registro com o código passado por parâmetro no banco de dados e informa se ele existe ou não.
	 * 
	 * @param codigo	código de prato a ser procurado no banco de dados
	 * @return	<code>true</code> se houver registro com o código informado e <code>false</code> caso contrário
	 * @throws Exception	se ocorrer algum erro ao contatar o banco de dados
	 */
	public boolean cadastrado (int codigo) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql = "SELECT * FROM Prato WHERE codPrato=?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery ();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar livro");
        }

        return retorno;
    }
	
	/**
	 * Inclui um novo registro de prato no banco de dados
	 *
	 * @param mesa	uma instância da classe Prato cujos valores das variáveis serão inseridos no banco de dados
	 * @throws Exception	se a mesa fornecida for nula
	 */
	public void incluir (Prato prato) throws Exception
    {
        if (prato==null)
            throw new Exception ("Livro nao fornecido");

        int codPrato;
        
        try
        {
        	String sql = "SELECT codPrato FROM Prato";
        	DAOs.getBD().prepareStatement(sql);
        	MeuResultSet codPratos = (MeuResultSet)DAOs.getBD().executeQuery();
        	codPratos.last();
        	codPrato = codPratos.getInt("codPrato");
        	codPrato++;
        }
        catch (Exception erro)
        {
        	throw new Exception ("Pratos: erro ao buscar pratos");
        }
        
        try
        {
            String sql = "INSERT INTO Prato VALUES (?,?,?,?,?,?)";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt(1, codPrato);
            DAOs.getBD().setString(2, prato.getIngredientes ());
            DAOs.getBD().setString(3, prato.getDescricao());
            DAOs.getBD().setString(4, prato.getClassificacao());
            DAOs.getBD().setString(5, prato.getNome());
            DAOs.getBD().setBigDecimal(6, prato.getPreco());

            DAOs.getBD().executeUpdate ();
            DAOs.getBD().commit();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir prato");
        }
    }
	
	/**
	 * Exclui do banco de dados um registro de prato.
	 *
	 * @param codigo	o código do prato que será excluido do banco de dados
	 * @throws Exception	se o código passado por parâmetro não existir
	 */
	public void excluir (int codigo) throws Exception
    {
        if (!cadastrado (codigo))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql = "DELETE FROM Prato WHERE codPrato=?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt (1, codigo);

            DAOs.getBD().executeUpdate ();
            DAOs.getBD().commit();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir prato");
        }
    }
	
	/**
	 * Altera um registro de prato no banco de dados
	 * 
	 * @param mesa	uma instância da classe Prato que servirá de referência para as alterações a serem feitas no banco de dados
	 * @throws Exception	se o prato fornecida for nulo ou não houver um registro com o código de prato da instância passada por parâmetro
	 */
	public void alterar (Prato prato) throws Exception
    {
        if (prato==null)
            throw new Exception ("Prato nao fornecido");

        if (!cadastrado (prato.getCodPrato()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql = "UPDATE Prato set ingredientes=?, preco=?, classificacao=?,descricao=?, nome= ? WHERE CODIGO = ?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setString (1, prato.getIngredientes());
            DAOs.getBD().setBigDecimal (2, prato.getPreco());
            DAOs.getBD().setString (3, prato.getClassificacao());
            DAOs.getBD().setString(4, prato.getDescricao());
            DAOs.getBD().setString(5, prato.getNome());
            DAOs.getBD().setInt(6, prato.getCodPrato());

            DAOs.getBD().executeUpdate ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados de prato");
        }
    }

    /**
     * Retorna as informações do prato com o código informado
     * 
     * @param codigo	o código do prato que será procurado no banco de dados
     * @return	uma instância da classe Prato cujo código seja igual ao parâmetro
     * @throws Exception	se não houver prato com o código fornecido ou ocorrer algum erro ao conectar com o banco de dados
     */
	public Prato getPrato (int codigo) throws Exception
    {
        Prato prato = null;

        try
        {
            String sql = "SELECT * FROM Prato WHERE codPrato=?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            prato = new Prato (resultado.getInt("codPrato"),resultado.getString("classificacao"),resultado.getString("ingredientes"),resultado.getString("descricao"),resultado.getString("nome"),resultado.getBigDecimal("preco"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar prato");
        }

        return prato;
    }
	
    /**
     * Retorna todos os pratos do banco de dados
     * 
     * @return	uma instância de MeuResultSet com todas os pratos do banco de dados
     * @throws Exception	se houver algum erro ao conectar com o banco de dados
     */
	public MeuResultSet getPratos () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql = "SELECT * FROM Prato";

            DAOs.getBD().prepareStatement (sql);

            resultado = (MeuResultSet)DAOs.getBD().executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar pratos");
        }

        return resultado;
    }
	
	public MeuResultSet getPratosOrdenado (String campo) throws Exception
	{
		MeuResultSet resultado = null;
		
		String sql = "SELECT * FROM Prato";
		
		if (!campo.equals("Todas"))
			sql += " WHERE classificacao = ?";
		
		try
		{
		DAOs.getBD().prepareStatement(sql);
		if (!campo.equals("Todas"))
			DAOs.getBD().setString(1, campo);
		resultado = (MeuResultSet)DAOs.getBD().executeQuery();
		}
		catch (Exception erro)
		{
			throw new Exception ("Pratos: Erro ao buscar mesas");
		}
		
		return resultado;
	}
}
