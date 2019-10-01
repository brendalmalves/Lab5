package lab5;

import java.util.HashMap;

public class FornecedorController {

	private HashMap<String, Fornecedor> fornecedores;
	
	public FornecedorController() {
		this.fornecedores = new HashMap<String, Fornecedor>();
	}

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
	
	public boolean existeFornecedor(String nome) {
		return this.fornecedores.containsKey(nome);
	}

	public String exibeFornecedor(String nome) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nome);
		String result = "";
		if(existeFornecedor(nome)) {
			result = this.fornecedores.get(nome).toString();
		}
		return result;
	}

	public String exibeTodosOsFornecedores() {
		String listaFornecedores = "";
		for (String nome : fornecedores.keySet()) {
			listaFornecedores += this.fornecedores.get(nome).toString() + " | ";	
		}
		return listaFornecedores;
	}

	public boolean editaCadastro(String nome, String email, String telefone) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nome);
		if(existeFornecedor(nome)) {
			this.fornecedores.get(nome).setEmail(email);
			this.fornecedores.get(nome).setTelefone(telefone);
			return true;
		}
		return false;
	}

	public boolean removeFornecedor(String nome) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nome);
		if(existeFornecedor(nome)) {
			this.fornecedores.remove(nome);
			return true;
		}
		return false;
	}
	
	public boolean cadastraProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		return this.fornecedores.get(nomeFornecedor).cadastarProduto(nomeProduto, descricao, preco);
		
	}
	
	
	
	
	
	
	
	
}
