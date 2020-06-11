package Mercearia;


import Library.*;
public class Login {

public static void Pergunta_login() {
	
	
	
String user;
String password;

	

user= IO.getString("Digite o Usuario");
password= IO.getString("Digite a senha");


System.out.println("seu login ´: " + user);
System.out.println("sua senha ´: " + password);

}

}
