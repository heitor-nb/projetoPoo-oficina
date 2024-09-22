package projetoPoo.controller;

import java.util.Scanner;

import projetoPoo.models.*;
import projetoPoo.view.*;

public class MenuProprietario extends Menu{
	public @Override void Executar(Funcionario funcionario) {
		View.MenuProprietario();
		Proprietario proprietario = (Proprietario) funcionario;
		var scanner = new Scanner(System.in);
		int opcao;
		do opcao = scanner.nextInt();
		while(opcao < 0 || opcao > 9);
		switch(opcao) {
		case 1:
			proprietario.RegistrarVenda();
			break;
		case 2:
			proprietario.CadastrarCliente();
			break;
		case 3:
			proprietario.AdicinarEstoque();
			break;
		case 4:
			proprietario.AdicionarFuncionario();
			break;
		case 5:
			proprietario.VerSaldo();
			break;
		case 6:
			proprietario.AdicionarGerente();
			break;
		case 7:
			proprietario.VerHistoricoFuncionarios();
			break;
		case 8:
			proprietario.VerHistoricoVendas();
			break;
		case 9:
			proprietario.VerEstoque();
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
