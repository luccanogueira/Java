package br.com.prime.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.springframework.http.HttpStatus;

import br.com.prime.dao.ClienteDao;
import br.com.prime.exception.ClienteException;
import br.com.prime.model.ClienteModel;
import br.com.prime.model.httprequest.ClienteAlterarRequest;
import br.com.prime.model.httprequest.ClienteRequest;

@RequestScoped
public class ClienteService {

	@Inject
	private ClienteDao dao;

	public List<ClienteModel> listaCliente() throws ClienteException {
		return this.dao.listaCliente();
	}

	public void incluirCliente(ClienteRequest request) {
		this.dao.incluirCliente(request);
	}

	public void deletarCliente(int id) throws ClienteException {
		boolean clienteExiste = verificaCliente(id);

		if (!clienteExiste) {
			throw new ClienteException("AVALIACAO-404", new Exception("Cliente nao existe!"), HttpStatus.NOT_FOUND);
		}

		this.dao.deletarCliente(id);
	}

	public void alterar(ClienteAlterarRequest request) throws ClienteException {
		boolean clienteExiste = verificaCliente(request.getId());

		if (!clienteExiste) {
			throw new ClienteException("AVALIACAO-404", new Exception("Cliente nao existe!"), HttpStatus.NOT_FOUND);
		}

		this.dao.alterar(request);
	}

	private boolean verificaCliente(int id) {
		boolean clienteExiste = this.dao.consultarClienteId(id);
		return clienteExiste;
	}

}
