package view;
import java.util.concurrent.Semaphore;

import controller.Cruzamento;

public class CruzamentoView {

	public static void main(String[] args) {
		String [] reta = { "foi da sul para a norte", "foi da norte para a sul", "foi da leste para a oeste", "foi da oeste para a leste"};
		Semaphore semaforo = new Semaphore(1);
		for (int i = 1; i < 5; i++) {
			Cruzamento car = new Cruzamento (reta[i - 1], semaforo);
			car.start();
		}

	}

}

