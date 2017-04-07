package copyFof;
//·Ö×é¡£
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Group extends WritableComparator{

	public Group(){
		super(Friend.class,true);
	}
	
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		Friend f1 = (Friend)a;
		Friend f2 = (Friend)b;
		
		int c = f1.getFriend1().compareTo(f2.getFriend1());
		return c;
	}
	
}
