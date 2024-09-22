package projetoPoo.models;

public class Produto {
	public String nome;
	public int id;
	public double valor;
	public int qtd;
	
	public Produto(String nome, int id, double valor, int qtd) {
		this.nome = nome;
		this.id = id;
		this.valor = valor;
		this.qtd = qtd;
	}
}
