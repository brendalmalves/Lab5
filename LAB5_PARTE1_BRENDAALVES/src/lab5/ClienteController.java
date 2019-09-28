package lab5;

import java.util.HashMap;

public class ClienteController {

	private HashMap<String, Cliente> clientes;
	
	public ClienteController() {
		this.clientes = new HashMap<String, Cliente>();
	}
	
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
	
	public boolean existeCliente(String cpf) {
		return this.clientes.containsKey(cpf);
	}
	
	public String exibeCliente(String cpf) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(cpf);
		String result = "";
		if(existeCliente(cpf)) {
			result = this.clientes.get(cpf).toString();			
		}
		return result;
	}
	
	public String exibeTodosOsClientes() {
		String listaClientes = "";
		for (String cpf : clientes.keySet()) {
			listaClientes += this.clientes.get(cpf).toString() + " | ";
		}
		return listaClientes;
		
	}
	
	public boolean editaCadastro(String cpf, String nome, String email, String localizacao) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(cpf);
		validaEntrada.validaString(nome);
		validaEntrada.validaString(email);
		validaEntrada.validaString(localizacao);
		if(existeCliente(cpf)) {
			this.clientes.get(cpf).setNome(nome);
			this.clientes.get(cpf).setEmail(email);
			this.clientes.get(cpf).setLocalizacao(localizacao);	
			return true;
		}
		return false;
	}
	
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
