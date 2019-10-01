package lab5;

public class Facade {
	
	private ClienteController clienteController;
	private FornecedorController fornecedorController;
	
	public Facade() {
		this.clienteController = new ClienteController();
		this.fornecedorController = new FornecedorController();
	}
	
	public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
		return this.clienteController.cadastraCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return this.clienteController.exibeCliente(cpf);
	}
	
	public String exibeTodosOsClientes() {
		return this.clienteController.exibeTodosOsClientes();
	}
	
	public boolean editaCadastroCliente(String cpf, String nome, String email, String localizacao) {
		return this.clienteController.editaCadastro(cpf, nome, email, localizacao);
	}
	
	public boolean removeCliente(String cpf) {
		return this.clienteController.removeCliente(cpf);
	}
	
	public String cadastraFornecedor(String nome, String email, String telefone) {
		return this.fornecedorController.cadastraFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return this.fornecedorController.exibeFornecedor(nome);
	}
	
	public String exibeTodosOsFornecedores() {
		return this.fornecedorController.exibeTodosOsFornecedores();
	}
	
	public boolean editaCadastroFornecedor(String nome, String email, String telefone) {
		return this.fornecedorController.editaCadastro(nome, email, telefone);
	}
	
	public boolean removeFornecedor(String nome) {
		return this.fornecedorController.removeFornecedor(nome);
	}
}
