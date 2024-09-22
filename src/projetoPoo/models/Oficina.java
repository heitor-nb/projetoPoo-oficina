package projetoPoo.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Oficina {
	private ArrayList<Funcionario> funcionarios;
	private ArrayList<Cliente> clientes;
	private ArrayList<Produto> estoque;
	private ArrayList<Venda> vendas;
	private Proprietario proprietario;
	
	public Oficina() {
		funcionarios = new ArrayList<Funcionario>();
		clientes = new ArrayList<Cliente>();
		estoque = new ArrayList<Produto>();
		vendas = new ArrayList<Venda>();
		
		var scanner = new Scanner(System.in);
		System.out.println("Nome do proprietário:");
		var nome = scanner.nextLine();
		System.out.println("Senha:");
		var senha = scanner.nextLine();
		proprietario = new Proprietario(nome, senha, this, Cargos.proprietario);
	}
	
	public ArrayList<Venda> getVendas() {
		return vendas;
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public ArrayList<Funcionario> getFuncionarios(){
		return funcionarios;
	}
	
	public Proprietario getProprietario() {
		return proprietario;
	}
	
	public ArrayList<Produto> getEstoque(){
		return estoque;
	}

	// Criar uma classe para encapsular essas operações do estoque
	
	private int IndiceProduto(String nome) {
		var index = -1;
		for(int i = 0; i < estoque.size(); i++) if(estoque.get(i).nome.equals(nome)) index = i;
		return index;
	}
	
	public Produto RemoverEstoque(String nome, int qtd) {
		int index = IndiceProduto(nome);
		if(index >= 0) {
			if(estoque.get(index).qtd >= qtd) {
				Produto produto = estoque.get(index);
				produto.qtd -= qtd;
				var produtoRemovido = new Produto(produto.nome, produto.id, produto.valor, qtd);
				return produtoRemovido;
			}
			else System.out.println("Quantitade em estoque insuficiente.");
		}
		else System.out.println("Produto não cadastrado.");
		return null;
	}
	
	public void AdicionarEstoque(String nome, int qtd) {
		var index = IndiceProduto(nome);
		var scanner = new Scanner(System.in);
		if(index != -1) {
			var produto = estoque.get(index);
			produto.qtd += qtd;
			System.out.println("- Quantidade atualizada -" + "\nNome: " + produto.nome + "\nQuantidade: " + produto.qtd + "\nPreço: " + produto.valor);
			System.out.println("Deseja alterar o preço do produto?");
			int opcao;
			do {
				System.out.println("1 - Sim / 0 - Não");
				opcao = scanner.nextInt();
			} while(opcao < 0 || opcao > 1);
			if(opcao == 1) {
				var novoPreco = scanner.nextDouble();
				produto.valor = novoPreco;
				System.out.println("Preço atualizado.");
			}
			else System.out.println("Retornando...");
		}
		else {
			System.out.println("Valor:");
			var valor = scanner.nextDouble();
			estoque.add(new Produto(nome, estoque.size(), valor, qtd));
		}
	}
	
	// ----------
}
