package projetoPoo.view;

public class View {
	public static void MenuFuncionario() {
		System.out.println("1 - Registar venda\n2 - Cadastrar cliente\n3 - Adicionar produto ao estoque"
				+ "\n4 - Ver estoque\n\n0 - Sair");
	}
	
	public static void MenuGerente() {
		System.out.println("1 - Registar venda\n2 - Cadastrar cliente\n3 - Adicionar produto ao estoque"
				+ "\n4 - Adicionar funcionário\n5 - Ver saldo\n6 - Ver estoque\n\n0 - Sair");
	}
	
	public static void MenuProprietario() {
		System.out.println("1 - Registar venda\n2 - Cadastrar cliente\n3 - Adicionar produto ao estoque"
				+ "\n4 - Adicionar funcionário\n5 - Ver saldo\n6 - Adicionar gerente"
				+ "\n7 - Lista de funcionários\n8 - Histórico de vendas\n9 - Ver estoque\n\n0 - Sair");
	}
	
	public static void MenuInicial() {
		System.out.println("- Oficina do tigrinho -");
	}
}
