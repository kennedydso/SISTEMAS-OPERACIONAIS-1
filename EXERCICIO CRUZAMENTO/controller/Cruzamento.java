package controller;

import java.util.concurrent.Semaphore;

public class Cruzamento extends Thread {
	private int idCar;
	private String reta;
	private double tInicial, tFinal, tTotal;
	private Semaphore semaforo;
	
		public Cruzamento (String reta, Semaphore semaforo ) {
			this.idCar = (int) this.getId();
			this.reta = reta;
			this.semaforo = semaforo;
			
		}
		public void run() {
			CarEmMovimento();
			try {
				CarEmMovimento();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			CarEmMovimento();
		}
		
		private void CarEmMovimento() {
			int tempo = 1000;
			int	disPercorrida = 0;
			
			while (disPercorrida < 100) {
				disPercorrida += (int) ((Math.random() * 5) + 6);
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.printf("o carro %d já percorreu uma distância de %d metros \n", idCar, disPercorrida);
			
			}
			
		}
		private void CarEsperando() {
			System.out.printf("O Carro %d parou no cruzamento \n", idCar);
			tInicial = System.nanoTime();
		}

		private void CarCruzando() {
			
			tFinal = System.nanoTime();
			tTotal = tFinal - tInicial;
			tTotal = tTotal / Math.pow(10, 9);
			System.out.printf("O carro %d ficou esperando no cruzamento %d segundos e %d \n", idCar, tTotal, reta);
			}
	

}
