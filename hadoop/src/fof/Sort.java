package fof;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Sort extends WritableComparator{

	public Sort(){
		super (Friend.class,true);
	}
	//
	@Override
	public int compare(WritableComparable a, WritableComparable b) {

		Friend f1  = (Friend)a;
		Friend f2  = (Friend)b;

		int c = f1.getFriend1().compareTo(f2.getFriend1());
		
		if(c ==0){
			//«◊√‹∂»Ωµ–Ú≈≈–Ú
			return -Integer.compare(f1.getHot(), f2.getHot());
		}
		
		return c;
	}
	
}
