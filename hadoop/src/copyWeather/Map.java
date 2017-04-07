package copyWeather;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;

public class Map extends Mapper<LongWritable, Text, Weather, IntWritable>{
	
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		
		String str = value.toString();
		String[] strs = StringUtils.split(str, '	');
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		
		try {
			cal.setTime(sdf.parse(strs[0].toString()));
			
			Weather w = new Weather();
			w.setYear(cal.get(Calendar.YEAR));
			w.setMonth(cal.get(Calendar.MONTH));
			w.setDay(cal.get(Calendar.DAY_OF_MONTH));
			
			w.setTem(Integer.parseInt(strs[1].toString()));
			
			context.write(w, new IntWritable(w.getTem()));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
