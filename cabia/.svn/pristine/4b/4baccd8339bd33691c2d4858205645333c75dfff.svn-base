package business.com.fzhong.service.kg.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import business.com.fzhong.service.kg.utils.FZhongConsts;

/***
 * 调用高德地图api接口，返回所需数据
 * 
 * @author DingFengwu
 * 
 */
public class GaodeMapDealing {

	/**
	 * 返回区名
	 * 
	 * @param address
	 * @return
	 * @throws IOException
	 */
	public static String gaodeMapCountyName(String address) throws IOException {
		return getCountyName(mapDealingByGAODE(address));
	}

	/**
	 * 返回高德地址
	 * 
	 * @param address
	 * @return
	 * @throws IOException
	 */
	public static String gaodeMapAddress(String address) throws IOException {
		return getMapAddress(mapDealingByGAODE(address));
	}

	/**
	 * 返回高德经纬度
	 * 
	 * @param address
	 * @return
	 * @throws IOException
	 */
	public static String gaodeMapLatAndLng(String address) throws IOException {
		return getLatAndLng(mapDealingByGAODE(address));
	}

	/**
	 * 连接高德地图，返回json数据
	 * 
	 * @param address
	 * @return
	 * @throws IOException
	 */
	static String mapDealingByGAODE(String address) throws IOException {
		String json = "";
		try {
			URL url = new URL(
					"http://restapi.amap.com/v3/place/text?extensions=all&keywords="
							+ address + "&city=shanghai&output=json&key="
							+ FZhongConsts.GAODEAK_MAP_PARAM);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream()));
			String line;
			while ((line = in.readLine()) != null) {
				json += line;
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 高德返回区名
	 * 
	 * @param json
	 * @return
	 * @throws IOException
	 */
	static String getCountyName(String json) throws IOException {
		String adname = "";
		try {
			JSONObject jsonObject = new JSONObject(json);
			JSONArray jsonArray = jsonObject
					.getJSONArray(FZhongConsts.POIS_MAP_PARAM);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject1 = jsonArray.getJSONObject(i);
				if (jsonObject1.has(FZhongConsts.ADNAME_MAP_PARAM)) {
					adname = jsonObject1
							.getString(FZhongConsts.ADNAME_MAP_PARAM);
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adname;
	}

	/**
	 * 高德返回map地址
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
					.getJSONArray(FZhongConsts.POIS_MAP_PARAM);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject2 = jsonArray.getJSONObject(i);
				if (jsonObject2.has(FZhongConsts.ADNAME_MAP_PARAM)
						&& jsonObject2.has(FZhongConsts.CITYNAME_MAP_PARAM)) {
					String str = jsonObject2
							.getString(FZhongConsts.CITYNAME_MAP_PARAM)
							+ jsonObject2
									.getString(FZhongConsts.ADNAME_MAP_PARAM)
							+ jsonObject2
									.getString(FZhongConsts.ADDRESS_MAP_PARAM);
					Matcher matcher = pattern.matcher(str);
					if (matcher.find()) {
						newAddress = str;
					}
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newAddress;
	}

	/**
	 * 高德返回经纬度
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
					.getJSONArray(FZhongConsts.POIS_MAP_PARAM);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject2 = jsonArray.getJSONObject(i);
				if (jsonObject2.has(FZhongConsts.LOCATION_MAP_PARAM)) {
					latAndLng = jsonObject2
							.getString(FZhongConsts.LOCATION_MAP_PARAM);
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return latAndLng;
	}
}
