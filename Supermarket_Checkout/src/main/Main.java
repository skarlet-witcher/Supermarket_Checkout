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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
