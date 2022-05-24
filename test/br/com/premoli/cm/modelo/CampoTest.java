package br.com.premoli.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CampoTest {

	private Campo campo;

	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}

	@Test
	void testeViznhoDistancia1Esquerda() {
		Campo vizinho = new Campo(3, 2);
		boolean resultado = campo.adcionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeViznhoDistancia1Direita() {
		Campo vizinho = new Campo(3, 4);
		boolean resultado = campo.adcionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeViznhoDistancia1Cima() {
		Campo vizinho = new Campo(2, 3);
		boolean resultado = campo.adcionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeViznhoDistancia1Baixo() {
		Campo vizinho = new Campo(4, 3);
		boolean resultado = campo.adcionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeViznhoDistancia2() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adcionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoViznho() {
		Campo vizinho = new Campo(1, 3);
		boolean resultado = campo.adcionarVizinho(vizinho);
		assertFalse(resultado);
	}

}
