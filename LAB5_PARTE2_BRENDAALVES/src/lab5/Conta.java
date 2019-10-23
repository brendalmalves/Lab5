package lab5;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	
	private String fornecedor;
	private String cliente;
	private double debito;
	private List<Compra> compras;
	
	
	public Conta(String fornecedor, String cliente) {
		this.fornecedor = fornecedor;
		this.debito = 0.0;
		this.compras = new ArrayList<Compra>();
	} 
	
	public void adicionaCompra(String nomeProduto, double preco, String data, String descricaoProduto) {
		this.debito += preco;
		compras.add(new Compra(nomeProduto, descricaoProduto, preco, data, cliente, this.fornecedor));
	}

	public double getDebito() {
		return debito;
	}
	
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
