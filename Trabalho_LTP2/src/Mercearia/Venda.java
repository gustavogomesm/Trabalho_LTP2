package Mercearia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import java.util.Scanner;

import Library.conexao;


public class Venda {

	private Scanner scan = new Scanner(System.in);

	public static String formatCurrencyReal(double value) {
		DecimalFormat real = new DecimalFormat("#,##0.00");
		return real.format(value);
	}
	public int getInt(String texto) {
		System.out.print(texto);
		return scan.nextInt();		
	}
	
	public double getDouble(String texto) {
		System.out.print(texto);
		return scan.nextDouble();		
	}
	
	public void print(String texto) {
		System.out.println(texto);
	}
	
	public void getProdutos() {
		try {
			
			Connection connection = conexao.getConnection();

			String sql = "SELECT * FROM PRODUTO";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultset = statement.executeQuery();
			System.out.println();
			System.out.println(" -------------------------------------");
			System.out.println();
			while (resultset.next()) {
				System.out.println(resultset.getInt("ID") + " - " + resultset.getString("NOME") + " - R$ " + formatCurrencyReal(Double.parseDouble(resultset.getString("VALOR"))) + " - " + resultset.getString("DESCRICAO") );
			}
			System.out.println();
			System.out.println();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getCarrinho(int cpf) {
		try {
			
			Connection connection = conexao.getConnection();

			String sql = "select pd.nome,pd.descricao,pd.valor,ca.quantidade from produto as pd " + 
						" inner join carrinho as ca on ca.codProduto = pd.id where ca.cpf = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setDouble(1, cpf);
			ResultSet resultset = statement.executeQuery();
			System.out.println();
			System.out.println(" ---- Carrinho CPF:"+ cpf + " -----");
			double valor = 0;
			while (resultset.next()) {
				valor = Double.parseDouble(resultset.getString("VALOR")) * resultset.getInt("quantidade");
				System.out.println(resultset.getString("NOME") +  " - " + resultset.getString("DESCRICAO") + " - R$ " + formatCurrencyReal(valor));
			}
			System.out.println();
			System.out.println();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void finalizaCompra(int cpf) {
		try {
			
			Connection connection = conexao.getConnection();

			String sql = "select pd.nome,pd.descricao,pd.valor,ca.quantidade from produto as pd " + 
						" inner join carrinho as ca on ca.codProduto = pd.id where ca.cpf = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setDouble(1, cpf);
			ResultSet resultset = statement.executeQuery();
			System.out.println();
			System.out.println(" ---- Carrinho CPF:"+ cpf + " -----");
			double valor = 0, valorTotal = 0, valorPago = 0, troco = 0;
			while (resultset.next()) {
				valor = Double.parseDouble(resultset.getString("VALOR")) * resultset.getInt("quantidade");
				valorTotal += Double.parseDouble(resultset.getString("VALOR")) * resultset.getInt("quantidade");
				System.out.println(resultset.getString("NOME") +  " - " + resultset.getString("DESCRICAO") + " - R$ " + formatCurrencyReal(valor));
			}
			
			do {
			this.print("");
			this.print("Valor Total: R$" + formatCurrencyReal(valorTotal));
			System.out.print("Valor pago: R$ ");
			valorPago = scan.nextDouble();
			troco = valorPago - valorTotal;
			if(troco<0)
				this.print("Valor invalido.");
			}while(troco < 0);
			
			System.out.println("Troco: R$ "+formatCurrencyReal(troco));
			System.out.println();
			System.out.println("Obrigado. Volte Sempre!");
			
			limpaCarrinho(cpf);
			
			System.out.println();
			System.out.println();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void limpaCarrinho(int cpf) {
		try {
			
			Connection connection = conexao.getConnection();

			String sql = "delete from carrinho where cpf = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, cpf);

			statement.execute();

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void addCarrinho(int cpf,int codProduto,int quantidade) {

		try {

			Connection connection = conexao.getConnection();

			String sql = "INSERT INTO CARRINHO (cpf, codProduto,quantidade) VALUES(?,?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setDouble(1, cpf);
			statement.setInt(2, codProduto);
			statement.setInt(3, quantidade);
			
			statement.execute();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public static Connection getConnection() throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Conectando ao banco");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/aulaltp2",
	                "root", "");
		}catch (ClassNotFoundException e) {
			//System.out.println("Não conectado");
			throw new SQLException(e.getMessage());
		}
	}
	
}
