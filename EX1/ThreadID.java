package controller;

public class ThreadID extends Thread {
	 
	private int idThread;
	
	
		public ThreadID(int idThread) {
			this.idThread = idThread;
			
		}

		@Override
		public void run() {
//			s� executa oq est� aq
			System.out.println(idThread);
		}
		

}
