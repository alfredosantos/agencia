package br.com.ags.bo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import br.com.ags.bo.Agencia;
import br.com.ags.bo.ContaCorrente;
import br.com.ags.bo.Pessoa;
import br.com.ags.common.Cpf;

public class AgenciaTest {
	private static Agencia agencia;
	private static Pessoa pessoa;
	
	@Before
	public void init() throws Exception{
		agencia = new Agencia();
		pessoa = new Pessoa("Jose", Cpf.of("13803623855"));
		agencia.registrarPessoa(pessoa);
		agencia.incluirConta(pessoa, new ContaCorrente(5));
	}
	
	@Test
	public void incluirConta(){
		assertNotNull(agencia.getConta(pessoa, 5));
	}
	
	@Test
	public void depositoConta() throws Exception{
		agencia.depositoConta(pessoa, 5, 1000);
		assertEquals(1000, agencia.getConta(pessoa, 5).getSaldo(),0.000001);
	}

	@Test
	public void removerConta() throws Exception{
		agencia.removerConta(pessoa, 5);
		assertNull(agencia.getConta(pessoa, 5));

	}
	
	@Test
	public void saqueConta() throws Exception{
		agencia.depositoConta(pessoa, 5, 1000);
		agencia.saqueConta(pessoa, 5, 900);
		assertEquals(100, agencia.getConta(pessoa, 5).getSaldo(),0.000001);

	}
}
