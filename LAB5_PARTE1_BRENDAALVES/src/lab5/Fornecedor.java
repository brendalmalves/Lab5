package lab5;

import java.util.HashMap;

/**
 * Representacao de um fornecedor que recebe nome, 
 * email e telefone, alem de administrar os produtos cadastrados
 * em seu nome.
 *  
 * @author Brenda Louisy Morais Alves - Matricula 119111113.
 *
 */
public class Fornecedor {

	/**
	 * Representacao em String do nome do cliente;
	 */
	private String nome;
	/**
	 * Representacao em String do email do cliente;
	 */
	private String email;
	/**
	 * Representacao em String do telefone do cliente;
	 */
	private String telefone;
	/**
	 * Representacao do mapa que armazena os produtos cadastrados.
	 */
	private HashMap<String, Produto> produtos;
	
	/**
	 * Constroi a representacao de um fornecedor, a partir do seu
	 * nome, email e telefone.
	 * @param nome do fornecedor
	 * @param email do fornecedor
	 * @param telefone do fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		validaEntrada.validaString(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		validaEntrada.validaString(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<String, Produto>();
		
	}
	
	/**
	 * Responsavel por cadastrar um produto.
	 * @param nome do produto
	 * @param descricao do produto
	 * @param preco do produto
	 * @return valor booleano indicando se o cadastro foi bem sucedido ou nao.
	 */
	public boolean cadastarProduto(String nome, String descricao, double preco) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nome, "Erro no cadastro do produto: nome nao pode ser vazio ou nulo.");
		validaEntrada.validaString(descricao, "Erro no cadastro do produto: descricao nao pode ser vazia ou nula.");
		validaEntrada.validaNumeroPositivo(preco, "Erro no cadastro de produto: preco invalido.");
		if(produtos.containsKey(nome+descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		this.produtos.put(nome+descricao, new Produto(nome, descricao, preco));
		return true;
	}
	
	/**
	 * Responsavel por verificar se ja existe um produto cadastrado,
	 * a partir do seu nome e descricao.
	 * @param nome do produto
	 * @param descricao do produto
	 * @return valor booleano indicando se o produto existe ou nao.
	 */
	public boolean existeProduto(String nome, String descricao) {
		return this.produtos.containsKey(nome+descricao);
	}
	
	/**
	 * Responsavel por retornar uma representacao em String
	 * do produto que deseja consultar.
	 * @param nome do produto
	 * @param descricao do produto
	 * @return representacao em String do produto consultado.
	 */
	public String consultarProduto(String nome, String descricao) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nome, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		validaEntrada.validaString(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		String result = "";
		if(existeProduto(nome, descricao)) {
			result = this.produtos.get(nome+descricao).toString();
		} else {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		return result;
	}
	
	/**
	 * Responsavel por gerar uma representacao em String de todos 
	 * os produtos cadastrados em um fornecedor.
	 * @return todos os produtos cadastrados em um fornecedor.
	 */
	public String exibirTodosOsProdutos() {
		String listaProdutos = "";
		for (String nomeProduto : produtos.keySet()) {
			listaProdutos += this.nome + " - " + this.produtos.get(nomeProduto).toString() + " | ";
		}
		return listaProdutos;
	}
	
	/**
	 * Responsavel por editar o preco do produto selecionado.
	 * @param nome do produto
	 * @param descricao do produto
	 * @param comando dado a ser editado
	 * @return valor booleano indicando se a edicao foi bem sucedida ou nao.
	 */
	public boolean editaProduto(String nome, String descricao, double novoValor) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nome, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		validaEntrada.validaString(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		validaEntrada.validaNumeroPositivo(novoValor, "Erro na edicao de produto: preco invalido.");
		if(existeProduto(nome, descricao)) {
			this.produtos.get(nome+descricao).setPreco(novoValor);
			return true;
		} else {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}
	}
	
	/**
	 * Responsavel por remover um produto cadastrado.
	 * @param nome do produto
	 * @param descricao do produto
	 * @return valor booleano indicando se a remocao foi bem sucedida ou nao.
	 */
	public boolean removeProduto(String nome, String descricao) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nome, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		validaEntrada.validaString(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		if(existeProduto(nome, descricao)) {
			this.produtos.remove(nome+descricao);
			return true;
		} else {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
	}
	
	/**
	 * Metodo que permite a edicao do email do fornecedor.
	 * @param email do fornecedor
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Metodo que permite a edicao do telefone do fornecedor.
	 * @param telefone do fornecedor
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Representacao em String dos dados do fornecedor, com nome, 
	 * email e telefone.
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	/**
	 * Representacao em inteiro do fornecedor, considerando o nome.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Retorna um valor booleano que verifica se um 
	 * fornecedor é igual ao outro, considerando o nome dos dois.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
