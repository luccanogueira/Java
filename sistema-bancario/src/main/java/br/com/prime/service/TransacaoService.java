package br.com.prime.service;

import javax.enterprise.context.RequestScoped;
import org.springframework.http.HttpStatus;
import br.com.prime.dao.ContaDao;
import br.com.prime.exception.BancoException;
import br.com.prime.model.ContaModel;
import br.com.prime.model.enums.StatusContaEnum;
import br.com.prime.model.httprequest.TransacaoModel;
import br.com.prime.utils.Util;

@RequestScoped
public class TransacaoService extends ContaDao {

	public void transacao(TransacaoModel request) throws BancoException {
		switch (request.getOperacao()) {
		case 1:
			ContaModel contaDeposito = Util.localizaConta(request.getnConta(), request.getnAgn(), lsContas);
			validacaoOperacao(request, contaDeposito);
			this.depositoConta(contaDeposito, request.getValor());
			break;
		case 2:
			ContaModel contaSaque = Util.localizaConta(request.getnConta(), request.getnAgn(), lsContas);
			validacaoOperacao(request, contaSaque);
			this.saqueConta(contaSaque, request.getValor());
			break;
		case 3:
			ContaModel contaDestino = Util.localizaConta(request.getnContaDestino(), request.getnAgnDestino(),
					lsContas);
			ContaModel contaOrigem = Util.localizaConta(request.getnConta(), request.getnAgn(), lsContas);
			if (validacaoOperacao(request, contaOrigem)
					&& contaDestino.getStatusConta().equals(StatusContaEnum.ATIVO)) {
				this.tranferenciaConta(contaOrigem, contaDestino, request.getValor());
			} else
				throw new BancoException("AVALIACAO-404", new Exception("A operação não pode ser realizada."),
						HttpStatus.FORBIDDEN);
			break;
		default:
			throw new BancoException("AVALIACAO-404", new Exception("Operação requisitada não existe."),
					HttpStatus.NOT_FOUND);
		}
	}

	public boolean validacaoOperacao(TransacaoModel request, ContaModel contaOrigem) throws BancoException {
		if (request.getValor() != null && request.getValor() > 0 
				&& request.getSenhaConta().equals(contaOrigem.getSenha())
				&& contaOrigem.getStatusConta().equals(StatusContaEnum.ATIVO)) {
			return true;
		} else {
			throw new BancoException("ERRO!", new Exception("A operação não pode ser realizada."),
					HttpStatus.FORBIDDEN);
		}
	}
}
