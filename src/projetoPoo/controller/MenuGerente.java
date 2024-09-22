package projetoPoo.controller;

import java.util.Scanner;
import projetoPoo.models.*;
import projetoPoo.view.View;

public class MenuGerente extends Menu{
	public @Override void Executar(Funcionario funcionario) {
		View.MenuGerente();
		Gerente gerente = (Gerente) funcionario;
		var scanner = new Scanner(System.in);
		int opcao;
		do opcao = scanner.nextInt();
		while(opcao < 0 || opcao > 6);
		switch(opcao) {
		case 1:
			gerente.RegistrarVenda();
			break;
		case 2:
			gerente.CadastrarCliente();
			break;
		case 3:
			gerente.AdicinarEstoque();
			break;
		case 4:
			gerente.AdicionarFuncionario();
			break;
		case 5:
			gerente.VerSaldo();
			break;
		case 6:
			gerente.VerEstoque();
			break;
		case 0:
			opcao = -1;
			break;
		default:
			break; // nunca vai entrar aqui
		}
		if(opcao != -1) Executar(funcionario);
	}
}
