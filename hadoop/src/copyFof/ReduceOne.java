package copyFof;
//»ñÈ¡Ç×ÃÜ¶È£¬
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReduceOne extends Reducer<Text, IntWritable, Text, IntWritable>{

	@Override
	protected void reduce(Text text, Iterable<IntWritable> iterable,Context context)
			throws IOException, InterruptedException {
		
		int sum = 0;
		boolean flag  = true;
		for (IntWritable i : iterable) {
			if(i.get() ==0){
				flag = false;
				break;
			}
			sum +=i.get();
		}
		if(flag){
			String str = text.toString() +"-"+sum;
			context.write(new Text(str), new IntWritable(sum));
		}
		
	}
	
}
