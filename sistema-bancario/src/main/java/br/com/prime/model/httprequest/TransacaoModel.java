package br.com.prime.model.httprequest;

import javax.validation.constraints.NotBlank;

public class TransacaoModel {

	@NotBlank
	private Integer operacao;
	@NotBlank
	private Integer nConta;
	@NotBlank
	private Integer nAgn;
	@NotBlank
	private Integer senhaConta;
	@NotBlank
	private Integer nContaDestino;
	@NotBlank
	private Integer nAgnDestino;
	@NotBlank
	private Double valor;
	
	public TransacaoModel() {
		super();
	}
	
	public TransacaoModel(@NotBlank Integer operacao, @NotBlank Integer nConta, @NotBlank Integer nAgn,
			@NotBlank Integer senhaConta, @NotBlank Integer nContaDestino, @NotBlank Integer nAgnDestino,
			@NotBlank Double valor) {
		super();
		this.operacao = operacao;
		this.nConta = nConta;
		this.nAgn = nAgn;
		this.senhaConta = senhaConta;
		this.nContaDestino = nContaDestino;
		this.nAgnDestino = nAgnDestino;
		this.valor = valor;
	}

	public Integer getOperacao() {
		return operacao;
	}
	public void setOperacao(Integer operacao) {
		this.operacao = operacao;
	}
	public Integer getnConta() {
		return nConta;
	}
	public void setnConta(Integer nConta) {
		this.nConta = nConta;
	}
	public Integer getnAgn() {
		return nAgn;
	}
	public void setnAgn(Integer nAgn) {
		this.nAgn = nAgn;
	}
	public Integer getSenhaConta() {
		return senhaConta;
	}
	public void setSenhaConta(Integer senhaConta) {
		this.senhaConta = senhaConta;
	}
	public Integer getnContaDestino() {
		return nContaDestino;
	}
	public void setnContaDestino(Integer nContaDestino) {
		this.nContaDestino = nContaDestino;
	}
	public Integer getnAgnDestino() {
		return nAgnDestino;
	}
	public void setnAgnDestino(Integer nAgnDestino) {
		this.nAgnDestino = nAgnDestino;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
