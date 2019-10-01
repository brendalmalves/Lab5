package lab5;

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
	private String nome;
	/**
	 * Representacao em String do email do cliente.
	 */
	private String email;
	/**
	 * Representacao em String da localizacao do cliente.
	 */
	private String localizacao;

	/**
	 * Constroi a representacao de um cliente, a partir do cpf, 
	 * nome, email e localizacao.
	 * Inicia o verificador de entrada.
	 * Verifica os dados para lancar excecao em caso de String vazia ou entrada null.
	 * @param cpf do cliente
	 * @param nome do cliente
	 * @param email do cliente
	 * @param localizacao do cliente
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(cpf);
		validaEntrada.validaString(nome);
		validaEntrada.validaString(email);
		validaEntrada.validaString(localizacao);
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}
	
	/**
	 * Metodo que permite a edicao do nome do cliente.
	 * @param nome do cliente
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
		return this.nome + " - " + this.localizacao + " - " + this.email;
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
	
	
}