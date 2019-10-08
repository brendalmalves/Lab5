package lab5;

/**
 * Representacao de um produto a ser cadastrado em um fornecedor.
 * 
 * @author Brenda Louisy Morais Alves - Matricula 119111113.
 *
 */
public class Produto {
	
	/**
	 * Representacao em double do preco do produto.
	 */
	private double preco;

	/**
	 * Representacao em String do nome do produto.
	 */
	private String nome;
	/**
	 * Representacao em String da descricao do produto.
	 */
	private String descricao;
	
	public String getNome() {
		return nome;
	}


	public String getDescricao() {
		return descricao;
	}


	/**
	 * Constroi um produto a partir do seu nome, descricao e preco.
	 * @param nome do produto
	 * @param descricao do produto
	 * @param preco do produto
	 */
	public Produto(String nome, String descricao, double preco) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nome, "Erro no cadastro do produto: nome nao pode ser vazio ou nulo.");
		validaEntrada.validaString(descricao, "Erro no cadastro do produto: descricao nao pode ser vazia ou nula.");
		validaEntrada.validaNumeroPositivo(preco, "Erro no cadastro de produto: preco invalido.");
		this.descricao = descricao;
		this.nome = nome;
		this.preco = preco;
	}
	
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	/**
	 * Responsavel por gerar uma representacao em String dos dados do produtos, 
	 * com nome, descricao e preco.
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - R$" + String.format("%.2f",this.preco).replace(".", ",");
	}
	

	/**
	 * Representacao em inteiro de um produto, a partir do nome e descricao.
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
	 * Retorna um valor booleano que verifica se um produto 
	 * é igual ao outro, considerando nome e descricao de ambos.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
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
