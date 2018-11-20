package threads;

import java.util.List;
import javax.swing.JFrame;
import components.Checkout;
import components.Customer;
import utils.RandomNum;
import utils.Record;
import services.Services;

/**
 *  A thread for scanning a product for a customer who is on the top of the queue for each checkout
 */
public class ProductScanner implements Runnable {
	/**
	 *  A queue in one of the list of checkouts
	 */
	private List<Customer> queue;
	/**
	 * A list of checkouts
	 */
	private List<Checkout> checkoutList;
	/**
	 *  the number of a checkout
	 */
	private int checkoutNum;
	/**
	 * the result window for updating the latest number of products for a customer
	 */
	private JFrame simulationWindow;
	/**
	 * the minimal time of for each product to be entered at the checkout (user specified)
	 */
	private double min_productTime;
	/**
	 * the maximal time of for each product to be entered at the checkout (user specified)
	 */
	private double max_productTime;
	/**
	 * A token of the services
	 */
	private Services distributeCustomer;
	/**
	 * @param checkoutList a list of checkouts on the GUI
	 * @param checkoutNum the number of a checkout
	 * @param simulationWindow the result window for updating the results
	 * @param distributeCustomer the token of the services
	 * @param min_productTime the minimal time of for each product to be entered at the checkout (user specified)
	 * @param max_productTime the maximal time of for each product to be entered at the checkout (user specified)
	 */
	public ProductScanner(List<Checkout> checkoutList, int checkoutNum, JFrame simulationWindow, Services distributeCustomer,
						  double min_productTime, double max_productTime) {
		super();
		this.queue = checkoutList.get(checkoutNum - 1).getQueue();
		this.checkoutList = checkoutList;
		this.checkoutNum = checkoutNum;
		this.simulationWindow = simulationWindow;
		this.min_productTime = min_productTime;
		this.max_productTime = max_productTime;
		this.distributeCustomer = distributeCustomer;
	}


    /**
     *  Scan a product for a customer
     */
	@Override
	public void run() {
		   while(Thread.currentThread().isAlive()) {
			   // the thread is working when there is a customer in a checkout.
			   while(queue!=null) {
				   try {
					   // get first person in each queue to scan a product
					   distributeCustomer.scanProduct(simulationWindow, checkoutList, checkoutNum);

					   // !

					   // time for each product to be scanned
					   Long scanningTime = (long)RandomNum.generateRandomNumByDouble(min_productTime, max_productTime) * 1000;
					   Thread.sleep(scanningTime);
				   } catch (InterruptedException e) {
					   e.printStackTrace();
				   }
			   }
		   }
	}
}
