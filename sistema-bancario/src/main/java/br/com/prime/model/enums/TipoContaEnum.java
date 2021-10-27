package br.com.prime.model.enums;

public enum TipoContaEnum {
	CC(1, "Conta Corrente"), CP(2, "Conta Poupança");
	
	private int cod;
	private String descricao;
	
	TipoContaEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public static TipoContaEnum encond(int cod) {
		for(TipoContaEnum tipo : TipoContaEnum.values()) {
			if(tipo.getCod() == cod) return tipo;
		}
		return null;
	}
	
	public static String retoraDescricao(int cod) {
		for(TipoContaEnum tipo : TipoContaEnum.values()) {
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
