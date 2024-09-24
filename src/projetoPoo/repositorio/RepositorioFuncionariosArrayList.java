package projetoPoo.repositorio;

import java.util.ArrayList;
import projetoPoo.models.*;

import projetoPoo.models.Cliente;

public class RepositorioFuncionariosArrayList { // Implementar classe generica
	private ArrayList<Funcionario> Funcionarios;
	
	public RepositorioFuncionariosArrayList() {
		Funcionarios = new ArrayList<Funcionario>();
	}
	
	public void Adicionar(Funcionario funcionario) {
		if(RecuperarPorNome(funcionario.nome) == null) {
			Funcionarios.add(funcionario);
			System.out.println("Funcionário adicionado com sucesso.");
		}
		else {
			System.out.println("Funcionário já adicionado.");
		}
	}
	
	public void ListarFuncionarios() {
		System.out.println("Funcionários:");
		for(int i = 0; i < Funcionarios.size(); i++) Funcionarios.get(i).ExibirDetalhes();
	}
	
	public Funcionario RecuperarPorNome(String nome) {
		for(int i = 0; i < Funcionarios.size(); i++) {
			if(Funcionarios.get(i).nome.equals(nome)) {
				return Funcionarios.get(i);
			}
		}
		return null;
	}
}
