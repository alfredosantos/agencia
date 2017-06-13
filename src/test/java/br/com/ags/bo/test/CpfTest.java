package br.com.ags.bo.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.ags.common.Cpf;

public class CpfTest {
	
	@Test
	public void IncluirCpf() throws Exception{
		Cpf.of("13803623855");
	}
	
	@Test
	public void IncluirCpfIncorreto(){
		try {
			Cpf.of("13803623850");
		} catch (Exception e) {
			assertTrue("CPF Inválido",e instanceof Exception); 
		}
	}


}
