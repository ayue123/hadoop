package fof;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class JobTwo {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		 
		Configuration conf = new Configuration();
		Job job = Job.getInstance();
		
		job.setJarByClass(JobTwo.class);
		job.setMapperClass(MapTwo.class);
		job.setMapOutputKeyClass(Friend.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setReducerClass(ReduceTwo.class);
		
		job.setSortComparatorClass(Sort.class);
		job.setGroupingComparatorClass(Group.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileSystem fs =FileSystem.get(conf);
		Path path = new Path(args[1]);
		if(fs.exists(path)){
			fs.delete(path);
		}
		
		FileOutputFormat.setOutputPath(job, path);
		
		job.waitForCompletion(true);
		
	}
}
