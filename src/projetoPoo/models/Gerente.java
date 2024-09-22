package projetoPoo.models;

import java.util.Scanner;

public class Gerente extends Funcionario {
	
	public Gerente(String nome, String pass, Oficina oficina, Cargos cargo) { // ?
		super(nome, pass, oficina, cargo);
		// TODO Auto-generated constructor stub
	}
	
	public void AdicionarFuncionario() {
		var scanner = new Scanner(System.in);
		System.out.println("Nome do funcionario:");
		var nome = scanner.nextLine();
		System.out.println("Senha:");
		var senha = scanner.nextLine();
		this.oficina.getFuncionarios().add(new Funcionario(nome, senha, this.oficina, Cargos.funcionario));
		System.out.println("Funcionario adicionado.");
	}

	public void VerSaldo() {
		double saldo = 0;
		for(int i = 0; i < this.oficina.getVendas().size(); i++) {
			saldo += this.oficina.getVendas().get(i).getValor();
		}
		System.out.println("Saldo total: " + saldo);
	}
}
