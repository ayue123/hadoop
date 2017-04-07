package fof;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Group extends WritableComparator{

	public Group(){
		super(Friend.class,true);
	}
	//目的：减少调用reduce的次数，相同key值只需要调用一次reduce，提高I/O效能。
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		
		Friend f1 = (Friend)a;
		Friend f2 = (Friend)b;
		
		int c = f1.getFriend1().compareTo(f2.getFriend1());
		return c;
	}
	
}
