package com.niukun.labmda;

/**
 * ***********Lambda表达式代替了实现类***************
 * 
 * java中使用Lambda表达式的前提是：必须有函数式接口
 * 
 * 概念：有且仅有一个         抽象方法       的接口，叫做函数式接口。
 * 
 * 可以使用@FunctionalInterface检测当前接口是不是函数式接口
 * 
 * Lambda的格式就是为了将抽象方法翻译成以下三点：
 *  1.一些参数（方法参数） 
 *  2.一个箭头 
 *  3.一些代码（方法体）
 */
public class CalcTest {
	public static void main(String[] args) {
		/**
		 * 调用方法的时候，参数类型是函数式接口，所以Lambda可以推断出是哪个接口
		 * 标准写法
		 */
		method1((int a, int b) -> { return a + b; });
		
		//也可以根据赋值语句左侧的类型来进行Lambda上下文推断
		Calc calc = (int a, int b) -> { return a + b; };
		method1(calc);
		
		/**
		 * 1.Lambda表达式参数类型可以省略
		 * 2.如果参数有且只有一个，那么小括号可以不写
		 * 3.如果语句只有一个，那么{}和return也可以省略
		 * 简略式
		 */
		method1((a, b) -> a + b);
		
		
		method2((a)->{return ++a;});
		method2(a->{return ++a;});
		method2(a->++a);
	}

	private static void method2(SinglePlus singlePlus) {
		int result = singlePlus.single(10);
		System.out.println(result);
	}

	/**
	 * Lambda表达式的好处就是不用去实现Calc接口。
	 * 
	 * @param calc
	 */
	private static void method1(Calc calc) {
		int result = calc.sum(1, 2);
		System.out.println(result);
	}
}
