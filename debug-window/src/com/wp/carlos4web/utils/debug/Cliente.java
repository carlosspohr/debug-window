package com.wp.carlos4web.utils.debug;

/**
 * Um javabean que representa os dados de um cliente.
 * 
 * @author Carlos A. Junior
 */
public class Cliente {

	private Long id;
	
	private String nome;
	
	private String email;
	
	private String fone;
	
	private int idade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
