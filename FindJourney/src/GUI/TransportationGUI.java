package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransportationGUI extends JFrame {

	private JPanel contentPane;

	
	TripFrame trip = new TripFrame(this);
	driverFrame driver = new driverFrame(this);
	
	

	
	public TransportationGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton haveTrip = new JButton("Have a Trip");
		haveTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trip.setVisible(true);
				dispose();
			}
		});
		haveTrip.setBounds(138, 71, 160, 37);
		contentPane.add(haveTrip);
		
		JButton drivers = new JButton("Drivers");
		drivers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				driver.setVisible(true);
				dispose();
			}
		});
		drivers.setBounds(138, 131, 160, 37);
		contentPane.add(drivers);
	}
}
