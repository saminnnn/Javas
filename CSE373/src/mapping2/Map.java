package mapping2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {
	public ArrayList<Node> node;
	public boolean[][] edge;
	
	public Map() throws FileNotFoundException{
		node=new ArrayList<Node>();
		edge=new boolean[552][552];
		File nodes=new File("map_node.txt");
		File edges=new File("map_edge.txt");
		Scanner scan=new Scanner(nodes);
		
		while(scan.hasNextLine()){
			String scanned=scan.next();
			int index=Integer.parseInt(scanned);
			scanned=scan.next();
			double lat=Double.parseDouble(scanned);
			scanned=scan.next();
			double longt=Double.parseDouble(scanned);
			
			node.add(new Node(index,lat,longt));
		}
		
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
	}
}
