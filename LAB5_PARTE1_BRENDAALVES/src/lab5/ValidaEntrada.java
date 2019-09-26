package lab5;

public class ValidaEntrada {

	public void validaString(String entrada) {
		
		if(entrada == null) {
			throw new NullPointerException("Entrada nula!");
		}
		
		if(entrada.trim().isEmpty()) {
			throw new IllegalArgumentException("Entrada Vazia");
			
		}
	}
	
}