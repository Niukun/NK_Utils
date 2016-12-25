package study;

import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

public class test {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
		int year = c.get(Calendar.YEAR); // 获取年
		int month = c.get(Calendar.MONTH) + 1; // 获取月份，0表示1月份
		int day = c.get(Calendar.DAY_OF_MONTH); // 获取当前天数
		int first = c.getActualMinimum(c.DAY_OF_MONTH); // 获取本月最小天数
		int last = c.getActualMaximum(c.DAY_OF_MONTH); // 获取本月最大天数
		int time = c.get(Calendar.HOUR_OF_DAY); // 获取当前小时
		int min = c.get(Calendar.MINUTE); // 获取当前分钟
		int xx = c.get(Calendar.SECOND); // 获取当前秒
		System.out.println(year+"/"+month+"/"+day+"/"+first+"/"+last+"/"+time+"/"+min+"/"+xx);
	}

	public static String toSemiangle(String src) {
		char[] c = src.toCharArray();
		for (int index = 0; index < c.length; index++) {
			if (c[index] == 12288) {// 全角空格
				c[index] = (char) 32;
			} else if (c[index] > 65280 && c[index] < 65375) {// 其他全角字符
				c[index] = (char) (c[index] - 65248);
			}
		}
		return String.valueOf(c);
	}
}
