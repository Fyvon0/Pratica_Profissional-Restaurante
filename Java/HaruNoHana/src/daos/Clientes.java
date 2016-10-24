package daos;

import java.sql.*;
import Core.MeuResultSet;
import banco.de.dados.*;

public class Clientes
{
	public boolean cadastrado (int codigo) throws Exception
	{
		boolean retorno = false;
		
		try
		{
			String sql;
			
			sql = "SELECT * FROM Cliente WHERE codCliente = ?";
			
			DAOs.getBD().prepareStatement(sql);
			
			DAOS.getBD().setInt(1,codigo);
			
			MeuResultSet resultado = (MeuResultSet)DAOs.getBD().executeQuery();
			
			retorno = resultado.first();
		}
		catch (SQLException erro)
		{
			throw new Exception ("Erro ao procurar Cliente");
		}
		
		return retorno;
	}
}
