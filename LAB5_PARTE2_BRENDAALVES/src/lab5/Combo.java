package lab5;

public class Combo extends Produto {
	
	private String nome;
	private String descricao;
	private double fator;
	private String produto1;
	private String produto2;
	

	public Combo(String nome,  String descricao, double fator, String produto1, String produto2) {
		super(nome, descricao, preco);
		this.nome = nome;
		this.descricao = descricao;
		this.fator = fator;
		this.produto1 = produto1;
		this.produto2 = produto2;
		
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		Combo other = (Combo) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
