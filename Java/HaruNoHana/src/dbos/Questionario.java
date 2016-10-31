package dbos;

public class Questionario {
	private int codQuest,codCliente;
	private float qualidadeComida, atendimento, tempoEspera;
	private String observacoes;
	
	/**
	 * Inicializa as vari�veis com os valores recebidos por par�metro
	 * 
	 * @param codQuest	c�digo �nico que identifica cada question�rio
	 * @param codCliente	o c�digo do cliente que respondeu o question�rio
	 * @param qualidadeComida	uma nota de 0 a 10 que o cliente atribuiu ao prato
	 * @param atendimento	uma nota de 0 a 10 que o cliente atribuiu ao servi�o do restaurante
	 * @param tempoEspera	uma avalia��o de 0 a 10 que o cliente atribuiu ao tempo de entrega do prato
	 * @param observacoes	quaisquer observa��es extras que o cliente tenha a fazer sobre o prato
	 * @throws Exception	se algum dos par�metros passados for inv�lido (veja os setters para mais informa��es)
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
	 * @return codQuest
	 */
	public int getCodQuest() {
		return codQuest;
	}

	/**
	 * @param codQuest	o c�digo de question�rio a ser redefinido
	 * @throws Exception	se o c�digo passado for menor ou igual a 0
	 */
	public void setCodQuest(int codQuest) throws Exception{
		if (codQuest <= 0)
			throw new Exception ("C�digo de Question�rio inv�lido");
		
		this.codQuest = codQuest;
	}

	/**
	 * @return codCliente
	 */
	public int getCodCliente() {
		return codCliente;
	}

	/**
	 * @param codCliente o c�digo de cliente a ser redefinido
	 * @throws Exception	se o c�digo passado for menor ou igual a 0
	 */
	public void setCodCliente(int codCliente) throws Exception{
		if (codCliente <= 0)
			throw new Exception ("C�digo de Cliente inv�lido");
		
		this.codCliente = codCliente;
	}

	/**
	 * @return qualidadeComida
	 */
	public float getQualidadeComida() {
		return qualidadeComida;
	}

	/**
	 * @param qualidadeComida a qualidade da comida a ser redefinida
	 * @throws Exception	se a qualidade da comida passada for menor que 0.0
	 */
	public void setQualidadeComida(float qualidadeComida) throws Exception{
		if (qualidadeComida < 0.0F)
			throw new Exception ("Qualidade da comida inv�lida");
		
		this.qualidadeComida = qualidadeComida;
	}

	/**
	 * @return atendimento
	 */
	public float getAtendimento() {
		return atendimento;
	}

	/**
	 * @param atendimento	a qualidade do atendimento a ser redefinida
	 * @throws Exception	se o par�metro fornecido for menor que 0.0
	 */
	public void setAtendimento(float atendimento) throws Exception{
		if (atendimento < 0.0F)
			throw new Exception ("Atendimento inv�lido");
		
		this.atendimento = atendimento;
	}

	/**
	 * @return tempoEspera
	 */
	public float getTempoEspera() {
		return tempoEspera;
	}

	/**
	 * @param tempoEspera a avalia��o do tempo de espera a ser redefinida
	 * @throws Exception	se a avalia��o do tempo de esperar passada for menor que 0.0
	 */
	public void setTempoEspera(float tempoEspera) throws Exception{
		if (tempoEspera < 0.0F)
			throw new Exception ("Tempo de Espera inv�lida");
		
		this.tempoEspera = tempoEspera;
	}

	/**
	 * @return observacoes
	 */
	public String getObservacoes() {
		return observacoes;
	}

	/**
	 * @param observacoes as observa��es a serem redefinidas
	 * @throws Exception	se as observa��es passadas forem nulas
	 */
	public void setObservacoes(String observacoes) throws Exception{
		if (observacoes == null)
			throw new Exception ("Observa��es n�o fornecidas");
		
		this.observacoes = observacoes;
	}
	
	
	
}
