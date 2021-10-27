package br.com.prime.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.prime.dao.ContaDao;
import br.com.prime.exception.BancoException;
import br.com.prime.model.ClienteModel;
import br.com.prime.model.ContaModel;
import br.com.prime.model.EnderecoModel;
import br.com.prime.model.enums.StatusContaEnum;
import br.com.prime.model.httprequest.ContaCadAtuModel;
import br.com.prime.utils.Util;

@RequestScoped
public class ContaService extends ContaDao {

	public List<ContaModel> listaConta() throws BancoException {
		if (lsContas.isEmpty()) {
			throw new BancoException("AVALIACAO-404", new Exception("Não existem contas cadastradas."),
					HttpStatus.NOT_FOUND);
		}
		return this.listConta();
	}

	public void cadastroNovaConta(ContaCadAtuModel request) throws BancoException {
		validaCep(request);
		this.cadNovaConta(request);
	}

	public boolean validaCep(ContaCadAtuModel request) {
		request.getCliente().getCep().replace("-", "");
		request.getCliente().getCep().replace(".", "");

		if (request.getCliente().getCep().length() == 8 
				&& request.getCliente().getCep().substring(0, 8).matches("[0-9]*")) {
			this.cadastroEnderecao(request);
		}
		return false;
	}

	public ContaCadAtuModel cadastroEnderecao(ContaCadAtuModel request) {
		String urlConexao = "http://viacep.com.br/ws/" + request.getCliente().getCep() + "/json";
		int codigoSucesso = 200;

		try {
			URL url = new URL(urlConexao);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			if (conexao.getResponseCode() != codigoSucesso)
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

			BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream(), "utf-8"));
			String jsonEmString = Util.converteJsonEmString(resposta);

			ObjectMapper mapper = new ObjectMapper();
			EnderecoModel endereco = mapper.readValue(jsonEmString, EnderecoModel.class);
			//endereco.setnEnd(requestCliente.getnEnd());
			request.getCliente().setEndereço(endereco);
			return request;
		} catch (Exception e) {

		}
		return null;
	}

	public void delete(int nConta, int nAgn) throws BancoException {
		ContaModel conta = Util.localizaConta(nConta, nAgn, lsContas);
		if (conta.getStatusConta().equals(StatusContaEnum.INATIVO) && conta.getSaldo() >= 0) {
			this.deletaConta(conta);
		} else
			throw new BancoException("ERRO!", new Exception("A conta não pode ser excluida."), HttpStatus.FORBIDDEN);
	}

	public ContaCadAtuModel comparaContaAgn(ContaCadAtuModel requestConta) throws BancoException {
		int i = 1;
		while (!validaContaAgn(requestConta.getnConta(), requestConta.getnAg())) {
			if (i <= 3) {
				requestConta.setnConta(geraConta(requestConta.getnConta()));
				requestConta.setnAg(geraAgn(requestConta.getnAg()));
				this.validaContaAgn(requestConta.getnConta(), requestConta.getnAg());
				i++;
			} else
				throw new BancoException("ERRO", new Exception("Não foi possivel realizar o cadastro."),
						HttpStatus.BAD_REQUEST);
		}
		return requestConta;
	}

	public boolean validaContaAgn(Integer nConta, Integer nAgn) {
		for (ContaModel conta : lsContas) {
			if (nConta == conta.getnConta() && nAgn == conta.getnAg()) {
				return false;
			}
		}
		return true;
	}
}
