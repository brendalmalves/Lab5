package lab5;

import java.util.Comparator;

public class OrdenaProdutoId implements Comparator<ProdutoInterface>{
	
	@Override
	public int compare(ProdutoInterface o1, ProdutoInterface o2) {
		return (o1.getNome()).compareTo(o2.getNome());
	}
}
