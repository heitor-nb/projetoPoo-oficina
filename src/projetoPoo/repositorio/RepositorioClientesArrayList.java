package projetoPoo.repositorio;

import java.util.ArrayList;

import projetoPoo.models.*;

public class RepositorioClientesArrayList {
	private ArrayList<Cliente> Clientes;
	
	public RepositorioClientesArrayList() {
		Clientes = new ArrayList<Cliente>();
	}
	
	public void Adicionar(Cliente cliente) {
		if(RecuperarPorNome(cliente.nome) == null) {
			Clientes.add(cliente);
			System.out.println("Cliente cadastrado com sucesso.");
		}
		else {
			System.out.println("Cliente já registrado.");
		}
	}
	
	public Cliente RecuperarPorNome(String nome) {
		for(int i = 0; i < Clientes.size(); i++) {
			if(Clientes.get(i).nome.equals(nome)) {
				return Clientes.get(i);
			}
		}
		return null;
	}

}
