//package prime.service;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import br.com.prime.dao.ContaDao;
//import br.com.prime.exception.BancoException;
//import br.com.prime.model.ContaModel;
//import br.com.prime.model.enums.StatusContaEnum;
//import br.com.prime.model.enums.TipoContaEnum;
//import br.com.prime.model.httprequest.ContaCadAtuModel;
//import br.com.prime.service.ContaService;
//
//public class ContaServiceTest {
//
//	@InjectMocks
//	private ContaService contaService;
//	
//	@Mock
//	private ContaDao dao;
//	
//	private ContaService serve = mock(ContaService.class);
//	private ContaCadAtuModel request = new ContaCadAtuModel();
//	
//	@Before
//	public void initMocks() {
//		MockitoAnnotations.initMocks(this);
//	}
//	
//	@Test
//	public void listaContaTest() throws BancoException {
//		List<ContaModel> lista = mockRetornoLista();
//		Mockito.when(contaService.listaConta()).thenReturn(lista);
//		Mockito.verify(contaService).listConta();
//	}
//	
//	@Test(expected = Exception.class)
//	public void listaContaVaziaTest() throws BancoException {
//		Exception ex = new Exception();
//		
//	}
//	
//	@Test
//	public void cadastroNovaContaTest() throws BancoException {
//	//	verify(dao).cadNovaConta(request);
//	}
//	
//	@Test
//	public void comparaContaTest() throws BancoException {
//		ContaCadAtuModel comparacao = contaService.comparaContaAgn(request);
//		assertEquals(comparacao, comparacao);
//	}
//	
//	@Test
//	public void validaContaAgnTest() {
//		boolean valida = contaService.validaContaAgn(1, 1);
//		assertEquals(true, valida);
//	}
//	
//	private List<ContaModel> mockRetornoLista() {
//		List<ContaModel> lsContas = new ArrayList<>();
//		ContaModel conta = new ContaModel();
//
//		//conta.setNomeCliente("Lucca Nogueira");
//		conta.setTipoConta(TipoContaEnum.CC);
//		conta.setSenha(1234);
//		conta.setStatusConta(StatusContaEnum.ATIVO);
//		conta.setnAg(1478);
//		conta.setnConta(147852);
//		conta.setSaldo(0.00);
//		
//		lsContas.add(conta);
//	
//		return lsContas;
//	}
//}
