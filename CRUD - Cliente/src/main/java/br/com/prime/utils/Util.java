package br.com.prime.utils;

import java.util.List;

import br.com.prime.model.ClienteModel;

public class Util {
	
	public static ClienteModel percorrerLista(int id, List<ClienteModel> clientes) {
		for(ClienteModel cliente: clientes) {
			if(cliente.getId().equals(id)) {
				return cliente;
			}
		}
		return null;
	}
}
