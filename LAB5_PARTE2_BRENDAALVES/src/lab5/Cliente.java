package lab5;

import java.util.Map;
import java.util.TreeMap;

/**
 * Representacao de um cliente, que recebe cpf, nome,
 * email e localizacao para o cadastro.
 * 
 * @author Brenda Louisy Morais Alves - Matricula 119111113.
 *
 */
public class Cliente {
	
	/**
	 * Representacao em String do cpf do cliente.
	 */
	private String cpf;
	/**
	 * Representacao em String do nome do cliente.
	 */
	private String nomeCliente;
	/**
	 * Representacao em String do email do cliente.
	 */
	private String email;
	/**
	 * Representacao em String da localizacao do cliente.
	 */
	private String localizacao;
	private Map<String, Conta> contas;

	/**
	 * Constroi a representacao de um cliente, a partir do cpf, 
	 * nome, email e localizacao.
	 * @param cpf do cliente
	 * @param nome do cliente
	 * @param email do cliente
	 * @param localizacao do cliente
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		validaEntrada.validaString(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		validaEntrada.validaString(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		validaEntrada.validaString(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		this.cpf = cpf;
		this.nomeCliente = nome;
		this.email = email;
		this.localizacao = localizacao;
		this.contas = new TreeMap<String, Conta>();
	}
	
	public String getNome() {
		return nomeCliente;
	}

	/**
	 * Metodo que permite a edicao do nome do cliente.
	 * @param nome do cliente
	 */
	public void setNome(String nome) {
		this.nomeCliente = nome;
	}

	/**
	 * Metodo que permite a edicao do email do cliente.
	 * @param email do cliente
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que permite a edicao da localizacao do cliente.
	 * @param localizacao do cliente
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	/**
	 * Retorna uma String que representa o nome, email e 
	 * localizacao do cliente cadastrado.
	 * @return representacao em String do nome, email e localizacao
	 */
	@Override
	public String toString() {
		return this.nomeCliente + " - " + this.localizacao + " - " + this.email;
	}
	
	/**
	 * Representacao em inteiro do cliente, considerando o cpf.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	/**
	 * Retorna um valor booleano que verifica se um 
	 * cliente é igual ao outro, considerando o cpf dos dois.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	public void adicionaCompra(String fornecedor, String data, double preco, String nomeProduto, String descricaoProduto) {
		if(this.contas.containsKey(fornecedor)) {
			this.contas.get(fornecedor).adicionaCompra(nomeProduto, preco, data, descricaoProduto);
		} else {
			this.contas.put(fornecedor, new Conta(fornecedor, nomeCliente));
			this.contas.get(fornecedor).adicionaCompra(nomeProduto, preco, data, descricaoProduto);
		}
	}

	public double getDebito(String nomeFornecedor) {
		if(this.contas.containsKey(nomeFornecedor)) {
			return this.contas.get(nomeFornecedor).getDebito();
		} else {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}
	}
	
	public boolean verificaConta(String nomeFornecedor) {
		return this.contas.containsKey(nomeFornecedor);
	}
	
	public String exibeConta(String nomeFornecedor) {
		return "Cliente: " + this.nomeCliente + " | " + contas.get(nomeFornecedor).toString();
	}

	public String exibeContas() {
		if(this.contas.isEmpty()) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		}
		String exibicaoFinal = "Cliente: " + this.nomeCliente + " | ";
		int i = 0;
		for (String fornecedor : contas.keySet()) {
			if(i == contas.size() - 1) {
				exibicaoFinal += contas.get(fornecedor).toString();
			} else {
				exibicaoFinal += contas.get(fornecedor).toString() + " | ";
			}
			i++;
		}
		return exibicaoFinal;
	}
	
	
	
	
}