package cn.bfd.mr;

public class Hadoop2ProtoTest {


	
	public static void main(String[] args) throws  Exception {
//		Configuration conf = HBaseConfiguration.create();
//		// set parameters
//		String[] otherArgs = new GenericOptionsParser(conf, args)
//				.getRemainingArgs();
//		if (otherArgs.length < 4) {
//			System.out.println("The number of parameters is wrong.");
//			return;
//		}
//		conf.set("mapred.textoutputformat.separator", ",");
//
//		//conf.set("mapred.map.tasks", "10");
//		//conf.set("mapred.min.split.size", "50000");
//
//		conf.set("Table", otherArgs[0]);
//		conf.set("FAMILY", otherArgs[1]);
//		conf.set("COLUMN", otherArgs[2]);
//		// hbase configuration
//		conf.set("hbase.zookeeper.quorum", "192.168.50.11,192.168.50.12,192.168.50.13,192.168.50.14,192.168.50.15");
//		conf.set("zookeeper.znode.parent", "/bfdhbasehot");
//		conf.set("hbase.rootdir", "hdfs://bfdhadoop/hbase");
//
//		Job job = Job.getInstance(conf, "hadoop2prototest");
//		job.setJarByClass(Hadoop2ProtoTest.class);
//		//job.setJobName("getUpWithFilter");
//
//		// DEBUG_B
//		for (int i = 0; i < otherArgs.length; ++i) {
//			System.out.println("The " + i + " argments is " + otherArgs[i]);
//		}
//		job.addCacheFile(new URI(otherArgs[3]));
//
//		Scan scan = new Scan();
//		scan.addFamily(Bytes.toBytes(otherArgs[1]));
//		scan.setCaching(1000);
//		scan.setCacheBlocks(false);
//		TableMapReduceUtil.initTableMapperJob(Bytes.toBytes(otherArgs[0]),
//				scan, TestMapper.class, Text.class, Text.class, job);
//		job.setNumReduceTasks(0);
//
//		FileOutputFormat.setOutputPath(job, new Path(otherArgs[4]));
//		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
