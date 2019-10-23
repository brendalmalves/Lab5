package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFornecedor {
	
	private Fornecedor fornecedorTeste;
	private Fornecedor controle;

	@BeforeEach
	void criaFornecedor() {
		Fornecedor f1 = new Fornecedor("Jucurutu", "jucurutu@gmail.com", "9999-9999");
		Fornecedor f2 = new Fornecedor("paozinho", "paozinho@gmail.com", "8888-8888");
		Produto p1 = new Produto("pao", "com manteiga", 2.50);
		Produto p2 = new Produto("pao", "com ovo", 3.50);
		
	}
	
	//@BeforeEach
	//void criaProduto() {
		Produto p1 = new Produto("pao", "com manteiga", 2.50);
		Produto p2 = new Produto("pao", "com ovo", 3.50);
	//}
	
	@Test
	void testCriaProdutoExistente() {
		assertThrows(NullPointerException.class, () -> {
			controle.cadastarProduto("pao", "com ovo", 3.50);			
		});
	}
	
	
	
	@Test
	void testCriaFornecedorNomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			Fornecedor f1 = new Fornecedor("", "jucurutu@gmail.com", "9999-9999");
		});
	}
	
	@Test
	void testCriaFornecedorEmailVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			Fornecedor f1 = new Fornecedor("jucurutu", "", "9999-9999");
		});
	}
	
	@Test
	void testCriaFornecedorTelefoneVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			Fornecedor f1 = new Fornecedor("jucurutu", "jucurutu@gmail.com", "");
		});
	}
	
	@Test
	void testCriaFornecedorTudoVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			Fornecedor f1 = new Fornecedor("", "", "");
		});
	}
	
	@Test
	void testCriaFornecedorNomeNull() {
		assertThrows(NullPointerException.class, () -> {
			Fornecedor f1 = new Fornecedor(null, "jucurutu@gmail.com", "9999-9999");
		});
	}
	
	@Test
	void testCriaFornecedorEmailNull() {
		assertThrows(NullPointerException.class, () -> {
			Fornecedor f1 = new Fornecedor("jucurutu", null, "9999-9999");
		});
	}
	
	@Test
	void testCriaFornecedorTelefoneNull() {
		assertThrows(NullPointerException.class, () -> {
			Fornecedor f1 = new Fornecedor("jucurutu", "jucurutu@gmail.com", null);
		});
	}
	
	@Test
	void testCriaFornecedorTudoNull() {
		assertThrows(NullPointerException.class, () -> {
			Fornecedor f1 = new Fornecedor(null, null, null);
		});
	}
	
	
	
	@Test
	void testCriaProdutoNomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			Produto p = new Produto("", "com manteiga", 2.5);
		});
	}
	
	@Test
	void testCriaProdutoDescricaoVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			Produto p = new Produto("pao", "", 2.50);
		});
	}
	
	@Test
	void testCriaProdutoTudoVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			Produto p = new Produto("", "", 0);
		});
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
			Produto p = new Produto("pao", null, 2.50);
		});
	}
	
	@Test
	void testCriaProdutoTudoNull() {
		assertThrows(NullPointerException.class, () -> {
			Produto p = new Produto(null, null, 0);
		});
	}
	
	
	
	
	
	
	
	
	
	

}
