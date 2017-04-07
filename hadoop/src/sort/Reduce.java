package sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Word, IntWritable, Text, NullWritable>{
	
	@Override
	protected void reduce(Word word, Iterable<IntWritable> iterable,Context context)
			throws IOException, InterruptedException {
		
		for (IntWritable i : iterable) {
			if(i.get()<0){
				break;
			}
			context.write(new Text(word.getWord()), NullWritable.get());
		}
		
	}

}
