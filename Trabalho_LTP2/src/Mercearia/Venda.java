package Mercearia;



import Library.vendaModel;


public class Venda {
	public static void  Menu_venda() {
		
		
	vendaModel sales = new vendaModel();
		boolean fim = false;
		 int cpf = 0;
		 
		sales.print("------- Realizar Venda -------");
		do {
			System.out.println();
		sales.print(" ####   MENU   ####");
		sales.print("1 - Listar produtos");
		sales.print("2 - Adicionar produto no carrinho");
		sales.print("3 - Visualizar Carrinho");
		sales.print("4 - Limpar Carrinho");
		sales.print("5 - Finalizar compra");
		sales.print("6 - Voltar ao Menu inicial");
		int opcao = sales.getInt("Selecione a opção desejada: ");
		
		switch(opcao) {
		  case 1:
			   sales.getProdutos();
		    break;
		  case 2:
			  cpf = sales.getInt("Informe seu CPF: ");
			  int codProduto = sales.getInt("Informe o codigo do produto: ");
			  int quantidade = sales.getInt("Informe a quantidade desejada: ");
			  sales.addCarrinho(cpf,codProduto,quantidade);
		    break;
		  case 3:
			  cpf = sales.getInt("Informe seu CPF: ");
			  sales.getCarrinho(cpf);		
			  break;
		  case 4:
			  cpf = sales.getInt("Informe seu CPF: ");
			  sales.limpaCarrinho(cpf);			  
		    break;
		  case 5:			  
			  cpf = sales.getInt("Informe seu CPF: ");
			  sales.finalizaCompra(cpf);			  
			  fim = true;
		    break;
		  
		  case 6:  
			  fim = true;
		    break;
		  default:
		    // code block
		}
		sales.print("--------------");
	}while(fim != true);

}
	
}
