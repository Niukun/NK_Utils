package business.com.fzhong.service.kg.map;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import business.com.fzhong.service.kg.utils.FZhongConsts;

/**
 * 调用高德api接口，返回所需数据
 * 
 * @author DingFengwu
 * 
 */
public class BaiduMapDealing {

	public static SnMD5 sn = new SnMD5();

	/***
	 * 返回百度地址
	 * 
	 * @param address
	 * @return
	 * @throws Exception
	 */
	public static String baiduMapAddress(String address) throws Exception {
		return getMapAddress(sn.getResults(address));
	}

	/**
	 * 返回区名
	 * 
	 * @param address
	 * @return
	 * @throws Exception
	 */
	public static String baiduMapCountyName(String address) throws Exception {
		return getCountyName(sn.getResults(address));
	}

	/**
	 * 返回经纬度
	 * 
	 * @param address
	 * @return
	 * @throws Exception
	 */
	public static String baiduMapLatAndLng(String address) throws Exception {
		return getLatAndLng(sn.getResults(address));
	}

	/**
	 * 返回百度地图地址
	 * 
	 * @param json
	 * @return
	 * @throws IOException
	 */
	static String getMapAddress(String json) throws IOException {
		String newAddress = "";
		Pattern pattern = Pattern.compile(".+[路,街,道,村][\\d~]+[弄,号].*");
		try {
			JSONObject jsonObject = new JSONObject(json);
			JSONArray jsonArray = jsonObject
					.getJSONArray(FZhongConsts.RESULTS_MAP_PARAM);
			JSONObject jsonObject2 = jsonArray.getJSONObject(0);
			if (jsonObject2.has(FZhongConsts.ADDRESS_MAP_PARAM)
					&& jsonObject2.has(FZhongConsts.NAME_MAP_PARAM)) {
				String str = jsonObject2
						.getString(FZhongConsts.ADDRESS_MAP_PARAM)
						+ jsonObject2.getString(FZhongConsts.NAME_MAP_PARAM);
				Matcher matcher = pattern.matcher(str);
				if (matcher.find()) {
					newAddress = str;
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newAddress;
	}

	/**
	 * 返回区名
	 * 
	 * @param json
	 * @return
	 * @throws IOException
	 */
	static String getCountyName(String json) throws IOException {
		String countyName = "";
		try {
			// System.out.println("json:"+json);
			JSONObject jsonObject = new JSONObject(json);
			JSONArray jsonArray = jsonObject
					.getJSONArray(FZhongConsts.RESULTS_MAP_PARAM);
			System.out.println(jsonArray.toString());
			if (jsonArray.length() > 1) {
				JSONObject jsonObject2 = jsonArray.getJSONObject(0);
				if (jsonObject2.has(FZhongConsts.ADDRESS_MAP_PARAM))
					countyName = jsonObject2
							.getString(FZhongConsts.ADDRESS_MAP_PARAM);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countyName;
	}

	/**
	 * 返回经纬度
	 * 
	 * @param json
	 * @return
	 * @throws IOException
	 */
	static String getLatAndLng(String json) throws IOException {
		String latAndLng = "";
		try {
			JSONObject jsonObject = new JSONObject(json);
			JSONArray jsonArray = jsonObject
					.getJSONArray(FZhongConsts.RESULTS_MAP_PARAM);
			JSONObject jsonObject2 = jsonArray.getJSONObject(0);
			JSONObject jsonObject3 = jsonObject2
					.getJSONObject(FZhongConsts.LOCATION_MAP_PARAM);
			latAndLng = jsonObject3.getDouble(FZhongConsts.LNG_MAP_PARAM) + ","
					+ jsonObject3.getDouble(FZhongConsts.LAT_MAP_PARAM);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return latAndLng;
	}
}
