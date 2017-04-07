package wordCount;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
public class Wc {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		Configuration conf  = new Configuration();
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(Wc.class);
		job.setMapperClass(WcMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setReducerClass(WcReduce.class);
		                                                                                                                                                                                                                                                                                                                                                                                                      
		FileInputFormat.addInputPath(job, new Path(args[0]));
		
		Path outpath = new Path(args[1]);
		FileSystem fs = FileSystem.get(conf);
		if(fs.exists(outpath)){
			fs.delete(outpath,true);
		}
		
		org.apache.hadoop.mapreduce.lib.output.FileOutputFormat.setOutputPath(job, outpath);
		boolean flag=job.waitForCompletion(true);
		if(flag){
			System.out.println("job success");
		}
		
	}

}
