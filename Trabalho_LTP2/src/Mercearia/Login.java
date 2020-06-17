package Mercearia;




import Library.*;
public class Login {
	

public static void  Menu_login() {
	
	
	  String user;
	  String email;
	  String password;
	  int id;
	
	boolean fim = false;
	System.out.println();
	do {

		System.out.println(" ####   Menu de Login   ####");
		System.out.println("1 - Listar usuarios");
		System.out.println("2 - Criar usuario");
		System.out.println("3 - atualizar E-mial / Login / senha");
		System.out.println("4 - Apagar Usuario");
		System.out.println("5 - Tela Inicial");
	int opcao = IO.getInt("Selecione a opção desejada: ");
	
	switch(opcao) {
	  case 1:
		  loginModel.listarTodos();
	    break;
	  case 2:
	//
		   user = IO.getString("Digite seu login: ");
		   email = IO.getString("Digite seu email: ");;
		   password = IO.getString("Digite sua senha: ");;

		  loginModel.inserir(user,email,password);
	    break;
	  case 3:
	//	  
		  loginModel.listarTodos();

		   id = IO.getInt("Digite o ID: ");
		   user = IO.getString("Digite seu login: ");
		   email = IO.getString("Digite seu email: ");;
		   password = IO.getString("Digite sua senha: ");;

		  loginModel.atualizar(id,user,email,password);
	  case 4:
		  loginModel.listarTodos();
		   id = IO.getInt("Digite o ID: ");

		  loginModel.remover(id);
	    break;
	  case 5:			  

		  System.out.println("5");
		  fim = true;
	    break;
	  default:
	    // code block
	}
	System.out.println("--------------");
}while(fim != true);

	Main.logado();
	


 


}

}
