package arm2;

import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Arm2 extends JPanel implements Runnable{
	int a1x1=200;
	int a1y1=400;
	int a1x2=400;
	int a1y2=100;
	int a2x1=a1x2;
	int a2y1=a1y2;
	int a2x2=500;
	int a2y2=100;
	double theta=0;
	double theta2=0;
	int length1=200;
	int length2=100;
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawLine(a1x1, a1y1, a1x2, a1y2);
		g.drawLine(a2x1, a2y1, a2x2, a2y2);
		g.drawLine(a2x2, a2y2, a2x2+15, a2y2+10);
		g.drawLine(a2x2, a2y2, a2x2+15, a2y2-10);
		g.drawLine(a1x1, a1y1-125, a1x1, a1y1+125);
	}
	

	@Override
	public void run() {
		ArmData data = null;
		try {
			data=new ArmData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Double> thetas=data.theta;
		ArrayList<Double> thetas2=data.theta2;
		
		while(true){
			for(int i=0;i<thetas2.size();i=i+10){
				theta=thetas.get(i);
				theta2=thetas2.get(i);
				theta=thetas.get(i);
				a1x2=(int)(a1x1+length1*Math.cos(theta));
				a1y2=(int)(a1y1+length1*Math.sin(theta));
				a2x1=a1x2;
				
				
				a2y1=a1y2;
				a2x2=(int)(a2x1+length2*Math.cos(theta2));
				a2y2=(int)(a2y1+length2*Math.sin(theta2));
				
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}