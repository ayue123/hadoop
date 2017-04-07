package findFriend;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class Friend implements WritableComparable<Friend> {

	private String friend1;
	private String friend2;

	public String getFriend1() {
		return friend1;
	}

	public void setFriend1(String friend1) {
		this.friend1 = friend1;
	}

	public String getFriend2() {
		return friend2;
	}

	public void setFriend2(String friend2) {
		this.friend2 = friend2;
	}

	@Override
	public void write(DataOutput out) throws IOException {

		out.writeUTF(friend1);
		out.writeUTF(friend2);

	}

	@Override
	public void readFields(DataInput in) throws IOException {

		this.friend1 = in.readUTF();
		this.friend2 = in.readUTF();

	}

	@Override
	public int compareTo(Friend f) {

		return this.friend1.compareTo(f.getFriend1());
	}

}
