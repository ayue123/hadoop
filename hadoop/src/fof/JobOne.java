package fof;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class JobOne {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance();
		
		job.setJarByClass(JobOne.class);
		job.setMapperClass(MapOne.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setReducerClass(ReduceOne.class);
		
		FileInputFormat.addInputPath(job, new Path("/input/fof"));
		Path path = new Path("/outputt");
		FileSystem fs = FileSystem.get(conf);
		if(fs.exists(path)){
			fs.delete(path);
		}
		
		FileOutputFormat.setOutputPath(job, path);
		if(job.waitForCompletion(true)){
			Configuration conf1 = new Configuration();
			Job job1 = Job.getInstance();
			
			job1.setJarByClass(JobOne.class);
			job1.setMapperClass(MapTwo.class);
			job1.setMapOutputKeyClass(Friend.class);
			job1.setMapOutputValueClass(IntWritable.class);
			job1.setReducerClass(ReduceTwo.class);
			
			//job1.setSortComparatorClass(Sort.class);
			//job1.setGroupingComparatorClass(Group.class);
			FileInputFormat.addInputPath(job1, new Path("/outputt/part-r-00000"));
			FileSystem fs1 =FileSystem.get(conf1);
			Path path1 = new Path("/outfof");
			if(fs1.exists(path1)){
				fs1.delete(path1);
			}
			
			FileOutputFormat.setOutputPath(job1, path1);
			
			job1.waitForCompletion(true);
		}
	}

}
