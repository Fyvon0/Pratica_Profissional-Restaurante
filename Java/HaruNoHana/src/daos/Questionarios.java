package daos;

import java.sql.*;
import Core.*;
import banco.de.dados.*;
import dbos.Questionario;

public class Questionarios {
	public boolean cadastrado (int codigo) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * FROM Questionario WHERE codQuest=?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery ();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar Questionario");
        }

        return retorno;
    }
	
	public Questionario getQuestionario (int codigo) throws Exception
    {
        Questionario questionario = null;

        try
        {
            String sql = "SELECT * FROM Questionario WHERE codQuest = ?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            questionario = new Questionario (resultado.getInt("codQuest"),resultado.getInt("codCliente"),resultado.getFloat("qualidadeComida"),resultado.getFloat("atendimento"),resultado.getFloat("tempoEspera"),resultado.getString("observacoes"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar livro");
        }

        return questionario;
    }
	
	public MeuResultSet getQuestionarios () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql = "SELECT * FROM Questionario";

            DAOs.getBD().prepareStatement (sql);

            resultado = (MeuResultSet)DAOs.getBD().executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar questionarios");
        }

        return resultado;
    }
}