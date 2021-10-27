package prime.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.prime.controller.BancoController;
import br.com.prime.exception.BancoException;
import br.com.prime.model.ContaModel;
import br.com.prime.model.enums.StatusContaEnum;
import br.com.prime.model.enums.TipoContaEnum;
import br.com.prime.model.httprequest.ContaCadAtuModel;
import br.com.prime.model.httprequest.TransacaoModel;
import br.com.prime.service.ContaService;
import br.com.prime.service.TransacaoService;

public class BancoControllerTest {

	@InjectMocks
	private BancoController controller;
	
	@Mock
	private ContaService conta;
	
	@Mock
	private TransacaoService transacaoService;
	
	private ContaCadAtuModel contaCadAtu = new ContaCadAtuModel();
	
	@Before
	public void inciaMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void listaContaTest() throws BancoException {
		Mockito.when(conta.listaConta()).thenReturn(mockRetornoLista());
		
		Response listaConta = controller.listaConta();
		assertEquals(200, listaConta.getStatus());
		assertNotNull(listaConta);
	}
	
	@Test
	public void cadContaTest() throws BancoException {
		//Response cadConta = controller.cadConta(contaCadAtu);
		//assertEquals(201, cadConta.getStatus());
	}
	
	@Test
	public void transacaoTest() throws BancoException {
		Response retorno = controller.transacao(transacao());
		assertEquals(200, retorno.getStatus());
	}
	
	@Test
	public void deleteTest() throws BancoException {
		Response confimacao = controller.deletaConta(1, 0);
		assertEquals(200, confimacao.getStatus());
	}
	
	private List<ContaModel> mockRetornoLista() {
		List<ContaModel> lsContas = new ArrayList<>();
		ContaModel conta = new ContaModel();

		//conta.setNomeCliente("Lucca Nogueira");
		conta.setTipoConta(TipoContaEnum.CC);
		conta.setSenha(1234);
		conta.setStatusConta(StatusContaEnum.ATIVO);
		conta.setnAg(1478);
		conta.setnConta(147852);
		conta.setSaldo(0.00);
		
		lsContas.add(conta);
	
		return lsContas;
	}
	
	private TransacaoModel transacao() {
		TransacaoModel transacaoModel = new TransacaoModel();
		
		transacaoModel.setOperacao(1);
		transacaoModel.setnConta(147852);
		transacaoModel.setnContaDestino(null);
		transacaoModel.setSenhaConta(1234);
		transacaoModel.setValor(100.00);
		
		return transacaoModel;
	}
}
