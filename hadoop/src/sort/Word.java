package sort;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class Word implements WritableComparable<Word>{
	
	private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(word);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		this.word = in.readUTF();
	}

	@Override
	public int compareTo(Word w) {
		return this.word.compareTo(w.word);
	}

}
