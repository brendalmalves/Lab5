package lab5;

public class Compra {

	
	private String nomeProduto;
	private String descricaoProduto;
	private double preco;
	private String data;
	private String cliente;
	private String fornecedor;
	
	public Compra(String nomeProduto, String descricaoProduto, double preco, String data, String cliente,
			String fornecedor) {
		super();
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.preco = preco;
		this.data = data;
		this.cliente = cliente;
		this.fornecedor = fornecedor;
	}
	
	@Override
	public String toString() {
		return this.nomeProduto + " - " + this.data.replaceAll("/", "-");
	}
	
}
