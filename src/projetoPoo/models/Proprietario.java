package projetoPoo.models;

import java.util.Scanner;

public class Proprietario extends Gerente {

	public Proprietario(String nome, String pass, Oficina oficina, Cargos cargo) {
		super(nome, pass, oficina, cargo);
		// TODO Auto-generated constructor stub
	}
	
	public void AdicionarGerente() {
		var scanner = new Scanner(System.in);
		System.out.println("Nome do gerente:");
		var nome = scanner.nextLine();
		System.out.println("Senha:");
		var senha = scanner.nextLine();
		this.oficina.funcionarios.Adicionar(new Gerente(nome, senha, this.oficina, Cargos.gerente));
		System.out.println("Gerente adicionado.");
	}
	
	public void VerHistoricoFuncionarios() {
		oficina.funcionarios.ListarFuncionarios();
	}
	
	public void VerHistoricoVendas() {
		oficina.vendas.ListarVendas();
	}
}
