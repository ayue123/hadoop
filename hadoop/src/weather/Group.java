package weather;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Group extends WritableComparator {

	public Group() {
		super(Tq.class, true);
	}

	public int compare(WritableComparable a, WritableComparable b) {

		Tq t1 = (Tq) a;
		Tq t2 = (Tq) b;

		int c1 = Integer.compare(t1.getYear(), t2.getYear());

		if (c1 == 0) {
			int c2 = Integer.compare(t1.getMonth(), t2.getMonth());

			return c2;
		}

		return c1;
	}

}
