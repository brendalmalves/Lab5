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
		return this.clienteController.editaCliente(cpf, atributo, novoValor);
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
		validaEntrada.validaString(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		validaEntrada.validaCpf(cpf, "Erro ao cadastrar compra: cpf invalido.");
		validaEntrada.validaString(nomeFornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		validaEntrada.validaString(nomeProduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		validaEntrada.validaString(descricao, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		validaEntrada.validaString(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		if(!fornecedorController.existeFornecedor(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		} else if(data.length() != 10) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}
		
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

	public String getDebito(String cpf, String nomeFornecedor) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		validaEntrada.validaCpf(cpf, "Erro ao recuperar debito: cpf invalido.");
		validaEntrada.validaString(nomeFornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
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
		Fornecedor fornecedor = this.fornecedorController.getFornecedor(nomeFornecedor);
		if(!this.fornecedorController.existeFornecedor(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}
		if(fator <= 0 || fator >= 1) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		
		String[] produtosCombo;
		produtosCombo = produtos.trim().split(", ");
		String[] produto1;
		produto1 = produtosCombo[0].trim().split(" - ");
		String[] produto2;
		produto2 = produtosCombo[1].trim().split(" - ");
		if(!fornecedorController.existeProduto(nomeFornecedor, produto1[0], produto1[1]) || !fornecedorController.existeProduto(nomeFornecedor, produto2[0], produto2[1])) {
			throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
		} else if(!(fornecedor.tipoProduto(produto1[0], produto1[1]) == "simples") || !(fornecedor.tipoProduto(produto2[0], produto2[1]) == "simples")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
		}
		double precoProduto1 = fornecedor.precoProduto(produto1[0].trim(), produto1[1].trim());
		double precoProduto2 = fornecedor.precoProduto(produto2[0].trim(), produto2[1].trim());
		this.fornecedorController.adicionaCombo(nomeFornecedor, nomeCombo, descricao, fator, precoProduto1, precoProduto2);			
		
		
	}

	public void editaCombo(String nomeCombo, String descricao, String nomeFornecedor, double novoFator) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nomeFornecedor, "Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		validaEntrada.validaString(descricao, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		validaEntrada.validaString(nomeCombo, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		if(!this.fornecedorController.existeFornecedor(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
		}
		if(novoFator <= 0 || novoFator >= 1) {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		}
		this.fornecedorController.editaCombo(nomeCombo, descricao, nomeFornecedor, novoFator);
		
	}

	public String exibeContas(String cpf, String nomeFornecedor) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		validaEntrada.validaCpf(cpf, "Erro ao exibir conta do cliente: cpf invalido.");
		validaEntrada.validaString(nomeFornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		if(!this.fornecedorController.existeFornecedor(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		} else if(!this.clienteController.existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		}
		return this.clienteController.exibeConta(cpf, nomeFornecedor);
	}

	public String exibeContasClientes(String cpf) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		validaEntrada.validaCpf(cpf, "Erro ao exibir contas do cliente: cpf invalido.");
		if(!this.clienteController.existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		}
		return this.clienteController.exibeContas(cpf);
	}

	public void realizaPagamento(String cpf, String nomeFornecedor) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(cpf, "Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
		validaEntrada.validaCpf(cpf, "Erro no pagamento de conta: cpf invalido.");
		validaEntrada.validaString(nomeFornecedor, "Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
		if(!this.clienteController.existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro no pagamento de conta: cliente nao existe.");
		} else if(!this.fornecedorController.existeFornecedor(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao existe.");
		}
		this.clienteController.realizaPagamento(cpf, nomeFornecedor);
	}


}


	
	
	

