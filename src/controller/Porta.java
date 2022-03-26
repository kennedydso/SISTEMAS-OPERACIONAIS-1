package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Porta extends Thread {

		private int idPessoa;
		private static int pSaida;
		private Semaphore semaforo;
		Random r = new Random();
		
		public Porta (int idPessoa, Semaphore semaforo) {
			this.idPessoa = idPessoa;
			this.semaforo = semaforo;
		}
		
		public void run() {
				PesCaminhando();
			try {
				semaforo.acquire();
				pesPorta();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			PesCruzando();
		}
		private void PesCaminhando() {
			int tempo = 1000;
			int distPercorrida = 0;
			
			while (distPercorrida < 200) {
				distPercorrida += (int) ((Math.random()* 4) + 6);
				try {
					Thread.sleep(tempo);	
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("A pessoa %d já caminhou %d metros \n", idPessoa, distPercorrida);
			}
		}
		private void pesPorta() {
			System.out.printf("A pessoa %d já está na porta \n", idPessoa);
			double tInicial = System.nanoTime();
//			para buscar um número entre os intervalos abaixos e nao considerar o 0
			int tParado = (r.nextInt((2 - 1) + 1) + 1) * 1000;
					try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
				
				
		} 
		private void PesCruzando() {
			pSaida++;
			 System.out.printf("a pessoa %d passou em %d ª pela porta ", idPessoa, pSaida);
			 
			
		}
}
