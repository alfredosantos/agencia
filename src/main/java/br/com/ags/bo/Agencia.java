package br.com.ags.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Agencia {

	HashMap<Pessoa, List<Conta>> mapaPessoaConta = new HashMap<>();

	/**
	 * @return the mapaPessoaConta
	 */
	public HashMap<Pessoa, List<Conta>> getMapaPessoaConta() {
		return mapaPessoaConta;
	}

	/**
	 * @param mapaPessoaConta
	 *            the mapaPessoaConta to set
	 */
	public void setMapaPessoaConta(HashMap<Pessoa, List<Conta>> mapaPessoaConta) {
		this.mapaPessoaConta = mapaPessoaConta;
	}

	public void registrarPessoa(Pessoa p) {
		this.mapaPessoaConta.put(p, new ArrayList<>());
	}

	public boolean clientePossuiConta(Pessoa pessoa, int numeroConta) {
		if (existePessoa(pessoa)) {
			return mapaPessoaConta.get(pessoa).stream().filter(conta -> conta.getNumero() == numeroConta)
					.findFirst() != null;
		}
		return false;
	}

	public Boolean existePessoa(Pessoa pessoa) {
		return mapaPessoaConta.get(pessoa) != null;
	}

	public List<Conta> listaContasPessoa(Pessoa pessoa) {
		if (existePessoa(pessoa)) {
			return new ArrayList<>();
		}
		List<Conta> contaOp = mapaPessoaConta.get(pessoa);
		return contaOp;
	}

	public Conta getConta(Pessoa pessoa, int numeroConta) {
		if (clientePossuiConta(pessoa, numeroConta)) {
			return mapaPessoaConta.get(pessoa).stream().filter(conta -> conta.getNumero() == numeroConta).findFirst()
					.get();
		}
		return null;
	}

	public Boolean incluirConta(Pessoa pessoa, Conta conta) {
		if (clientePossuiConta(pessoa, conta.getNumero())) {
			List<Conta> contas = mapaPessoaConta.get(pessoa);
			contas.add(conta);
			mapaPessoaConta.put(pessoa, contas);
			return true;
		}
		return false;
	}

	public Boolean depositoConta(Pessoa pessoa, int numeroConta, double valor) throws Exception {
		if ((clientePossuiConta(pessoa, numeroConta))) {
			getConta(pessoa, numeroConta).depositarValor(valor);
			return true;
		} else {
			return false;
		}
	}

	public Boolean removerConta(Pessoa pessoa, int numeroConta) {
		if (clientePossuiConta(pessoa, numeroConta)) {
			List<Conta> contas = mapaPessoaConta.get(pessoa);
			return contas.removeIf(conta -> conta.getNumero() == numeroConta);
		}
		return false;
	}

	public Boolean saqueConta(Pessoa pessoa, int numeroConta, double valor) throws Exception {
		if (clientePossuiConta(pessoa, numeroConta)) {
			mapaPessoaConta.get(pessoa).stream().filter(conta -> conta.getNumero() == numeroConta)
				.findFirst().get().saque(valor);
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agencia [ mapaPessoaConta=" + mapaPessoaConta + "]";
	}

}
