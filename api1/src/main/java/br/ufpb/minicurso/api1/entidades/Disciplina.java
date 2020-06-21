package br.ufpb.minicurso.api1.entidades;

public class Disciplina {
	
	private String nome;
	private int id;
	private double nota;
	
	
	public Disciplina(String nome, int id, double nota) {
		super();
		this.setNome(nome);
		this.setId(id);
		this.setNota(nota);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
	

}



