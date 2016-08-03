package business.com.fzhong.service.kg.map;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * 调用高德和百度接口，返回区名；以百度地图为首选
 * 
 * @author DingFengwu
 * 
 */
public class MapApiTools {

	/**
	 * 返回区名
	 * 
	 * @param address
	 * @return
	 */
	public String getCounty(String address) {
		String county = "";
		if (address.length() < 10 && address.length() > 2) {
			try {
				county = BaiduMapDealing.baiduMapCountyName(address);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Pattern pattern = Pattern.compile("(.*[区县])(.*)");
			Matcher matcher = pattern.matcher(county);
			Pattern pattern1 = Pattern.compile("(.*[市])(.*[区县])(.*)");
			Matcher matcher1 = pattern1.matcher(county);
			if (matcher1.find()) {
				county = matcher1.group(2);
			} else if (matcher.find()) {
				county = matcher.group(1);
			} else {
				try {
					county = GaodeMapDealing.gaodeMapCountyName(address);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (matcher1.find()) {
					county = matcher1.group(2);
				} else if (matcher.find()) {
					county = matcher.group(1);
				}
			}
		}
		return county;
	}

	/**
	 * 返回经纬度
	 * @param address
	 * @return
	 * @throws Exception
	 */
	public static List<BigDecimal> getLatAndLng(String address)
			throws Exception {
		String latAndLng = "";
		List<BigDecimal> list = new ArrayList<BigDecimal>();
		try {
			latAndLng = BaiduMapDealing.baiduMapLatAndLng(address);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (latAndLng == "" || latAndLng == null) {
			try {
				latAndLng = GaodeMapDealing.gaodeMapLatAndLng(address);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Pattern pattern = Pattern.compile("(.*)[,](.*)");
		Matcher matcher = pattern.matcher(latAndLng);
		if (matcher.find()) {
			list.add(new BigDecimal(matcher.group(2)));
			list.add(new BigDecimal(matcher.group(1)));
		}
		return list;
	}

	/**
	 * 返回地图地址信息
	 * @param address
	 * @return
	 * @throws Exception
	 */
	public String getMapAddress(String address) throws Exception {
		String mapAddress = "";
		try {
			mapAddress = BaiduMapDealing.baiduMapAddress(address);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (mapAddress == null || mapAddress == "") {
			try {
				mapAddress = GaodeMapDealing.gaodeMapAddress(address);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return mapAddress;
	}
}
