package Mercearia;



import Library.IO;

import Library.produtoModel;


public class Produto {
	public static void  Menu_Produto() {
		
		int id;
		String nome;
		float Valor;
 String Categoria;
String Descricao;
		
		boolean fim = false;
		System.out.println();
		do {

			System.out.println(" ####   Menu do Produto   ####");
			System.out.println("1 - Listar Produtos em Estoque");
			System.out.println("2 - adicionar Produto");
			System.out.println("3 - atualizar quantidade");
			System.out.println("4 - Apagar Produtos do Estoque");
			System.out.println("5 - Tela Inicial");
		int opcao = IO.getInt("Selecione a opção desejada: ");
		
		switch(opcao) {
		  case 1:
			  produtoModel.listarTodos();
		    break;
		  case 2:
		
			  nome = IO.getString("Digite o nome do produto: ");
			  Valor = IO.getFloat("Digite o valor do produto: ");;
			  Categoria = IO.getString("Digite a categoria do produto: ");
			  Descricao = IO.getString("Digite a descrição: ");;

			  produtoModel.inserir( nome, Valor,  Categoria, Descricao);
		    break;
		  case 3:
		//	  
			  produtoModel.listarTodos();
			  id = IO.getInt("Digite o id do produto: ");
			  nome = IO.getString("Digite o nome do produto: ");
			  Valor = IO.getFloat("Digite o valor do produto: ");;
			  Categoria = IO.getString("Digite a categoria do produto: ");
			  Descricao = IO.getString("Digite a descrição: ");;

			  produtoModel.atualizar(id,nome, Valor,  Categoria, Descricao);
			  break;
		  case 4:
			  produtoModel.listarTodos();
			   id = IO.getInt("Digite o ID: ");

			   produtoModel.remover(id);
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
