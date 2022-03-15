package controller;

public class ThreadID extends Thread {
	 
	private int idThread;
	
	
		public ThreadID(int idThread) {
			this.idThread = idThread;
			
		}

		@Override
		public void run() {
//			só executa oq está aq
			System.out.println(idThread);
		}
		

}
