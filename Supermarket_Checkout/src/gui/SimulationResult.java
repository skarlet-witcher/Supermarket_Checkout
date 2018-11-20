package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import utils.Record;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import components.Checkout;
import components.Customer;
import services.Services;
import threads.CustomerAdder;
import threads.ProductScanner;


/**
 * The result of the simulation for supermarket checkout
 */
public class SimulationResult {

	/**
	 * the frame of the result window
	 */
	private JFrame frmSimulationresult;
	/**
	 * A variable to store the list of checkouts
	 */
	private List<Checkout> checkoutList = new ArrayList<Checkout>();
    /**
     * A token of the services
     */
	private Services distributeCustomer = new Services();

	/**
	 * Launch the window of simulation result.
	 */
			public void run() {
				try {
					SimulationResult window = new SimulationResult();
					window.frmSimulationresult.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Initialize the window of simulation result.
	 */
	public SimulationResult() {
		initialize();
	}
	
	/**
	 * Initialize the window of simulation result.
	 */
	private void initialize() {
		frmSimulationresult = new JFrame();
		frmSimulationresult.setTitle("SimulationResult");
		frmSimulationresult.setBounds(0, 0, 957, 738);
		frmSimulationresult.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmSimulationresult.getContentPane().setLayout(null);

		generateCheckoutList();
        recordCheckoutList();
        initCustomerAdder();
        initProductScanner();

        outputRecord();
	}

    /**
     * generate the normal checkout and express checkout
     */
	private void generateCheckoutList() {
        // generate the checkout by using loop
        for(int i = 1; i <= Record.getInstance().getCheckoutNum(); i++) {

            // last one is the express checkout
            if (i > Record.getInstance().getCheckoutNum() - Record.getInstance().getExpressCheckoutNum()) {
                JLabel lblNewLabel = new JLabel("<html>Checkout " + i + "<br/>( 5 items or less )  <html>");
                lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
                lblNewLabel.setBounds(0, 135 + i * 80, 330, 51);
                frmSimulationresult.getContentPane().add(lblNewLabel);

                // add express checkout into checkoutList
                checkoutList.add(new Checkout(i, new ArrayList<Customer>()));
                continue;
            }

            JLabel lblNewLabel = new JLabel("Checkout " + i);
            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
            lblNewLabel.setBounds(0, 135 + i * 80, 330, 51);
            frmSimulationresult.getContentPane().add(lblNewLabel);

            // add checkout into checkoutList
            checkoutList.add(new Checkout(i, new ArrayList<>()));

        }
    }

    /**
     * make a record for the checkoutList
     */
    private void recordCheckoutList() {
        Record.getInstance().setCheckoutList(checkoutList);
        Record.getInstance().setStartSimulationTime(System.currentTimeMillis());
    }

    /**
     * initialize the thread of adding customer and start
     */
    private void initCustomerAdder() {
        // start the thread of adding customer into checkout
        new Thread(new CustomerAdder(frmSimulationresult, checkoutList, distributeCustomer)).start();
    }

    /**
     * initialize the thread of scanning products and start
     */
    private void initProductScanner() {
        for(int i = 1; i <= Record.getInstance().getCheckoutNum(); i++) {

            // start the thread of scanning product for each checkout.
            new Thread(new ProductScanner(checkoutList, i, frmSimulationresult, distributeCustomer,Record.getInstance().getMin_productTime(), Record.getInstance().getMax_productTime())).start();
        }
    }

    /**
     * Output the record after the window closed
     */
    private void outputRecord() {
        // Output the record when system closed
        frmSimulationresult.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                Record.getInstance().outputResult();
                e.getWindow().dispose();
                System.exit(0);
            }
        });
    }
}


