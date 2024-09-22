package projetoPoo.controller;

import java.util.Scanner;
import projetoPoo.view.*;
import projetoPoo.models.*;

public class MenuFuncionario extends Menu {
	
	public @Override void Executar(Funcionario funcionario) {
		View.MenuFuncionario();
		var scanner = new Scanner(System.in);
		int opcao;
		do opcao = scanner.nextInt();
		while(opcao < 0 || opcao > 4);
		switch(opcao) {
		case 1:
			funcionario.RegistrarVenda();
			break;
		case 2:
			funcionario.CadastrarCliente();
			break;
		case 3:
			funcionario.AdicinarEstoque();
			break;
		case 4:
			funcionario.VerEstoque();
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
