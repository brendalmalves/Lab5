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
	void testCadastraClienteExistenteDadosDiferentes() {
		assertThrows(IllegalArgumentException.class, () -> {			
			controle.cadastraCliente("12345678900", "brenda", "brenda@gmail.com", "lsd");
		});
	}
	
	@Test
	void testCadastraClienteExistenteDadosIguais() {
		assertThrows(IllegalArgumentException.class, () -> {			
			controle.cadastraCliente("84579834759", "antonio", "antonio@gmail.com", "lsd");
		});
	}
	
	
	@Test
	void testCadastraClienteNaoExistente() {
		controle.cadastraCliente("09475684776", "brenda", "brenda@gmail.com", "lsd");
	}
	
	@Test
	void testCadastraClienteCpfVazio() {
		assertThrows(IllegalArgumentException.class, () -> {			
			controle.cadastraCliente("", "brenda", "brenda@gmail.com", "lsd");
		});
	}
	
	@Test
	void testCadastraClienteNomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> {			
			controle.cadastraCliente("9357983276", "", "brenda@gmail.com", "lsd");
		});
	}
	
	
	@Test
	void testCadastraClienteEmailVazio() {
		assertThrows(IllegalArgumentException.class, () -> {			
			controle.cadastraCliente("9357983276", "brenda", "", "lsd");
		});
	}
	
	@Test
	void testCadastraClienteLocalizacaoVazio() {
		assertThrows(IllegalArgumentException.class, () -> {			
			controle.cadastraCliente("9357983276", "brenda", "brenda@gmail.com", "");
		});
	}
	
	@Test
	void testCadastraClienteTudoVazio() {
		assertThrows(IllegalArgumentException.class, () -> {			
			controle.cadastraCliente("", "", "", "");
		});
	}
	
	@Test
	void testCadastraClienteCpfNull() {
		assertThrows(NullPointerException.class, () -> {
			controle.cadastraCliente(null, "ana", "ana@gmail.com", "splab");
		});
	}
	
	@Test
	void testCadastraClienteNomeNull() {
		assertThrows(NullPointerException.class, () -> {
			controle.cadastraCliente("9204750396", null, "ana@gmail.com", "splab");
		});
	}
	
	@Test
	void testCadastraClienteEmailNull() {
		assertThrows(NullPointerException.class, () -> {
			controle.cadastraCliente("9204750396", "ana", null, "splab");
		});
	}
	
	@Test
	void testCadastraClienteLocalizacaoNull() {
		assertThrows(NullPointerException.class, () -> {
			controle.cadastraCliente("9204750396", "ana", "ana@gmail.com", null);
		});
	}
	
	@Test
	void testCadastraClienteTudoNull() {
		assertThrows(NullPointerException.class, () -> {
			controle.cadastraCliente(null, null, null, null);
		});
	}
	
	@Test 
	void testExibeClienteExistente() {
		assertEquals("ana - lsd - ana@gmail.com", controle.exibeCliente("12345678900"));
	}
	
	@Test 
	void testExibeClienteNaoExistente() {
		assertEquals("", controle.exibeCliente("09876533777"));
	}
	
	@Test 
	void testExibeClienteCpfVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			assertEquals("ana - lsd - ana@gmail.com", controle.exibeCliente(""));
		});
	}
	
	@Test 
	void testExibeClienteCpfNull() {
		assertThrows(NullPointerException.class, () -> {
			assertEquals("ana - lsd - ana@gmail.com", controle.exibeCliente(null));
		});
	}
	
	@Test
	void testImprimeClientes() {
		assertEquals("antonio - lsd - antonio@gmail.com | ana - lsd - ana@gmail.com | ", controle.exibeTodosOsClientes());
	}
	
	@Test
	void testEditaCpfExistenteEmail() {
		assertTrue(controle.editaCadastro("12345678900", "eMail"));
	}
	
	@Test
	void testEditaCpfExistenteNome() {
		assertTrue(controle.editaCadastro("12345678900", "nomE"));
	}
	
	@Test
	void testEditaCpfExistenteLocalizacao() {
		assertTrue(controle.editaCadastro("12345678900", "Localizacao"));
	}


	
	@Test
	void testEditaCpfVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			controle.editaCadastro("", "EMAIL");
		});
	}
	
	@Test
	void testEditaCpfTudoVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			controle.editaCadastro("", "");
		});
	}
	
	@Test
	void testEditaCpfExistenteComandoNull() {
		assertThrows(NullPointerException.class, () -> {
			controle.editaCadastro("12345678900", null);
		});
	}
	
	@Test
	void testEditaCpfCpfNull() {
		assertThrows(NullPointerException.class, () -> {
			controle.editaCadastro(null, "email");
		});
	}
	
	@Test
	void testEditaCpfExistenteTudoNull() {
		assertThrows(NullPointerException.class, () -> {
			controle.editaCadastro(null, null);
		});
	}
	
	@Test
	void testEditaCpfNaoExistente() {
		assertFalse(controle.editaCadastro("9999999999", "localizacao"));
	}
	
	@Test 
	void testRemoveCpfExistente() {
		assertTrue(controle.removeCliente("12345678900"));
	}
	
	@Test
	void testRemoveCpfNaoExistente() {
		assertFalse(controle.removeCliente("99999999999"));
	}


}
