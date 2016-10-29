package daos;

import java.sql.*;
import banco.de.dados.*;
import Core.*;
import dbos.*;

public class Mesas {
	public boolean cadastrado (int codigo) throws Exception
	{
	    boolean retorno = false;
	
	    try
	    {
	        String sql;
	
	        sql = "SELECT * FROM Mesa WHERE codMesas=?";
	
	        DAOs.getBD().prepareStatement (sql);
	
	        DAOs.getBD().setInt (1, codigo);
	
	        MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery ();
	
	        retorno = resultado.first();
	    }
	    catch (SQLException erro)
	    {
	        throw new Exception ("Erro ao procurar mesa");
	    }
	
	    return retorno;
	}
	
	public void incluir (Mesa mesa) throws Exception
    {
        if (mesa==null)
            throw new Exception ("Mesa nao fornecida");

        try
        {
            String sql;

            sql = "INSERT INTO Mesa VALUES (?,?,?,?,?,?,?,?)";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt(1, mesa.getReserva ());
            DAOs.getBD().setTimestamp(2, mesa.getHorario ());
            DAOs.getBD().setTimestamp(3,mesa.getHoraPrevista());
            DAOs.getBD().setString(4,mesa.getFormaPagamento());
            DAOs.getBD().setBigDecimal(5, mesa.getValorTotal());
            DAOs.getBD().setTimestamp(6, mesa.getHoraFechamento());;
            DAOs.getBD().setInt(7, mesa.getStatusMesa());
            DAOs.getBD().setInt(8, mesa.getCodCliente());

            DAOs.getBD().executeUpdate ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir mesa");
        }
    }
	
	public void excluir (int codigo) throws Exception
    {
        if (!cadastrado (codigo))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql = "DELETE FROM Mesa WHERE codMesa=?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt (1, codigo);

            DAOs.getBD().executeUpdate ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir mesa");
        }
    }

    public void alterar (Mesa mesa) throws Exception
    {
        if (mesa==null)
            throw new Exception ("Mesa n�o fornecida");

        if (!cadastrado(mesa.getCodMesa()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql = "update Mesa set reserva=?, horario=?, horaPrevista=?,formaPagamento=?,valorTotal=?,"
            		+ "horaFechamento=?,statusMesa=?,codCliente=? where codMesa=?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt(1, mesa.getReserva ());
            DAOs.getBD().setTimestamp(2, mesa.getHorario ());
            DAOs.getBD().setTimestamp(3,mesa.getHoraPrevista());
            DAOs.getBD().setString(4,mesa.getFormaPagamento());
            DAOs.getBD().setBigDecimal(5, mesa.getValorTotal());
            DAOs.getBD().setTimestamp(6, mesa.getHoraFechamento());;
            DAOs.getBD().setInt(7, mesa.getStatusMesa());
            DAOs.getBD().setInt(8, mesa.getCodCliente());
            DAOs.getBD().setInt(9, mesa.getCodMesa ());

            DAOs.getBD().executeUpdate ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados de mesa");
        }
    }
    
    public Mesa getMesa (int codigo) throws Exception
    {
        Mesa mesa = null;

        try
        {
            String sql = "SELECT * FROM Mesa WHERE codMesa = ?";

            DAOs.getBD().prepareStatement (sql);

            DAOs.getBD().setInt (1, codigo);

            MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            mesa = new Mesa(resultado.getInt("codMesa"),resultado.getInt("reserva"),resultado.getInt("statusMesa"),
            		resultado.getInt("codCliente"),resultado.getTimestamp("horario"),
            		resultado.getTimestamp("horaPrevista"),resultado.getTimestamp("horaFechamento"),
            		resultado.getString("formaPagamento"),resultado.getBigDecimal("valorTotal"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar livro");
        }

        return mesa;
    }

    public MeuResultSet getMesas () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql = "SELECT * FROM Mesas";

            DAOs.getBD().prepareStatement (sql);

            resultado = (MeuResultSet)DAOs.getBD().executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar mesas");
        }

        return resultado;
    }
}