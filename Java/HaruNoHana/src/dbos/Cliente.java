package dbos;

import java.sql.*;

public class Cliente 
{
	private int codCliente;
	private String userLogin, senha, nome, celular;
	private float frequencia, mediaGasta;
	private Timestamp ultimaVisita, dataCadastro;
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) throws Exception {
		if (codCliente <=0 )
			throw new Exception ("Codigo inv�lido");
		this.codCliente = codCliente;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) throws Exception {
		if (userLogin.equals("")||userLogin ==null)
			throw new Exception ("Usu�rio n�o fornecido");
		
		this.userLogin = userLogin;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) throws Exception{
		if (senha.equals("")||senha == null)
			throw new Exception ("Senha n�o fornecida");
		
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws Exception {
		if (nome.equals("")|| nome == null)
			throw new Exception ("Nome n�o fornecida");
		
		this.nome = nome;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) throws Exception{
		if (celular.equals("")|| celular == null)
			throw new Exception ("Celular n�o fornecido");
		
		this.celular = celular;
	}
	public float getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(float frequencia) throws Exception{
		if (frequencia <= 0.00f)
			throw new Exception ("Frequencia inv�lida");
		
		this.frequencia = frequencia;
	}
	public float getMediaGasta() {
		return mediaGasta;
	}
	public void setMediaGasta(float mediaGasta) throws Exception{
		if (mediaGasta <= 0.0f)
			throw new Exception ("Media gasta inv�lida");
		
		this.mediaGasta = mediaGasta;
	}
	public Timestamp getUltimaVisita() {
		return ultimaVisita;
	}
	public void setUltimaVisita(Timestamp ultimaVisita) throws Exception{
		this.ultimaVisita = ultimaVisita;
	}
	public Timestamp getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
