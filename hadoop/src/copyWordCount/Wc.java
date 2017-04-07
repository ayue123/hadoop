package copyWordCount;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Wc {

	public static void main(String[] args) throws Exception {
		Configuration conf  = new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(Wc.class);
		job.setMapperClass(WcMap.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setReducerClass(WcReduce.class);
		
		FileInputFormat.addInputPath(job, new Path(""));
		Path path = new Path("");
		FileSystem fs = FileSystem.get(conf);
		if(fs.exists(path)){
			fs.delete(path, true);
		}
		
		FileOutputFormat.setOutputPath(job, path);
		boolean f = job.waitForCompletion(true);
		if(f){
			System.out.println("job is sucess!");
		}
	}

}
