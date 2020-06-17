package Mercearia;




import Library.*;
public class Login {
	

public static void  Pergunta_login() {
	
	

int id = IO.getInt("Digite o ID: ");
String user = IO.getString("Digite seu login: ");
String email = IO.getString("Digite seu email: ");;
String password = IO.getString("Digite sua senha: ");;

loginModel.atualizar(id,user,email,password);
 


}

}
