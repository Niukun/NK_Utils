package org.acc.word2vec.util;

import java.math.BigDecimal;

public class test {

	public static void main(String[] args) {
		test2();
	}

	private static void test2() {
		BigDecimal b1 = new BigDecimal(0.00000000000000232323);
		BigDecimal b2 = new BigDecimal(0.000000000000232423);
		BigDecimal b0 = new BigDecimal(0.0);
		if(b1.subtract(b2).compareTo(b0)>=0){
			System.out.println("b1:" + b1);
		}else{
			System.out.println("b2:" + b2);
		}
		
	}

}
