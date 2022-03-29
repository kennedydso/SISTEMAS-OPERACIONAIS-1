package controller;

import java.util.concurrent.Semaphore;

public class ThreadBilheteria extends Thread {

	private int id;
	private Semaphore semaforo;
	private static int ticket = 100;

	public ThreadBilheteria(int idPessoa, Semaphore semaforo) {
		this.id = idPessoa;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		login();
	}

	private void login() {
		System.out.printf("Pessoa %d faça o seu login \n", id);
		System.out.printf("Pessoa %d digite seu username \n", id);
		System.out.printf("Pessoa %d insira a senha \n", id);
		try {
			int tempo = (int) (Math.random() * 1950) + 51;
			System.out.printf("Pessoa %d espere um momento... \n", id);
			sleep(tempo);
			if (tempo >= 1000) {
				System.out.printf("Pessoa %d login realizado com sucesso \n", id);
				compra();
			} else {
				System.out.printf(
						"Pessoa %id Erro de carregamento \n Tente novamente \n ", id);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void compra() {
		System.out.printf("Pessoa %d agora voce pode comprar seu ticket \n", id);
		try {
			int tempo = (int) (Math.random() * 3001) + 1001;
			System.out.println("processando compra");
			sleep(tempo);
			if (tempo <= 2500) {
				System.out.println("compra realizada ");
				finalizar();
			} else {
				System.out.printf(
						"Pessoa %d seu tempo de sessão esgotou, Tente novamente \n", id);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void finalizar() {
		try {
			semaforo.acquire();
			int compras = (int) (Math.random() * 4) + 1;
			if (compras <= ticket) {
				System.out.printf("Senhor(a) %d você adquiriu %d ingressos \n", id, compras);
				ticket -= compras;
				System.out.printf("Restam apenas %d ingressos \n", ticket);
			} else {
				System.out.println(
						"não há estoque para essa quantidade de ingressos. Tente novamente com um valor menor ");
			}
			if (ticket == 0) {
				System.out.println("Os ingressos acabaram");
			}

		} catch (InterruptedException e) {
		
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

}