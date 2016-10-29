package dbos;

import java.math.*;

public class Prato
{
	private int codPrato,classificacao;
	private String ingredientes,descricao;
	private BigDecimal preco;
	public int getCodPrato() {
		return codPrato;
	}
	public void setCodPrato(int codPrato) throws Exception{
		if (codPrato <= 0)
			throw new Exception ("C�digo de prato inv�lido");
		
		this.codPrato = codPrato;
	}
	public int getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(int classificacao) throws Exception{
		if (classificacao <= 0)
			throw new Exception ("Classifica��o inv�lida");
		
		this.classificacao = classificacao;
	}
	public String getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String ingredientes) throws Exception{
		if (ingredientes == null || ingredientes.equals(""))
			throw new Exception ("Ingrendientes inv�lidos");
		
		this.ingredientes = ingredientes;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) throws Exception{
		if (descricao == null || descricao.equals(""))
			throw new Exception ("Descri��o inv�lida");
		
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) throws Exception{
		if (preco.compareTo(new BigDecimal(0.0)) < 0)
			throw new Exception ("Pre�o inv�lido");
		
		this.preco = preco;
	}
	
	public Prato(int codPrato, int classificacao, String ingredientes, String descricao, BigDecimal preco) throws Exception{
		this.setCodPrato(codPrato);
		this.setClassificacao(classificacao);
		this.setIngredientes(ingredientes);
		this.setDescricao(descricao);
		this.setPreco(preco);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 666;
		result = prime * result + (new Integer(classificacao)).hashCode();
		result = prime * result + (new Integer(codPrato)).hashCode();
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((ingredientes == null) ? 0 : ingredientes.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Prato other = (Prato) obj;
		
		if (classificacao != other.classificacao)
			return false;
		
		if (codPrato != other.codPrato)
			return false;
		
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		
		if (ingredientes == null) {
			if (other.ingredientes != null)
				return false;
		} else if (!ingredientes.equals(other.ingredientes))
			return false;
		
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		
		return true;
	}
	
	
	
	
}