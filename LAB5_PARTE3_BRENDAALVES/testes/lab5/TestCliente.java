package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestCliente {

	private Cliente clienteTeste;
	
	@BeforeEach
	void criaCliente() {
		Cliente c1 = new Cliente("12345678900", "ana", "ana@gmail.com", "lsd");
		Cliente c2 = new Cliente("98257098653", "clara", "clara@gmai.com", "splab");
		Cliente c3 = new Cliente("12345678900", "brenda", "brenda@gmail.com", "lsd");
	}

	@Test
	void testCriaClienteCpfNull() {
		assertThrows(NullPointerException.class, () -> {
			Cliente c = new Cliente(null, "ana", "ana@gmai.com", "lsd");
		});
	}
	
	@Test
	void testCriaClienteCpfVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			Cliente c = new Cliente("", "ana", "ana@gmai.com", "lsd");
		});
	}
	
	@Test
	void testCriaClienteNomeNull() {
		assertThrows(NullPointerException.class, () -> {
			Cliente c = new Cliente("28375098459", null, "ana@gmai.com", "lsd");
		});
	}
	
	@Test
	void testCriaClienteNomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			Cliente c = new Cliente("29837589357", "", "ana@gmai.com", "lsd");
		});
	}
	
	@Test
	void testCriaClienteEmailNull() {
		assertThrows(NullPointerException.class, () -> {
			Cliente c = new Cliente("29837589357", "ana", null, "lsd");
		});
	}
	
	@Test
	void testCriaClienteEmailVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			Cliente c = new Cliente("29837589357", "ana", "", "lsd");
		});
	}
	
	@Test
	void testCriaClienteLocalizacaoNull() {
		assertThrows(NullPointerException.class, () -> {
			Cliente c = new Cliente("29837589357", "ana", "ana@gmail.com", null);
		});
	}

	@Test
	void testCriaClienteLocalizacaoVazia() {
		assertThrows(IllegalArgumentException.class, () -> {
			Cliente c = new Cliente("29837589357", "ana", "ana@gmail.com", "");
		});
	}
	
	@Test
	void testCriaClienteTudoNull() {
		assertThrows(NullPointerException.class, () -> {
			Cliente c = new Cliente(null, null, null, null);
		});
	}
	
	@Test
	void testCriaClienteTudoVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			Cliente c = new Cliente("", "", "", "");
		});
	}
	
	@Test
	void testToString() {
		assertThrows(NullPointerException.class, () -> {
			assertEquals("ana - ana@gmail.com - lsd", clienteTeste.toString(), "erro"); 
		});
	}
	
	@Test
	void testHashCode() {
		Cliente c1 = new Cliente("12345678900", "menina", "menina@gmail.com", "lsd");
		Cliente c2 = new Cliente("12345678900", "roberta", "roberta@gmail.com", "lsd");
		assertEquals(c1.hashCode(), c2.hashCode());
	}
	
	@Test
	void testEqualsObject() {
		Cliente c1 = new Cliente("12345678900", "menina", "menina@gmail.com", "lsd");
		Cliente c2 = new Cliente("12345678900", "roberta", "roberta@gmail.com", "lsd");
		assertTrue(c1.equals(c2));
	}
	
	@Test
	void testEqualsObjectDiferent() {
		Cliente c1 = new Cliente("08745897384", "menina", "menina@gmail.com", "lsd");
		Cliente c2 = new Cliente("12345678900", "menina", "menina@gmail.com", "lsd");
		assertFalse(c1.equals(c2));
	}
	
	
}
