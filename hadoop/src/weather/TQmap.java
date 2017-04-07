package weather;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;

public class TQmap extends Mapper<LongWritable, Text, Tq, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		String[] strs = StringUtils.split(value.toString(), '	');

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(strs[0]));

			Tq t = new Tq();
			t.setYear(cal.get(Calendar.YEAR));
			t.setMonth(cal.get((Calendar.MONTH)+1));
			t.setDay(cal.get(Calendar.DAY_OF_MONTH));

			int tem = Integer.parseInt(strs[1].substring(0, strs[1].lastIndexOf("c")));

			t.setTem(tem);

			context.write(t, new IntWritable(tem));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
