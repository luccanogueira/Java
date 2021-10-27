package br.com.prime.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import br.com.prime.exception.BancoException;
import br.com.prime.model.ClienteModel;
import br.com.prime.model.ContaModel;
import br.com.prime.model.httprequest.ContaCadAtuModel;
import br.com.prime.service.ContaService;

@RequestScoped 
public class ContaDao{
	
	@Inject
	private ContaService service;
	
	protected static List<ContaModel> lsContas = new ArrayList<ContaModel>();
	
	private static ContaModel mapModelConta(Object requestConta) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(requestConta, ContaModel.class);
	}
	
	public List<ContaModel> listConta() throws BancoException {
		return lsContas;
	}
	
	public void cadNovaConta(ContaCadAtuModel request) throws BancoException { 
		request.setnConta(geraConta(request.getnConta()));
		request.setnAg(geraAgn(request.getnAg()));
		
		service.comparaContaAgn(request);
		ContaModel novaConta = mapModelConta(request);
		lsContas.add(novaConta);
	}
	
	public void depositoConta(ContaModel conta, Double valor) throws BancoException {
		conta.setSaldo(conta.getSaldo() + valor);
	}		

	public void saqueConta(ContaModel conta, Double valor) throws BancoException {
			conta.setSaldo(conta.getSaldo() - valor);
	}
	
	public void tranferenciaConta(ContaModel contaOrigem, ContaModel contaDestino, Double valor) throws BancoException {
			this.depositoConta(contaDestino, valor);
			this.saqueConta(contaOrigem, valor);
	}

	public void deletaConta(ContaModel conta) throws BancoException {
			lsContas.remove(conta);
	}
	
	public int geraConta(Integer nConta) {
		nConta = new Random().nextInt(9999);
		return nConta;
	}
	public int geraAgn(Integer nAgn) {
		nAgn = (new Random().nextInt(999));
		return nAgn;
	}
}
