package Library;

import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Utils {
	static Scanner leia = new Scanner(System.in);


	
	
	
	
	public static int isIntergerNumberPositive(String textLabel) {
		
		int value;
			
			do {
				System.out.println("===========================");
				System.out.print(textLabel);
				value = leia.nextInt();
				if(value < 0) {
					System.err.println("O número deve ser maior ou igual a zero!");
				}
			} while (value < 0);
			

			return value;
		}
		
	public static boolean confirmExit() {
		char sair;

		System.out.println("===========================");
		System.out.println("============Deseja Sair?=============");
		System.out.println("=========Digite Sim ou Nao==========");

		sair = leia.next().charAt(0);
		sair = Character.toUpperCase(sair);
		
		
		if(sair == 'S') {
		return true;
		}else {
	    return false;
		}		
	}
	
	public static float isFloatNumberPositive(String textLabel) {
		
		float value;
			
			do {
				System.out.println("===========================");
				System.out.print(textLabel);
				value = leia.nextFloat();
				if(value < 0) {
					System.err.println("O número deve ser maior ou igual a zero!");
				}
			} while (value < 0);
			

			return value;
		}
	
	public static int dateCompareTo(String data1,String data2) {
		
		DateFormat f = new SimpleDateFormat("dd/mm/yyyy");

			Date d1;
			Date d2;

			d1 = f.parse(data1, new ParsePosition(0));
			d2 = f.parse(data2, new ParsePosition(0));
			
		return (d2 .compareTo(d1));
		}

	public static String capitalize(String nome) {
	boolean verificaEspaco = false;
	boolean verificaExecoes = true;
	
	char[] letras = new char[nome.length()];
	
	for (int i = 0; i < nome.length(); i++) {
		char letra = nome.charAt(i);


	
	
		if(i==0) {
			letras[i] = Character.toUpperCase(letra);
		}else if(verificaExecoes == false) {
			letras[i] = Character.toLowerCase(letra);
		}else if(verificaEspaco == true) {
			
			 letras[i] = Character.toUpperCase(letra);
		}
		else {
			
			letras[i] = letra;
		}
		
		
		if(letra == ' ') {
			verificaEspaco = true;
		}else {
			verificaEspaco = false;
		}
		

	}

	String str = new String(letras);
	
	return str;
	}
		
	// utilizado pelo capitalize para verificaçoes
	public static boolean VerifiarExecoes(char v1,char v2,char v3,char v4,char v5) {
		char[] pelo = new char[5];
		char[] de = new char[3];
		char[] da = new char[3];
		char[] em = new char[3];
		char[] e = new char[2];
		char[] ou = new char[3];
		char[] as = new char[3];
		char[] os = new char[3];
	//	nome.charAt(i),nome.charAt(i+1),nome.charAt(i+2),nome.charAt(i+3),nome.charAt(i+4),
		pelo[0] = v1;
		pelo[1] = v2;
		pelo[2] = v3;
		pelo[3] = v4;
		pelo[4] = v5;
		
		de[0] = v1;
		de[1] = v2;
		de[2] = v3;
		
		da[0] = v1;
		da[1] = v2;
		da[2] = v3;
		
		em[0] = v1;
		em[1] = v2;
		em[2] = v3;
		
		e[0] = v1;
		e[1] = v2;
		
		as[0] = v1;
		as[1] = v2;
		as[2] = v3;	
		
		ou[0] = v1;
		ou[1] = v2;
		ou[2] = v3;	
		
		os[0] = v1;
		os[1] = v2;
		os[2] = v3;
		
		String S_pelo = new String(pelo);
		String S_de = new String(de);
		String S_da = new String(da);
		String S_em = new String(em);
		String S_e = new String(e);
		String S_as = new String(as);
		String S_ou = new String(ou);
		String S_os = new String(os);
		
		
		
		boolean verificacao = true;
		if(S_pelo.toUpperCase().equals("PELO ")) {
			verificacao = false;
		}else if(S_de.toUpperCase().equals("DE ")) {
			verificacao = false;
		}else if(S_da.toUpperCase().equals("DA ")) {
			verificacao = false;
		}else if(S_em.toUpperCase().equals("EM ")) {
			verificacao = false;
		}else if(S_e.toUpperCase().equals("E ")) {
			verificacao = false;
		}else if(S_as.toUpperCase().equals("AS ")) {
			verificacao = false;
		}else if(S_ou.toUpperCase().equals("OU ")) {
			verificacao = false;
		}else if(S_os.toUpperCase().equals("OS ")) {
			verificacao = false;
		}
		

		
		pelo = null;
		de  = null;
		da  = null;
		em  = null;
		 e  = null;
		ou  = null;
		as  = null;
		os  = null;
		
		return verificacao;
		
	}
	
	
	
	public static boolean Verificaplaca(String placa) {
		
		boolean verifica[] = new boolean[7], verifica2[] = new boolean[7];
	if(placa.length() == 7) {
	for (int i = 0; i <= 6; i++) {
		
		char letra = placa.charAt(i);
		
		if(!Character.isDigit( letra ) && i < 3) {
			 
			verifica[i] = true;
		}else if(i < 3){
			verifica2[i] = false;
		}else {
			verifica2[i] = false;
		}
		
		if(Character.isDigit( letra ) && i > 2) {
			verifica2[i] = true;
		}else if(i > 2){
			verifica2[i] = false;
		}else {
			verifica2[i] = false;
		}
	}
	
	}else { System.out.println("tamanho invalido");}
	
	if(verifica[0] == true && verifica[1]== true && verifica[2]==true && verifica2[3] == true && verifica2[4] == true && verifica2[5] == true && verifica2[6] == true) {
		return true;
	}
	return false;
	
}
	
	
	
	public static boolean validarString(String textLabel) {

		
		for (int i = 0; i < textLabel.length(); i++) {

			if (i >= 0 ) {
					
				if (textLabel.toUpperCase().charAt(i) < 'A' || textLabel.toUpperCase().charAt(i) > 'Z') {
					for (int a = 0; a < textLabel.length(); a++) {
					System.out.println("Você digitou '" + textLabel.charAt(a));
					}
					System.out.println("Digite somente letras");
					return false;
					} else{
						return true;
					}
				} 
			}
		return true;
		

}

public static int calculoMinutosViagem(float kmCidade) {

String armazenar;
float a, casa1;
int valorEmMinutos;
a = kmCidade/800;
armazenar = String.valueOf(a);
casa1 = Float.parseFloat(armazenar.substring(0,1));
// casa2 = Float.parseFloat(armazenar.substring(2));

valorEmMinutos = (int) (casa1*60);




	
return valorEmMinutos;
}

public static int escala(float kmCidade){
int escala = 0;
String armazenar;
float a;

a = kmCidade/800;
armazenar = String.valueOf(a);
escala = Integer.parseInt(armazenar.substring(0,1));

	if(escala >= 3){
		escala = escala/3;
	}	
	
	return escala;
}

public static float valorPassagem(float kmCidade){

float resultadoFinal = kmCidade * 0.25f;


return resultadoFinal;
	
}
	
// 1205

public static String destinoPassageiro(int codDestino) {
	String destino;
	if (codDestino == 1) { // Norte
		destino = "Região Norte";
	} else if (codDestino == 2) { // Nordeste
		destino = "Região Nordeste";
	} else if (codDestino == 3) {// Centro-Oeste
		destino = "Região Centro-Oeste";
	} else {// Sul
		destino = "Região Sul";
	}
	
	return destino;
}

public static float precoPassagem(int codDestino, int codTipo) {
	float preco;

	if (codDestino == 1) { // Norte
		if (codTipo == 1) { // Somente Ida
			preco = 500;
		} else { // Ida e Volta
			preco = 900;
		}
	} else if (codDestino == 2) { // Nordeste
		if (codTipo == 1) { // Somente Ida
			preco = 350;
		} else { // Ida e Volta
			preco = 650;
		}
	} else if (codDestino == 3) {// Centro-Oeste
		if (codTipo == 1) { // Somente Ida
			preco = 350;
		} else { // Ida e Volta
			preco = 600;
		}
	} else {// Sul
		if (codTipo == 1) { // Somente Ida
			preco = 300;
		} else { // Ida e Volta
			preco = 550;
		}
	}
	return preco;
}
}
