package dbos;

import java.sql.*;
import java.util.Calendar;

public class Cliente implements Cloneable
{
	private int codCliente, qtdVisitas;
	private String userLogin, senha, nome, celular;
	private float mediaGasta;
	private Timestamp ultimaVisita, dataCadastro;
	
	/**
	 * Construtor da classe cliente, inicializando suas variáveis a partir dos valores dos parametros
	 * 
	 * @param codCliente	código de Cliente
	 * @param userLogin		nick que o usuário usa para se logar
	 * @param senha			senha do usuário
	 * @param nome			nome do usuário
	 * @param celular		celular para eventuais contatos
	 * @param mediaGasta	média que o cliente gasta no restaurante
	 * @param ultimaVisita	última visita registrada do cliente
	 * @param dataCadastro	data de inserção do registro do cliente
	 * @throws Exception	lança Exception se os paramêtros passados forem inválidos dentro da classificação dos setters
	 */
	public Cliente(int codCliente, int qtdVisitas, String userLogin, String senha, String nome, String celular,
			float mediaGasta, Timestamp ultimaVisita, Timestamp dataCadastro) throws Exception{
		this.setCodCliente(codCliente);
		this.setQtdVisitas(qtdVisitas);
		this.setUserLogin (userLogin);
		this.setSenha(senha);
		this.setNome(nome);
		this.setCelular(celular);
		this.setMediaGasta(mediaGasta);
		this.setUltimaVisita(ultimaVisita);
		this.setDataCadastro(dataCadastro);
	}
	
	/**
	 * @return a quantidade de visitas que o cliente já realizou
	 */
	public int getQtdVisitas() {
		return qtdVisitas;
	}

	/**
	 * @param qtdVisitas a quantidade de visitas a ser redefinida
	 */
	public void setQtdVisitas(int qtdVisitas) {
		this.qtdVisitas = qtdVisitas;
	}

	/** 
	 * @return codCliente	
	 */
	
	public int getCodCliente() {
		return codCliente;
	}
	
	/**
	 * @param codCliente	código do cliente a ser redefinido
	 * @throws Exception	se o código do cliente for menor ou igual a 0
	 */
	public void setCodCliente(int codCliente) throws Exception {
		if (codCliente <=0 )
			throw new Exception ("Codigo inválido");
		this.codCliente = codCliente;
	}
	
	/**
	 * @return userLogin
	 */
	public String getUserLogin() {
		return userLogin;
	}
	
	/**
	 * @param userLogin 	userLogin a ser redefinido
	 * @throws Exception	se o userLogin for nulo ou igual a String vazia
	 */
	public void setUserLogin(String userLogin) throws Exception {
		if (userLogin.equals("")||userLogin ==null)
			throw new Exception ("Usuário não fornecido");
		
		this.userLogin = userLogin;
	}
	
	/**
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * @param 	senha 	senha a ser redefinida
	 * @throws 	Exception se a senha for nula ou igual a String vazia
	 */
	public void setSenha(String senha) throws Exception{
		if (senha.equals("")||senha == null)
			throw new Exception ("Senha não fornecida");
		
		this.senha = senha;
	}
	
	/**
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @param nome	nome a ser redefinido
	 * @throws Exception	se o nome for nulo ou igual a String vazia
	 */
	public void setNome(String nome) throws Exception {
		if (nome.equals("")|| nome == null)
			throw new Exception ("Nome não fornecida");
		
		this.nome = nome;
	}
	
	/**
	 * @return celular
	 */
	public String getCelular() {
		return celular;
	}
	
	/**
	 * @param celular	celular a ser redefinido
	 * @throws Exception	se o celular for nulo ou igual a String vazia
	 */
	public void setCelular(String celular) throws Exception{
		if (celular.equals("")|| celular == null)
			throw new Exception ("Celular não fornecido");
		
		this.celular = celular;
	}
	
	/**
	 * @return	mediaGasta
	 */
	public float getMediaGasta() {
		return mediaGasta;
	}
	
	/**
	 * @param mediaGasta	mediaGasta a ser redefinida
	 * @throws Exception	se a mediaGasta for menor ou igual a 0
	 */
	public void setMediaGasta(float mediaGasta) throws Exception{
		if (mediaGasta <= 0.0f)
			throw new Exception ("Media gasta inválida");
		
		this.mediaGasta = mediaGasta;
	}
	
	/**
	 * @return ultimaVisita
	 */
	public Timestamp getUltimaVisita() {
		return ultimaVisita;
	}
	
	/**
	 * @param ultimaVisita	a data da ultima visita a ser redefinida
	 * @throws Exception 	se a data da última visita for nula
	 */
	public void setUltimaVisita(Timestamp ultimaVisita) throws Exception{
		if (ultimaVisita == null)
			throw new Exception ("Data da última visita nula");
			
		Calendar cal = Calendar.getInstance();
		cal.setTime(ultimaVisita);
		this.ultimaVisita = (Timestamp)cal.getTime();
	}
	
	/**
	 * @return dataCadastro
	 */
	public Timestamp getDataCadastro() {
		return dataCadastro;
	}
	
	/**
	 * @param dataCadastro	a data de cadastro a ser redefinida
	 * @throws Exception	se a data de cadastro for nula
	 */
	public void setDataCadastro(Timestamp dataCadastro) throws Exception{
		if (dataCadastro == null)
			throw new Exception ("Data de cadastro nula");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(ultimaVisita);
		this.ultimaVisita = (Timestamp)cal.getTime();
	}
	
	// APOCALÍPTICOS
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + codCliente;
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + Float.floatToIntBits(mediaGasta);
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + qtdVisitas;
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((ultimaVisita == null) ? 0 : ultimaVisita.hashCode());
		result = prime * result + ((userLogin == null) ? 0 : userLogin.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (codCliente != other.codCliente)
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (Float.floatToIntBits(mediaGasta) != Float.floatToIntBits(other.mediaGasta))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (qtdVisitas != other.qtdVisitas)
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (ultimaVisita == null) {
			if (other.ultimaVisita != null)
				return false;
		} else if (!ultimaVisita.equals(other.ultimaVisita))
			return false;
		if (userLogin == null) {
			if (other.userLogin != null)
				return false;
		} else if (!userLogin.equals(other.userLogin))
			return false;
		return true;
	}

	/**
	 * Gera uma representação da classe em String
	 * 
	 * @return o nome seguido do valor das variáveis
	 */
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", userLogin=" + userLogin + ", senha=" + senha + ", nome=" + nome
				+ ", celular=" + celular + ", mediaGasta=" + mediaGasta
				+ ", ultimaVisita=" + ultimaVisita + ", dataCadastro=" + dataCadastro + "]";
	}
	
	/**
	 * Construtor de cópia da classe Cliente. Copia o valor das variáveis de uma instância de Cliente parâmetro
	 * 
	 * @param cliente	instância da classe Cliente que servira de base para cópia
	 * @throws Exception	se a instância fornecida for nula
	 */
	public Cliente (Cliente cliente) throws Exception{
		if (cliente == null)
			throw new Exception ("Cliente não fornecido");
		
		this.setCodCliente(cliente.codCliente);
		this.setQtdVisitas(cliente.qtdVisitas);
		this.setUserLogin (cliente.userLogin);
		this.setSenha(cliente.senha);
		this.setNome(cliente.nome);
		this.setCelular(cliente.celular);
		this.setMediaGasta(cliente.mediaGasta);
		this.setUltimaVisita(cliente.ultimaVisita);
		this.setDataCadastro(cliente.dataCadastro);
	}
	
	/**
	 * Gera uma cópia da instância
	 * 
	 * @return uma instância da classe Cliente com os mesmos valores de this
	 */
	public Cliente clone () {
		Cliente ret = null;
		
		try
		{
			ret = new Cliente (this);
		}
		catch (Exception erro)
		{}
		
		return ret;
	}
}
