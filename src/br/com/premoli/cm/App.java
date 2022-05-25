package br.com.premoli.cm;

import br.com.premoli.cm.modelo.Tabuleiro;
import br.com.premoli.cm.visao.TabuleiroConsole;

public class App {
	
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		new TabuleiroConsole(tabuleiro);
	}
}
