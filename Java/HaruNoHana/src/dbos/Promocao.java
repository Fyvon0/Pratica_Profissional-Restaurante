package dbos;

public class Promocao {
	private int codPromocao;
	private String descricao;
	
	/**
	 * @param codPromocao
	 * @param descricao
	 */
	public Promocao(int codPromocao, String descricao) {
		super();
		this.codPromocao = codPromocao;
		this.descricao = descricao;
	}

	/**
	 * @return the codPromocao
	 */
	public int getCodPromocao() {
		return codPromocao;
	}

	/**
	 * @param codPromocao the codPromocao to set
	 */
	public void setCodPromocao(int codPromocao) throws Exception{
		if (codPromocao <= 0)
			throw new Exception ("C�digo de promo��o inv�lido");
		
		this.codPromocao = codPromocao;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) throws Exception{
		if (descricao == null || descricao.equals(""))
			throw new Exception ("Descri��o n�o fornecida");
		
		this.descricao = descricao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 666;
		result = prime * result + (new Integer(codPromocao)).hashCode();
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Promocao other = (Promocao) obj;
		
		if (codPromocao != other.codPromocao)
			return false;
		
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		
		return true;
	}
	
	
	
}