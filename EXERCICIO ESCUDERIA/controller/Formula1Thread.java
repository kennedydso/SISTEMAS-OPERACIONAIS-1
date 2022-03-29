package controller;

import java.util.concurrent.Semaphore;

import view.Formula1;

public class Formula1Thread extends Thread {
	private int idEscuderia;
	private Semaphore semaforoPartida;
	private Semaphore semaforoEscuderia;
	public static int carrosOutOfPista = 0;
	
	public Formula1Thread (int id, Semaphore semaforoPartida, Semaphore semaforoEscuderia) {
		this.idEscuderia = id;
		this.semaforoEscuderia = semaforoEscuderia;
		this.semaforoPartida = semaforoPartida;
	}
	public void run() {

		for (int i = 1; i < 3; i++) {
			try {
				semaforoPartida.acquire();
				CarEmMovimento(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforoPartida.release();
				System.out.printf("O carro %d da escuderia %d  saiu da pista\n", i, idEscuderia);
				carrosOutOfPista++;
			}
		}
		if (carrosOutOfPista == 14) {
			Ordenacao();
		}
	}
	private void CarEmMovimento (int carro) {
		System.out.printf("o carro %d da escuderia %d entrou na pista \n", carro, idEscuderia);
		for (int i = 1; i < 4; i++) {
			int tVolta = (int) ((Math.random()* 180) + 60);
			try {
				sleep(tVolta * 30);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}
			System.out.printf("Escuderia: %d Carro: %d Volta: %d Tempo: %d segundos \n", idEscuderia, carro, i,  tVolta);
			
			try {
				semaforoEscuderia.acquire();
				if (tVolta < Formula1.valorVoltas[(2 * idEscuderia) - carro]
						|| Formula1.valorVoltas[(2 * idEscuderia) - carro] == 0) {
					Formula1.valorVoltas[(2 * idEscuderia - 2 + carro) - 1] = tVolta;
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			} finally {
				semaforoEscuderia.release();
			}
			
		}
		
		
	}
	
	public void Ordenacao() {
		int aux;
		String auxiliar;
		for (int i = 0; i < 13; i++) {
			for (int j = i + 1; j < 14; j++) {
				if (Formula1.valorVoltas[i] > Formula1.valorVoltas[j]) {
					aux = Formula1.valorVoltas[i];
					Formula1.valorVoltas[i] = Formula1.valorVoltas[j];
					Formula1.valorVoltas[j] = aux;
					auxiliar = Formula1.textoVoltas[i];
					Formula1.textoVoltas[i] = Formula1.textoVoltas[j];
					Formula1.textoVoltas[j] = auxiliar;
				}
			}
		}
		for (int i = 0; i < 14; i++) {
			System.out.print("Posição " + (i + 1) + ": " + Formula1.textoVoltas[i] + Formula1.valorVoltas[i] + " segundos");
		}
	}
}

