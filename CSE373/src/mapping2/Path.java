package mapping2;
import java.util.ArrayList;

public class Path {
	public ArrayList<Integer> position=new ArrayList<Integer>();
	public ArrayList<Long> timeStamp=new ArrayList<Long>();
	
	public Path(){}
	
	public void set(int pos, long time){
		if(position.isEmpty()){
			position.add(pos);
			timeStamp.add(time);
		}
		else{
			if(position.get(position.size()-1)!=pos){
				position.add(pos);
				timeStamp.add(time);
			}
		}
		//System.out.println("Position is "+(position.get(position.size()-1)+" and time is "+(timeStamp.get(timeStamp.size()-1))));
	}

}
