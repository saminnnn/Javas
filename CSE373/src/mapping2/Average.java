package mapping2;

import java.util.Calendar;

public class Average {
	public float time;
	int count=0;
	
	public Average(){}
	
	public void set(long timeStamp, long prevTime){
		Calendar now=Calendar.getInstance();
		Calendar prev=Calendar.getInstance();
		int hnow, hprev, mnow, mprev;
		float diff;
		
		now.setTimeInMillis(timeStamp*1000l);
		prev.setTimeInMillis(prevTime);
		
		hnow=now.getTime().getHours();
		mnow=now.getTime().getMinutes();
		hprev=prev.getTime().getHours();
		mprev=prev.getTime().getMinutes();
		
		diff=(Math.abs((hnow*60+mnow)-(hprev*60+mprev)));
		
		time=(count*time+diff)/(count+1);
		count++;
		
		System.out.println(" Diff="+hnow+":"+mnow+"-"+hprev+":"+mprev+"="+diff+"      count="+count+" Time="+time);
	}

}
