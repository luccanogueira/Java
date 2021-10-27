package br.com.prime.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.prime.comum.controller.BaseController;
import br.com.prime.exception.AppValidationException;
import br.com.prime.exception.ClienteException;
import br.com.prime.model.ClienteModel;
import br.com.prime.model.httprequest.ClienteAlterarRequest;
import br.com.prime.model.httprequest.ClienteRequest;
import br.com.prime.service.ClienteService;

@Path("/clientes")
public class ClienteController extends BaseController {

	@Inject
	private ClienteService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaCliente() throws ClienteException {
		List<ClienteModel> clientes = this.service.listaCliente();
		return Response.status(Status.OK).entity(clientes).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response incluirCliente(ClienteRequest request) throws AppValidationException {
		this.validaObjeto(request);
		this.service.incluirCliente(request);
		return Response.status(Status.CREATED).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletarCliente(@PathParam("id") int id) throws ClienteException {
		this.service.deletarCliente(id);
		return Response.status(Status.OK).entity("Operação realizada com sucesso!").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterarCliente(ClienteAlterarRequest request) throws ClienteException {
		this.service.alterar(request);
		return Response.status(Status.OK).entity("Operação realizada com sucesso!").build();
	}
}
