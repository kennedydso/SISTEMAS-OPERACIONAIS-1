package view;

import controller.ThreadCalc;

public class ThreadView {

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			Thread t = new ThreadCalc(i);
			t.start();
		}

	}

}