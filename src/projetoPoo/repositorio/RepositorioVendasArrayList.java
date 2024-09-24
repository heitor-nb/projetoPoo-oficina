package projetoPoo.repositorio;

import java.util.ArrayList;
import projetoPoo.models.*;

public class RepositorioVendasArrayList {
	private ArrayList<Venda> Vendas;
	
	public RepositorioVendasArrayList() {
		Vendas = new ArrayList<Venda>();
	}
	
	public void Adicionar(Venda venda) {
		Vendas.add(venda);
	}
	
	public int Tam() {
		return Vendas.size();
	}
	
	public void ListarVendas() {
		System.out.println("Vendas:");
		for(int i = 0; i < Vendas.size(); i++) Vendas.get(i).ExibirVenda();
	}
	
	public double SaldoTotal() {
		double saldo = 0;
		for(int i = 0; i < Vendas.size(); i++) saldo += Vendas.get(i).getValor();
		return saldo;
	}
	
	public ArrayList<Venda> VendasFuncionario(String id) {
		var vendas = new ArrayList<Venda>();
		for(int i = 0; i < Vendas.size(); i++) {
			if(Vendas.get(i).getFuncionarioId().equals(id)) vendas.add(Vendas.get(i));
		}
		return vendas;
	}
	
	
}
