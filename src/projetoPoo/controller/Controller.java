package projetoPoo.controller;

import java.util.HashMap;
import java.util.Scanner;

import projetoPoo.models.*;
import projetoPoo.view.View;

public class Controller {
	
	private HashMap<Cargos, Menu> menus;
	private Oficina oficina;
	
	public Controller(Oficina oficina) {
		this.oficina = oficina;
		menus = new HashMap<Cargos, Menu>();
		menus.put(Cargos.funcionario, new MenuFuncionario());
		menus.put(Cargos.gerente, new MenuGerente());
		menus.put(Cargos.proprietario, new MenuProprietario());
	}
	
	public void Run() {
		View.MenuInicial();
		var scanner = new Scanner(System.in);
		System.out.println("1 - Login / 0 - Sair");
		int opcao;
		do opcao = scanner.nextInt();
		while(opcao < 0 || opcao > 1);
		if(opcao != 0) Login();
	}
	
	private void Login() {
		var scanner = new Scanner(System.in);
		System.out.println("Nome:");
		var nome = scanner.nextLine();
		if(nome.equals(oficina.getProprietario().nome)) {
			System.out.println("Bem-vindo(a) " + nome + "\nSenha:");
			var senha = scanner.nextLine();
			if(senha.equals(oficina.getProprietario().getPass())) menus.get(Cargos.proprietario).Executar(oficina.getProprietario());
			else System.out.println("Senha incorreta.");
		}
		else {
			var funcionario = oficina.funcionarios.RecuperarPorNome(nome);
			if(funcionario != null) {
				System.out.println("Bem-vindo(a) " + nome + "\nSenha:");
				var senha = scanner.nextLine();
				if(senha.equals(funcionario.getPass())) menus.get(funcionario.cargo).Executar(funcionario);
				else System.out.println("Senha incorreta.");
			}
			else {
				System.out.println("Nome não encontrado.");
			}
		}
		Run();
	}	
}
