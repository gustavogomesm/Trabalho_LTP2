package Mercearia;

import Library.IO;
import Library.estoqueModel;


public class Estoque {

public static void  Menu_Estoque() {
	
	
	  int quantidade;
	  int idproduto;
	  int id;
	
	boolean fim = false;
	System.out.println();
	do {

		System.out.println(" ####   Menu do Estoque   ####");
		System.out.println("1 - Listar Produtos em Estoque");
		System.out.println("2 - adicionar Produto");
		System.out.println("3 - atualizar quantidade");
		System.out.println("4 - Apagar Produtos do Estoque");
		System.out.println("5 - Tela Inicial");
	int opcao = IO.getInt("Selecione a opção desejada: ");
	
	switch(opcao) {
	  case 1:
		  estoqueModel.listarTodos();
	    break;
	  case 2:
	
		  idproduto = IO.getInt("Digite o id do produto: ");
		  quantidade = IO.getInt("Digite a qauntidade: ");;
		   

		  estoqueModel.inserir(idproduto,quantidade);
	    break;
	  case 3:
	//	  
		  estoqueModel.listarTodos();

		  idproduto = IO.getInt("Digite o ProdutoID: ");
		  quantidade = IO.getInt("Digite a qauntidade: ");;
		   

		   estoqueModel.atualizar(idproduto,quantidade);
	  case 4:
		  estoqueModel.listarTodos();
		   id = IO.getInt("Digite o ID: ");

		   estoqueModel.remover(id);
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
