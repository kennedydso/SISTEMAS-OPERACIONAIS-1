package view;

import java.util.concurrent.Semaphore;

import controller.ThreadAeroporto;

public class Main {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforoNorte = new Semaphore(permissoes);

		Semaphore semaforoSul = new Semaphore(permissoes);

		for (int idAvi�o = 1; idAvi�o <= 12; idAvi�o++) {
			Thread aviao = new ThreadAeroporto(idAvi�o, semaforoNorte, semaforoSul);
			aviao.start();
		}
	}

}