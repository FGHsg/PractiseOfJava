import java.util.Scanner;
import java.util.Random;
public class gamble {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println("���ȭ��1���� 2ʯͷ 3������");
		int player = in.nextInt();
		Random xx = new Random();
		int computer = xx.nextInt(3);
		switch(player){
		case 1:System.out.println("����");
		break;
		case 2:System.out.println("ʯͷ");
		break;
		case 3:System.out.println("��");
		break;
		//default break;
		}
		if(computer==0){
			System.out.println("����");
			if(player==2){
				System.out.println("YOU WON��(�R��Q)�ϣ�");
			}
			if(player==1){
				System.out.println("DRAW( ^_^ )");
			}
			if(player==3){
				System.out.println("YOU LOSE(���n��)");
			}
		}
		if(computer==1){
			System.out.println("ʯͷ");
			if(player==2){
				System.out.println("DRAW( ^_^ )");
			}
			if(player==1){
				System.out.println("YOU LOSE(���n��)");
			}
			if(player==3){
				System.out.println("YOU WON��(�R��Q)�ϣ�");
			}
		}
		if(computer==2){
			System.out.println("��");
			if(player==2){
				System.out.println("YOU LOSE(���n��)");
			}
			if(player==1){
				System.out.println("YOU WON��(�R��Q)�ϣ�");
			}
			if(player==3){
				System.out.println("DRAW( ^_^ )");
			}
		}
		}
}
