package stubs;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Example input line:
 * 96.7.4.14 - - [24/Apr/2011:04:20:11 -0400] "GET /cat.jpg HTTP/1.1" 200 12433
 *
 */
public class LogFileMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

	  
	  
	  //trim string and place in
	  // string array index 0 should be ip address
	  String line = value.toString();
      String[] data = line.trim().split("- -");
      
      
      // make sure ip address is not
      // empty before mapping
      if (data.length > 1) 
      {
          String ipAddress = data[0];
          context.write(new Text(ipAddress), new IntWritable(1));
      }
	 
  }
}