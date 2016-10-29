package daos;

import java.sql.*;
import Core.*;
import banco.de.dados.*;
import dbos.Prato;

public class Pratos {
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
	
	public void incluir (Prato prato) throws Exception
    {
        if (prato==null)
            throw new Exception ("Livro nao fornecido");

        try
        {
            String sql = "INSERT INTO Prato VALUES (?,?,?,?)";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setString(1, prato.getIngredientes ());
            DAOs.getBD().setBigDecimal(2, prato.getPreco());
            DAOs.getBD().setInt(3, prato.getClassificacao());
            DAOs.getBD().setString(4, prato.getDescricao());

            DAOs.getBD().executeUpdate ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir prato");
        }
    }
	
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
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir prato");
        }
    }
	
	public void alterar (Prato prato) throws Exception
    {
        if (prato==null)
            throw new Exception ("Prato nao fornecido");

        if (!cadastrado (prato.getCodPrato()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql = "UPDATE Prato set ingredientes=?, preco=?, classificacao=?,descricao=? WHERE CODIGO = ?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setString (1, prato.getIngredientes());
            DAOs.getBD().setBigDecimal (2, prato.getPreco());
            DAOs.getBD().setInt (3, prato.getClassificacao());
            DAOs.getBD().setString(4, prato.getDescricao());

            DAOs.getBD().executeUpdate ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados de prato");
        }
    }

	public Prato getLivro (int codigo) throws Exception
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

            prato = new Prato (resultado.getInt("codPrato"),resultado.getInt("classificacao"),resultado.getString("ingredientes"),resultado.getString("descricao"),resultado.getBigDecimal("preco"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar prato");
        }

        return prato;
    }
	
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
}