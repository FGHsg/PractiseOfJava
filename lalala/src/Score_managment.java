import java.util.Scanner;
public class Score_managment {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("卓秋雨是傻逼！！！！！");
		//System.out.println("请输入学生人数： ");
		int Stu_num = in.nextInt();
		System.out.println("请输入课程数目： ");
		int Course_num = in.nextInt();
		String[] Course_name = new String[Course_num];
		String[] Stu_name = new String[Stu_num];
		int[][] Stu_score = new int[Stu_num][Course_num];
		int[] sum = new int[Stu_num];
		int[] ave = new int[Stu_num];
		String[] str = new String[Stu_num];
		
		for(int i=0; i<Course_num; i++){
			System.out.println("请输入第"+(i+1)+"门课程的名称：");
			Course_name[i] = in.next();
		}
		
		for(int i=0;i<Stu_num;i++){
			System.out.println("请输入第"+(i+1)+"位学生的姓名：");
			Stu_name[i] = in.next();
		}
		
		for(int i=0;i<Stu_num;i++){
			String str1 = "";
			for(int j=0; j<Course_num;j++){
				System.out.println("请输入"+Stu_name[i]+"的"+Course_name[j]+"成绩");
				Stu_score[i][j] = in.nextInt();
				sum[i] += Stu_score[i][j];
				str1+=Stu_score[i][j]+"\t";
			}
			ave[i] = sum[i]/Course_num;
			str[i] = Stu_name[i]+"\t"+str1+sum[i]+"\t"+ave[i];
		}
		
		for(int i=0;i<Stu_num-1;i++){
			for(int j=0;j<Stu_num-1;j++){
				if(sum[j]<sum[j+1]){
					int a=sum[j];		String b=str[j];
					sum[j]=sum[j+1];	str[j]=str[j+1];
					sum[j+1] = a;		str[j+1]=b;
				}			
			}
		}
		
		System.out.print("姓名\t");
		for(int i=0;i<Stu_num;i++){
			System.out.print(Course_name[i]+"\t");
		}
		System.out.print("总分"+"\t"+"平均分"+"\t"+"排名");
		System.out.println();
		
		for(int i=0;i<Stu_num;i++){
			System.out.print(str[i]+"\t"+"第"+(i+1)+"名");
			System.out.println();
		}
	}
}
