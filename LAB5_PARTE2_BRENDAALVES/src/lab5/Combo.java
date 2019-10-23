package lab5;

public class Combo implements ProdutoInterface {
	
	private String nome;
	private String descricao;
	private double fator;
	private double precoProduto1;
	private double precoProduto2;
	private String tipoProduto;
	private double preco;
	

	public Combo(String nome, String descricao, double fator, double precoProduto1, double precoProduto2) {
		this.nome = nome;
		this.descricao = descricao;
		this.fator = fator;
		this.precoProduto1 = precoProduto1;
		this.precoProduto2 = precoProduto2;
		this.tipoProduto = "combo";
		this.preco = (precoProduto1 + precoProduto2) - ((precoProduto1 + precoProduto2) * fator);
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - R$" + String.format("%.2f",this.preco).replace(".", ",");
	}

	
	public double getPreco() {
		return preco;
	}


	public String getNome() {
		return nome;
	}


	private void setPreco() {
		this.preco = (precoProduto1 + precoProduto2) - ((precoProduto1 + precoProduto2) * fator);
	}


	public String getTipoProduto() {
		return tipoProduto;
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

	public void setFator(double novoFator) {
		this.fator = novoFator;
		setPreco();
	}

}
