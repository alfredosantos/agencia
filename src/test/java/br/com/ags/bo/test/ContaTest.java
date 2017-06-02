package br.com.ags.bo.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.ags.bo.Conta;

public class ContaTest {

	@Test
	public void incluirConta(){
		Conta conta = new Conta(1) {
		};
		assertNotNull(conta);
	}
}