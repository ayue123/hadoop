package copyWeather;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
//必须申明子类的类型，故用super
public class Sort extends WritableComparator{
	public Sort(){
		super(Weather.class,true);
	}
	
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		
		Weather w1 = (Weather) a;
		Weather w2 = (Weather) b;
		int c1 = Integer.compare(w1.getYear(),w2.getYear());
		if(c1 == 0){
			int c2 = Integer.compare(w1.getMonth(), w2.getMonth());
			if(c2 == 0){
				return -Integer.compare(w1.getTem(), w2.getTem());
			}
			return c2;
		}
		return c1;
	}

}
