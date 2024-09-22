package projetoPoo.models;

import java.util.UUID;

public class Cliente {
	public String nome;
	public String id;
	
	public Cliente(String nome) {
		this.nome = nome;
		this.id = UUID.randomUUID().toString();
	}
}
