package br.com.ags.bo.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.ags.bo.Conta;
import br.com.ags.bo.ContaCorrente;
import br.com.ags.bo.ContaPoupanca;

public class ContaTest {
	@Before
	public void init() throws Exception{
		ContaPoupanca contaPoupanca = new ContaPoupanca(132);
		contaPoupanca.setLimite(400);
	}
	
	@Test
	public void incluirConta(){
		Conta contas = new Conta(1) {
		};
		assertNotNull(contas);
	}
	
	@Test
	public void depositarContaCorrente() throws Exception{
		ContaCorrente contaCorrente = new ContaCorrente(132);
		contaCorrente.setLimite(1800);
		contaCorrente.depositarValor(600);
	}
	
	@Test
	public void depositarContaPoupanca() throws Exception{
		ContaPoupanca contaPoupanca = new ContaPoupanca(132);
		contaPoupanca.setLimite(3500);
		contaPoupanca.depositarValor(300);
		
	}
}