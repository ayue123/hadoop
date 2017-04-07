package weather;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Sort extends WritableComparator {

	public Sort() {
		super(Tq.class,true);//必须写构造方法。
	}

	public int compare(WritableComparable a, WritableComparable b) {

		Tq t1 = (Tq) a;
		Tq t2 = (Tq) b;

		int c1 = Integer.compare(t1.getYear(), t2.getYear());

		if (c1 == 0) {
			int c2 = Integer.compare(t1.getMonth(), t2.getMonth());

			if (c2 == 0) {
				return -Integer.compare(t1.getTem(), t2.getTem());
			}
			return c2;
		}

		return c1;
	}

}
