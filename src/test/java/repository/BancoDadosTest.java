package repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import enums.EnumSexo;
import models.Pessoa;

public class BancoDadosTest {
	
	private BancoDados bd = new BancoDados();
	
	@BeforeEach
	void init() {
		bd.clearData();
		Pessoa p1 = new Pessoa("Bianca", 18, EnumSexo.FEMININO);
		Pessoa p2 = new Pessoa("Matheus", 15, EnumSexo.MASCULINO);
		Pessoa p3 = new Pessoa("Sofia", 15, EnumSexo.FEMININO);
		Pessoa p4 = new Pessoa("Pedro", 30, EnumSexo.MASCULINO);
		Pessoa p5 = new Pessoa("João", 7, EnumSexo.MASCULINO);
		bd.add(p1);
		bd.add(p2);
		bd.add(p3);
		bd.add(p4);
		bd.add(p5);
		
	}
	
	@Test
	@DisplayName("Teste lista")
	void testListAll() {
		
		List <Pessoa> cads = bd.listAll();
		assertEquals(5, cads.size());
		assertEquals("Bianca", cads.get(0).getNome());
		bd.add(new Pessoa("Maria", 20, EnumSexo.FEMININO));
		cads = bd.listAll();
		assertEquals(6, cads.size());
		assertEquals(6, cads.get(5).getId());
		
	}
	
	@Test
	@DisplayName("Teste findById")
	
	void testeFindById() {
		
		Pessoa p = bd.findById(1);
		assertEquals("Bianca", p.getNome());
		
		
	}
	
	@Test
	@DisplayName("Teste update")
	
	void testeUpdate() {
		
		Pessoa p = bd.update(3, new Pessoa("Jorge", 23, EnumSexo.MASCULINO));
		assertEquals("Jorge", p.getNome()); 
		
		
	}
	
	

}
