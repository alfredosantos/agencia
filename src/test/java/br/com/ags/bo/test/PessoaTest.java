package br.com.ags.bo.test;

import org.junit.Test;

import br.com.ags.bo.Pessoa;
import br.com.ags.common.Cpf;

public class PessoaTest {

	@Test
	public void incluirPessoa() throws Exception {
		Pessoa pessoa = new Pessoa("Ad�o", Cpf.of("13803623855"));
		pessoa.setNome("Ad�o");
		pessoa.setDataNacimento("11/10/1979");
	}
}
