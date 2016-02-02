package stopWatch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class StopWatch implements ActionListener {
	
	JLabel jlab;
	long start;
	
	StopWatch() {
		JFrame jfrm = new JFrame("Stopwatch");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(230,  90);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton jbtnStart = new JButton("Start");
		JButton jbtnStop = new JButton("Stop");
		
		jbtnStart.addActionListener(this);
		jbtnStop.addActionListener(this);

		jfrm.add(jbtnStart);
		jfrm.add(jbtnStop);
		
		jlab = new JLabel("Press Start");
		jfrm.add(jlab);
		
		jfrm.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Calendar cal = Calendar.getInstance();
		
		if (ae.getActionCommand().equals("Start")) {
			start = cal.getTimeInMillis();
			jlab.setText("Stopwatch running...");
		}
		else
			jlab.setText("Elapsed time is " + 
				(double) (cal.getTimeInMillis() - start) / 1000);
	}
	
	public static void main(String args[])	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new StopWatch();
			}
		});
	}
}