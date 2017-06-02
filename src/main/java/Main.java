import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.ags.bo.Agencia;
import br.com.ags.bo.Conta;
import br.com.ags.bo.ContaCorrente;
import br.com.ags.bo.ContaPoupanca;
import br.com.ags.bo.Endereco;
import br.com.ags.bo.Pessoa;
import br.com.ags.common.Cpf;
import br.com.ags.common.Email;
import br.com.ags.common.Rg;

public class Main {

	static Agencia agencia = new Agencia();
	static Pessoa pessoaExterna;
	public static void main(String[] args) throws Exception {
		
		Email.isEmail(null);
		
		Pessoa pessoa = new Pessoa("Adão", Cpf.of("13803623855"));
		pessoa.setNome("Adão");
		pessoa.setDataNacimento("11/10/1979");
		inclusaoEndereco(pessoa);
		//inclusaoCpf(pessoa);
		inclusaoEmail(pessoa);
		inclusaoRg(pessoa);
		inclusaoDeAgencia(pessoa);
		System.out.println(pessoa);
		pessoaExterna = pessoa;
		testarAgencia();
		
}

	private static void testarAgencia() {
		
		//agencia.incluirConta(new Pessoa(), new ContaCorrente());
		//agencia.removerConta(new Pessoa(), 21);
		agencia.getConta(pessoaExterna, 1);
	}

	public static void inclusaoEndereco(Pessoa pessoa){
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua Atlantica");
		endereco.setNumero(105);
		endereco.setComplemento("AB");
		pessoa.setEndereco(endereco);
    }
	
    public static void inclusaoCpf(Pessoa pessoa){
    	try {
			pessoa.setCpf(Cpf.of("13803623855"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    public static void inclusaoEmail(Pessoa pessoa){
		try {
			pessoa.setEmail(Email.of("adao@gmail.com.br"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    private static void inclusaoRg(Pessoa pessoa) {
    	try {
    		pessoa.setRg(Rg.of("91.122.534-1"));
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static void inclusaoDeAgencia(Pessoa pessoa){
    	
    	ContaCorrente contaCorrente = new ContaCorrente(1);
		contaCorrente.setAgencia(185);
		contaCorrente.setLimite(500);
		
		ContaCorrente contaCorrente2 = new ContaCorrente(2);
		contaCorrente2.setAgencia(185);
		
		contaCorrente2.setLimite(1500);
		
		ContaPoupanca contaPoupanca = new ContaPoupanca(3);
		contaPoupanca.setAgencia(185);
		contaPoupanca.setNumero(3);
		contaPoupanca.setLimite(5400);
		
		ContaPoupanca contaPoupanca2 = new ContaPoupanca(4);
		contaPoupanca2.setAgencia(185);
		
		contaPoupanca2.setLimite(5006);
		
		ContaPoupanca contaPoupanca3 = new ContaPoupanca(5);
		contaPoupanca3.setAgencia(185);
		
		contaPoupanca3.setLimite(4500);
		
		ContaCorrente contaCorrente4 = new ContaCorrente(6);
		contaCorrente4.setAgencia(185);
		contaCorrente4.setLimite(7500);

		HashMap<Pessoa, List<Conta>> mapaAgenciaPessoaConta = new HashMap<Pessoa, List<Conta>>();
		List<Conta> listContas = new ArrayList<Conta>();
		listContas.add(contaCorrente);
		listContas.add(contaCorrente2);

		mapaAgenciaPessoaConta.put(pessoa, listContas);
		
		agencia.setMapaPessoaConta(mapaAgenciaPessoaConta);
		
		agencia.incluirConta(pessoa, contaPoupanca);
		agencia.incluirConta(pessoa, contaPoupanca2);
		agencia.incluirConta(pessoa, contaPoupanca3);
		
		agencia.depositoConta(pessoa, 5, 1000);
		
		agencia.removerConta(pessoa, 3);
		
		try {
			agencia.saqueConta(pessoa, 5, 100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		agencia.getMapaPessoaConta();
		
		System.out.println(agencia);
		}
}

