package mapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class routes {

	public static void main(String[] args) throws FileNotFoundException {
		File route=new File("route_data.txt");
		Scanner scan=new Scanner(route);
		int i=0;
		
		scan.useDelimiter(",");
		while(scan.hasNextLine() && i<10){
			System.out.println(scan.next());
			i++;
		}
	}

}
