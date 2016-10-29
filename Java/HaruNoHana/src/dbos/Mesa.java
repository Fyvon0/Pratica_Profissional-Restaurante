package dbos;

import java.sql.*;
import java.util.Calendar;
import java.math.*;

public class Mesa {
	private int codMesa, reserva, statusMesa, codCliente;
	private Timestamp horario, horaPrevista, horaFechamento;
	private String formaPagamento;
	private BigDecimal valorTotal;

	public Mesa(int codMesa, int reserva, int statusMesa, int codCliente, Timestamp horario, Timestamp horaPrevista,
			Timestamp horaFechamento, String formaPagamento, BigDecimal valorTotal) throws Exception{
		this.setCodMesa(codMesa);
		this.setReserva(reserva);
		this.setStatusMesa(statusMesa);
		this.setCodCliente(codCliente);
		this.setHorario(horario);
		this.setHoraPrevista(horaPrevista);
		this.setHoraFechamento(horaFechamento);
		this.setFormaPagamento(formaPagamento);
		this.setValorTotal(valorTotal);
	}
	
	/**
	 * @return codMesa
	 */
	public int getCodMesa() {
		return codMesa;
	}
	
	/**
	 * @param codMesa	o código de mesa a ser redefinido
	 * @throws Exception	se o código da mesa for menor ou igual a 0
	 */
	public void setCodMesa(int codMesa) throws Exception{
		if (codMesa <= 0)
			throw new Exception ("Código inválido");
			
		this.codMesa = codMesa;
	}
	
	/**
	 * Verifica se uma mesa está reservada ou não
	 * 
	 * @return reserva	retorna 0 se a mesa estiver livre e 1 se estiver reservada
	 */
	public int getReserva() {
		return reserva;
	}
	
	/**
	 * @param reserva	valor da reserva a ser redefinida
	 * @throws Exception	se o valor não for 0 nem 1
	 */
	public void setReserva(int reserva) throws Exception{
		if (!(reserva == 0 || reserva == 1))
			throw new Exception ("Status de reserva inválido");
		
		this.reserva = reserva;
	}
	
	/**
	 * @return statusMesa
	 */
	public int getStatusMesa() {
		return statusMesa;
	}
	public void setStatusMesa(int statusMesa) throws Exception{
		if (!(statusMesa == 1 || statusMesa == 2))
			throw new Exception ("StatusMesa inválido");
		
		this.statusMesa = statusMesa;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) throws Exception{
		if (codCliente <= 0)
			throw new Exception ("Código de cliente inválido");
		
		this.codCliente = codCliente;
	}
	public Timestamp getHorario() {
		return horario;
	}
	public void setHorario(Timestamp horario) throws Exception{
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.setTime(horario);
		this.horario = (Timestamp)cal.getTime();
	}
	public Timestamp getHoraPrevista() {
		return horaPrevista;
	}
	public void setHoraPrevista(Timestamp horaPrevista) {
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.setTime(horaPrevista);
		this.horaPrevista = (Timestamp)cal.getTime();
	}
	public Timestamp getHoraFechamento() {
		return horaFechamento;
	}
	public void setHoraFechamento(Timestamp horaFechamento) throws Exception{
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.setTime(horaFechamento);
		this.horaFechamento = (Timestamp)cal.getTime();
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) throws Exception{
		if (formaPagamento == null || formaPagamento.equals(""))
			throw new Exception ("Forma de Pagamento não fornecida");
			
		this.formaPagamento = formaPagamento;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) throws Exception{
		if (valorTotal.compareTo(new BigDecimal(0.0)) < 0)
			throw new Exception ("Valor Total inválido");
			
		this.valorTotal = valorTotal;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 666;
		result = prime * result + (new Integer(codCliente)).hashCode();
		result = prime * result + (new Integer(codMesa)).hashCode();
		result = prime * result + ((formaPagamento == null) ? 0 : formaPagamento.hashCode());
		result = prime * result + ((horaFechamento == null) ? 0 : horaFechamento.hashCode());
		result = prime * result + ((horaPrevista == null) ? 0 : horaPrevista.hashCode());
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
		result = prime * result + (new Integer(reserva)).hashCode();
		result = prime * result + (new Integer(statusMesa)).hashCode();
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Mesa other = (Mesa) obj;
		
		if (codCliente != other.codCliente)
			return false;
		
		if (codMesa != other.codMesa)
			return false;
		
		if (formaPagamento == null) {
			if (other.formaPagamento != null)
				return false;
		} else if (!formaPagamento.equals(other.formaPagamento))
			return false;
		
		if (horaFechamento == null) {
			if (other.horaFechamento != null)
				return false;
		} else if (!horaFechamento.equals(other.horaFechamento))
			return false;
		
		if (horaPrevista == null) {
			if (other.horaPrevista != null)
				return false;
		} else if (!horaPrevista.equals(other.horaPrevista))
			return false;
		
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		
		if (reserva != other.reserva)
			return false;
		
		if (statusMesa != other.statusMesa)
			return false;
		
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		
		return true;
	}
	
	
}
