package average;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text, Text, Text, IntWritable>{
	
	@Override
	protected void reduce(Text text, Iterable<Text> iterable,Context context) 
			throws IOException,InterruptedException {
		
		int i = 0;
		int average = 0;
		int sum = 0;
		for (Text text2 : iterable) {
			
			sum = sum + Integer.valueOf(text2.toString());
			i++;
			
		}
		average = sum / i;
		context.write(text, new IntWritable(average));
		
	}

}
