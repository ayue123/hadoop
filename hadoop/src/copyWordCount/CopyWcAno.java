package copyWordCount;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.StringUtils;

public class CopyWcAno {
	public static class map extends Mapper<LongWritable, Text, Text, IntWritable>{
	
		public void map(LongWritable key, Text value,Context context)
				throws IOException, InterruptedException {
			String str = value.toString();
			String[] strs = StringUtils.split(str,' ');
			for (String string : strs) {
				context.write(new Text(string), new IntWritable(1));
			}
			
			
		}
	}
	
	public static class reduce extends Reducer<Text, IntWritable, Text, IntWritable>{
		
		public void reduce(Text text, Iterable<IntWritable> interable,Context context)
				throws IOException, InterruptedException {
			int sum = 0;
			for (IntWritable i : interable) {
				sum +=i.get();
			}
			context.write(text, new IntWritable(sum));
			
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf  = new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(CopyWcAno.class);
		job.setMapperClass(map.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setReducerClass(reduce.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileSystem fs = FileSystem.get(conf);
		Path path = new Path(args[1]);
		if(fs.exists(path)){
			fs.delete(path, true);
		}
		
		FileOutputFormat.setOutputPath(job, path);
		job.waitForCompletion(true);		
	}
}
