package arm2;

import javax.swing.JFrame;

public class main2 extends JFrame{

	public static void main(String[] args) {
		Arm2 arm=new Arm2();
		Thread thread=new Thread(arm);
		JFrame frame=new JFrame("Simulation1");
		frame.getContentPane().add(arm);
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		thread.start();
		
	}

}