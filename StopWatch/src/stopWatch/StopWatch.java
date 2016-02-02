package stopWatch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class StopWatch implements ActionListener {
	
	JLabel jlab;
	JButton jbtn;
	long start;
	
	StopWatch() {
		JFrame jfrm = new JFrame("Stopwatch");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(230,  90);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jbtn = new JButton("Start");
		
		jbtn.addActionListener(this);

		jfrm.add(jbtn);
		
		jlab = new JLabel("Press Start");
		jfrm.add(jlab);
		
		jfrm.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Calendar cal = Calendar.getInstance();
		
		if (ae.getActionCommand().equals("Start")) {
			start = cal.getTimeInMillis();
			jlab.setText("Stopwatch running...");
			jbtn.setText("Stop");
			jbtn.setActionCommand("Stop");
			
		}
		else { 
			jlab.setText("Elapsed time is " + 
				(double) (cal.getTimeInMillis() - start) / 1000);

			jbtn.setText("Start");
			jbtn.setActionCommand("Start");
		}
	}
	
	public static void main(String args[])	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new StopWatch();
			}
		});
	}
}