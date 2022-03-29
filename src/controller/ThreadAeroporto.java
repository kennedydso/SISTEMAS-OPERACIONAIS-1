package controller;

import java.util.concurrent.Semaphore;

public class ThreadAeroporto extends Thread {

	private Semaphore semaforoNorte;
	private Semaphore semaforoSul;
	private int idAviao;

	
	public ThreadAeroporto(int idAvi�o, Semaphore semaforoNorte, Semaphore semaforoSul) {
		this.semaforoNorte = semaforoNorte;
		this.semaforoSul = semaforoSul;
		this.idAviao = idAvi�o;
	}

	
		@Override
		public void run() {
		decolagem();
		}

		private void decolagem() {
	
			int manobra = (int) (Math.random() * 2700) + 3000;
			int taxiar = (int) (Math.random() * 2) + 4999;
			int decolagem = (int) (Math.random() * 5) + 1000;
			int afastamento = (int) (Math.random() * 3) + 3000;
			
			int pista = (int) (Math.random() * 1.5) + 1;
			
			switch(pista) {
			
	
			case 1: 
				try {
					semaforoNorte.acquire();
					System.out.println("Avi�o "+idAviao+" est� circulando na pista Norte");
					System.out.println("Ir� fazer o pouso agora");
					System.out.println("Pouso realizado");
					System.out.println("Come�ando a fase de taxiamento");
					sleep(taxiar);
					System.out.println("Taxiamento realizado");
					System.out.println("Preparando para a aterrissagem ");
					sleep(decolagem);
					System.out.println("aterrissagem realizada com �xito");
					System.out.println("Aguarde o afastamento para outro avi�o entrar na pista");
					sleep(afastamento);
					System.out.println("Afastamento realizado com �xito. Pista livre para a pr�xima aterrissagem");
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}finally {
					semaforoNorte.release();
				}
			case 2: 
				try {
					semaforoSul.acquire();
					System.out.println("Avi�o "+idAviao+" est� circulando na pista sul");
					System.out.println("Ir� fazer o pouso agora");
					sleep(manobra);
					System.out.println("Pouso realizado");
					System.out.println("Come�ando a fase de taxiamento");
					sleep(taxiar);
					System.out.println("Taxiamento realizado");
					System.out.println("Preparando para a aterissagem ");
					sleep(decolagem);
					System.out.println("aterrissagem realizada com �xito");
					System.out.println("Aguarde o afastamento para outro avi�o entrar na pista");
					sleep(afastamento);
					System.out.println("Afastamento realizado com �xito. Pista livre para a pr�xima aterrissagem");
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}finally {
					semaforoSul.release();
				}
			}

}
		
		
		
		
}