package lab5;

/**
 * Representacao de um compra realizada pelo cliente.
 * @author Brenda Louisy Morais Alves - Matricula 119111113.
 *
 */
public class Compra {

	/**
	 * Representacao do nome do produto comprado.
	 */
	private String nomeProduto;
	/**
	 * Representacao da descricao do produto comprado.
	 */
	private String descricaoProduto;
	/**
	 * Representacao do preco do produto comprado.
	 */
	private double preco;
	/**
	 * Representacao da data da compra.
	 */
	private String data;
	/**
	 * Representacao do cliente que realizou a compra.
	 */
	private String cliente;
	/**
	 * Representacao do fornecedor.
	 */
	private String fornecedor;
	
	/**
	 * Responsavel por construir a representacao de uma compra.
	 * @param nomeProduto
	 * @param descricaoProduto
	 * @param preco
	 * @param data
	 * @param cliente
	 * @param fornecedor
	 */
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
	
	/**
	 * Representacao em String dos dados da compra.
	 */
	@Override
	public String toString() {
		return this.nomeProduto + " - " + this.data.replaceAll("/", "-");
	}
	
}
