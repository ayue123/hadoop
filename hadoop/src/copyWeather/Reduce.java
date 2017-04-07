package copyWeather;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Weather, IntWritable, Text, NullWritable>{
	
	@Override
	protected void reduce(Weather weather, Iterable<IntWritable> iterable,Context context)
			throws IOException, InterruptedException {
		
		int f = 0;
		for (IntWritable i : iterable) {
			f++;
			if(f>2){
				break;
			}
			
			String ss = weather.getYear()+"-" +weather.getMonth() + "-" +weather.getDay() +"--"+i.get();
			context.write(new Text(ss), NullWritable.get());
		}
		
	}

}
