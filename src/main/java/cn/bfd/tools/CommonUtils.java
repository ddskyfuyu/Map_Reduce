package cn.bfd.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class CommonUtils {
	
	private static Logger LOG = Logger.getLogger(CommonUtils.class);
	
	public static final String reverseString(String str) {
		char c[] = str.toCharArray();
		char t;
		for (int i = 0; i < (str.length() + 1) / 2; i++) {
			t = c[i];
			c[i] = c[c.length - i - 1];
			c[c.length - i - 1] = t;
		}
		String str2 = new String(c);
		return str2;
	}

	public static final String getNowDate() {

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	public static final String getJsonString(String key, String value) {
		String jsonStr = "{\"" + key + "\": " + value + "}";
		return jsonStr;
	}

	/**
	 * 时间unix转换
	 * 
	 * @param timestampString
	 * @return
	 */
	public static String TimeStampDate(String timestampString, String format) {

		Long timestamp = Long.parseLong(timestampString) * 1000;
		String date = new java.text.SimpleDateFormat(format).format(new java.util.Date(timestamp));
		return date;
	}

	/**
	 * 将时间unix转换为int类型
	 * 
	 * @param timeString
	 * @param format
	 * @return
	 * @throws ParseException 
	 */
	public static int DateToInt(String timeString, String format)  {

		int time = 0;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date;
		if (timeString == null || timeString.trim().length() == 0) {
			return -1;
		}
		try {
			date = sdf.parse(timeString);
			String strTime = date.getTime() + "";
			strTime = strTime.substring(0, 10);
			time = Integer.parseInt(strTime);
			
		} catch (ParseException e) {
			LOG.error("format date to int error:"+e.getMessage());
		}

		return time;
	}
	
	public static int DateToInt()  {

		int time = 0;
		Date date = new Date();
		String strTime = date.getTime() + "";
		strTime = strTime.substring(0, 10);
		time = Integer.valueOf(strTime);

		return time;
	}

	public static int DateToInt(String timeString)  {

		int time = 0;
		if (timeString == null || timeString.trim().length() == 0) {
			return -1;
		}
		try {
			time = Integer.valueOf(timeString);
		} catch (Exception e) {
			LOG.error("format third party date to int error:"+e.getMessage());
		}

		return time;
	}
	
	public static void main(String[] args) throws ParseException {
		String str = "2015-09-12 23:43:12";
		System.out.println(DateToInt(str, "yyyy-MM-dd HH:mm:ss"));
		
	}
}
