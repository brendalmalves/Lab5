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
		validaEntrada.validaString(cpf);
		validaEntrada.validaString(nome);
		validaEntrada.validaString(email);
		validaEntrada.validaString(localizacao);
		if(existeCliente(cpf)) {
			throw new IllegalArgumentException("Cliente já cadastrado!");
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
		validaEntrada.validaString(cpf);
		String result = "";
		if(existeCliente(cpf)) {
			result = this.clientes.get(cpf).toString();			
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
		validaEntrada.validaString(cpf);
		
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
		validaEntrada.validaString(cpf);
		if(existeCliente(cpf)) {
			this.clientes.remove(cpf);
			return true;
		}
		return false;
	}
}
