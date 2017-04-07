package sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;


public class Map extends Mapper<LongWritable, Text, Word, IntWritable>{
	
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		
		String[] s = StringUtils.split(value.toString(), ' ');
		Word w = new Word();
		for (String ss : s) {
			w.setWord(ss);
			context.write(w, new IntWritable(1));
		}
	}

}
