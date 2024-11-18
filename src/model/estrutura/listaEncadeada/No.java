package model.estrutura.listaEncadeada;

public class No{
	private String cidade;
	private No proximo;
	
	public No(String cidade){
		this.proximo = null;
		this.cidade = cidade;
	}
	
	public No(String cidade, No proximo) {
		this.cidade = cidade;
		this.proximo = proximo;
	}
	
	public String getCidade(){
		return cidade;
	}
	
	public void setCidade(String cidade){
		this.cidade = cidade;
	}
	
	public No getProximo(){
		return proximo;
	}
	
	public void setProximo(No proximo){
		this.proximo = proximo;
	}
}