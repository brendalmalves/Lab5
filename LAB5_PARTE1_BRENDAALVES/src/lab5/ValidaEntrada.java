package lab5;

public class ValidaEntrada {

	public void validaString(String entrada, String mensagem) {
		
		if(entrada == null) {
			throw new NullPointerException(mensagem);
		}else if(entrada.trim().isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
		
		
	}
	
	public void validaCpf(String cpf, String mensagem) {
		if(cpf.trim().length() != 11) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
}
