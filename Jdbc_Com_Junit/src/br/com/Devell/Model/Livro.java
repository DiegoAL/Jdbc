package br.com.Devell.Model;

public class Livro {
	private int id;
	private String nomeLivro;
	private int numeroSerie;
	private String autor;

	public Livro(String nomeLivro, int numeroSerie, String autor) {
		this.nomeLivro = nomeLivro;
		this.numeroSerie = numeroSerie;
		this.autor = autor;
	}

	public Livro(int id, String nomeLivro, int numeroSerie, String autor) {
		this.id = id;
		this.nomeLivro = nomeLivro;
		this.numeroSerie = numeroSerie;
		this.autor = autor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public int getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
