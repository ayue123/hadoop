package fof;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReduceTwo extends Reducer<Friend, IntWritable, Text, NullWritable>{

	@Override
	protected void reduce(Friend friend, Iterable<IntWritable> interable,Context context)
			throws IOException, InterruptedException {
		
		for (IntWritable i : interable) {
			String s = friend.getFriend1() + "-" +friend.getFriend2() + "-" +i.get();
			context.write(new Text(s), NullWritable.get());
		}
	}
	
}
