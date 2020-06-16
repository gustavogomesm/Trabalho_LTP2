package master_class;

import library.Utils.conexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
	private int id; 
	private String produto;
	private int quantidade;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public void inserir(Estoque Estoque) {

		try {

			Connection connection = conexaoUtil.getInstance().getConnection();

			String sql = "INSERT INTO ESTOQUE (PRODUTO, QUANTIDADE) VALUES(?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, Estoque.getProduto());
			statement.setFloat(2, Estoque.getQuantidade());

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
	public List<Estoque> listarTodos() {
		List<Estoque> listaEstoque = new ArrayList<Estoque>();
		try {
			Connection connection = conexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM ESTOQUE";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				Estoque etq = new Estoque();
				etq.setId(resultset.getInt("ID"));
				etq.setProduto(resultset.getString("PRODUTO"));
				etq.setQuantidade(resultset.getInt("QUANTIDADE"));
				
				listaEstoque.add(etq);
			}
			connection.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listaEstoque;
	}
	
	public void atualizar (Estoque Estoque) {
		try {
			Connection connection = conexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE ESTOQUE SET PRODUTO = ?, QUANTIDADE = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, produto.getProduto());
			statement.setInt(2, produto.getQuantidade());

			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return;
	}

}
