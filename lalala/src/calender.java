import java.util.Scanner;
/*******************
 * ��ʾ1900��1��1�յ�2016��6��20�յ��������ٸ�������������ؼ��㣬�õ��ܼ�����Ϣ�����жϵ��µ����������ɱ��
 * @author FGHsg_
 *
 */
public class calender {
	public static void main(String args[]){
		int sum=0;
		int day=0;
		Scanner xx=new Scanner(System.in);
		System.out.println("��������ݣ�\n");
		int year1=xx.nextInt();
		System.out.println("�������·ݣ�\n");
		int month1=xx.nextInt();
		for(int year=1900;year<year1;year++){
			if(year%4==0&&year%100!=0||year%400==0){
				sum+=366;
			}
			else{
				sum+=365;
			}
		}
		for(int month=1;month<month1;month++){
			if(month==2){
				if(year1%4==0&&year1%100!=0||year1%400==0){
					sum+=29;
				}
				else{
					sum+=28;
				}
			}			
			if(month!=2&&month!=4&&month!=6&&month!=9&&month!=11){
				sum+=31;
			}
			else if(month!=2){
				sum+=30;
			}
		}
		sum+=1;
		int wekday = sum%7;
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		
		for(int i=1;i<=wekday;i++){
			System.out.print("\t");
		}
		
		if(month1==2){
			if(year1%4==0&&year1%100!=0||year1%400==0){
				day=29;
			}
			else{
				day=28;
			}
		}			
		if(month1!=2&&month1!=4&&month1!=6&&month1!=9&&month1!=11){
			day=31;
		}
		else if(month1!=2){
			day=30;
		}
		
		for(int i=1;i<=day;i++){
			if(sum%7==6){
				System.out.print(i +"\n");
			}
			else{
				System.out.print(i+"\t" );
			}
			sum++;
		}
				
		System.out.println("\n\n�Ƿ���Ҫ�������룡�ǣ�yes ��no" );
		String user = xx.next();
		if(user=="yes"){
			return;
		}
	}
}
