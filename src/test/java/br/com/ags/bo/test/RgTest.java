package br.com.ags.bo.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.ags.common.Rg;

public class RgTest {

	@Test
	private void inclusaoRg() throws Exception {
		Rg.of("29.386.947-7");
	}
	
	@Test
	private void inclusaoRgErro() {
		try {
			Rg.of("91.122.534-1");
		} catch (Exception e) {
			assertTrue("Rg Inválido",e instanceof Exception); 
		}
	}
}