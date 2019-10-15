package lab5;

public class Facade {
	
	private ControllerPrincipal controllerPrincipal;

	public Facade() {
		this.controllerPrincipal = new ControllerPrincipal();
	}
	
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.controllerPrincipal.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return this.controllerPrincipal.exibeCliente(cpf);
	}
	
	public String exibeClientes() {
		return this.controllerPrincipal.exibeClientes();
	}
	
	public boolean editaCliente(String cpf, String atributo, String novoValor) {
		return this.controllerPrincipal.editaCliente(cpf, atributo, novoValor);
	}
	
	public boolean removeCliente(String cpf) {
		return this.controllerPrincipal.removeCliente(cpf);
	}
	
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.controllerPrincipal.adicionaFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return this.controllerPrincipal.exibeFornecedor(nome);
	}
	
	public String exibeFornecedores() {
		return this.controllerPrincipal.exibeFornecedores();
	}
	
	public boolean editaFornecedor(String nome, String atributo, String novoValor) {
		return this.controllerPrincipal.editaFornecedor(nome, atributo, novoValor);
	}
	
	public boolean removeFornecedor(String nome) {
		return this.controllerPrincipal.removeFornecedor(nome);
	}
	
	public boolean adicionaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		return this.controllerPrincipal.adicionaProduto(nomeFornecedor, nomeProduto, descricao, preco);
		
	}
	
	public String exibeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		return this.controllerPrincipal.exibeProduto(nomeFornecedor, nomeProduto, descricao);
	}
	
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return this.controllerPrincipal.exibeProdutosFornecedor(nomeFornecedor);
	}
	
	public String exibeProdutos() {
		return this.controllerPrincipal.exibeProdutos();
	}
	
	public boolean editaProduto(String nomeProduto, String descricao, String nomeFornecedor, double novoValor) {
		return this.controllerPrincipal.editaProduto(nomeProduto, descricao, nomeFornecedor, novoValor);
	}
	
	public boolean removeProduto(String nomeFornecedor, String nome, String descricao) {
		return this.controllerPrincipal.removeProduto(nomeFornecedor, nome, descricao);
	}
	
	public void adicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProduto, String descricao) {
		this.controllerPrincipal.adicionaCompra(cpf, nomeFornecedor, data, nomeProduto, descricao);
	}
	
	public double getDebito(String cpf, String nomeFornecedor) {
		return this.controllerPrincipal.getDebito(cpf, nomeFornecedor);
	}
	
}
