package threads;

import java.util.List;
import javax.swing.JFrame;
import components.Checkout;
import components.Customer;
import services.Services;
import utils.RandomNum;
import utils.Record;


/**
 *  A thread for adding a customer to the minimal queue among those checkouts
 */
public class CustomerAdder implements Runnable {
	/**
	 *  The result window for updating the a new customer on the GUI
	 */
	private JFrame simulationWindow;
	/**
	 *  A list of checkouts on the GUI
	 */
	private List<Checkout> checkoutList;
	/**
	 *  A token of the services
	 */
	private Services distributeCustomer;
	/**
	 *  A temporary variable for finding the minimal queue in a list of checkouts
	 */
	private List<Customer> temp_minimal_queue;
	/**
	 *  A temporary variable for finding the minimal queue in express checkouts
	 */
	private List<Customer> temp_express_minimal_queue;
	/**
	 *  A variable of the minimal queue of a express checkout
	 */
	private List<Customer> express_minimal_queue;
	/**
	 *  The number of the checkout that a customer will be joined.
	 */
	private int checkoutNum;
	/**
	 *  The Id number for the new customer
	 */
	private int customer_id;
	/**
	 *  The number of products a new customer has
	 */
	private int productNum;

	/**
	 * @param simulationWindow the result window which will be updated with a new customer
	 * @param checkoutList a list of generated checkouts
	 * @param distributeCustomer a token of the services
	 */
	public CustomerAdder(JFrame simulationWindow, List<Checkout> checkoutList, Services distributeCustomer) {
		super();
		this.simulationWindow = simulationWindow;
		this.checkoutList = checkoutList;
		this.distributeCustomer = distributeCustomer;
		this.customer_id = 1;
		this.express_minimal_queue = null;
	}

	/**
	 *  Find the minimal queue among checkouts and add a new customer into it.
	 */
	@Override
	public void run() {
		// keep adding customers
		while(Thread.currentThread().isAlive()) {
			
			// find the minimal queue for a customer to join among those checkouts
			for( int i = 0; i < Record.getInstance().getCustomer_rate(); i++) {
				
				// initialize the express minimal queue each time
				express_minimal_queue =  null;
				// find minimal queue for the normal checkouts
				for(int j = 0; j < checkoutList.size() - Record.getInstance().getExpressCheckoutNum(); j++) {
					if( j == 0 ) {
						// assume that the first queue is the minimal one
						temp_minimal_queue = checkoutList.get(j).getQueue();
						checkoutNum = j + 1;
						continue;
					}
					if(checkoutList.get(j).getQueue().size() < temp_minimal_queue.size()) {
						temp_minimal_queue = checkoutList.get(j).getQueue();
						// if the minimal queue is updated, save the checkout Number
						checkoutNum = j + 1;
					}
				}


				// generate random product number in the trolley
				productNum = RandomNum.generateRandomNumByInt(Record.getInstance().getMin_productNum(), Record.getInstance().getMax_productNum());
				
				// whether join the express checkout
				if(productNum <= 5) {
					
					// if there is a available express checkout
					for(int a = 1; a <= Record.getInstance().getExpressCheckoutNum(); a++) {
						temp_express_minimal_queue = checkoutList.get(checkoutList.size() - a).getQueue();
						
						// if the size of normal checkout is smaller than the express checkout
						if(temp_minimal_queue.size() <= temp_express_minimal_queue.size()) {
							continue;
						} else {
							express_minimal_queue = temp_express_minimal_queue;
							break;
						}
						
					}
					// the size of normal checkout is smaller than express checkouts
					if(express_minimal_queue == null) {
						// if queue > 6, the customer will not join the queue.
						if(temp_minimal_queue.size() > 6) {
							// Record: the total number of the lost customers
							Record.getInstance().setLostCustomerNum(Record.getInstance().getLostCustomerNum() + 1);
							Record.getInstance().setTotalCustomerNum(Record.getInstance().getTotalCustomerNum() + 1);
							// output the info of lost customer
							System.out.println("Customer " + customer_id + " Lost!");
							System.out.println("------------------------------------");
							customer_id++;
							continue;
						}

						distributeCustomer.addCustomer(simulationWindow, temp_minimal_queue, customer_id,
								productNum, "Waiting", checkoutNum, checkoutList);

						// Record: modify the total number of products
						// for printing the average products per trolley
						Record.getInstance().setTotalProductNum(Record.getInstance().getTotalProductNum() + productNum);
						customer_id++;
					}
					else {
						// find minimal queue among express checkouts
						int express_checkoutNum = 0;
						for(int a = 1; a <= Record.getInstance().getExpressCheckoutNum(); a++) {
							if(a == 1) {
								// assume the first checkout is the minmal one
								express_minimal_queue = checkoutList.get(checkoutList.size() - a).getQueue();
								express_checkoutNum = checkoutList.size() - a + 1;
							}
							if(express_minimal_queue.size() > checkoutList.get(checkoutList.size() - a).getQueue().size() ) {
								express_minimal_queue =  checkoutList.get(checkoutList.size() - a).getQueue();
								express_checkoutNum = checkoutList.size() - a + 1;
							}
						}
                        // if queue > 6, the customer will not join the queue.
                        if(express_minimal_queue.size() > 6) {
                            // Record: the total number of the lost customers
                            Record.getInstance().setLostCustomerNum(Record.getInstance().getLostCustomerNum() + 1);
                            Record.getInstance().setTotalCustomerNum(Record.getInstance().getTotalCustomerNum() + 1);
                            // output the info of lost customer
                            System.out.println("Customer " + customer_id + " Lost!");
                            System.out.println("------------------------------------");
                            customer_id++;
                            continue;
                        }
						
						// add the customer into express checkout
						distributeCustomer.addCustomer(simulationWindow, express_minimal_queue, customer_id, 
								productNum, "Waiting", express_checkoutNum, checkoutList);

						// Record: modify the total number of products
						// for printing the average products per trolley
						Record.getInstance().setTotalProductNum(Record.getInstance().getTotalProductNum() + productNum);
						customer_id++;
						
					}
					
				
					
				} else {

					if(temp_minimal_queue.size() > 6) {
						// Record: the total number of the lost customers
						Record.getInstance().setLostCustomerNum(Record.getInstance().getLostCustomerNum() + 1);
						Record.getInstance().setTotalCustomerNum(Record.getInstance().getTotalCustomerNum() + 1);
						// output the info of lost customer
						System.out.println("Customer " + customer_id + " Lost!");
						System.out.println("------------------------------------");
						customer_id++;
						continue;
					}

					distributeCustomer.addCustomer(simulationWindow, temp_minimal_queue, customer_id, 
							productNum, "Waiting", checkoutNum, checkoutList);
					
					// Record: modify the total number of products
					// for printing the average products per trolley
					Record.getInstance().setTotalProductNum(Record.getInstance().getTotalProductNum() + productNum);
					customer_id++;
				}
				
			}
			try {
				// sleep for a better view
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
