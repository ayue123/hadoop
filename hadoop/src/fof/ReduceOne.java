package fof;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReduceOne extends Reducer<Text, IntWritable, Text, NullWritable>{
	
	@Override
	protected void reduce(Text text, Iterable<IntWritable> interable,Context context)
			throws IOException, InterruptedException {
		
		//Ç×ÃÜ¶ÈµÄÖµ
		int sum = 0;
		boolean flag = true;
		for (IntWritable i : interable) {
			if(i.get() == 0){
				flag = false;
				break;
			}
			sum+=i.get();
		}
		
		if(flag){
			String msg = text.toString() + "-" + sum;
			context.write(new Text(msg), NullWritable.get());
		}
		
	}
	

}
