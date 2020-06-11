package Library;
import java.util.Scanner;
public class IO {


		static Scanner leia = new Scanner(System.in);
		public static int getIntBetween(String textLabel , int minValue, int maxValue) {
			int ValueBtween;
			
			do {
				System.out.println("===========================");
				System.out.print(textLabel);
				ValueBtween = leia.nextInt();
				if(ValueBtween < minValue || ValueBtween > maxValue ) {
					System.err.println("O número deve ser entre "+minValue+" e "+maxValue+" !");
				}
			} while (ValueBtween < minValue || ValueBtween > maxValue );
			
			return ValueBtween;
		}
		public static char getCharUpperCase(String texto) {
			System.out.print(texto);
			return leia.next().toUpperCase().charAt(0);
		}
		public static String getStringUpperCase(String texto) {
			String valor = "";
			System.out.print(texto);
			
			do {	
				valor = leia.nextLine().toUpperCase();
			} while (valor.equals("") || valor.isEmpty());

			return valor;

		}
		public static char getSorN(String texto) {
			char opcao;
			do {
				opcao = getCharUpperCase(texto);
				if (opcao != 'S' && opcao != 'N') {
					System.out.println("Você deve informar S ou N");
				}
			} while (opcao != 'S' && opcao != 'N');

			return opcao;
		}
		public static int getInt(String textLabel) {
			System.out.println("===========================");
			System.out.print(textLabel);

			return leia.nextInt();
		}

		public static float getFloat(String textLabel) {
			System.out.println("===========================");
			System.out.print(textLabel);

			return leia.nextFloat();
		}
			
		public static char getChar(String textLabel) {
			System.out.println("===========================");
			System.out.print(textLabel);

			return leia.next().charAt(0); 
		}
		
		public static String getString(String textLabel) {
			String text;

			System.out.println("===========================");
			System.out.print(textLabel);
			do {
				text = leia.nextLine();
			} while (text.equalsIgnoreCase(""));
			
			return text;
		}
		
		public static float getFloatBetween(String textLabel , int minValue, int maxValue) {
			float ValueBtween;
			
			do {
				System.out.println("===========================");
				System.out.print(textLabel);
				ValueBtween = leia.nextInt();
				if(ValueBtween < minValue || ValueBtween > maxValue ) {
					System.err.println("O número deve ser entre "+minValue+" e "+maxValue+" !");
				}
			} while (ValueBtween < minValue || ValueBtween > maxValue );
			

			return ValueBtween;
		}
		
		public static char getCharUpperCase(char ch) {
			
			char letra = Character.toUpperCase(ch);
			
			return letra;
			}
		
		public static String getDateValid(String data) {
			if (data.length() != 10) {

				return "Data inválida, digite 10 caracteres DD/MM/AAAA";
			}
			if (data.charAt(2) != '/' || data.charAt(5) != '/') {
				
				return "Data inválida, digite / no 3º. e 6º. caracteres DD/MM/AAAA";
			}
			try {
				
				int mes = Integer.parseInt(data.substring(3, 5));
				if (mes < 1 || mes > 12) {
					return "Data inválida, digite mes entre 1 e 12";
				}
				int dia = Integer.parseInt(data.substring(0, 2));
				if (dia < 1 || dia > 31) {
					return "Data inválida, digite dia entre 1 e 31";
				}
				if (mes == 2 && dia > 28) {

					return "Data inválida, para fevereiro, digite dia entre 1 e 28";
				}
				if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
					
					return "Data inválida, para meses 4,6,9 e 11, digite dia entre 1 e 30";
				}
			} catch (NumberFormatException e) {

				return "Data inválida, digite dia, mes e ano numéricos";
			}
			return data;
		}

		public static String getValidarHora(String horario) {
			int hora, minuto;
			
			

			//Verificar se tem 5 posições para atender o formato HH:MM
			
			if(horario.length()!=5){
				return ("A hora tem que ser no formato HH:MM");
			}
			
			try {
				hora = Integer.parseInt(horario.substring(0, 2));
				minuto = Integer.parseInt(horario.substring(3));
			} catch (NumberFormatException e) {
				return ("Horario Inválido, digite no formato HH:MM");
				
			}

			if (horario.charAt(2) != ':') {
				return ("Horario Inválido, digite no formato HH:MM");
				
			}
			if (hora < 0 || hora > 23) {
				return  ("Horario Inválido, digite hora entre 0 e 23");
				
			}
			if (minuto < 0 || minuto > 59) {
				return  ("Horario Inválido, digite minuto entre 0 e 59");
				
			}

			return horario;
		}

		public static int getDestino() {
			int codDestino;
			do {
			System.out.println("REGIÃO ====================== ");
			System.out.println(" 1 - Região norte");
			System.out.println(" 2 - Região nordeste");
			System.out.println(" 3 - Região centro-oeste");
			System.out.println(" 4 - Região sul");
			System.out.print(">>> Informe o código:");
			codDestino = leia.nextInt();
			if (codDestino < 1 || codDestino > 4) {
				System.err.println(" >>>>>> O Código deve ser entre 1 e 4");
			}
			} while (codDestino < 1 || codDestino > 4);
			System.out.println("codigo digitado: "+ codDestino);

			return codDestino;
		}
		
		
		public static int getTipo() {
			int codTipo;
			do {
				System.out.println("TIPO =================");
				System.out.println(" 1 - Ida");
				System.out.println(" 2 - Ida e Volta");
				System.out.print(">>> Informe o código:");
				codTipo = leia.nextInt();
				if (codTipo < 1 || codTipo > 2) {
					System.err.println(" >>>>>> O Código deve ser entre 1 e 2");
				}
			} while (codTipo < 1 || codTipo > 2);
			return codTipo;
		}
		
		public static int getPassageiros() {
			int quantidadePassagens;
			do {
				System.out.println("Informe a QUANTIDADES de passagens: ");
				quantidadePassagens = leia.nextInt();
				if (quantidadePassagens < 1) {
					System.err.println(" >>>>>> A Quantidade deve ser maior que ZERO!");
				}
			} while (quantidadePassagens < 1);
		return quantidadePassagens;
		}
		
		
	}
	
	

