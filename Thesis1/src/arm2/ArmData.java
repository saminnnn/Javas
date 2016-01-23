package arm2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArmData {
	public ArrayList<Double> theta=new ArrayList<Double>();
	public ArrayList<Double> theta2=new ArrayList<Double>();
	
	public ArmData() throws FileNotFoundException{
		File file=new File("simData.txt");
		Scanner scan=new Scanner(file);
		
		while(scan.hasNextLine()){
			String scanned=scan.next();
			scanned=scan.next();
			theta.add(Double.parseDouble(scanned));
		}
		
		file=new File("simData2.txt");
		scan=new Scanner(file);
		
		while(scan.hasNextLine()){
			String scanned=scan.next();
			scanned=scan.next();
			theta2.add(Double.parseDouble(scanned));
		}
	}

}
