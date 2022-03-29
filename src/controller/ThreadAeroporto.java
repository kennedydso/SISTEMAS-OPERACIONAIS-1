package controller;

import java.util.concurrent.Semaphore;

public class ThreadAeroporto extends Thread {

	private Semaphore semaforoNorte;
	private Semaphore semaforoSul;
	private int idAviao;

	
	public ThreadAeroporto(int idAvião, Semaphore semaforoNorte, Semaphore semaforoSul) {
		this.semaforoNorte = semaforoNorte;
		this.semaforoSul = semaforoSul;
		this.idAviao = idAvião;
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
					System.out.println("Avião "+idAviao+" está circulando na pista Norte");
					System.out.println("Irá fazer o pouso agora");
					System.out.println("Pouso realizado");
					System.out.println("Começando a fase de taxiamento");
					sleep(taxiar);
					System.out.println("Taxiamento realizado");
					System.out.println("Preparando para a aterrissagem ");
					sleep(decolagem);
					System.out.println("aterrissagem realizada com êxito");
					System.out.println("Aguarde o afastamento para outro avião entrar na pista");
					sleep(afastamento);
					System.out.println("Afastamento realizado com êxito. Pista livre para a próxima aterrissagem");
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}finally {
					semaforoNorte.release();
				}
			case 2: 
				try {
					semaforoSul.acquire();
					System.out.println("Avião "+idAviao+" está circulando na pista sul");
					System.out.println("Irá fazer o pouso agora");
					sleep(manobra);
					System.out.println("Pouso realizado");
					System.out.println("Começando a fase de taxiamento");
					sleep(taxiar);
					System.out.println("Taxiamento realizado");
					System.out.println("Preparando para a aterissagem ");
					sleep(decolagem);
					System.out.println("aterrissagem realizada com êxito");
					System.out.println("Aguarde o afastamento para outro avião entrar na pista");
					sleep(afastamento);
					System.out.println("Afastamento realizado com êxito. Pista livre para a próxima aterrissagem");
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}finally {
					semaforoSul.release();
				}
			}

}
		
		
		
		
}