package services;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import components.Checkout;
import components.Customer;
import utils.Record;

/**
 * what actions can the project do.
 * add a customer from a queue,
 * remove a customer from a queue,
 * and scan products
 */
public class Services {

	/**
	 * Add a customer into a queue and update on the GUI
	 * @param simulationWindow the result window for updating the result
	 * @param queue the queue for adding a customer
	 * @param customerId the id number of a customer
	 * @param productNum the product number of a customer
	 * @param status	 the status of a customer
	 * @param checkoutNum the number of the checkout a customer will be added to. (as a index to get a checkout in checkoutList)
	 * @param checkoutList the list of checkouts
	 */
	public synchronized void addCustomer(JFrame simulationWindow, List<Customer> queue, int customerId, int productNum,
			String status, int checkoutNum, List<Checkout> checkoutList) {

		// init the params for initializing the customer. 
		Customer customer = new Customer(null, customerId, productNum, status);
		
		// for showing in the GUI 
		JButton btn_customer = new JButton("<html>" + customerId + "<br/>" + customer.getStatus() + "<br/>"
				+ customer.getProductNum() + "<br/>" + "</html>");
		
		// this is for the "null" above
		customer.setCustomer(btn_customer);

		// add click event for showing the customer detail in the GUI
		btn_customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(
						null, "ID: " + customer.getCustomerId() + " Status: " + customer.getStatus()
								+ " ProductNumber: " + customer.getProductNum() + 
								" Waiting Time: " + (customer.getWaitingTime()/1000)/60 + " min " + 
								(customer.getWaitingTime()/1000)%60 + " sec" ,
						"Customer Detail", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		// add into the queue
		queue.add(customer);
		
		// record the utilized time for checkouts
				if(checkoutList.get(checkoutNum - 1).getHasCustomer() == false && queue.size() > 0) {
					
					checkoutList.get(checkoutNum - 1).setUtilizedTime_start(System.currentTimeMillis());
					
					checkoutList.get(checkoutNum - 1).setHasCustomer(true);
				}
				
		// Record
		// modify the total number of customers
		Record.getInstance().setTotalCustomerNum(Record.getInstance().getTotalCustomerNum() + 1);

		// Display Settings
		btn_customer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_customer.setBounds(80 + queue.size() * 60, 125 + checkoutNum * 80, 45, 60);
		simulationWindow.getContentPane().add(btn_customer);
		
		// refresh the GUI
		simulationWindow.revalidate();
		simulationWindow.repaint();
		
		// one of the queue has a customer
		notifyAll();

	}

	/**
	 * Remove a customer from a queue and update on the GUI
	 * @param simulationWindow the result window for updating the result
	 * @param checkoutNum the number of the checkout a customer will be removed. (as a index to get a checkout in checkoutList)
	 * @param checkoutList the list of checkouts
	 */
	public synchronized void removeCustomer(JFrame simulationWindow, int checkoutNum, List<Checkout> checkoutList) {
		List<Customer> queue = checkoutList.get(checkoutNum - 1).getQueue(); 
		
		// get the customer who will be removed (first customer in the checkout)
		Customer customer = queue.get(0);
		
		// make the customer invisible like removing
		customer.getCustomer().setVisible(false);
		
		// remove from the queue
		queue.remove(0);
		
		// record the utilized time for checkouts
				if(checkoutList.get(checkoutNum - 1).getHasCustomer() == true && queue.size() <= 0) {
					
					checkoutList.get(checkoutNum - 1).setUtilizedTime_end(System.currentTimeMillis());
					
					long utilized_time = checkoutList.get(checkoutNum - 1).getUtilizedTime_total() + 
			        ((checkoutList.get(checkoutNum - 1).getUtilizedTime_end() - 
			        checkoutList.get(checkoutNum - 1).getUtilizedTime_start()));  
					
					checkoutList.get(checkoutNum - 1).setUtilizedTime_total(
							checkoutList.get(checkoutNum - 1).getUtilizedTime_total() + utilized_time);
					// reset 
					checkoutList.get(checkoutNum - 1).setUtilizedTime_start(0);
					checkoutList.get(checkoutNum - 1).setUtilizedTime_end(0);
					
					checkoutList.get(checkoutNum - 1).setHasCustomer(false);
				}
				Record.getInstance().addTotalWaitTime(customer.getWaitingTime());
				
		// repaint the GUI
		for (int i = 0; i < queue.size(); i++) {
			JButton btn_customer = queue.get(i).getCustomer();
			btn_customer.setBounds(80 + i * 60 + 40, 135 + checkoutNum * 80, 45, 60);
			queue.get(i).updateStatus();
			simulationWindow.revalidate();
			simulationWindow.repaint();
		}
		
	}

	/**
	 * Scan a product for a customer and update on the GUI
	 * @param simulationWindow the result window for updating the result
	 * @param checkoutList the list of checkouts
	 * @param checkoutNum the number of the checkout a product will be scanned. (as a index to get a checkout in checkoutList)
	 */
	public synchronized void scanProduct(JFrame simulationWindow, List<Checkout> checkoutList,int checkoutNum) {
		
		List<Customer> queue = checkoutList.get(checkoutNum - 1).getQueue(); 
		
		while (queue.size() <= 0) {
			try {
				wait();
				// System.out.println("I'm waiting");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// System.out.println("Finally");
		// System.out.println("Size of the queue: " + queue.size());
		Customer customer = queue.get(0);
		customer.setStatus("Active");
		customer.setProductNum(customer.getProductNum() - 1);
		customer.getCustomer().setText("<html>" + customer.getCustomerId() + "<br/>" + customer.getStatus() + "<br/>"
				+ customer.getProductNum() + "<br/>" + "</html>");
		// System.out.println("product scanned!");

		// Record
		// total product processed
		Record.getInstance().setTotalProcessedProductNum(Record.getInstance().getTotalProcessedProductNum() + 1);

		// when a customer has no product in the trolley
		if (customer.getProductNum() == 0) {
			removeCustomer(simulationWindow, checkoutNum, checkoutList);
		}

		simulationWindow.revalidate();
		simulationWindow.repaint();
		

		
	
	}
}
