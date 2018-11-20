package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import gui.SimulationResult;
import utils.Record;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 *  A main menu for user to input params for the simulation
 */
public class Menu {

	/**
	 * Frame of the main menu
	 */
	private JFrame frmMenu;
	/**
	 * a variable number of functioning checkouts (1 to 8)
	 */
	private JTextField tf_checkoutNum;
	/**
	 * the minimal number of products for each trolley to be generated randomly within a user specified range (1 to 200)
	 */
	private JTextField tf_min_productNum;
	/**
	 * the maximal number of products for each trolley to be generated randomly within a user specified range (1 to 200)
	 */
	private JTextField tf_max_productNum;
	/**
	 * the minimal time for each product to be entered at the checkout to be generated randomly within a user specified range (.5 to 6).
	 */
	private JTextField tf_min_productTime;
	/**
	 * the maximal time for each product to be entered at the checkout to be generated randomly within a user specified range (.5 to 6).
	 */
	private JTextField tf_max_productTime;
	/**
	 * one or more checkouts to have a restriction on the number of items e.g. "5 items or less".
	 */
	private JTextField tf_expressCheckout;

	/**
	 * Initialize the main menu
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the main menu of the project.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 1221, 736);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);
		
		tf_checkoutNum = new JTextField();
		tf_checkoutNum.setBounds(421, 150, 65, 30);
		frmMenu.getContentPane().add(tf_checkoutNum);
		tf_checkoutNum.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Number of Checkouts (1 to 8) :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(47, 135, 330, 51);
		frmMenu.getContentPane().add(lblNewLabel);
		
		JLabel lblSupermarketCheckout = new JLabel("Supermarket Checkout Simulation");
		lblSupermarketCheckout.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSupermarketCheckout.setBounds(332, 40, 507, 51);
		frmMenu.getContentPane().add(lblSupermarketCheckout);
		
		JLabel lblT = new JLabel("The range of the number of products for each trolley ( 1 to 200 ) :\r\n");
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblT.setBounds(47, 254, 695, 57);
		frmMenu.getContentPane().add(lblT);
		
		tf_min_productNum = new JTextField();
		tf_min_productNum.setBounds(752, 272, 57, 30);
		frmMenu.getContentPane().add(tf_min_productNum);
		tf_min_productNum.setColumns(10);
		
		JLabel lbl_to_1 = new JLabel("to");
		lbl_to_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_to_1.setBounds(831, 272, 32, 31);
		frmMenu.getContentPane().add(lbl_to_1);
		
		tf_max_productNum = new JTextField();
		tf_max_productNum.setColumns(10);
		tf_max_productNum.setBounds(873, 272, 57, 30);
		frmMenu.getContentPane().add(tf_max_productNum);
		
		JLabel lblTheRangeOf = new JLabel("The range of the time for each product to be entered at the checkout ( 0.5 to 6 ) :\r\n");
		lblTheRangeOf.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTheRangeOf.setBounds(47, 334, 872, 57);
		frmMenu.getContentPane().add(lblTheRangeOf);
		
		tf_min_productTime = new JTextField();
		tf_min_productTime.setColumns(10);
		tf_min_productTime.setBounds(929, 350, 57, 30);
		frmMenu.getContentPane().add(tf_min_productTime);
		
		JLabel lbl_to_2 = new JLabel("to");
		lbl_to_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_to_2.setBounds(1005, 349, 32, 31);
		frmMenu.getContentPane().add(lbl_to_2);
		
		tf_max_productTime = new JTextField();
		tf_max_productTime.setColumns(10);
		tf_max_productTime.setBounds(1041, 350, 57, 30);
		frmMenu.getContentPane().add(tf_max_productTime);
		
		JLabel lblTheRateThe_1 = new JLabel("The rate the customers arrive at the checkouts\r\n");
		lblTheRateThe_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTheRateThe_1.setBounds(47, 408, 484, 57);
		frmMenu.getContentPane().add(lblTheRateThe_1);
		
		JComboBox comboBox_rate_customer = new JComboBox();
		comboBox_rate_customer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_rate_customer.setModel(new DefaultComboBoxModel(new String[] {"Please select", "Not busy", "Normal", "Busy"}));
		comboBox_rate_customer.setBounds(541, 424, 125, 30);
		frmMenu.getContentPane().add(comboBox_rate_customer);
		
		JLabel lblNotBusy = new JLabel("Not busy: 1 customer per sec \r\n");
		lblNotBusy.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNotBusy.setBounds(772, 424, 311, 57);
		frmMenu.getContentPane().add(lblNotBusy);
		
		JLabel lblNormalCustomer = new JLabel("Normal: 5 customer per sec \r\n");
		lblNormalCustomer.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNormalCustomer.setBounds(782, 492, 311, 57);
		frmMenu.getContentPane().add(lblNormalCustomer);
		
		JLabel lblBusyCustomer = new JLabel("Busy: 10 customer per sec \r\n");
		lblBusyCustomer.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblBusyCustomer.setBounds(787, 560, 311, 57);
		frmMenu.getContentPane().add(lblBusyCustomer);
		
		tf_expressCheckout = new JTextField();
		tf_expressCheckout.setBounds(666, 214, 57, 29);
		frmMenu.getContentPane().add(tf_expressCheckout);
		tf_expressCheckout.setColumns(10);
		
		JButton btn_startSimulation = new JButton("Start Simulation");
		btn_startSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Precondition check for each parameter
				try {
					// check the number of checkout
					if(tf_checkoutNum.getText().trim() == "" || 
							   Integer.parseInt(tf_checkoutNum.getText().trim()) < 1 || 
							   Integer.parseInt(tf_checkoutNum.getText().trim()) > 8) {
							 JOptionPane.showMessageDialog(null, "The number of checkout is invalid.", 
							 "Error Message in the number of checkout",JOptionPane.ERROR_MESSAGE);
							 return;
							}
					// check the number of express checkout
					if(tf_expressCheckout.getText().trim() == "" || Integer.parseInt(tf_expressCheckout.getText().trim()) < 0 ||
							Integer.parseInt(tf_expressCheckout.getText().trim()) > 2) {
						 JOptionPane.showMessageDialog(null, "The number of express checkout is invalid.", 
								 "Error Message in the number of express checkout",JOptionPane.ERROR_MESSAGE);
								 return;
					}
					// check the number of products in each trolley
					if(tf_min_productNum.getText().trim() == "" || 
					   tf_max_productNum.getText().trim() == "" ||
					   Integer.parseInt(tf_min_productNum.getText().trim()) > Integer.parseInt(tf_max_productNum.getText().trim()) ||
					   Integer.parseInt(tf_min_productNum.getText().trim()) < 1 || 
					   Integer.parseInt(tf_max_productNum.getText().trim()) > 200 ) {
						JOptionPane.showMessageDialog(null, "The number of proudcts in each trolley is invalid.", 
								 "Error Message in the number of checkout",JOptionPane.ERROR_MESSAGE);
								 return;
					}
					// check the time of scanning products
					if(tf_min_productTime.getText().trim() == "" || 
					   tf_max_productTime.getText().trim() == "" ||
					   Double.parseDouble(tf_min_productTime.getText().trim()) > Double.parseDouble(tf_max_productTime.getText().trim()) ||
					   Double.parseDouble(tf_min_productTime.getText().trim()) < 0.5 || 
					   Double.parseDouble(tf_max_productTime.getText().trim()) > 6 ) {
						JOptionPane.showMessageDialog(null, "The time of scanning proudcts is invalid.", 
								  "Error Message in the time of scanning products",JOptionPane.ERROR_MESSAGE);
								  return;
							}
					// check the total number of the customers
					if(comboBox_rate_customer.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(null, "Please choose the rate of the arrival of customers", 
								  "Error Message in the rate of customers' arrival ",JOptionPane.ERROR_MESSAGE);
								  return;
					}
					// assign values to record
					// one checkout for express checkout
					Record.getInstance().setExpressCheckoutNum(Integer.parseInt(tf_expressCheckout.getText().trim()));
					Record.getInstance().setCheckoutNum(Integer.parseInt(tf_checkoutNum.getText().trim()) + Integer.parseInt(tf_expressCheckout.getText().trim()));
					Record.getInstance().setMin_productNum(Integer.parseInt(tf_min_productNum.getText().trim()));
					Record.getInstance().setMax_productNum(Integer.parseInt(tf_max_productNum.getText().trim()));
					Record.getInstance().setMin_productTime(Double.parseDouble(tf_min_productTime.getText().trim()));
					Record.getInstance().setMax_productTime(Double.parseDouble(tf_max_productTime.getText().trim()));
					
					if(comboBox_rate_customer.getSelectedIndex() == 1) {
						Record.getInstance().setCustomer_rate(1);
					} else if(comboBox_rate_customer.getSelectedIndex() == 2) {
						Record.getInstance().setCustomer_rate(5);
					} else {
						Record.getInstance().setCustomer_rate(10);
					}
					
					
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "The type of the input is invalid, Please check each input carefully", 
							 "Exceptional Error",JOptionPane.ERROR_MESSAGE);
							 return;
				}
				SimulationResult sr = new SimulationResult();
				sr.run();
				Record.getInstance().setStartSimulationTime(System.currentTimeMillis());
			}
		});
		btn_startSimulation.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btn_startSimulation.setBounds(192, 520, 333, 57);
		frmMenu.getContentPane().add(btn_startSimulation);
		
		JLabel lblNumberOfExpress = new JLabel("Number of Express ( Five items or less ) Checkout (0 to 2):");
		lblNumberOfExpress.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNumberOfExpress.setBounds(47, 209, 609, 28);
		frmMenu.getContentPane().add(lblNumberOfExpress);
		
		
		
	}

	/**
	 * @return get the main menu window
	 */
	public JFrame getfrmMenu() {
		return this.frmMenu;
	}
}
