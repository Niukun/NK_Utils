package com.niukun.img;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Niukun
 *
 */
public class Img {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//得到图片缓冲区
		BufferedImage bi = new BufferedImage(150,70,BufferedImage.TYPE_INT_RGB);
		
		//得到它的绘制环境（这张图片的笔）
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		//设置颜色
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, 150, 70);//填充整张图片(其实就是设置背景色)
		
		g2.setColor(Color.RED);
		g2.drawRect(0, 0, 150-1, 70-1);
		
		g2.setFont(new Font("宋体",Font.BOLD,14));//设置字体
		g2.setColor(Color.BLACK);//设置颜色
		g2.drawString("Hello world", 10, 40);
		
		ImageIO.write(bi, "JPEG", new FileOutputStream("C:/a.jpg"));
		
		
		
		
		
		
	}

}
