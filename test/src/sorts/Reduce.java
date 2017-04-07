package sorts;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<IntWritable, IntWritable, IntWritable, NullWritable>{
	
	@Override
	protected void reduce(
			IntWritable i,
			Iterable<IntWritable> iterable,Context context)
			throws IOException, InterruptedException {
		
		context.write(i, NullWritable.get());
		
	}

}
