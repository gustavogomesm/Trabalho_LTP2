package Library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;





public class loginModel {

	// Querys 
	public static void inserir(String nome,String email, String senha)  {

		try {
			Connection connection = conexao.getConnection();
			String sql = "INSERT INTO usuario (nome,email,senha) VALUES(?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, nome);
			statement.setString(2, email);
			statement.setString(3, senha);
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void remover(int id) {
		try {

			Connection connection = conexao.getConnection();

			String sql = "DELETE FROM usuario WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			statement.execute();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	public static void listarTodos() {
		
		try {
			
			Connection connection = conexao.getConnection();

			String sql = "SELECT * FROM usuario";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultset = statement.executeQuery();
			System.out.println();
			System.out.println(" -------------------------------------");
			System.out.println();
			while (resultset.next()) {
				System.out.println("ID: "+resultset.getInt("id") + " - Nome: " + resultset.getString("nome") + " Email: "+ resultset.getString("email"));
			}
			System.out.println();
			System.out.println();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
	

	public static void atualizar (int id,String nome,String email, String senha) {
		try {
			Connection connection = conexao.getConnection();
			String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ? where  id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, nome);
			statement.setString(2, email);
			statement.setString(3, senha);
			statement.setInt(4, id);
			statement.execute();
			connection.close();
			//System.out.println("");
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return;
	}
	
	public static Boolean VerificaLogin(String email,String senha) {
		
		try {
			
			Connection connection = conexao.getConnection();

			String sql = "SELECT * FROM usuario where email = ? and senha = ?";

			
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, email);
			statement.setString(2, senha);

			ResultSet resultset = statement.executeQuery();
			System.out.println();
			System.out.println(" -------------------------------------");
			System.out.println();
			int i = 0;
			while (resultset.next()) {	
				i++;			
			}
			connection.close();
			if(i>0) {
				return true;
			}else {
				return false;
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	
	}
	
	}

