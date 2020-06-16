package Mercearia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class cliente {
	private int id;
	private String NomeCliente;
	private String TelefoneCliente;
	private String CPF;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return NomeCliente;
	}

	public void setNome(String NomeCliente) {
		this.NomeCliente = NomeCliente;
	}

	public String TelefoneCliente() {
		return TelefoneCliente;
	}

	public void setCategoria(String TelefoneCliente) {
		this.TelefoneCliente = TelefoneCliente;
	}

	public String CPF() {
		return CPF;
	}

	public void setDescricao(String CPF) {
		this.CPF = CPF;
	}

	public void inserir(cliente cliente) {

		try {

			Connection connection = conexaoUtil.getInstance().getConnection();

			String sql = "INSERT INTO PRODUTO (NOME, VALOR, CATEGORIA, DESCRICAO) VALUES(?,?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.TelefoneCliente());
			statement.setString(3, cliente.CPF());

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

	public List<cliente> listarTodos() {
		List<cliente> listaProdutos = new ArrayList<cliente>();
		try {
			Connection connection = conexaoUtil.getInstance().getConnection();

			String sql = "SELECT * FROM PRODUTO";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				cliente p = new cliente();
				p.setId(resultset.getInt("ID"));
				p.setNome(resultset.getString("NOME"));
				p.setCategoria(resultset.getString("TELEFONE"));
				p.setDescricao(resultset.getString("CPF"));

				listaProdutos.add(p);
			}
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaProdutos;
	}

	public void atualizar(cliente cliente) {
package Cliente2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class cliente {
	private int id;
	private String NomeCliente;
	private String TelefoneCliente;
	private String CPF;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return NomeCliente;
	}

	public void setNome(String NomeCliente) {
		this.NomeCliente = NomeCliente;
	}

	public String TelefoneCliente() {
		return TelefoneCliente;
	}

	public void setTelefoneCliente(String TelefoneCliente) {
		this.TelefoneCliente = TelefoneCliente;
	}

	public String CPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public void inserir(cliente cliente) {

		try {

			Connection connection = conexaoUtil.getInstance().getConnection();

			String sql = "INSERT INTO PRODUTO (NOMECLIENTE, TELEFONECLIENTE, CPF) VALUES(?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.TelefoneCliente());
			statement.setString(3, cliente.CPF());

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

	public List<cliente> listarTodos() {
		List<cliente> listaClientes = new ArrayList<cliente>();
		try {
			Connection connection = conexaoUtil.getInstance().getConnection();

			String sql = "SELECT * FROM PRODUTO";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				cliente p = new cliente();
				p.setId(resultset.getInt("ID"));
				p.setNome(resultset.getString("NOME"));
				p.setTelefoneCliente(resultset.getString("TELEFONE"));
				p.setCPF(resultset.getString("CPF"));

				listaClientes.add(p);
			}
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaClientes;
	}

	public void atualizar(cliente cliente) {
		try {
			Connection connection = conexaoUtil.getInstance().getConnection();

			String sql = "UPDATE PRODUTO SET NOME = ?, TELEFONE = ?, CPF = ?, WHERE ID = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.TelefoneCliente());
			statement.setString(3, cliente.CPF());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return;
	}

	public static class conexaoUtil {

		private static conexaoUtil conexaoUtil;

		public static conexaoUtil getInstance() {

			if (conexaoUtil == null) {
				conexaoUtil = new conexaoUtil();
			}
			return conexaoUtil;

		}

		public Connection getConnection() throws ClassNotFoundException, SQLException {

			Class.forName("com.mysql.jdbc.Driver");

			return DriverManager.getConnection("jdbc:mysql://localhost/AulaLTP2", "root", "root");

		}
	}
}
