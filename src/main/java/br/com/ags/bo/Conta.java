package br.com.ags.bo;

public abstract class Conta {
	int numero;
	int agencia;
	double saldo;
	double limite;
	
	public Conta(int numero) {
		setNumero(numero);
	}
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	 * @return the agencia
	 */
	public int getAgencia() {
		return agencia;
	}
	/**
	 * @param agencia the agencia to set
	 */
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	/**
	 * @return the limite
	 */
	public double getLimite() {
		return limite;
	}
	/**
	 * @param limite the limite to set
	 */
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public void depositarValor(double valor) throws Exception {
		double saque;
		if (valor <= 0) {
			throw new Exception("Valor do depósito menor que 0");
		}
		double valorNovo;
		valorNovo = this.getSaldo() + valor;
		this.setSaldo(valorNovo);
		
	}
	
	public Double saque(double valor) throws Exception{
		double saque;
		if (valor <= 0) {
			throw new Exception("Valor saque menor que 0");
		}
		if (getSaldo() + getLimite() >= valor){
			saque = getSaldo() - valor;
			setSaldo(saque);
			return getSaldo() + getLimite();
		}
		throw new Exception("Saldo insuficiente");
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Conta [ numero=" + numero + ", agencia=" + agencia + ", saldo=" + saldo + ", limite=" + limite + "]";
	}
	
	
}
