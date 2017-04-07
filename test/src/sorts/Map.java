package sorts;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;

public class Map extends Mapper<LongWritable, Text, IntWritable, IntWritable>{
	
	@Override
	protected void map(LongWritable key,Text value,Context context)
			throws IOException, InterruptedException {
		
		String[] s = StringUtils.split(value.toString(), ' ');
		for (int i = 0; i < s.length; i++) {
			IntWritable l = new IntWritable();
			l.set(Integer.parseInt(s[i]));
			context.write(l, new IntWritable(1));
			
		}
	}

}
