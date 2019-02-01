package stubs;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AverageReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {

  @Override
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {

	  Double wls = 0.0;
	  Double cnt = 0.0;
	  
	  // loop over and sum up words
	  for(IntWritable wl : values)
	  {
		  wls += wl.get();
		  cnt++;
	  }
	  //writes average with key
	  context.write(key,  new DoubleWritable(wls / cnt));
  }
}