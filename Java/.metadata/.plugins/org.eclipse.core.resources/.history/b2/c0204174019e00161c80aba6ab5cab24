package dbos;

import java.sql.*;
import java.util.Calendar;

public class Cliente 
{
	private int codCliente;
	private String userLogin, senha, nome, celular;
	private float frequencia, mediaGasta;
	private Timestamp ultimaVisita, dataCadastro;
	
	public Cliente(int codCliente, String userLogin, String senha, String nome, String celular, float frequencia,
			float mediaGasta, Timestamp ultimaVisita, Timestamp dataCadastro) throws Exception{
		this.setCodCliente(codCliente);
		this.setUserLogin (userLogin);
		this.setSenha(senha);
		this.setNome(nome);
		this.setCelular(celular);
		this.setFrequencia(frequencia);
		this.setMediaGasta(mediaGasta);
		this.setUltimaVisita(ultimaVisita);
		this.setDataCadastro(dataCadastro);
	}

	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) throws Exception {
		if (codCliente <=0 )
			throw new Exception ("Codigo inválido");
		this.codCliente = codCliente;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) throws Exception {
		if (userLogin.equals("")||userLogin ==null)
			throw new Exception ("Usuário não fornecido");
		
		this.userLogin = userLogin;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) throws Exception{
		if (senha.equals("")||senha == null)
			throw new Exception ("Senha não fornecida");
		
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws Exception {
		if (nome.equals("")|| nome == null)
			throw new Exception ("Nome não fornecida");
		
		this.nome = nome;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) throws Exception{
		if (celular.equals("")|| celular == null)
			throw new Exception ("Celular não fornecido");
		
		this.celular = celular;
	}
	public float getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(float frequencia) throws Exception{
		if (frequencia <= 0.00f)
			throw new Exception ("Frequencia inválida");
		
		this.frequencia = frequencia;
	}
	public float getMediaGasta() {
		return mediaGasta;
	}
	public void setMediaGasta(float mediaGasta) throws Exception{
		if (mediaGasta <= 0.0f)
			throw new Exception ("Media gasta inválida");
		
		this.mediaGasta = mediaGasta;
	}
	public Timestamp getUltimaVisita() {
		return ultimaVisita;
	}
	public void setUltimaVisita(Timestamp ultimaVisita) throws Exception{
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.setTime(ultimaVisita);
		this.ultimaVisita = (Timestamp)cal.getTime();
	}
	public Timestamp getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Timestamp dataCadastro) throws Exception{
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.setTime(ultimaVisita);
		this.ultimaVisita = (Timestamp)cal.getTime();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 666;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + (new Integer(codCliente)).hashCode();
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + (new Float(frequencia)).hashCode();
		result = prime * result + (new Float(mediaGasta)).hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((ultimaVisita == null) ? 0 : ultimaVisita.hashCode());
		result = prime * result + ((userLogin == null) ? 0 : userLogin.hashCode());
		return result;
	}

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
		
		if (Float.floatToIntBits(frequencia) != Float.floatToIntBits(other.frequencia))
			return false;
		
		if (Float.floatToIntBits(mediaGasta) != Float.floatToIntBits(other.mediaGasta))
			return false;
		
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
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

	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", userLogin=" + userLogin + ", senha=" + senha + ", nome=" + nome
				+ ", celular=" + celular + ", frequencia=" + frequencia + ", mediaGasta=" + mediaGasta
				+ ", ultimaVisita=" + ultimaVisita + ", dataCadastro=" + dataCadastro + "]";
	}
	
}
