package daos;

import java.sql.*;
import Core.*;
import banco.de.dados.*;
import dbos.Promocao;

public class Promocoes {
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
	
	public void incluir (Promocao promocao) throws Exception
    {
        if (promocao==null)
            throw new Exception ("Livro nao fornecido");

        try
        {
            String sql = "INSERT INTO Promocao VALUES (?)";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setString (1, promocao.getDescricao());

            DAOs.getBD().executeUpdate ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir promocao");
        }
    }
	
	public void excluir (int codigo) throws Exception
    {
        if (!cadastrado (codigo))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql = "DELETE FROM Promocao WHERE codPromocao=?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt (1, codigo);

            DAOs.getBD().executeUpdate ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir promocao");
        }
    }
	
	public void alterar (Promocao promocao) throws Exception
    {
        if (promocao==null)
            throw new Exception ("Promocao nao fornecida");

        if (!cadastrado (promocao.getCodPromocao()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE Promocao set descricao = ?  WHERE codPromocao = ?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setString (1, promocao.getDescricao());
            DAOs.getBD().setInt    (2, promocao.getCodPromocao());

            DAOs.getBD().executeUpdate ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados de promocao");
        }
    }
	
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

            promocao = new Promocao (resultado.getInt("codPromocao"),resultado.getString("descricao"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar promocao");
        }

        return promocao;
    }
	
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
