package stubs;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



public class LetterMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	  
	//string delimiter to split strings on white space
	  for(String token:value.toString().split("\\W"))
	  {
		  if(token.length() > 0)
			  context.write(new Text(String.valueOf(token.charAt(0))), new IntWritable(token.length()));
	  }

  }
}
