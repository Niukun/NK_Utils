package business.com.fzhong.service.kg.map;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import business.com.fzhong.service.kg.utils.FZhongConsts;

/***
 * 使用百度地图api接口，需借助baiduak，现使用sn校验方式，需对其进行MD5解密；
 * 
 * @author DingFengwu
 * 
 */
public class SnMD5 {

	/**
	 * 调用接口返回的json格式数据
	 * 
	 * @param address
	 * @return
	 * @throws Exception
	 */
	public String getResults(String address) throws Exception {
		/**
		 * 以http://api.map.baidu.com/geocoder/v2/?address=百度大厦&output=json&ak=
		 * yourak为例
		 * ak设置了sn校验不能直接使用必须在url最后附上sn值，get请求计算sn跟url中参数对出现顺序有关，需按序填充paramsMap，
		 * post请求是按字母序填充，具体参照testPost()
		 */
		Map<String, String> paramsMap = new LinkedHashMap<String, String>();
		paramsMap.put("q", address);
		paramsMap.put("region", "上海");
		paramsMap.put("page_size", "1");
		paramsMap.put("output", "json");
		paramsMap.put("ak", FZhongConsts.BAIDUSN_MAP_PARAM);

		// 调用下面的toQueryString方法，对paramsMap内所有value作utf8编码
		String paramsStr = toQueryString(paramsMap);

		// 对paramsStr前面拼接上/geocoder/v2/?，后面直接拼接yoursk
		String wholeStr = new String("/place/v2/search?" + paramsStr
				+ FZhongConsts.BAIDUSK_MAP_PARAM);

		// 对上面wholeStr再作utf8编码
		String tempStr = URLEncoder.encode(wholeStr, "UTF-8");

		// 调用下面的MD5方法得到sn签名值
		String sn = MD5(tempStr);

		// 算得sn后发送get请求
		String result = "";
		// 打印响应内容
		
		CloseableHttpClient client = null;
		HttpGet httpget = new HttpGet(
				"http://api.map.baidu.com//place/v2/search?q=" + address
						+ "&region=上海&page_size=1&output=json&ak="
						+ FZhongConsts.BAIDUSN_MAP_PARAM + "&sn=" + sn);
		CloseableHttpResponse response = null;
		InputStream is = null;
		try {
			client = HttpClientBuilder.create().build();
			response = client.execute(httpget);
			is = response.getEntity().getContent();
			result = inStream2String(is);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				is.close();
				response.close();
				client.close();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 对Map内所有value作utf8编码，拼接返回结果
	 * 
	 * @param data
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws URIException
	 */
	public String toQueryString(Map<?, ?> data)
			throws UnsupportedEncodingException, URIException {
		StringBuffer queryString = new StringBuffer();
		for (Entry<?, ?> pair : data.entrySet()) {
			queryString.append(pair.getKey() + "=");
			// queryString.append(URLEncoder.encode((String) pair.getValue(),
			// "UTF-8") + "&");
			queryString.append(URIUtil.encodeQuery((String) pair.getValue(),
					"UTF-8") + "&");
		}
		if (queryString.length() > 0) {
			queryString.deleteCharAt(queryString.length() - 1);
		}
		return queryString.toString();
	}

	/**
	 * MD5计算方法，调用了MessageDigest库函数，并把byte数组结果转换成16进制
	 * 
	 * @param md5
	 * @return
	 */
	public String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
						.substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}

	/**
	 * 将输入流转换成字符串
	 * 
	 * @param is
	 * @return
	 * @throws Exception
	 */
	private static String inStream2String(InputStream is) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int len = -1;
		while ((len = is.read(buf)) != -1) {
			baos.write(buf, 0, len);
		}
		return new String(baos.toByteArray(), "UTF-8");
	}
}