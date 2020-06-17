package Library;

import java.sql.Connection;
import java.sql.PreparedStatement;




public class loginModel {
	
	private String nome;	
	private String email;
	private String senha;
	private int id;
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getsenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
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
	
	
	/*erro 
	public static List<loginModel> listarTodos() {
		List<loginModel> usuarios = new ArrayList<loginModel>();
		try {
			Connection connection = conexao.getConnection();
			
			String sql = "SELECT * FROM usuario";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				loginModel etq = new loginModel();
				etq.setID(resultset.getInt("ID"));
				etq.setEmail(resultset.getString("email"));
				etq.setNome(resultset.getString("nome"));
				
				usuarios.add(etq);
			}
			connection.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	*/
	
	// não funciona \/
	public static void atualizar (int id,String nome,String email, String senha) {
		try {
			Connection connection = conexao.getConnection();
			String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, nome);
			statement.setString(2, email);
			statement.setString(3, senha);
			statement.setInt(4, id);

			System.out.println(sql);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return;
	}
	
	}

