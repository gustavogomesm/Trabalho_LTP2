package Library;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
	public static Connection getConnection() throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conectando ao banco");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/aulaltp2",
	                "root", "");
		}catch (ClassNotFoundException e) {
			System.out.println("Não conectado");
			throw new SQLException(e.getMessage());
		}
	}
	}