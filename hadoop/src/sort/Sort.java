package sort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Sort extends WritableComparator{
	public Sort (){
		super (Word.class,true);
	}
	
	@Override
	public int compare(WritableComparable a, WritableComparable b) {

		Word w1 = (Word)a;
		Word w2 = (Word)b;
		return w1.getWord().compareTo(w2.getWord());
	}
}
