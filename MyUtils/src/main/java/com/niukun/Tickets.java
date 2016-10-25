package com.niukun;
class Ball{
	int red =0;
	int blue = 0;
	public void redPlus(){
		red++;
	}
	public void bluePlus(){
		blue++;
	}
}
public class Tickets {

	public static void main(String[] args) {
		int[][] results = {
				{9,15,21,24,27,32,10},
				{7,9,12,14,20,27,16},
				{15,22,23,24,28,29,8},
				{2,3,10,23,25,28,9},
				{2,5,6,21,25,28,9},
				{9,19,21,30,31,32,4},
				{9,14,22,23,31,33,14},
				{3,10,14,17,28,33,2},
				{7,18,20,23,27,31,13},
				{6,8,20,22,26,27,9},
				{5,16,20,22,27,29,9}
				};
		int[] myticket1 = {7,9,21,27,30,33,8};
		int[] myticket2 = {5,9,12,16,18,24,7};
		System.out.println("第一个球中奖结果：");
		PrintResult(results, myticket1);
		System.out.println("第二个球中奖结果：");
		PrintResult(results, myticket2);
	}

	private static void PrintResult(int[][] results, int[] myticket) {
		for (int i = 0; i < results.length; i++) {
			Ball ball = new Ball();
			for (int j = 0; j <results[0].length; j++) {
				for (int k = 0; k < myticket.length; k++) {
					if(myticket[k]==results[i][j]&&j<6&&k<6){
						ball.redPlus();
					}else if(myticket[k]==results[i][j]&&j==6&&k==6){
						ball.bluePlus();
					}
				}
			}
			System.out.print("红球中:"+ball.red+"个:蓝球中"+ball.blue+"个  ");
			getMoney(ball);
			System.out.println();
		}
	}
	private static void getMoney(Ball ball){
		switch(ball.red){
		case 0: if(ball.blue==1) System.out.print("奖金5元");break;
		case 1: if(ball.blue==1) System.out.print("奖金5元");break;
		case 2: if(ball.blue==1)System.out.print("奖金5元");break;
		case 3: if(ball.blue==1)System.out.print("奖金10元");break;
		case 4: if(ball.blue==1)System.out.print("奖金200元");else if(ball.blue==0) System.out.print("jaingjin10元");break;
		case 5: if(ball.blue==1)System.out.print("奖金3000元");else if(ball.blue==0) System.out.print("jaingjin200元");break;
		case 6: if(ball.blue==1)System.out.print("奖金5000000元");else if(ball.blue==0) System.out.print("jaingjin60000元");break;
		}
	}
}
