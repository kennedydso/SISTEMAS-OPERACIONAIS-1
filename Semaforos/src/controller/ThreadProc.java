package controller;

import java.util.concurrent.Semaphore;

public class ThreadProc extends Thread {

	private int idCarro;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;

	public ThreadProc(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		CarroAndando();
		try {
			semaforo.acquire();
			CarroParado();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		CarroSaindo();
	}

	// carro se move até chegar no estacionamento e anota sua posição de chegada
	// 
	private void CarroAndando() {
		int distanciaFinal = 1000;
		int variacaoDistancia = (int) ((Math.random() * 101) + 100);
		int tempo = 500;
		int distanciaPercorrida = 0;

		while (distanciaPercorrida < distanciaFinal) {
			distanciaPercorrida += variacaoDistancia;
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O carro " + idCarro + " já andou " + distanciaPercorrida + " metros");
		}
		posChegada++;
		System.out.println("O carro " + idCarro + " foi o " + posChegada + "º a chegar");
	}

	// dps de passar pelo semaforo o carro estaciona e fica parado por um tempo qualquer
	private void CarroParado() {
		System.out.println("O carro " + idCarro + " estacionou");
		int tempoParado = (int) ((Math.random() * 510) + 500);
		try {
			Thread.sleep(tempoParado);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//verifica a posição q o carro saiu do estacionamento
	private void CarroSaindo() {
		posSaida++;
		System.out.println("O carro " + idCarro + " foi o " + posSaida + " o. a sair");
	}
	}