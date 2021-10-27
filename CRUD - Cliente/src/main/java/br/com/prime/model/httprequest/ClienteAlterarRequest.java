package br.com.prime.model.httprequest;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class ClienteAlterarRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Não pode ser nulo/vazio")
	private Integer id;
	private String nome;
	private String sobrenome;
	private String email;
	private String telefone;
	private String cpf;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
