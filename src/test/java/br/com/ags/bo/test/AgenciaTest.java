package br.com.ags.bo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.ags.bo.Agencia;
import br.com.ags.bo.ContaCorrente;
import br.com.ags.bo.Pessoa;
import br.com.ags.common.Cpf;

public class AgenciaTest {
	@Test
	public void incluirConta() throws Exception{
		Agencia b = new Agencia();
		b.incluirConta(new Pessoa("Jose", Cpf.of("13803623855")), new ContaCorrente());
		assertNotNull(b);
	}
	
	@Test
	public void depositoConta() throws Exception{
		Agencia b = new Agencia();
		Pessoa p = new Pessoa("Jose", Cpf.of("13803623855")); new ContaCorrente();
		b.depositoConta(p, 5, 1000);

	}

	@Test
	public void removerConta() throws Exception{
		Agencia b = new Agencia();
		Pessoa p = new Pessoa("Jose", Cpf.of("13803623855")); new ContaCorrente();
		b.removerConta(p, 5);
		assertNotNull(b);

	}
}
