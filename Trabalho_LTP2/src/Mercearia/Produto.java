package master_class;

import library.Utils.conexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Produto {
	private int id;
	private String nome;
	private float valor;
	private String categoria;
	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void inserir(Produto Produto) {

		try {

			Connection connection = conexaoUtil.getInstance().getConnection();

			String sql = "INSERT INTO PRODUTO (NOME, VALOR, CATEGORIA, DESCRICAO) VALUES(?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, Produto.getNome());
			statement.setFloat(2, Produto.getValor());
			statement.setString(3, Produto.getCategoria());
			statement.setString(4, Produto.getDescricao());

			statement.execute();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void remover(int id) {
		try {

			Connection connection = conexaoUtil.getInstance().getConnection();

			String sql = "DELETE FROM PRODUTO WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			statement.execute();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public List<Produto> listarTodos() {
		List<Produto> listaProdutos = new ArrayList<Produto>();
		try {
			Connection connection = conexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM PRODUTO";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				Produto p = new Produto();
				p.setId(resultset.getInt("ID"));
				p.setNome(resultset.getString("NOME"));
				p.setValor(resultset.getFloat("VALOR"));
				p.setCategoria(resultset.getString("CATEGORIA"));
				p.setDescricao(resultset.getString("DESCRICAO"));
				
				listaProdutos.add(p);
			}
			connection.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listaProdutos;
	}
	
	public void atualizar (Produto produto) {
		try {
			Connection connection = conexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE PRODUTO SET NOME = ?, VALOR = ?, CATEGORIA = ?, DESCRICAO = ? WHERE ID = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, produto.getNome());
			statement.setFloat(2, produto.getValor());
			statement.setString(3, produto.getCategoria());
			statement.setString(4, produto.getDescricao());

			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return;
	}

}
