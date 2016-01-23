package mapping2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class searchMain {
	public static Map map;
	public static Path path=new Path();
	
	public static void main(String[] args) throws FileNotFoundException {
		Average[][] avg=new Average[552][552];
		map=new Map();
		double lat;
		double longt;
		File file=new File("route_data1.txt");
		Scanner scan=new Scanner(file);
		scan.useDelimiter(",");
		int i=0;
		String s;
		
		while(scan.hasNextLine()){
			//if(i==20) break;
			scan.next();
			s=scan.next();
			if(s.matches("end")) break;
			long time=Long.parseLong(s);
			lat=Double.parseDouble(scan.next());
			longt=Double.parseDouble(scan.next());
			search(lat,longt,time);
			scan.next();
			scan.next();
			//System.out.println("Time="+time);
			//i++;
		}
		
		for(i=1;i<path.position.size();i++){
			if(map.edge[path.position.get(i)][path.position.get(i-1)]){
				if(avg[path.position.get(i)][path.position.get(i-1)]==null) avg[path.position.get(i)][path.position.get(i-1)]=new Average();
				avg[path.position.get(i)][path.position.get(i-1)].set(path.timeStamp.get(i), path.timeStamp.get(i-1));
			}
		}
		
		PrintWriter pw=new PrintWriter("times.txt");
		
		for(i=0;i<552;i++){
			pw.print("From location "+i+":");
			pw.println("");
			for(int j=0;j<552;j++){
				if(avg[i][j]!=null) pw.println("    Location "+j+" takes "+avg[i][j].time+" minutes");
			}
			pw.println("");
		}
		
		pw.close();
	}
	
	
	
	public static void search(double lat, double longt, long time){
		int i=0;
		int output=0;
		
		while(i<map.node.size()){
		if(Math.abs(lat-map.node.get(i).latitude)<.0001){
			if(Math.abs(longt-map.node.get(i).longitude)<.001){
				output=map.node.get(i).index;
				break;
				}
			}
			i++;
		}
		
		if(output!=0) path.set(output, time);
	}
}
