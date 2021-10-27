package br.com.prime.dao;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

import br.com.prime.exception.ClienteException;
import br.com.prime.model.ClienteModel;
import br.com.prime.model.httprequest.ClienteAlterarRequest;
import br.com.prime.model.httprequest.ClienteRequest;
import br.com.prime.utils.Util;

@RequestScoped
public class ClienteDao {

	private static List<ClienteModel> clientes = new ArrayList<>();
	
	private static Integer id = 0;
	
	public List<ClienteModel> listaCliente() throws ClienteException {
		if(clientes.size() == 0) {
			throw new ClienteException("AVALIACAO-404", new Exception("Lista vazia!"), HttpStatus.NOT_FOUND);
		}
		
		return this.clientes;
	}

	public void deletarCliente(int id) throws ClienteException {
		ClienteModel old = new ClienteModel();
		
		old = Util.percorrerLista(id, clientes);
		
		if(old.equals(null)) {
			throw new ClienteException("AVALIACAO-404", new Exception("Nao ha dados!"), HttpStatus.NOT_FOUND);
		}
		
		clientes.remove(old);
	}

	public boolean consultarClienteId(int id) {
		for(ClienteModel cliente: clientes) {
			if(cliente.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public void incluirCliente(ClienteRequest request) {
		ClienteModel obj = criaModelCliente(request);
		obj.setId(id+=1);
		this.clientes.add(obj);
	}

	public void alterar(ClienteAlterarRequest request) throws ClienteException {
		ClienteModel obj = criaModelCliente(request);
		
		ClienteModel old = new ClienteModel();
		
		old = Util.percorrerLista(request.getId(), clientes);
		
		if(old.equals(null)) {
			throw new ClienteException("AVALIACAO-404", new Exception("Nao ha dados!"), HttpStatus.NOT_FOUND);
		}
		
		this.clientes.remove(old);
		this.clientes.add(obj);
	}
	
	private ClienteModel criaModelCliente(Object request) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(request, ClienteModel.class);
	}
}
