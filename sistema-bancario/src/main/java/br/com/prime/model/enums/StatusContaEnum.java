package br.com.prime.model.enums;

public enum StatusContaEnum {
	ATIVO(1, "Ativo"), INATIVO(2, "Inativo");
	
	private int cod;
	private String descricao;
	
	StatusContaEnum(int cod, String descricao) {
	this.cod = cod;
	this.descricao = descricao;
	}

	public static StatusContaEnum encode(int cod) {
		for(StatusContaEnum tipo :StatusContaEnum.values()) {
			if(tipo.getCod() == cod) return tipo;
		}
		return null;
	}
	
	public static String retornaDescricao(int cod) {
		for(StatusContaEnum tipo : StatusContaEnum.values()) {
			if(tipo.getCod() == cod) return tipo.getDescricao();
		}
		return "";
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
