package br.com.premoli.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.premoli.cm.excecao.ExplosaoException;
import br.com.premoli.cm.excecao.SairException;
import br.com.premoli.cm.modelo.Tabuleiro;

public class TabuleiroConsole {

	private Tabuleiro tabuleiro;
	private Scanner teclado = new Scanner(System.in);

	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;

		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;

			while (continuar) {
				cicloDoJogo();
				System.out.println("Outra partida? (S/n) ");
				String resposta = teclado.nextLine();

				if ("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				} else {
					tabuleiro.reiniciarJogo();
				}
			}
		} catch (SairException e) {
			System.out.println("Tchau!!!");
		} finally {
			teclado.close();
		}
	}

	private void cicloDoJogo() {
		try {

			while (!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);

				String digitado = capturarValorDigitado("Digite (X , Y): ");
				Iterator<Integer> xy = Arrays.stream(digitado.split(",")).map(e -> Integer.parseInt(e.trim()))
						.iterator();

				digitado = capturarValorDigitado("1 - Abrir ou 2 - Alterar Marcacao");

				if ("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				} else if ("2".equals(digitado)) {
					tabuleiro.alternarMarcacao(xy.next(), xy.next());
				}
			}

			System.out.println("Voce ganhou!");
		} catch (ExplosaoException e) {
			System.out.println(tabuleiro);
			System.out.println("Voce perdeu!");
		}
	}

	private String capturarValorDigitado(String texto) {
		System.out.print(texto);
		String coordenadas = teclado.nextLine();

		if ("sair".equalsIgnoreCase(coordenadas)) {
			throw new SairException();
		}

		return coordenadas;
	}
}
