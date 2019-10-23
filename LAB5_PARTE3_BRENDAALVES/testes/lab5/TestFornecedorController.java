package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFornecedorController {
	
	private FornecedorController controle;

	@BeforeEach
	void criaFornecedor() {
		Fornecedor f1 = new Fornecedor("ines", "ines@gmail.com", "9999-9999");
		Fornecedor f2 = new Fornecedor("paulo", "paulo@gmail.com", "8888-8888");
	}
	
	
	@Test
	void testCriaFornecedorNaoExistente() {
		assertThrows(NullPointerException.class, () -> {
			controle.cadastraFornecedor("flavia", "flavia@gmail.com", "938470947");			
		});
	}
	
	@Test
	void testCriaFornecedorNomeNull() {
		assertThrows(NullPointerException.class, () -> {
			controle.cadastraFornecedor(null, "flavia@gmail.com", "938470947");			
		});
	}
	
	@Test
	void testCriaFornecedorEmailNull() {
		assertThrows(NullPointerException.class, () -> {
			controle.cadastraFornecedor("flavia", null, "938470947");			
		});
	}
	
	@Test
	void testCriaFornecedortelefoneNull() {
		assertThrows(NullPointerException.class, () -> {
			controle.cadastraFornecedor("flavia", "flavia@gmail.com", null);			
		});
	}
	
	@Test
	void testCriaFornecedorTudoNull() {
		assertThrows(NullPointerException.class, () -> {
			controle.cadastraFornecedor(null, null, null);			
		});
	}
	
	@Test
	void testCriaFornecedorTudoVazio() {
		assertThrows(NullPointerException.class, () -> {
			controle.cadastraFornecedor("", "", "");			
		});
	}
	
	@Test
	void testCriaFornecedorNomeVazio() {
		assertThrows(NullPointerException.class, () -> {
			controle.cadastraFornecedor("", "flacia@gmail.com", "89374-9373");			
		});
	}
	
	@Test
	void testCriaFornecedorEmailVazio() {
		assertThrows(NullPointerException.class, () -> {
			controle.cadastraFornecedor("flavia", "", "89374-9373");			
		});
	}
	
	@Test
	void testCriaFornecedorTelefoneVazio() {
		assertThrows(NullPointerException.class, () -> {
			controle.cadastraFornecedor("flavia", "flacia@gmail.com", "");			
		});
	}
	
	
	
	
	
	
	
	
	
	
	

}
