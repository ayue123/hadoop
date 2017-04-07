package copyWordCount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;

public class WcMap extends Mapper<LongWritable,Text, Text, IntWritable>{
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		String str = value.toString();
		String[] strs = StringUtils.split(str, ' ');
		for (String s : strs) {
			context.write(new Text(s),new IntWritable(1));
		}
	}
}
