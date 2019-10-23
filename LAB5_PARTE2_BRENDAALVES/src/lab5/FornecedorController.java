package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

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
		validaEntrada.validaString(nome, "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		validaEntrada.validaString(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		validaEntrada.validaString(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		if(existeFornecedor(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
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
		validaEntrada.validaString(nome, "Erro na exibicao do fornecedor: fornecedor nao existe.");
		String result = "";
		if(existeFornecedor(nome)) {
			result = this.fornecedores.get(nome).toString();
		} else {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
		return result;
	}

	/**
	 * Responsavel por exibir os dados de todos os fornecedores
	 * cadastrados no sistema.
	 * @return representacao em String de todos os fornecedores cadastrados.
	 */
	public String exibeTodosOsFornecedores() {
		List<Fornecedor> fornecedoresOrdenados = new ArrayList<>(fornecedores.values());
		Collections.sort(fornecedoresOrdenados, Comparator.comparing(Fornecedor::getNome));
		String listaFornecedores = "";
		for (int i = 0; i < fornecedoresOrdenados.size(); i++) {
			if(i == fornecedoresOrdenados.size() - 1) {
				listaFornecedores += fornecedoresOrdenados.get(i).toString();
			} else {
				listaFornecedores += fornecedoresOrdenados.get(i).toString() + " | ";					
			}
		}
		return listaFornecedores;
	}

	/**
	 * Responsavel por editar o cadastro de um fornecedor.
	 * @param nome do fornecedor
	 * @param atributo dado a ser editado
	 * @return valor booleano indicando se a operacao foi bem sucedida ou nao
	 */
	public boolean editaCadastro(String nome, String atributo, String novoValor) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		validaEntrada.validaString(atributo, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		validaEntrada.validaString(novoValor,"Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		if(existeFornecedor(nome)) {
			if(atributo.trim().toLowerCase().equals("nome")) {
				throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
			} else if(atributo.trim().toLowerCase().equals("email")) {
				this.fornecedores.get(nome).setEmail(novoValor);
			} else if(atributo.trim().toLowerCase().equals("telefone")) {
				this.fornecedores.get(nome).setTelefone(novoValor);
			} else {
				throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
			}
		} else {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
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
		validaEntrada.validaString(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		if(existeFornecedor(nome)) {
			this.fornecedores.remove(nome);
			return true;
		} else {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
		
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
		validaEntrada.validaString(nomeFornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		validaEntrada.validaString(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		validaEntrada.validaString(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		if(existeFornecedor(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor).cadastarProduto(nomeProduto, descricao, preco);
		} else {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");			
		}
		
	}
	
	/**
	 * Responsavel por consultar um produto cadastrado em 
	 * um determinado fornecedor
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao do produto
	 * @return representacao em String de um produto 
	 */
	public String consultaProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		validaEntrada.validaString(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		validaEntrada.validaString(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		if(existeFornecedor(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor).consultarProduto(nomeProduto, descricao);
		} else {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
	}
	
	/**
	 * Responsavel por consultar todos os produtos de um fornecedor
	 * @param nomeFornecedor
	 * @return representacao em String dos produtos de um fornecedor
	 */
	public String consultarTodosProdutos(String nomeFornecedor) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nomeFornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if(existeFornecedor(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor).exibirTodosOsProdutos();			
		} else {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
	}
	
	/**
	 * Responsavel por exibir todos os produtos cadastrados no sistema, em geral
	 * @return representacao em String de todos os produtos
	 */
	public String exibeTodosProdutosCadastrados() {
		List<Fornecedor> fornecedoresProdutosOrdenados = new ArrayList<Fornecedor>(fornecedores.values());
		Collections.sort(fornecedoresProdutosOrdenados, Comparator.comparing(Fornecedor::getNome));
		String listaProdutos = "";
		for (int i = 0; i < fornecedoresProdutosOrdenados.size(); i++) {
			if(i == fornecedoresProdutosOrdenados.size() - 1) {
				listaProdutos += fornecedoresProdutosOrdenados.get(i).exibirTodosOsProdutos();				
			} else {
				listaProdutos += fornecedoresProdutosOrdenados.get(i).exibirTodosOsProdutos() + " | ";				
			}			
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
	public boolean editaProduto(String nomeProduto, String descricao, String nomeFornecedor, double novoValor) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nomeProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		validaEntrada.validaString(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		validaEntrada.validaString(nomeFornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if(existeFornecedor(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor).editaProduto(nomeProduto, descricao, novoValor);
		} else {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
	}
	
	/**
	 * Responsavel por remover um produto cadastrado
	 * @param nomeFornecedor
	 * @param nomeProduto
	 * @param descricao do produto
	 * @return valor booleando indicando se a remocao foi bem sucedida ou nao
	 */
	public boolean removeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nomeFornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		validaEntrada.validaString(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		validaEntrada.validaString(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		if(existeFornecedor(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor).removeProduto(nomeProduto, descricao);			
		} else {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
	}

	public boolean existeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		 return this.fornecedores.get(nomeFornecedor).existeProduto(nomeProduto, descricao);
	}
	
	public boolean existeCombo(String nomeFornecedor, String nomeCombo, String descricao) {
		return this.fornecedores.get(nomeFornecedor).existeProduto(nomeCombo, descricao);
	}

	public double getPreco(String nomeFornecedor, String nomeProduto, String descricao) {
		return this.fornecedores.get(nomeFornecedor).getPreco(nomeProduto, descricao);
	}

	public void adicionaCombo(String nomeFornecedor, String nomeCombo, String descricao, double fator, double precoProduto1, double precoProduto2) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		validaEntrada.validaString(nomeCombo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		if(!existeFornecedor(nomeFornecedor)) {
			throw new IllegalArgumentException("");
		}
		this.fornecedores.get(nomeFornecedor).adicionaCombo(nomeCombo, descricao, fator, precoProduto1, precoProduto2);
		
	}

	public Fornecedor getFornecedor(String nomeFornecedor) {
		if(existeFornecedor(nomeFornecedor)) {
			return this.fornecedores.get(nomeFornecedor);
		}
		return null;
	}

	public void editaCombo(String nomeCombo, String descricao, String nomeFornecedor, double novoFator) {
		if(existeFornecedor(nomeFornecedor)) {
			this.fornecedores.get(nomeFornecedor).editaCombo(nomeCombo, descricao, novoFator);
		}
		
		
	}

	
	
	
	
	
	
	
	
}
