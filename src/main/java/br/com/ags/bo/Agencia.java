package br.com.ags.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Agencia {

	HashMap<Pessoa, List<Conta>> mapaPessoaConta = new HashMap<>();

	/**
	 * @return the mapaPessoaConta
	 */
	public HashMap<Pessoa, List<Conta>> getMapaPessoaConta() {
		return mapaPessoaConta;
	}

	/**
	 * @param mapaPessoaConta the mapaPessoaConta to set
	 */
	public void setMapaPessoaConta(HashMap<Pessoa, List<Conta>> mapaPessoaConta) {
		this.mapaPessoaConta = mapaPessoaConta;
	}
	
	public void registrarPessoa(Pessoa p){
		this.mapaPessoaConta.put(p, new ArrayList<>());
	}
	
	public boolean clientePossuiConta(Pessoa pessoa , int numeroConta){
		Optional<Conta> contaOp = mapaPessoaConta.get(pessoa).stream().filter(conta -> conta.getNumero() == numeroConta).findFirst();
		return contaOp.isPresent();
	}
	
	public Conta getConta(Pessoa pessoa, int numeroConta){
		if ( mapaPessoaConta.get(pessoa) == null){
			return null;
		}
		Optional<Conta> contaOp = mapaPessoaConta.get(pessoa).stream().filter(conta -> conta.getNumero() == numeroConta).findFirst();
		if (contaOp.isPresent())
			return contaOp.get();
		return null;
	}
	
	public Boolean incluirConta(Pessoa pessoa, Conta conta){
		if (clientePossuiConta(pessoa, conta.getNumero())){
			return false;	
		}else{
			List<Conta> contas = mapaPessoaConta.get(pessoa);
			contas.add(conta);
			mapaPessoaConta.put(pessoa, contas);
			return true;
		}
	}
	
	public Boolean depositoConta(Pessoa pessoa, int numeroConta, double valor){
		if (getConta(pessoa, numeroConta) == null){
			return false;	
		};
		Optional<Conta> contaOp =  mapaPessoaConta.get(pessoa).stream().filter(conta -> conta.getNumero() == numeroConta).findFirst();
		if (contaOp.isPresent()){
			contaOp.get().depositarValor(valor);
			return true;
			}else{
				return false;
			}
	}
	
	public Boolean removerConta(Pessoa pessoa, int numeroConta){
		if (getConta(pessoa, numeroConta) == null){
			return false;	
		};
		List<Conta> contas = mapaPessoaConta.get(pessoa);
		return contas.removeIf(conta -> conta.getNumero() == numeroConta);
	}
	
	public Boolean saqueConta(Pessoa pessoa, int numeroConta, double valor) throws Exception{
		if (getConta(pessoa, numeroConta) == null){
			return false;	
		};
		Optional<Conta> contaOp =  mapaPessoaConta.get(pessoa).stream().filter(conta -> conta.getNumero() == numeroConta).findFirst();
		if (contaOp.isPresent()){
			contaOp.get().saque(valor);
			return true;
			}else{
				return false;
			}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agencia [ mapaPessoaConta=" + mapaPessoaConta + "]";
	}
	
}
