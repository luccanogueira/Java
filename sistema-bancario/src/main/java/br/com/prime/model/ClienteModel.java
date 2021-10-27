package br.com.prime.model;

public class ClienteModel {
	String nome;
	String cpf;
	String telefone;
	String email;
	String cep;
	EnderecoModel endereco;
	
	public ClienteModel() {
		super();
	}
	
	public ClienteModel(String nome, String cpf, String telefone, String email, String cep, EnderecoModel endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.cep = cep;
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public EnderecoModel getEndereço() {
		return endereco;
	}
	public void setEndereço(EnderecoModel endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "ClienteModel [nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email + ", cep="
				+ cep + ", endereço=" + endereco + "]";
	}
}
