package br.com.Devell.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import br.com.Devell.Controller.LivroCRUD;
import br.com.Devell.Model.Livro;

public class LivroCRUDTest {
	Livro livro = new Livro("Chocalhando", 1234155856, "Diego A. Alves");
	LivroCRUD livroCRUD = new LivroCRUD();

	@Test
	public void testInsetDuplicateBook() {
		assertEquals(false, livroCRUD.insert(livro));

	}

	@Test
	public void testListOneBookQueryByName() {
		ArrayList<Livro> listaLivros = livroCRUD.listBooks("Chocalhando");
		Livro livro = listaLivros.get(0);
		assertEquals("Chocalhando", livro.getNomeLivro());
	}

	@Test
	public void testListAllBooks() {
		ArrayList<Livro> listaLivros = livroCRUD.listBooks();
		assertEquals(false, listaLivros.isEmpty());

	}

	@Test
	public void testDeleteBook() {
		try {
			livroCRUD.insert(new Livro("jdbc", 12334543, "JDBC Method"));
		} catch (Exception e) {
			System.out.println("Registro já existente");
		}

		assertEquals(true, livroCRUD.deleteBook("jdbc"));
	}

	@Test
	public void testUpdateBookName() {
		livroCRUD.insert(new Livro("Tabelando", 14234543, "JDBC Method"));
		livroCRUD.deleteBook("TabelandoNovo");
		assertEquals(true, livroCRUD.updateBookName("Tabelando", "TabelandoNovo"));
	}

}
