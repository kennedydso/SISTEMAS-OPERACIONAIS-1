package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAeroporto;

public class Main {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforoNorte = new Semaphore(permissoes);

		Semaphore semaforoSul = new Semaphore(permissoes);

		for (int idAvião = 1; idAvião <= 12; idAvião++) {
			Thread aviao = new ThreadAeroporto(idAvião, semaforoNorte, semaforoSul);
			aviao.start();
		}
	}

}