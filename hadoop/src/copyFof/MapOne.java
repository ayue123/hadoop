package copyFof;
/*1.将原数据切分；
 * 2.获取真正的二度关系，去除好友关系；
**/
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;
public class MapOne extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		
		Fof fof = new Fof();
		String[] s = StringUtils.split(value.toString(), ' ');
		for (int i = 0; i < s.length; i++) {
			
			String s1 = fof.Format(s[0], s[i]);
			context.write(new Text(s1), new IntWritable(0));
			for (int j = i+1; j < s.length; j++) {
				String s2 = fof.Format(s[i], s[j]);
				context.write(new Text(s2), new IntWritable(1));
			}
		}
		
	}

}
