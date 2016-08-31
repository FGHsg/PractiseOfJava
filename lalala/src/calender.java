import java.util.Scanner;
/*******************
 * 显示1900年1月1日到2016年6月20日的天数，再根据天数进行相关计算，得到周几的信息，再判断当月的天数，生成表格
 * @author FGHsg_
 *
 */
public class calender {
	public static void main(String args[]){
		int sum=0;
		int day=0;
		Scanner xx=new Scanner(System.in);
		System.out.println("请输入年份：\n");
		int year1=xx.nextInt();
		System.out.println("请输入月份：\n");
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
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		
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
				
		System.out.println("\n\n是否需要继续输入！是：yes 否：no" );
		String user = xx.next();
		if(user=="yes"){
			return;
		}
	}
}
