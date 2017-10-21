package br.com.Devell.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.Devell.Model.Livro;

public class LivroCRUD {
	Connection connectionBd = ConnectionFactory.getConnection();

	/**
	 * Insere um novo livro na base de dados
	 * 
	 * @param livro
	 *            objeto para persistencia no banco
	 * @return true se for possivel inserir no banco e false caso ocorrra algum erro
	 *         alem do trace
	 */
	public boolean insert(Livro livro) {
		String sql = "INSERT INTO livros(nomeLivro, numeroSerie, autor) VALUES (?, ?, ?)";
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connectionBd.prepareStatement(sql);
			prepareStatement.setString(1, livro.getNomeLivro());
			prepareStatement.setInt(2, livro.getNumeroSerie());
			prepareStatement.setString(3, livro.getAutor());
			return prepareStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Realiza consulta no banco de dados com base nos parametros enviados
	 * 
	 * @param sql
	 *            string para select no banco
	 * @param paramWhere
	 *            parametro que sera utlizado no where, caso seja informado "" sera
	 *            ignorado
	 * @return lista de livros encontrados
	 */

	private ArrayList<Livro> queryBooks(String sql, String paramWhere) {
		Connection connection = ConnectionFactory.getConnection();
		ArrayList<Livro> livrosEncontrados = new ArrayList<Livro>();

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			if (!paramWhere.equals("")) {
				prepareStatement.setString(1, paramWhere);
			}

			ResultSet resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				livrosEncontrados.add(new Livro(resultSet.getInt("id"), resultSet.getString("nomeLivro"),
						resultSet.getInt("numeroSerie"), resultSet.getString("autor")));
			}

			prepareStatement.close();
			return livrosEncontrados;
		} catch (SQLException e) {
			e.printStackTrace();
			return livrosEncontrados;
		}

	}

	/**
	 * Pesqisa no banco de dados por livros com correspondencia do nome encontrado
	 * 
	 * @param nomeLivro
	 *            nome do livro que será pesquisa
	 * @return lista de livros encontrados
	 */
	public ArrayList<Livro> listBooks(String nomeLivro) {
		String sql = "SELECT * FROM livros WHERE nomeLivro = ?";
		return queryBooks(sql, nomeLivro);

	}

	/**
	 * Pesquisa no banco de dados por todos os livros
	 * 
	 * @return lista de livros encontrados
	 */
	public ArrayList<Livro> listBooks() {
		String sql = "SELECT * FROM livros";
		return queryBooks(sql, "");
	}

	/**
	 * Deleta um livro da base de dados
	 * 
	 * @param nomeLivro
	 *            nome do livro que sera deletado
	 * @return true se deletado com sucesso e false se ocorrer erro
	 */

	public boolean deleteBook(String nomeLivro) {
		String SQL = "DELETE FROM livros WHERE nomelivro = ?";
		Connection connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQL);
			prepareStatement.setString(1, nomeLivro);
			prepareStatement.execute();
			prepareStatement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Atualiza o nome de um livro no banco de dados
	 * 
	 * @param nomeAtual
	 *            nome atual do livro
	 * @param nomeNovo
	 *            novo nome do livro
	 * @return true se ocorrer com exito a atualizacao e false caso ocorra erro
	 */

	public boolean updateBookName(String nomeAtual, String nomeNovo) {
		String SQL = "UPDATE livros SET nomeLivro=? WHERE nomelivro = ?";
		Connection connection = ConnectionFactory.getConnection();

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SQL);
			prepareStatement.setString(1, nomeNovo);
			prepareStatement.setString(2, nomeAtual);
			prepareStatement.execute();
			prepareStatement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}
