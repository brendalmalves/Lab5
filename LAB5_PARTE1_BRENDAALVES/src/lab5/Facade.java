package lab5;

public class Facade {
	
	private ClienteController clienteController;
	
	public Facade() {
		this.clienteController = new ClienteController();
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
	
	public boolean editaCadastro(String cpf, String nome, String email, String localizacao) {
		return this.clienteController.editaCadastro(cpf, nome, email, localizacao);
	}
	
	public boolean removeCliente(String cpf) {
		return this.clienteController.removeCliente(cpf);
	}
}