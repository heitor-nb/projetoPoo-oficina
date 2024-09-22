package projetoPoo.models;

public class Venda {
	private String descricao;
	private int id;
	private double valor;
	private String funcionarioId;
	private String clienteId;
	private Veiculos veiculo;
	private Produto produto;
	
	public Venda(String descricao, int id, double valor, String funcionarioId, String clienteId, Veiculos veiculo, Produto produto) {
		this.descricao = descricao;
		this.id = id;
		this.valor = valor;
		this.funcionarioId = funcionarioId;
		this.clienteId = clienteId;
		this.veiculo = veiculo;
		this.produto = produto;
	}
	
	public double getValor() {
		return valor;
	}
	
	public String getFuncionarioId() {
		return funcionarioId;
	}
	
	public void ExibirVenda() {
		System.out.println("----------\nDescricao: " + descricao + "\nValor: " + valor + 
				"\nVeiculo: " + veiculo + "\nProduto: " + produto.nome + " (qtd: " + produto.qtd + ")\n----------");
	}
	
}
