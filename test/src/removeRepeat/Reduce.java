package removeRepeat;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text, Text, Text,Text>{
	
	@Override
	protected void reduce(Text text, Iterable<Text> iterable,Context context) throws IOException,
			InterruptedException {
		
		context.write(text, new Text(""));
	}

}
