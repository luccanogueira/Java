package br.com.prime.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;

import br.com.prime.exception.BancoException;
import br.com.prime.model.ContaModel;

public class Util {

	public static ContaModel localizaConta(int nConta, int nAgn, List<ContaModel> contas) throws BancoException {
//		contas.stream().filter(c -> c.getnConta().equals(nConta) && c.getClass().equals(nAgn)).findFirst();
		for(ContaModel conta : contas) {
			if(conta.getnConta().equals(nConta) && conta.getnAg().equals(nAgn)) {
				return conta;
			}
		}
		throw new BancoException("ERRO", new Exception("Conta não encontrada"), HttpStatus.NOT_FOUND);
	}
	
	public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
        String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString += resposta;
        }
        buffereReader.close();
        
        return jsonEmString;
    }
}
