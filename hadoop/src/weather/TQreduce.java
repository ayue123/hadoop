package weather;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TQreduce extends Reducer<Tq, IntWritable, Text, NullWritable> {

	@Override
	protected void reduce(Tq tq, Iterable<IntWritable> iterable, Context context)
			throws IOException, InterruptedException {

		int flag = 0;
		for (IntWritable i : iterable) {
			flag++;
			if (flag > 2) {
				break;
			}

			String msg = tq.getYear() + "-" + tq.getMonth() + "-" + tq.getDay()
					+ "-" + i.get();

			context.write(new Text(msg), NullWritable.get());
		}

	}

}
