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
import br.com.prime.exception.BancoException;
import br.com.prime.model.ContaModel;
import br.com.prime.model.httprequest.ContaCadAtuModel;
import br.com.prime.model.httprequest.TransacaoModel;
import br.com.prime.service.ContaService;
import br.com.prime.service.TransacaoService;

@Path("/banco")
public class BancoController {

	@Inject
	private ContaService conta;
	@Inject
	private TransacaoService transacao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listaConta() throws BancoException {
		List<ContaModel> lsContas = this.conta.listaConta();
		return Response.status(Status.OK).entity(lsContas).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadConta(ContaCadAtuModel requestConta) throws BancoException {
		this.conta.cadastroNovaConta(requestConta);
		return Response.status(Status.CREATED).entity("Conta criada com sucesso!").build();
	}
	
	@PUT
	@Path("/operacao")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response transacao(TransacaoModel request) throws BancoException {
		this.transacao.transacao(request);
		return Response.status(Status.OK).entity("Operação realizado com sucesso.").build();
	}
	
	@DELETE
	@Path("{nConta}/{nAgn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletaConta(@PathParam("nConta")int nConta, @PathParam("nAgn") int nAgn) throws BancoException{
		this.conta.delete(nConta, nAgn);
		return Response.status(Status.OK).entity("Conta deletada com sucesso.").build();
	}
}
