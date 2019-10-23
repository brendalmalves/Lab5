package lab5;

/**
 * Representacao de um combo formado por dois produtos.
 * @@author Brenda Louisy Morais Alves - Matricula 119111113.
 *
 */
public class Combo implements ProdutoInterface {
	
	/**
	 * Representacao do nome do combo.
	 */
	private String nome;
	/**
	 * Representacao da descricao do combo.
	 */
	private String descricao;
	/**
	 * Representacao do fator desconto do combo.
	 */
	private double fator;
	/**
	 * Representacao do preco do produto 1 que forma o combo.
	 */
	private double precoProduto1;
	/**
	 * Representacao do preco do produto 2 que forma o combo.
	 */
	private double precoProduto2;
	/**
	 * Representacao do tipo do produto.
	 */
	private String tipoProduto;
	/**
	 * Representacao do preco final do combo, aplicado o fator desconto.
	 */
	private double preco;
	
	/**
	 * Responsavel pela construcao de um combo, a partir do nome, descricao,
	 * fator, preco do produto 1 e do produto 2.
	 * @param nome
	 * @param descricao
	 * @param fator
	 * @param precoProduto1
	 * @param precoProduto2
	 */
	public Combo(String nome, String descricao, double fator, double precoProduto1, double precoProduto2) {
		this.nome = nome;
		this.descricao = descricao;
		this.fator = fator;
		this.precoProduto1 = precoProduto1;
		this.precoProduto2 = precoProduto2;
		this.tipoProduto = "combo";
		this.preco = (precoProduto1 + precoProduto2) - ((precoProduto1 + precoProduto2) * fator);
	}

	/**
	 * Representacao em String dos dados de um combo.
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - R$" + String.format("%.2f",this.preco).replace(".", ",");
	}

	/**
	 * Responsavel por retornar o preco.
	 */
	public double getPreco() {
		return preco;
	}


	/**
	 * Responsavel por retornar o nome.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Responsavel por permitir a alteracao do preco.
	 */
	private void setPreco() {
		this.preco = (precoProduto1 + precoProduto2) - ((precoProduto1 + precoProduto2) * fator);
	}

	/**
	 * Responsavel por retornar o tipo de produto.
	 */
	public String getTipoProduto() {
		return tipoProduto;
	}
	
	/**
	 * Permite a alteracao do fator.
	 * @param novoFator
	 */
	public void setFator(double novoFator) {
		this.fator = novoFator;
		setPreco();
	}

	/**
	 * Representacao em inteiro que verifica se um combo é igual 
	 * ao outro atraves do nome e descricao.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	/**
	 * Representacao em booleano que verifica se um combo é igual 
	 * ao outro atraves do nome e descricao.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combo other = (Combo) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	

}
