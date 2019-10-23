package lab5;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Representacao de um Controller dos clientes cadastrados, 
 * responsavel pelas acoes realizadas sobre os clientes.
 * 
 * @author Brenda Louisy Morais Alves - Matricula 119111113.
 *
 */

public class ClienteController {

	/**
	 * Representacao de um mapa responsavel por armazenar os clientes cadastrados.
	 */
	private Map<String, Cliente> clientes;
	
	/**
	 * Constroi a representacao de um mapa responsavel por armazenar
	 * os clientes cadastrados.
	 */
	public ClienteController() {
		this.clientes = new HashMap<String, Cliente>();
	}
	
	/**
	 * Retorna uma String que representa o cpf, caso o cadastro seja bem sucedido.
	 * Caso nao, retorna uma excecao e encerra. 
	 * 
	 * @param cpf do cliente
	 * @param nome do cliente
	 * @param email do cliente
	 * @param localizacao do cliente 
	 * @return cpf do cliente em caso de cadastro bem sucedido, excecao em 
	 * caso de cliente ja cadastrado.
	 */
	public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		validaEntrada.validaCpf(cpf, "Erro no cadastro do cliente: cpf invalido.");
		validaEntrada.validaString(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		validaEntrada.validaString(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		validaEntrada.validaString(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		if(existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
		this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
		return cpf;
	}
	
	/**
	 * Verifica se ja existe um cliente cadastrado.
	 * @param cpf do cliente
	 * @return valor booleano indicando se o cliente ja existe ou nao.
	 */
	public boolean existeCliente(String cpf) {
		return this.clientes.containsKey(cpf);
	}
	
	/**
	 * Retorna uma String representando o cliente a ser exibido, 
	 * consultado a partir do cpf.
	 * @param cpf do cliente
	 * @return String com os dados do cliente solicitado.
	 */
	public String exibeCliente(String cpf) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		String result = "";
		if(existeCliente(cpf)) {
			result = this.clientes.get(cpf).toString();			
		}else {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		
		return result;
	}
	
	/**
	 * Gera uma String com os dados de todos os clientes que
	 * estao cadastrados.
	 * @return representacao de uma String com todos os clientes
	 */
	public String exibeTodosOsClientes() {
		List<Cliente> clientesOrdenados = new ArrayList<>(clientes.values());
		Collections.sort(clientesOrdenados, Comparator.comparing(Cliente::getNome));
		String listaClientes = "";
		for (int i = 0; i < clientesOrdenados.size(); i++) {
			if(i == clientesOrdenados.size() - 1) {
				listaClientes += clientesOrdenados.get(i).toString();
			} else {
				listaClientes += clientesOrdenados.get(i).toString() + " | ";
			}
		}
		return listaClientes;
		
	}
	
	
	public boolean editaCadastro(String cpf, String atributo, String novoValor) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		validaEntrada.validaString(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		validaEntrada.validaString(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		if(existeCliente(cpf)) {
			if(atributo.trim().toLowerCase().equals("cpf")) {
				throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
			} else if(atributo.trim().toLowerCase().equals("nome")) {
				this.clientes.get(cpf).setNome(novoValor);
			} else if(atributo.trim().toLowerCase().equals("email")) {
				this.clientes.get(cpf).setEmail(novoValor);
			} else if(atributo.trim().toLowerCase().equals("localizacao")){
				this.clientes.get(cpf).setLocalizacao(novoValor);	
			} else {
				throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
			}
			return true;
		} else {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
	}
	
	/**
	 * Metodo que permite a remocao de um cliente do sistema.
	 * @param cpf do cliente
	 * @return valor booleano indicando se o processo de remocao
	 * foi bem sucedido ou nao.
	 */
	public boolean removeCliente(String cpf) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		validaEntrada.validaCpf(cpf, "Erro na remocao do cliente: cliente nao existe.");
		if(existeCliente(cpf)) {
			this.clientes.remove(cpf);
			return true;
		} else {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}
		
	}

	public void adicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProduto, String descricao,
			double preco) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		if(this.clientes.containsKey(cpf)) {
			this.clientes.get(cpf).adicionaCompra(nomeFornecedor, data, preco, nomeProduto, descricao);
		} else {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}
	}

	public String getDebito(String cpf, String nomeFornecedor) {
		DecimalFormat converteDecimal = new DecimalFormat("#0.00");
		if(!this.clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		}
		return converteDecimal.format(this.clientes.get(cpf).getDebito(nomeFornecedor)).replaceAll(",", ".");
		
	}

	public String exibeConta(String cpf, String nomeFornecedor) {
		if(!this.clientes.get(cpf).verificaConta(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}
		return this.clientes.get(cpf).exibeConta(nomeFornecedor);
		
	}

	public String exibeContas(String cpf) {
		return this.clientes.get(cpf).exibeContas();
	}

}
