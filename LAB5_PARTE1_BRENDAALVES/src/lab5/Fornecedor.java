package lab5;

public class Fornecedor {

	private String nome;
	private String email;
	private String telefone;
	
	public Fornecedor(String nome, String email, String telefone) {
		ValidaEntrada validaEntrada = new ValidaEntrada();
		validaEntrada.validaString(nome);
		validaEntrada.validaString(email);
		validaEntrada.validaString(telefone);
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
