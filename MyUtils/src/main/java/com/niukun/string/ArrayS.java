package com.niukun.string;
public class ArrayS {

	public static void main(String[] args) {
		String[][] strs = new  String[][] {
            {"长宁区延安西路889号太平洋中心23层","长宁"} ,
            {"静安区威海路755号","静安"} ,
            {"唐山路1424号", "杨浦"},
            {"上海市梅陇路130号","徐汇"},
            {"新城路13号","金山"},
            {"梅陇路100号","徐汇"},
            {"兆丰世贸大厦","长宁"}
        };
        for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i][1]);
		}
	}

}
