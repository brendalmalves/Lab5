package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestClienteController {

	private ClienteController controle;
	
	@BeforeEach
	void criaClienteController() {
		controle = new ClienteController();
		controle.cadastraCliente("12345678900", "ana", "ana@gmail.com", "lsd");
		controle.cadastraCliente("84579834759", "antonio", "antonio@gmail.com", "lsd");
	}
	
	@Test
	void testCadastraClienteNaoExistente() {
		assertThrows(IllegalArgumentException.class, () -> {			
			controle.cadastraCliente("09475684776", "brenda", "brenda@gmail.com", "lsd");
		});
	}

}
