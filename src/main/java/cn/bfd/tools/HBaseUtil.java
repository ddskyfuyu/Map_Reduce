package cn.bfd.tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.log4j.Logger;



public class HBaseUtil {

	private static Logger LOG = Logger.getLogger(HBaseUtil.class);
	
	private static void test() throws MasterNotRunningException, ZooKeeperConnectionException, IOException{
		 Configuration conf = HBaseConfiguration.create();
		 Connection connection = ConnectionFactory.createConnection(conf);
		 Table table = connection.getTable(TableName.valueOf("table1"));
		 
		 
		 
		 
		 
	}
	
	/*
	public List<Get> getGets(List<String> gids){
		String gid = null;
		String rowkey = null;
		List<Get> gets = new ArrayList<Get>();
		for (int i = 0; i < gids.size(); ++i) {
		        gid = gids.get(i);
		        if (gid == null || gid.isEmpty()){
		        	continue;
		        }
		        Get g = new Get();
		        rowkey = UpUtils.reverseString(gid);
		        g.setRow(rowkey.getBytes());
		        TColumn t = new TColumn();
		        t.setFamily(family.getBytes());
		        
		        if (column != null && column.trim().length() > 0) {
		        	t.setQualifier(column.getBytes());
				}else{
					t.setQualifier(Bytes.toBytes(""));
				}
		        g.addToColumns(t);
		        gets.add(g);
		 }
		return gets;
	}
	
	*//**
	 * 
	 * 取得hbase表中column名称是空的记录
	 *//*
	public List<Get> getColumnIsEmptyGets(List<String> gids){
		String rowkey = null;
		String gid = null;
		List<Get> gets = new ArrayList<Get>();
		for (int i = 0; i < gids.size(); ++i) {
		        gid = gids.get(i);
		        if (gid == null || gid.isEmpty()){
		        	continue;
		        }
		        Get g = new Get();
		        rowkey = UpUtils.reverseString(gid);
		        g.setRow(rowkey.getBytes());
		        TColumn t = new TColumn();
		        t.setFamily(family.getBytes());
				t.setQualifier(Bytes.toBytes(""));
		        g.addToColumns(t);
		        gets.add(g);
		 }
		return gets;
	}
	*/
	
}
