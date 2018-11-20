
package components;

import java.util.List;

/**
 *  Basic Info of a checkout
 */
public class Checkout {
    /**
     *  the number of the checkout
     */
	private int checkoutNum;
    /**
     *  The number of customers waiting in this checkout
     */
	private List<Customer> queue;
    /**
     *  Whether the checkout has a customer or not
     */
	private boolean hasCustomer;
    /**
     *  The start time of the utilization
     */
	private long utilizedTime_start;
    /**
     *  The end time of the utilization
     */
	private long utilizedTime_end;
    /**
     *  The total time of the utilization
     */
	private long utilizedTime_total;


    /**
     * Initialize the basic info of a checkout
     * @param checkoutNum initialize the checkout number
     * @param queue initialize the queue of customers
     */
	public Checkout(int checkoutNum, List<Customer> queue) {
		super();
		this.checkoutNum = checkoutNum;
		this.queue = queue;
		this.hasCustomer = false;
		this.utilizedTime_start = 0;
		this.utilizedTime_end = 0;
		this.utilizedTime_total = 0;
	}

    /**
     * get the queue of a checkout
     * @return the queue of a checkout
     */
	public List<Customer> getQueue() {
		return queue;
	}

    /**
     * get the result of whether a checkout has customers
     * @return the result of whether a checkout has customers
     */
	public boolean getHasCustomer() {
		return hasCustomer;
	}

    /**
     * set the result of whether a checkout has customers
     * @param hasCustomer the value of whether a checkout has customers.
     */
	public synchronized void setHasCustomer(boolean hasCustomer) {
		this.hasCustomer = hasCustomer;
	}

    /**
     * get the start time of the utilization in a checkout
     * @return the start time of the utilization in a checkout
     */
	public synchronized long getUtilizedTime_start() {
		return utilizedTime_start;
	}

    /**
     * set the start time of the utilization in a checkout
     * @param utilizedTime_start the start time of utilization
     */
	public synchronized void setUtilizedTime_start(long utilizedTime_start) {
		this.utilizedTime_start = utilizedTime_start;
	}

    /**
     * get the end time of the utilization in a checkout
     * @return the end time of the utilization in a checkout
     */
	public synchronized long getUtilizedTime_end() {
		return utilizedTime_end;
	}

    /**
     * set the end time of the utilization in a checkout
     * @param utilizedTime_end the end time of utilization
     */
	public synchronized void setUtilizedTime_end(long utilizedTime_end) {
		this.utilizedTime_end = utilizedTime_end;
	}

    /**
     * get the total utilization time of a checkout
     * @return the total utilization time of a checkout
     */
	public synchronized long getUtilizedTime_total() {
		return utilizedTime_total;
	}

    /**
     * set the total utilization time of a checkout
     * @param utilizedTime_total the total utilization time of a checkout
     */
	public synchronized void setUtilizedTime_total(long utilizedTime_total) {
		this.utilizedTime_total = utilizedTime_total;
	}
}
