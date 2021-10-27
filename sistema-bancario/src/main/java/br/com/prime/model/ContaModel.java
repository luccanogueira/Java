package br.com.prime.model;

import br.com.prime.model.enums.StatusContaEnum;
import br.com.prime.model.enums.TipoContaEnum;

public class ContaModel {

	private ClienteModel cliente;
	private TipoContaEnum tipoConta;
	private Integer senhaConta;
	private StatusContaEnum statusConta;
	private Integer nConta;
	private Integer nAgn;
	private Double saldo = 0.00;
	
	public ContaModel() {
		super();
	}
	
	public ContaModel(ClienteModel cliente, TipoContaEnum tipoConta, Integer senhaConta, StatusContaEnum statusConta,
			Integer nConta, Integer nAg, Double saldo) {
		super();
		this.cliente = cliente;
		this.tipoConta = tipoConta;
		this.senhaConta = senhaConta;
		this.statusConta = statusConta;
		this.nConta = nConta;
		this.nAgn = nAg;
		this.saldo = saldo;
	}

	public ClienteModel getCliente() {
		return cliente;
	}
	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
	public TipoContaEnum getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(TipoContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}
	public Integer getSenha() {
		return senhaConta;
	}
	public void setSenha(Integer senhaConta) {
		this.senhaConta = senhaConta;
	}
	public StatusContaEnum getStatusConta() {
		return statusConta;
	}
	public void setStatusConta(StatusContaEnum statusConta) {
		this.statusConta = statusConta;
	}
	public Integer getnConta() {
		return nConta;
	}
	public void setnConta(Integer nConta) {
		this.nConta = nConta;
	}
	public Integer getnAg() {
		return nAgn;
	}
	public void setnAg(Integer nAg) {
		this.nAgn = nAg;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
}
