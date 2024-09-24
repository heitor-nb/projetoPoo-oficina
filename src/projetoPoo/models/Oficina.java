package projetoPoo.models;

import java.util.Scanner;
import projetoPoo.repositorio.*;

public class Oficina {
	public RepositorioFuncionariosArrayList funcionarios;
	public RepositorioClientesArrayList clientes;
	public RepositorioProdutosArrayList estoque;
	public RepositorioVendasArrayList vendas;
	private Proprietario proprietario;
	
	public Oficina() {
		funcionarios = new RepositorioFuncionariosArrayList();
		clientes = new RepositorioClientesArrayList();
		estoque = new RepositorioProdutosArrayList();
		vendas = new RepositorioVendasArrayList();
		
		var scanner = new Scanner(System.in);
		System.out.println("Nome do proprietário:");
		var nome = scanner.nextLine();
		System.out.println("Senha:");
		var senha = scanner.nextLine();
		proprietario = new Proprietario(nome, senha, this, Cargos.proprietario);
	}
	
	public Proprietario getProprietario() {
		return proprietario;
	}
	
}
