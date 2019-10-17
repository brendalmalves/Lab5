package lab5;

public class ControllerPrincipal {

	private ClienteController clienteController;
	private FornecedorController fornecedorController;
	
	
	public ControllerPrincipal() {
		this.clienteController = new ClienteController();
		this.fornecedorController = new FornecedorController();
	}

	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.clienteController.cadastraCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return this.clienteController.exibeCliente(cpf);
	}
	
	public String exibeClientes() {
		return this.clienteController.exibeTodosOsClientes();
	}
	
	public boolean editaCliente(String cpf, String atributo, String novoValor) {
		return this.clienteController.editaCadastro(cpf, atributo, novoValor);
	}
	
	public boolean removeCliente(String cpf) {
		return this.clienteController.removeCliente(cpf);
	}
	
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.fornecedorController.cadastraFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return this.fornecedorController.exibeFornecedor(nome);
	}
	
	public String exibeFornecedores() {
		return this.fornecedorController.exibeTodosOsFornecedores();
	}
	
	public boolean editaFornecedor(String nome, String atributo, String novoValor) {
		return this.fornecedorController.editaCadastro(nome, atributo, novoValor);
	}
	
	public boolean removeFornecedor(String nome) {
		return this.fornecedorController.removeFornecedor(nome);
	}
	
	public boolean adicionaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		return this.fornecedorController.cadastraProduto(nomeFornecedor, nomeProduto, descricao, preco);
		
	}
	
	public String exibeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		return this.fornecedorController.consultaProduto(nomeFornecedor, nomeProduto, descricao);
	}
	
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return this.fornecedorController.consultarTodosProdutos(nomeFornecedor);
	}
	
	public String exibeProdutos() {
		return this.fornecedorController.exibeTodosProdutosCadastrados();
	}
	
	public boolean editaProduto(String nomeProduto, String descricao, String nomeFornecedor, double novoValor) {
		return this.fornecedorController.editaProduto(nomeProduto, descricao, nomeFornecedor, novoValor);
	}
	
	public boolean removeProduto(String nomeFornecedor, String nome, String descricao) {
		return this.fornecedorController.removeProduto(nomeFornecedor, nome, descricao);
	}

	public void adicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProduto, String descricao) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaCpf(cpf, "Erro ao cadastrar compra: cpf invalido.");
		validaEntrada.validaString(nomeFornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		validaEntrada.validaString(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		validaEntrada.validaString(nomeProduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		validaEntrada.validaString(descricao, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		validaEntrada.validaString(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		if(fornecedorController.existeProduto(nomeFornecedor, nomeProduto, descricao)) {
			if(clienteController.existeCliente(cpf)) {
				double preco = this.fornecedorController.getPreco(nomeFornecedor, nomeProduto, descricao);
				this.clienteController.adicionaCompra(cpf, nomeFornecedor, data, nomeProduto, descricao, preco);				
			} else {
				throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
			}
		} else {
			throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
		}
	}

	public double getDebito(String cpf, String nomeFornecedor) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaCpf(cpf, "Erro ao recuperar debito: cpf invalido.");
		validaEntrada.validaString(nomeFornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		validaEntrada.validaString(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		if(!this.fornecedorController.existeFornecedor(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		} else if(!this.clienteController.existeCliente(cpf)){
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		}
		return this.clienteController.getDebito(cpf, nomeFornecedor);				
	
		}

	public void adicionaCombo(String nomeFornecedor, String nomeCombo, String descricao, double fator, String produtos) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nomeFornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		validaEntrada.validaString(descricao, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		validaEntrada.validaString(nomeCombo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		validaEntrada.validaString(produtos, "Erro no cadastro de combo: combo deve ter produtos.");
		if(!this.fornecedorController.existeFornecedor(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}
		if(fator <= 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		
		String[] produtosCombo;
		produtosCombo = produtos.trim().split(",");
		String[] produto1;
		produto1 = produtos.trim().split("-");
		String[] produto2;
		produto2 = produtos.trim().split("-");
		if(!fornecedorController.existeProduto(nomeFornecedor, produto1[0], produto1[1]) || !fornecedorController.existeProduto(nomeFornecedor, produto2[0], produto2[1])) {
			throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
		} else {
		}
		
		// precoProduto1 e 2, com trim,
		// fornecedorController.precoProduto(
		this.fornecedorController.adicionaCombo(nomeFornecedor, nomeCombo, descricao, fator, produtos);			
		
		
		
	}


}


	
	
	

