package mapping2;

import java.io.FileNotFoundException;

public class testMain {

	public static void main(String[] args) throws FileNotFoundException {
		Map map=new Map();
		System.out.println(map.node.get(1).latitude+" and index is "+map.node.get(1).index);
		System.out.println(map.edge[1][6]);
	}

}
