package cn.bfd.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Created by yu.fu on 2015/10/15.
 */
public class HFILEMapper extends Mapper<LongWritable, Text, Text, Text> {
   
    
    @Override
    protected void map(LongWritable key, Text val, Mapper<LongWritable, Text, Text, Text>.Context context)
    		throws IOException, InterruptedException {

    	if (val != null && val.toString().length() > 0) {
			context.write(new Text(val), new Text("1"));
    		
		}
    
    }
    
   
}
