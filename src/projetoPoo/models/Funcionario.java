package projetoPoo.models;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Funcionario {
	public String nome;
	private String pass;
	public String id;
	private ArrayList<Venda> historico;
	public Oficina oficina;
	public Cargos cargo;
	
	public Funcionario(String nome, String pass, Oficina oficina, Cargos cargo) {
		this.nome = nome;
		this.pass = pass;
		this.id = UUID.randomUUID().toString();
		historico = new ArrayList<Venda>();
		this.oficina = oficina;
		this.cargo = cargo;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void ExibirDetalhes() {
		double valorVendido = 0;
		var vendas = oficina.vendas.VendasFuncionario(id);
		for(int i = 0; i < vendas.size(); i++) valorVendido += vendas.get(i).getValor();
		System.out.println("----------\nNome: " + nome + "\nId: " + id + "\nValor vendido: " + valorVendido + "\n----------");
	}
	
	// tratar excecoes relacinadas a classe Scanner
	
	public void RegistrarVenda() {
		var scanner = new Scanner(System.in);
		System.out.println("Nome do cliente:");
		var nomeCliente = scanner.nextLine();
		var cliente = oficina.clientes.RecuperarPorNome(nomeCliente);
		if(cliente != null) {
			System.out.println("Nome do produto associado à venda:");
			var produtoNome = scanner.nextLine();
			System.out.println("Quantidade:");
			var produtoQtd = scanner.nextInt();
			var produto = oficina.estoque.RemoverEstoque(produtoNome, produtoQtd);
			if(produto != null) {
				System.out.println("Descrição da venda:");
				scanner.nextLine(); // limpando o buffer
				var descricao = scanner.nextLine();
				var id = oficina.vendas.Tam();
				System.out.println("Valor do serviço:");
				var valor = scanner.nextDouble();
				var veiculos = Veiculos.values();
				for(int i = 0; i < veiculos.length; i++) System.out.println(i + " - " + veiculos[i]);
				int veiculo;
				System.out.println("Índice do veículo:");
				do {
					veiculo = scanner.nextInt();
				} while(veiculo < 0 || veiculo > veiculos.length);
				var novaVenda = new Venda(descricao, id, valor + produto.valor * produtoQtd, this.id, cliente.id, veiculos[veiculo], produto);
				System.out.println("Confirma as informações:");
				novaVenda.ExibirVenda();
				int opcao;
				do {
					System.out.println("1 - Sim / 0 - Não");
					opcao = scanner.nextInt();
				} while(opcao < 0 || opcao > 1);
				if(opcao == 1) {
					oficina.vendas.Adicionar(novaVenda);
					historico.add(novaVenda);
					System.out.println("Venda registrada com sucesso.");
				}
				else {
					System.out.println("Retornando...");
				}
			}
		}
		else System.out.println("Cliente não existe.");
	}
	
	public void CadastrarCliente() {
		var scanner = new Scanner(System.in);
		System.out.println("Nome do cliente:");
		var nome = scanner.nextLine();
		oficina.clientes.Adicionar(new Cliente(nome));
	}
	
	public void AdicinarEstoque() {
		var scanner = new Scanner(System.in);
		System.out.println("Nome do produto:");
		var nome = scanner.nextLine();
		System.out.println("Quantidade:");
		var qtd = scanner.nextInt();
		oficina.estoque.AdicionarEstoque(nome, qtd);
	}
	
	public void VerEstoque() {
		oficina.estoque.VerEstoque();
	}
}
