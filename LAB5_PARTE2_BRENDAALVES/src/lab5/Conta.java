package lab5;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	
	private String fornecedor;
	private double debito;
	private List<String> compras;
	
	
	public Conta(String fornecedor) {
		this.fornecedor = fornecedor;
		this.debito = 0.0;
		this.compras = new ArrayList<String>();
	} 
	
	public void adicionaCompra(String nomeProduto, double preco, String data) {
		this.debito += preco;
		compras.add(nomeProduto);
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
