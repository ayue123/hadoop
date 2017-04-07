package copyFof;
//Êä³öºÃÓÑÍÆ¼ö¡£
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class ReduceTwo extends Reducer<Friend, IntWritable, Text, NullWritable>{

	@Override
	protected void reduce(Friend friend, Iterable<IntWritable> iterable,Context context)
			throws IOException, InterruptedException {
		
		for (IntWritable i : iterable) {
			String s = friend.getFriend1()+"-" + friend.getFriend2() +"-"+i.get();
			context.write(new Text(s), NullWritable.get());
		}
		
	}
	
}
