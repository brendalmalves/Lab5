package lab5;

import java.util.HashMap;

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
	private HashMap<String, Cliente> clientes;
	
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
		String listaClientes = "";
		for (String cpf : clientes.keySet()) {
			listaClientes += this.clientes.get(cpf).toString() + " | ";
		}
		return listaClientes;
		
	}
	
	/**
	 * Metodo que permite a edicao dos dados do cliente.
	 * @param cpf do cliente
	 * @param nome do cliente
	 * @param email do cliente
	 * @param localizacao do cliente
	 * @return valor booleado indicando se o processo de edicao 
	 * foi bem sucedido ou nao.
	 */
	public boolean editaCadastro(String cpf, String comando) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaCpf(cpf, "Erro no cadastro do cliente: cpf invalido.");
		validaEntrada.validaString(cpf, "Erro na edicao do cliente: cpf nao pode ser editado.");
		
		if(existeCliente(cpf)) {
			if(comando.trim().toUpperCase().equals("nome")) {
				this.clientes.get(cpf).setNome();
			} else if(comando.trim().toUpperCase().equals("email")) {
				this.clientes.get(cpf).setEmail();
			} else if(comando.trim().toUpperCase().equals("localizacao")){
				this.clientes.get(cpf).setLocalizacao();	
			}
			return true;
		}
		return false;
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
		if(existeCliente(cpf)) {
			this.clientes.remove(cpf);
			return true;
		}
		return false;
	}
}
