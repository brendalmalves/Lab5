package lab5;

public class Facade {
	
	private ClienteController clienteController;
	private FornecedorController fornecedorController;

	public Facade() {
		this.clienteController = new ClienteController();
		this.fornecedorController = new FornecedorController();
	}
	
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.clienteController.cadastraCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return this.clienteController.exibeCliente(cpf);
	}
	
	public String exibeTodosOsClientes() {
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
	
	public String exibeTodosOsFornecedores() {
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
	
	public String exibeTodosProdutosDeUmFornecedor(String nomeFornecedor) {
		return this.fornecedorController.consultarTodosProdutos(nomeFornecedor);
	}
	
	public String exibeTodosProdutosCadastrados() {
		return this.fornecedorController.exibeTodosProdutosCadastrados();
	}
	
	public boolean editaProduto(String nomeProduto, String descricao, String nomeFornecedor, double novoValor) {
		return this.fornecedorController.editaProduto(nomeProduto, descricao, nomeFornecedor, novoValor);
	}
	
	public boolean removeProduto(String nomeFornecedor, String nome, String descricao) {
		return this.fornecedorController.removeProduto(nomeFornecedor, nome, descricao);
	}
}
