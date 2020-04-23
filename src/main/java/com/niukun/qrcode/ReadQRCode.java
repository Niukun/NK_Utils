package com.niukun.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;



/**
 * 教学网址：http://www.imooc.com/video/10316/0
 * 
 * @author Niukun
 *
 */
public class ReadQRCode {
	/*public static void main(String[] args) {
		try {
			MultiFormatReader formatReader = new MultiFormatReader();
			File file = new File("files/123.jpg");
			BufferedImage image;
			image = ImageIO.read(file);

			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			HashMap hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

			Result result = formatReader.decode(binaryBitmap, hints);
			System.out.println("解析结果:" + result.toString());
			System.out.println("二维码格式类型:" + result.getBarcodeFormat());
			System.out.println("二维码文本内容:" + result.getText());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}*/

}
