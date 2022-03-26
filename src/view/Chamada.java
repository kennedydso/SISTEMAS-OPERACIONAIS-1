package view;

import java.util.concurrent.Semaphore;

import controller.Porta;

public class Chamada {

	public static void main(String[] args) {
		int pesPorVez = 1;
		Semaphore semaforo = new Semaphore(pesPorVez);
		
		for (int idPessoa = 1; idPessoa < 5; idPessoa++) {
			Thread pessoa = new Porta(idPessoa, semaforo);
			pessoa.start();
		}
		
	

	}

}
