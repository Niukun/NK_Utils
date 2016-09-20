package com.niukun.list;

import java.util.Scanner;
/**
 * 
 * @author Niukun
 *
 */
public class securityCode {
	public static void main(String[] args) {
		//save security code
		char[][] secret = new char[3][3];
		String sec;
		Scanner scan;
		//Input the 9 chars
		System.out.println("请输入三行密码：");
		for (int i = 0; i < 3; i++) {
			scan = new Scanner(System.in);
			sec = scan.nextLine();
			for (int j = 0; j < 3; j++) {
				secret[i][j] = sec.charAt(j);
			}
		}
		System.out.println(isCenter(secret));
	}

	/**
	 * Determine whether the symmetry
	 * @param secret
	 * @return
	 */
	private static String isCenter(char[][] secret) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if("x".equalsIgnoreCase(String.valueOf(secret[i][j]))){
					if("x".equalsIgnoreCase(String.valueOf(secret[2-i][2-j]))){
						continue;
					}else{
						return "NO";
					}
				}
			}
		}
		return "YES";
	}
}
