package Mercearia;



import Library.IO;
import Library.loginModel;


 
public class Main {

	public static void main(String[] args) {
		

		
		boolean veryLogin;
		
		String usuario;
		String senha;
		System.out.println(" ####   Login   ####");
		do{
		usuario = IO.getString("digite o email:");
		senha = IO.getString("digite a senha:");
		veryLogin = loginModel.VerificaLogin(usuario,senha);
		
		if(!veryLogin) {
			System.out.println();
			System.err.println(" ####   Usuario inexistente   ####");
			System.out.println(" ####     Tente Novamente     ####");
			System.out.println();
		}
		
		}while(!veryLogin); 
		
		if(veryLogin) {
		logado();
		}
	}
	public static void logado() {
		boolean fim = false;
			do {	
			System.out.println(" ####   MENU   ####");
			System.out.println("1 - Dados de Usuario");
			System.out.println("2 - Dados de Venda");
			System.out.println("3 - Dados de Estoque");
			System.out.println("4 - Dados de Produto");
			System.out.println("5 - Finalizar");
		int opcao = IO.getInt("Selecione a opção desejada: ");
		
		switch(opcao) {
		  case 1:
		Login.Menu_login();
		    break;
		  case 2:
			  Venda.Menu_venda();
			  break;
		  case 3:
			  Estoque.Menu_Estoque();
			  break;
		  case 4:
			  Produto.Menu_Produto();

		    break;
		  case 5:			  

			  System.out.println("Finalizado com sucesso");
			  fim = true;
		    break;
		  default:
		    // code block
		}
		System.out.println("--------------");
	}while(fim != true);
			
			
		
		
		
	}

}
