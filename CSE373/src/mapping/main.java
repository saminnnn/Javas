package mapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		File nodes=new File("map_node.txt");
		File edges=new File("map_edge.txt");
		ArrayList<Map> node=new ArrayList<Map>();
		Scanner scan=new Scanner(nodes);
		boolean[][] edge=new boolean[552][552];
		
		while(scan.hasNextLine()){
			String scanned=scan.next();
			int index=Integer.parseInt(scanned);
			scanned=scan.next();
			double lat=Double.parseDouble(scanned);
			scanned=scan.next();
			double longt=Double.parseDouble(scanned);
			
			node.add(new Map(index,lat,longt));
			
			//System.out.println(index+": "+lat+","+longt);
		}
		
		//System.out.println(node.get(3).index+": "+node.get(3).latitude+","+node.get(3).longitude);
		
		for(int i=0;i<552;i++){
			for(int j=0;j<552;j++){
				edge[i][j]=false;
			}
		}
		
		scan=new Scanner(edges);
		
		while(scan.hasNextLine()){
			String scanned=scan.next();
			int a=Integer.parseInt(scanned);
			scanned=scan.next();
			int b=Integer.parseInt(scanned);
			edge[a][b]=true;
			edge[b][a]=true;
		}
		
		sort(node);
		
	}

	private static void sort(ArrayList<Map> values) {
		double[] lats=new double[values.size()];
		double[] longt=new double[values.size()];
		
		for(int i=0;i<values.size();i++){
			lats[i]=values.get(i).latitude;
			longt[i]=values.get(i).longitude;
		}
		
		Arrays.sort(longt);
		Arrays.sort(lats);
		
		for(int i=0;i<values.size();i++){
			System.out.println(longt[i]+","+lats[i]);
		}
	}

}
