package br.com.ags.bo.test;

import org.junit.Test;

import br.com.ags.common.Email;

public class EmailTest {
	@Test
	public void IncluirEmail() throws Exception {
		try {
			Email.of("adao@gmail.com.br");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}