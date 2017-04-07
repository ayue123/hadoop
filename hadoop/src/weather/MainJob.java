package weather;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MainJob {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(MainJob.class);
		job.setMapperClass(TQmap.class);
		job.setMapOutputKeyClass(Tq.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setReducerClass(TQreduce.class);

		job.setPartitionerClass(TQpartition.class);
		job.setSortComparatorClass(Sort.class);
		job.setGroupingComparatorClass(Group.class);

		job.setNumReduceTasks(3);

		FileInputFormat.addInputPath(job, new Path("/input/weather"));
		FileSystem fs = FileSystem.get(conf);

		Path path = new Path("/iiii");
		if (fs.exists(path)) {
			fs.delete(path, true);
		}

		FileOutputFormat.setOutputPath(job, path);
		try {
			job.waitForCompletion(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
