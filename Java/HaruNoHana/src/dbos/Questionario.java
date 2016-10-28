package dbos;

public class Questionario {
	private int codQuest,codCliente;
	private float qualidadeComida, atendimento, tempoEspera;
	private String observacoes;
	
	/**
	 * @param codQuest
	 * @param codCliente
	 * @param qualidadeComida
	 * @param atendimento
	 * @param tempoEspera
	 * @param observacoes
	 */
	public Questionario(int codQuest, int codCliente, float qualidadeComida, float atendimento, float tempoEspera,
			String observacoes) throws Exception{
		this.setCodQuest(codQuest);
		this.setCodCliente(codCliente);
		this.setQualidadeComida(qualidadeComida);
		this.setAtendimento(atendimento);
		this.setTempoEspera(tempoEspera);
		this.setObservacoes(observacoes);
	}

	/**
	 * @return the codQuest
	 */
	public int getCodQuest() {
		return codQuest;
	}

	/**
	 * @param codQuest the codQuest to set
	 */
	public void setCodQuest(int codQuest) throws Exception{
		if (codQuest <= 0)
			throw new Exception ("Código de Questionário inválido");
		
		this.codQuest = codQuest;
	}

	/**
	 * @return the codCliente
	 */
	public int getCodCliente() {
		return codCliente;
	}

	/**
	 * @param codCliente the codCliente to set
	 */
	public void setCodCliente(int codCliente) throws Exception{
		if (codCliente <= 0)
			throw new Exception ("Código de Cliente inválido");
		
		this.codCliente = codCliente;
	}

	/**
	 * @return the qualidadeComida
	 */
	public float getQualidadeComida() {
		return qualidadeComida;
	}

	/**
	 * @param qualidadeComida the qualidadeComida to set
	 */
	public void setQualidadeComida(float qualidadeComida) throws Exception{
		if (qualidadeComida < 0.0F)
			throw new Exception ("Qualidade da comida inválida");
		
		this.qualidadeComida = qualidadeComida;
	}

	/**
	 * @return the atendimento
	 */
	public float getAtendimento() {
		return atendimento;
	}

	/**
	 * @param atendimento the atendimento to set
	 */
	public void setAtendimento(float atendimento) throws Exception{
		if (atendimento < 0.0F)
			throw new Exception ("Atendimento inválido");
		
		this.atendimento = atendimento;
	}

	/**
	 * @return the tempoEspera
	 */
	public float getTempoEspera() {
		return tempoEspera;
	}

	/**
	 * @param tempoEspera the tempoEspera to set
	 */
	public void setTempoEspera(float tempoEspera) throws Exception{
		if (tempoEspera < 0.0F)
			throw new Exception ("Tempo de Espera inválida");
		
		this.tempoEspera = tempoEspera;
	}

	/**
	 * @return the observacoes
	 */
	public String getObservacoes() {
		return observacoes;
	}

	/**
	 * @param observacoes the observacoes to set
	 */
	public void setObservacoes(String observacoes) throws Exception{
		if (observacoes == null)
			throw new Exception ("Observações não fornecidas");
		
		this.observacoes = observacoes;
	}
	
	
	
}
