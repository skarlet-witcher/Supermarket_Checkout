package main;

import gui.Menu;
import utils.RandomNum;

/**
 *  Main entrance of the project.
 */
public class Main {

	/**
	 *  Run main() to execute the project.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Menu window = new Menu();
			window.getfrmMenu().setVisible(true);
			double figure = 2;
			double figure2 = 3;
			System.out.println(figure/figure2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
