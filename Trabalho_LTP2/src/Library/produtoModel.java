package Library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class produtoModel {

	
	

	public static void inserir(String nome,float Valor, String Categoria,String Descricao)  {

		try {
			Connection connection = conexao.getConnection();
			String sql = "INSERT INTO PRODUTO (NOME, VALOR, CATEGORIA, DESCRICAO) VALUES(?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setFloat(2,  Valor);
			statement.setString(3, Categoria);
			statement.setString(4, Descricao);

			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void remover(int id) {
		try {

			Connection connection = conexao.getConnection();

			String sql = "DELETE FROM PRODUTO WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			System.out.println("Removido com sucesso.");
			statement.execute();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	public static void listarTodos() {
		
		try {
			
			Connection connection = conexao.getConnection();

			String sql = "SELECT * FROM PRODUTO";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultset = statement.executeQuery();
			System.out.println();
			System.out.println(" -------------------------------------");
			System.out.println();
			while (resultset.next()) {
				System.out.println("ID: "+resultset.getInt("id") + " - Produto: " + resultset.getString("nome")+ " - Valor: " + resultset.getFloat("valor") + " categoria: "+ resultset.getString("categoria")+ " Descrição: "+ resultset.getString("descricao"));
			}
			System.out.println();
			System.out.println();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
	

	public static void atualizar (int id,String nome,float Valor,  String Categoria,String Descricao) {
		try {
			Connection connection = conexao.getConnection();
			String sql = "UPDATE produto SET nome = ?, Categoria = ?, valor = ?, Descricao = ? where  id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, nome);
			statement.setFloat(2, Valor);
			statement.setString(3, Categoria);
			statement.setString(4, Descricao);
			statement.setInt(5, id);

			statement.execute();
			connection.close();
			
			//System.out.println("");
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return;
	}
	
		
}
