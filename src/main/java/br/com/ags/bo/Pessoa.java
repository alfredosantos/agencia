package br.com.ags.bo;

import br.com.ags.common.Cpf;
import br.com.ags.common.Email;
import br.com.ags.common.Rg;

public class Pessoa {
	String nome;
	String dataNacimento;
	Endereco endereco;
	Cpf cpf;
	Email email;
	Rg rg;
	
	public Pessoa(String nome, Cpf cpf){
		setCpf(cpf);
		setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNacimento() {
		return dataNacimento;
	}
	public void setDataNacimento(String dataNacimento) {
		this.dataNacimento = dataNacimento;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Cpf getCpf() {
		return cpf;
	}
	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public Rg getRg() {
		return rg;
	}
	public void setRg(Rg rg) {
		this.rg = rg;
	}
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", dataNacimento=" + dataNacimento + ", endereco=" + endereco + ", cpf=" + cpf
				+ ", email=" + email + ", rg=" + rg + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	 
}
