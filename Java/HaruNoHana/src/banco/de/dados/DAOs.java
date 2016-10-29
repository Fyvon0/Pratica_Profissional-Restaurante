/**
 * 
 */
package banco.de.dados;

/**
 * @author u16164
 *
 */
import Core.*;
import daos.*;

public class DAOs {
	
	private static MeuPreparedStatement bd;
	
	private static Clientes clientes;	
	private static Mesas mesas;	
	private static Pedidos pedidos;	
	private static Pratos pratos;	
	private static Promocoes promocoes;
	private static Questionarios questionarios;
	
	static
	{
		try
		{
			DAOs.bd = new MeuPreparedStatement (
                    "com.microsoft.sqlserver.jdbc.SQLServerDriver",
                    "jdbc:sqlserver://regulus:1433;databasename=BDGRUPO9",
                    "BDGRUPO9", "BDGRUPO9");

          DAOs.clientes = new Clientes ();
          DAOs.mesas = new Mesas ();
          DAOs.pedidos = new Pedidos ();
          DAOs.pratos = new Pratos ();
          DAOs.promocoes = new Promocoes ();
          DAOs.questionarios = new Questionarios ();
		}
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0); // aborta o programa
        }
	}
	
	/**
	 * @return the bd
	 */
	public static MeuPreparedStatement getBd() {
		return bd;
	}

	/**
	 * @return the pedidos
	 */
	public static Pedidos getPedidos() {
		return pedidos;
	}

	/**
	 * @return the pratos
	 */
	public static Pratos getPratos() {
		return pratos;
	}

	/**
	 * @return the promocoes
	 */
	public static Promocoes getPromocoes() {
		return promocoes;
	}

	/**
	 * @return the questionarios
	 */
	public static Questionarios getQuestionarios() {
		return questionarios;
	}

	public static Mesas getMesas() {
		return mesas;
	}

	public static Clientes getClientes() {
		return DAOs.clientes;
	}

	public static MeuPreparedStatement getBD ()
	{
		return DAOs.bd;
	}
	
	

}