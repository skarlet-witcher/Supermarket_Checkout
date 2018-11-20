package utils;

import java.text.NumberFormat;
import java.util.List;

import components.Checkout;

/**
 * Record all the data for outputting on the console
 */
public class Record {
	/**
	 * total number of the customers
	 */
	private int totalCustomerNum;
	/**
	 * total waiting time of the customers
	 */
	private long totalWaitingTime;
	/**
	 * total number of processed products
	 */
	private int totalProcessedProductNum;
	/**
	 * total number of the lost customers
	 */
	private int lostCustomerNum;
	/**
	 * total number of products
	 */
	private int totalProductNum;
	/**
	 * the total number of checkouts
	 */
	private int checkoutNum;
	/**
	 * the total number of express checkouts
	 */
	private int expressCheckoutNum;
	/**
	 * the minimal number of products for each trolley
	 */
	private int min_productNum;
	/**
	 * the maximal number of products for each trolley
	 */
	private int max_productNum;
	/**
	 * the minimal time for each product to be entered at the checkout
	 */
	private double min_productTime;
	/**
	 * the maximal time for each product to be entered at the checkout
	 */
	private	double max_productTime;
	/**
	 * the rate the customer arrive at the checkouts
	 */
	private int customer_rate;
	/**
	 * a list of checkouts on the GUI
	 */
	private List<Checkout> checkoutList;
	/**
	 * the start time when the simulation is started
	 */
	private long startSimulationTime;
	/**
	 *  a variable for singleton
	 */
	public static Record record = null;

	/**
	 * Initialize the variable with 0 value
	 */
	private Record() {
		this.totalCustomerNum = 0;
		this.totalWaitingTime = 0;
		this.totalProcessedProductNum = 0;
		this.lostCustomerNum = 0;
		this.checkoutNum = 0;
		this.min_productNum = 0;
		this.max_productNum = 0;
		this.min_productTime = 0;
		this.max_productTime = 0;
	}

	/**
	 * @return the instance of the Record class
	 */
	public static Record getInstance() {
		if(record == null) {
			record = new Record();
		}
		return record;
	}


	/**
	 * get the number of the express checkout
	 * @return the number of the express checkout
	 */
	public int getExpressCheckoutNum() {
		return expressCheckoutNum;
	}

    /**
     * set the number of the express checkout
     * @param expressCheckoutNum the number of the express checkout
     */
	public void setExpressCheckoutNum(int expressCheckoutNum) {
		this.expressCheckoutNum = expressCheckoutNum;
	}

    /**
     * get the total number of the customers
     * @return the total number of the customers
     */
	public synchronized int getTotalCustomerNum() {
		return totalCustomerNum;
	}

    /**
     * set the total number of the customers
     * @param totalCustomerNum the total number of the customers
     */
	public synchronized void setTotalCustomerNum(int totalCustomerNum) {
		this.totalCustomerNum = totalCustomerNum;
	}

    /**
     * get the total number of the processed products
     * @return the total number of the processed products
     */
	public synchronized int getTotalProcessedProductNum() {
		return totalProcessedProductNum;
	}

    /**
     * set the total number of the processed products
     * @param totalProcessedProductNum the total number of the processed products
     */
	public synchronized void setTotalProcessedProductNum(int totalProcessedProductNum) {
		this.totalProcessedProductNum = totalProcessedProductNum;
	}

    /**
     * get the total number of the lost customers
     * @return the total number of the lost customers
     */
	public synchronized int getLostCustomerNum() {
		return lostCustomerNum;
	}

    /**
     * set the total number of the lost customers
     * @param lostCustomerNum the total number of the lost customers
     */
	public synchronized void setLostCustomerNum(int lostCustomerNum) {
		this.lostCustomerNum = lostCustomerNum;
	}

    /**
     * get the total number of checkouts
     * @return the total number of checkouts
     */
	public int getCheckoutNum() {
		return checkoutNum;
	}

    /**
     * set the total number of checkouts
     * @param checkoutNum the total number of checkouts
     */
	public void setCheckoutNum(int checkoutNum) {
		this.checkoutNum = checkoutNum;
	}

    /**
     * get the minimal number of products for each trolley
     * @return the minimal number of products for each trolley
     */
	public int getMin_productNum() {
		return min_productNum;
	}

    /**
     * set the minimal number of products for each trolley
     * @param min_productNum the minimal number of products for each trolley
     */
	public void setMin_productNum(int min_productNum) {
		this.min_productNum = min_productNum;
	}

    /**
     * get the maximal number of products for each trolley
     * @return the maximal number of products for each trolley
     */
	public int getMax_productNum() {
		return max_productNum;
	}

    /**
     * set the maximal number of products for each trolley
     * @param max_productNum the maximal number of products for each trolley
     */
	public void setMax_productNum(int max_productNum) {
		this.max_productNum = max_productNum;
	}

    /**
     * get the minimal time for each product to be entered at the checkout
     * @return the minimal time for each product to be entered at the checkout
     */
	public double getMin_productTime() {
		return min_productTime;
	}

    /**
     * set the minimal time for each product to be entered at the checkout
     * @param min_productTime the minimal time for each product to be entered at the checkout
     */
	public void setMin_productTime(double min_productTime) {
		this.min_productTime = min_productTime;
	}

    /**
     * get the maximal time for each product to be entered at the checkout
     * @return the maximal time for each product to be entered at the checkout
     */
	public double getMax_productTime() {
		return max_productTime;
	}

    /**
     * set the maximal time for each product to be entered at the checkout
     * @param max_productTime the maximal time for each product to be entered at the checkout
     */
	public void setMax_productTime(double max_productTime) {
		this.max_productTime = max_productTime;
	}

    /**
     * get the rate the customer arrive at the checkouts
     * @return the rate the customer arrive at the checkouts
     */
	public int getCustomer_rate() {
		return customer_rate;
	}

    /**
     * set the rate the customer arrive at the checkouts
     * @param customer_rate the rate the customer arrive at the checkouts
     */
	public void setCustomer_rate(int customer_rate) {
		this.customer_rate = customer_rate;
	}

    /**
     * get the total number of products
     * @return the total number of products
     */
	public int getTotalProductNum() {
		return totalProductNum;
	}

    /**
     * set the total number of products
     * @param totalProductNum the total number of products
     */
	public void setTotalProductNum(int totalProductNum) {
		this.totalProductNum = totalProductNum;
	}

    /**
     * get the list of checkouts
     * @return the list of checkouts
     */
	public List<Checkout> getCheckoutList() {
		return checkoutList;
	}

    /**
     * set the list of checkouts on the GUI
     * @param checkoutList the list of checkouts on the GUI
     */
	public void setCheckoutList(List<Checkout> checkoutList) {
		this.checkoutList = checkoutList;
	}

    /**
     * get the start time of simulation
     * @return the start time of simulation
     */
	public long getStartSimulationTime() {
		return startSimulationTime;
	}

    /**
     * set the start time of simulation
     * @param startSimulationTime the start time of simulation
     */
	public void setStartSimulationTime(long startSimulationTime) {
		this.startSimulationTime = startSimulationTime;
	}

    /**
     * @return the total waiting time of all the customers
     */
	private long getTotalWaitTime() {
		for(int i = 0; i < this.checkoutNum; i++) {
			for( int j = 0; j < this.getCheckoutList().get(i).getQueue().size(); j++) {
				this.totalWaitingTime += this.getCheckoutList().get(i).getQueue().get(j).getWaitingTime();
			}
		}
		return this.totalWaitingTime;
	}

    /**
     * record total waiting time when a customer is about to leave
     * @param totalWaitingTime total waiting time when a customer is about to leave
     */
	public synchronized void addTotalWaitTime(Long totalWaitingTime) {
	    this.totalWaitingTime += totalWaitingTime;
    }

    /**
     * output total utilization for each checkout
     */
	private void outputUtilizedTimeForEachCheckout() {
		long FinishTime = System.currentTimeMillis();
		long elapsedTime = FinishTime - this.getStartSimulationTime();
		long openTime;
		
		// make the attribute with the same type
		double totalUtilizedTime = 0;
		double temp1;
		double temp2;
		double checkoutNum;
		double utilizedTime;
        Checkout currentCheckout;
		// init the format of outputting the percentage
		NumberFormat nf  =  NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits( 2 );
        checkoutNum = checkoutList.size();
		System.out.println("Total utilization for each checkout:");
		System.out.println("");
		for(int i = 0; i < this.checkoutList.size(); i++) {
			currentCheckout = this.checkoutList.get(i);


			if(currentCheckout.getHasCustomer()) {
			    // when window closed, the checkout is still active
                openTime = currentCheckout.getUtilizedTime_total() + (FinishTime - currentCheckout.getUtilizedTime_start());
            } else {
			    // when window closed, the checkout is not active
			    openTime = currentCheckout.getUtilizedTime_total();
            }


			temp1 = openTime;
			temp2 = elapsedTime;
			utilizedTime = temp1/temp2;
			// make the percentage more precise (non-determinism?)
			if(utilizedTime >= 1) {
				utilizedTime = 1;
			}
			 System.out.println("Checkout " + ( i + 1 ) + " "+ nf.format(utilizedTime) );
			 System.out.println("");
			 //System.out.println("openTime: " + openTime );
			// System.out.println("elapsedTime: " + elapsedTime );
			 totalUtilizedTime += utilizedTime;
			
		}
		System.out.println("");
		System.out.println("Average utilization for each checkout: " + nf.format(totalUtilizedTime / checkoutNum));
	}

    /**
     * output all the required record on the console
     */
	public void outputResult() {
		System.out.println("----------System Record-----------");
		System.out.println("");
		System.out.println("Total products processed: " + this.totalProcessedProductNum);
		System.out.println("");
		System.out.println("Average products per trolley: " + this.totalProductNum /this.totalCustomerNum);
		System.out.println("");
		outputUtilizedTimeForEachCheckout();
		System.out.println("");
		System.out.println("The total number of the lost customers: " + this.lostCustomerNum);
		System.out.println("");
		System.out.println("The total waiting time for all customers: " +
		        ((this.getTotalWaitTime()/1000) / 60) + " min " +
				((this.getTotalWaitTime()/1000) % 60) + " sec ");
		System.out.println("");
		System.out.println("Average customer waiting time: " + 
		(((this.getTotalWaitTime() / this.totalCustomerNum) / 1000) / 60) + " min " + 
		(((this.getTotalWaitTime() / this.totalCustomerNum) / 1000) % 60) + " sec ");
		System.out.println("");
		System.out.println("----------------------------------");
		
	}

}
