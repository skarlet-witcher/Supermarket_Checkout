
package components;

import javax.swing.JButton;

/**
 * 	Basic Info of a customer
 */
public class Customer {
	/**
	 *  use a button to represent a customer on the GUI
	 */
	private JButton customer;
	/**
	 *  ID number of a customer
	 */
	private int customerId;
	/**
	 *  the number of products a customer has
	 */
	private int productNum;
	/**
	 *  The status of a customer which can be  "Active" or "Waiting"
	 */
	private String status;
	/**
	 *  The time of a customer is created (for calculating wait time for customer)
	 */
	private long createTime;

	/**
	 * Initialize the basic info of a customer
	 * @param customer initialize a button for showing a customer on the GUI
	 * @param customerId initialize ID number of a customer
	 * @param productNum initialize the number of products a customer has
	 * @param status initialize the status of a customer
	 */
	public Customer(JButton customer, int customerId, int productNum, String status) {
		super();
		this.customer = customer;
		this.customerId = customerId;
		this.productNum = productNum;
		this.status = status;
		this.createTime = System.currentTimeMillis();
	}

    /**
     *  update the status of a customer (typically from "Waiting" to "Active")
     */
	public void updateStatus() {
		this.getCustomer().setText("<html>" + this.getCustomerId() + "<br/>" + this.getStatus() + "<br/>"
				+ this.getProductNum() + "<br/>" + "</html>");
	}

    /**
     * get the total waiting time of a customer
     * @return the total waiting time of a customer
     */
	public long getWaitingTime() {
		return this.getCurrentTime() - this.getCreateTime();
	}

    /**
     * get the button represented as a customer
     * @return the button represented as a customer
     */
	public JButton getCustomer() {
		return customer;
	}

    /**
     * set a JButton to represent a customer
     * @param customer An object of the JButton to represent a customer
     */
	public void setCustomer(JButton customer) {
		this.customer = customer;
	}

    /**
     * get the id number of a customer
     * @return the id number of a customer
     */
	public int getCustomerId() {
		return customerId;
	}

    /**
     * get the number of products a customer has
     * @return the number of products a customer has
     */
	public int getProductNum() {
		return productNum;
	}

    /**
     * set the number of products
     * @param productsNum the number of products
     */
	public void setProductNum(int productsNum) {
		this.productNum = productsNum;
	}

    /**
     * get the status of a customer
     * @return the status of a customer
     */
	public String getStatus() {
		return status;
	}

    /**
     * get the time of a customer is created
     * @return The time of a customer is created
     */
	public long getCreateTime() {
		return createTime;
	}

    /**
     * get the current time (milliseconds)
     * @return the current time
     */
	public long getCurrentTime() {
		return System.currentTimeMillis();
	}


    /**
     * set the status of a customer ("Waiting" or "Active")
     * @param status the status of a customer ("Waiting" or "Active")
     */
	public void setStatus(String status) {
		this.status = status;
		this.updateStatus();
	}
}
