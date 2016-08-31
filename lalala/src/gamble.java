import java.util.Scanner;
import java.util.Random;
public class gamble {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println("请出拳（1剪刀 2石头 3布）！");
		int player = in.nextInt();
		Random xx = new Random();
		int computer = xx.nextInt(3);
		switch(player){
		case 1:System.out.println("剪刀");
		break;
		case 2:System.out.println("石头");
		break;
		case 3:System.out.println("布");
		break;
		//default break;
		}
		if(computer==0){
			System.out.println("剪刀");
			if(player==2){
				System.out.println("YOU WONㄟ(≧◇≦)ㄏ！");
			}
			if(player==1){
				System.out.println("DRAW( ^_^ )");
			}
			if(player==3){
				System.out.println("YOU LOSE(＞﹏＜)");
			}
		}
		if(computer==1){
			System.out.println("石头");
			if(player==2){
				System.out.println("DRAW( ^_^ )");
			}
			if(player==1){
				System.out.println("YOU LOSE(＞﹏＜)");
			}
			if(player==3){
				System.out.println("YOU WONㄟ(≧◇≦)ㄏ！");
			}
		}
		if(computer==2){
			System.out.println("布");
			if(player==2){
				System.out.println("YOU LOSE(＞﹏＜)");
			}
			if(player==1){
				System.out.println("YOU WONㄟ(≧◇≦)ㄏ！");
			}
			if(player==3){
				System.out.println("DRAW( ^_^ )");
			}
		}
		}
}
