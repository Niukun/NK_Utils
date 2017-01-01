package nlpir;

import java.math.BigDecimal;

public class test1 {
	public static void main(String[] args) {
		BigDecimal[] bs = {new BigDecimal(21),new BigDecimal(4.1)};
		BigDecimal b = bs[1].add(bs[0]);
		System.out.println(b);
	}
}
