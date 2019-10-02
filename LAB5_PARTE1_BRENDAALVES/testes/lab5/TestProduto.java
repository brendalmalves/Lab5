package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestProduto {

	private Produto produtoTeste;
	
	@BeforeEach
	void criaProduto() {
		Produto p1 = new Produto("tapioca", "com manteiga", 2.50);
		Produto p2 = new Produto("Bolo", "chocolate", 1.50);
	}
	
	@Test
	void testCriaProdutoNomeNull() {
		assertThrows(NullPointerException.class, () -> {
			Produto p = new Produto(null, "com manteiga", 2.50);
		});
	}
	
	@Test
	void testCriaProdutoDescricaoNull() {
		assertThrows(NullPointerException.class, () -> {
			Produto p = new Produto("tapioca", null, 2.50);
		});
	}
	
	@Test
	void testCriaProdutoTudoNull() {
		assertThrows(NullPointerException.class, () -> {
			Produto p = new Produto(null, null, 0);
		});
	}
	
	@Test
	void testCriaProdutoNomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			Produto p = new Produto("", "com manteiga", 2.50);
		});
	}
	
	@Test
	void testCriaProdutoDescricaoVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			Produto p = new Produto("tapioca", "", 2.50);
		});
	}
	
	@Test
	void testCriaProdutoTudoVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			Produto p = new Produto("", "", 0);
		});
	}
	
	@Test
	void testToString() {
		assertThrows(NullPointerException.class, () -> {
			assertEquals("tapioca - com manteiga - R$2.50", produtoTeste.toString(), "erro"); 
		});
	}
	
	@Test
	void testHashCode() {
		Produto p1 = new Produto("pao", "com ovo", 2.00);
		Produto p2 = new Produto("pao", "com manteiga", 1.50);
		assertNotEquals(p1.hashCode(), p2.hashCode());
	}
	
	@Test
	void testHashCodeDiferente() {
		Produto p1 = new Produto("pao", "com ovo", 2.00);
		Produto p2 = new Produto("pao", "com ovo", 1.50);
		assertEquals(p1.hashCode(), p2.hashCode());
	}
	
	@Test
	void testEqualsObject() {
		Produto p1 = new Produto("pao", "com ovo", 2.00);
		Produto p2 = new Produto("pao", "com ovo", 1.50);
		assertTrue(p1.equals(p2));
	}
	
	@Test
	void testEqualsObjectDiferent() {
		Produto p1 = new Produto("pao", "com ovo", 2.00);
		Produto p2 = new Produto("pao", "com manteiga", 1.50);
		assertFalse(p1.equals(p2));
	}
	
	

}
