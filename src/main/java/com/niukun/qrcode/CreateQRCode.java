package com.niukun.qrcode;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 教学网址：http://www.imooc.com/video/10316/0
 * 
 * @author Niukun
 *
 */

public class CreateQRCode {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// 定义二维码参数
		/*int width = 300;
		int height = 300;
		String format = "jpg";
		String content = "https://www.baidu.com";
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);

		// 生成二维码
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			Path file = new File("files/123.jpg").toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Finished......");*/
	}

}
