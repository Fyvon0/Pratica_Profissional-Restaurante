package banco.de.dados;

import Core.*;
import daos.*;

/**
 * A class DAOs serve como um "hub", reunindo todos as classes de acesso ao banco de dados utilizadas no projeto
 */
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
	 * @return uma inst�ncia de MeuPreparedStatement que representa a conex�o com o banco de dados
	 */
	public static MeuPreparedStatement getBD() {
		return DAOs.bd;
	}

	/**
	 * @return uma inst�ncia da classe Pedidos
	 */
	public static Pedidos getPedidos() {
		return DAOs.pedidos;
	}

	/**
	 * @return uma inst�ncia da classe Pratos
	 */
	public static Pratos getPratos() {
		return DAOs.pratos;
	}

	/**
	 * @return uma inst�ncia da classe Promocoes
	 */
	public static Promocoes getPromocoes() {
		return DAOs.promocoes;
	}

	/**
	 * @return uma inst�ncia da classe Questionarios
	 */
	public static Questionarios getQuestionarios() {
		return DAOs.questionarios;
	}

	/**
	 * @return uma inst�ncia da classe Mesas
	 */
	public static Mesas getMesas() {
		return DAOs.mesas;
	}

	/**
	 * @return uma inst�ncia da classe Clientes
	 */
	public static Clientes getClientes() {
		return DAOs.clientes;
	}
	

}
