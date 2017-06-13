package br.com.ags.bo.test;

import org.junit.Test;

import br.com.ags.bo.Endereco;

public class EnderecoTest {

	@Test
	public void incluirEndereco() {
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua Atlantica");
		endereco.setNumero(105);
		endereco.setComplemento("AB");
	}
}