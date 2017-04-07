package weather;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class Tq implements WritableComparable<Tq> {

	private int year;
	private int month;
	private int day;
	private int tem;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getTem() {
		return tem;
	}

	public void setTem(int tem) {
		this.tem = tem;
	}

	// 序列化和反序列化。
	public void readFields(DataInput in) throws IOException {
		this.year = in.readInt();
		this.month = in.readInt();
		this.day = in.readInt();
		this.tem = in.readInt();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(year);
		out.writeInt(month);
		out.writeInt(day);
		out.writeInt(tem);
	}

	@Override
	public int compareTo(Tq t) {
		int c1 = Integer.compare(this.year, t.getYear());
		if (c1 == 0) {
			int c2 = Integer.compare(this.month, t.getMonth());
			if (c2 == 0) {
				return Integer.compare(this.tem, t.getTem());
			}
			return c2;
		}
		return c1;
	}

}
