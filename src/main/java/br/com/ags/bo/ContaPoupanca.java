package br.com.ags.bo;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca(int numero) {
		super(numero);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void depositarValor(double valor) {
		double valorPoup;
		valorPoup = (this.getSaldo() + valor) * 1.05 ;
		this.setSaldo(valorPoup);
		
	}

}
