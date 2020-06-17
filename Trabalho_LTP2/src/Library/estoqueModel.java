package Library;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class estoqueModel {
	

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


		public static void inserir(int idproduto, int quantidade) {
			try {
				Connection connection = conexao.getConnection();
				String sql = "INSERT INTO ESTOQUE (ProdutoID,quantidade	) VALUES(?,?)";

				PreparedStatement statement = connection.prepareStatement(sql);

				statement.setInt(1, idproduto);
				statement.setInt(2, quantidade);
				
				
				statement.execute();
				connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		public static void remover(int id) {
			try {

				Connection connection = conexao.getConnection();

				String sql = "DELETE FROM estoque WHERE id = ?";
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

				String sql = "SELECT * FROM ESTOQUE";

				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultset = statement.executeQuery();
				System.out.println();
				System.out.println(" -------------------------------------");
				System.out.println();
				while (resultset.next()) {
					System.out.println("ID: "+resultset.getInt("id") + " - ProdutoID: " + resultset.getInt("ProdutoID") + " quantidade: "+ resultset.getInt("quantidade"));
				}
				System.out.println();
				System.out.println();
				connection.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public static void atualizar (int idproduto, int quantidade) {
			try {
				
				try {
					Connection connection = conexao.getConnection();
					String sql = "UPDATE estoque SET quantidade = ? where  ProdutoID = ?";
					
					PreparedStatement statement = connection.prepareStatement(sql);

					statement.setInt(1, quantidade);
					statement.setInt(2, idproduto);
					
					statement.execute();
					connection.close();
					//System.out.println("");
				}catch (Exception e){
					e.printStackTrace();
				}
				
				Connection connection =conexao.getConnection();
				
				String sql = "UPDATE ESTOQUE SET estoque = ?, QUANTIDADE = ?";
				
				PreparedStatement statement = connection.prepareStatement(sql);

				statement.setString(1, "erro");
				statement.setInt(2, 1);

				
			}catch (Exception e){
				e.printStackTrace();
			}
			
			return;
		}

	}

