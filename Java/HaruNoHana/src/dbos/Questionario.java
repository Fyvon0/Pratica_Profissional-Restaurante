package dbos;

public class Questionario {
	private int codQuest,codCliente;
	private float qualidadeComida, atendimento, tempoEspera;
	private String observacoes;
	
	/**
	 * Inicializa as variáveis com os valores recebidos por parâmetro
	 * 
	 * @param codQuest	código único que identifica cada questionário
	 * @param codCliente	o código do cliente que respondeu o questionário
	 * @param qualidadeComida	uma nota de 0 a 10 que o cliente atribuiu ao prato
	 * @param atendimento	uma nota de 0 a 10 que o cliente atribuiu ao serviço do restaurante
	 * @param tempoEspera	uma avaliação de 0 a 10 que o cliente atribuiu ao tempo de entrega do prato
	 * @param observacoes	quaisquer observações extras que o cliente tenha a fazer sobre o prato
	 * @throws Exception	se algum dos parâmetros passados for inválido (veja os setters para mais informações)
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
	 * @param codQuest	o código de questionário a ser redefinido
	 * @throws Exception	se o código passado for menor ou igual a 0
	 */
	public void setCodQuest(int codQuest) throws Exception{
		if (codQuest <= 0)
			throw new Exception ("Código de Questionário inválido");
		
		this.codQuest = codQuest;
	}

	/**
	 * @return codCliente
	 */
	public int getCodCliente() {
		return codCliente;
	}

	/**
	 * @param codCliente o código de cliente a ser redefinido
	 * @throws Exception	se o código passado for menor ou igual a 0
	 */
	public void setCodCliente(int codCliente) throws Exception{
		if (codCliente <= 0)
			throw new Exception ("Código de Cliente inválido");
		
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
			throw new Exception ("Qualidade da comida inválida");
		
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
	 * @throws Exception	se o parâmetro fornecido for menor que 0.0
	 */
	public void setAtendimento(float atendimento) throws Exception{
		if (atendimento < 0.0F)
			throw new Exception ("Atendimento inválido");
		
		this.atendimento = atendimento;
	}

	/**
	 * @return tempoEspera
	 */
	public float getTempoEspera() {
		return tempoEspera;
	}

	/**
	 * @param tempoEspera a avaliação do tempo de espera a ser redefinida
	 * @throws Exception	se a avaliação do tempo de esperar passada for menor que 0.0
	 */
	public void setTempoEspera(float tempoEspera) throws Exception{
		if (tempoEspera < 0.0F)
			throw new Exception ("Tempo de Espera inválida");
		
		this.tempoEspera = tempoEspera;
	}

	/**
	 * @return observacoes
	 */
	public String getObservacoes() {
		return observacoes;
	}

	/**
	 * @param observacoes as observações a serem redefinidas
	 * @throws Exception	se as observações passadas forem nulas
	 */
	public void setObservacoes(String observacoes) throws Exception{
		if (observacoes == null)
			throw new Exception ("Observações não fornecidas");
		
		this.observacoes = observacoes;
	}
	
	
	
}
