package lab5;

import java.util.HashMap;

/**
 * Representacao de um fornecedor, resposavel por 
 * administrar também os produtos cadastrados em seu nome.
 * 
 * @author Brenda Louisy Morais Alves - Matrícula 119111113.
 *
 */
public class FornecedorController {

	/**
	 * Representacao de um mapa que armazena os fornecedores.
	 */
	private HashMap<String, Fornecedor> fornecedores;
	
	/**
	 * Constroi a representacao do mapa responsavel
	 * por armazenar os fornecedores.
	 */
	public FornecedorController() {
		this.fornecedores = new HashMap<String, Fornecedor>();
	}
	
	/**
	 * Responsavel por cadastrar um fornecedor no sistema.
	 * @param nome do fornecedor
	 * @param email do fornecedor
	 * @param telefone do fornecedor
	 * @return nome do fornecedor caso o cadastro seja bem sucedido
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nome);
		validaEntrada.validaString(email);
		validaEntrada.validaString(telefone);
		if(existeFornecedor(nome)) {
			throw new IllegalArgumentException("Fornecedor já cadastrado!");
		}
		this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
		return nome;
	}
	
	/**
	 * Responsavel por verificar se existe determinado
	 * fornecedor cadastrado no sistema.
	 * @param nome do fornecedor
	 * @return valor booleano indicando se existe ou nao
	 */
	public boolean existeFornecedor(String nome) {
		return this.fornecedores.containsKey(nome);
	}
	
	/**
	 * Responsavel por exibir um fornecedor a partir do seu nome.
	 * @param nome do fornecedor
	 * @return representacao em String dos dados do fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nome);
		String result = "";
		if(existeFornecedor(nome)) {
			result = this.fornecedores.get(nome).toString();
		}
		return result;
	}

	/**
	 * Responsavel por exibir os dados de todos os fornecedores
	 * cadastrados no sistema.
	 * @return representacao em String de todos os fornecedores cadastrados.
	 */
	public String exibeTodosOsFornecedores() {
		String listaFornecedores = "";
		for (String nome : fornecedores.keySet()) {
			listaFornecedores += this.fornecedores.get(nome).toString() + " | ";	
		}
		return listaFornecedores;
	}

	/**
	 * Responsavel por editar o cadastro de um fornecedor.
	 * @param nome do fornecedor
	 * @param comando dado a ser editado
	 * @return valor booleano indicando se a operacao foi bem sucedida ou nao
	 */
	public boolean editaCadastro(String nome, String comando) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nome);
		
		if(existeFornecedor(nome)) {
			if(comando.trim().toUpperCase().equals("email")) {
				this.fornecedores.get(nome).setEmail();
			} else if(comando.trim().toUpperCase().equals("telefone")) {
				this.fornecedores.get(nome).setTelefone();
			}
			return true;
		}
		return false;
	}

	/**
	 * Responsavel por remover um fornecedor cadastrado no sistema.
	 * @param nome do fornecedor
	 * @return valor booleano indicando se a remocao foi bem sucedida ou nao
	 */
	public boolean removeFornecedor(String nome) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nome);
		if(existeFornecedor(nome)) {
			this.fornecedores.remove(nome);
			return true;
		}
		return false;
	}
	
	/**
	 * Responsavel por cadastrar um produto no fornecedor indicado.
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao do produto
	 * @param preco do produto
	 * @return valor booleano indicando se o cadastro foi bem sucedido ou nao
	 */
	public boolean cadastraProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nomeFornecedor);
		validaEntrada.validaString(nomeProduto);
		validaEntrada.validaString(descricao);
		return this.fornecedores.get(nomeFornecedor).cadastarProduto(nomeProduto, descricao, preco);
		
	}
	
	/**
	 * Responsavel por consultar um produto cadastrado em 
	 * um determinado fornecedor
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao do produto
	 * @return representacao em String de um produto 
	 */
	public String consultaProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nomeFornecedor);
		validaEntrada.validaString(nomeProduto);
		validaEntrada.validaString(descricao);
		return this.fornecedores.get(nomeFornecedor).consultarProduto(nomeProduto, descricao);
	}
	
	/**
	 * Responsavel por consultar todos os produtos de um fornecedor
	 * @param nomeFornecedor
	 * @return representacao em String dos produtos de um fornecedor
	 */
	public String consultarTodosProdutos(String nomeFornecedor) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nomeFornecedor);
		return this.fornecedores.get(nomeFornecedor).exibirTodosOsProdutos();
	}
	
	/**
	 * Responsavel por exibir todos os produtos cadastrados no sistema, em geral
	 * @return representacao em String de todos os produtos
	 */
	public String exibeTodosProdutosCadastrados() {
		String listaProdutos = "";
		for (String fornecedor : fornecedores.keySet()) {
			listaProdutos += consultarTodosProdutos(fornecedor);
		}
		return listaProdutos;
	}	
	
	/**
	 * Responsavel por editar um produto
	 * 
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao
	 * @param comando dado a ser editado
	 * @return valor booleano indicando se a edicao foi bem sucedida ou ano
	 */
	public boolean editaProduto(String nomeFornecedor, String nomeProduto, String descricao, String comando) {
		return this.fornecedores.get(nomeFornecedor).editaProduto(nomeProduto, descricao, comando);
	}
	
	/**
	 * Responsavel por remover um produto cadastrado
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao do produto
	 * @return valor booleando indicando se a remocao foi bem sucedida ou nao
	 */
	public boolean removeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nomeFornecedor);
		validaEntrada.validaString(nomeProduto);
		validaEntrada.validaString(descricao);
		return this.fornecedores.get(nomeFornecedor).removeProduto(nomeProduto, descricao);
	}

	
	
	
	
	
	
	
	
}
