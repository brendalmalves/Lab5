package lab5;

import java.util.ArrayList;
import java.util.List;

/**
 * Representacao de uma conta de um cliente em determinado fornecedor.
 * @author Brenda Louisy Morais Alves - Matricula 119111113.
 *
 */
public class Conta {
	
	/**
	 * Representacao de um fornecedor.
	 */
	private String fornecedor;
	/**
	 * Representacao de um cliente.
	 */
	private String cliente;
	/**
	 * Representacao do debito do cliente na conta.
	 */
	private double debito;
	/**
	 * Representacao da lista que armazena as compras de uma conta.
	 */
	private List<Compra> compras;
	
	/**
	 * Responsavel por construir uma conta de um cliente em um fornecedor.
	 * @param fornecedor
	 * @param cliente
	 */
	public Conta(String fornecedor, String cliente) {
		this.fornecedor = fornecedor;
		this.debito = 0.0;
		this.compras = new ArrayList<Compra>();
	} 
	
	/**
	 * Responsavel por adicionar a compra do cliente na conta.
	 * @param nomeProduto
	 * @param preco
	 * @param data
	 * @param descricaoProduto
	 */
	public void adicionaCompra(String nomeProduto, double preco, String data, String descricaoProduto) {
		this.debito += preco;
		compras.add(new Compra(nomeProduto, descricaoProduto, preco, data, cliente, this.fornecedor));
	}

	/**
	 * Reponsavel por retornar o debito do cliente em uma conta.
	 * @return
	 */
	public double getDebito() {
		return debito;
	}
	
	/**
	 * Responsavel por gerar uma String com a lista de compras em uma conta.
	 */
	@Override
	public String toString() {
		String listaCompras = this.fornecedor + " | ";
		for (int i = 0; i < compras.size(); i++) {
			if(i == compras.size() - 1) {
				listaCompras += this.compras.get(i);				
			} else {
				listaCompras += this.compras.get(i) + " | ";			
			}
		}
		return listaCompras;
	}

	
	
	
	
	
	
	
}
