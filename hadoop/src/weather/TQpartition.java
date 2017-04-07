package weather;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;

public class TQpartition extends HashPartitioner<Tq, IntWritable> {
	@Override
	public int getPartition(Tq key, IntWritable value, int numReduceTasks) {
		return (key.getYear() - 1949) % numReduceTasks;
		// return super.getPartition(key, value, numReduceTasks);
	}
}
