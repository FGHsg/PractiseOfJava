import java.util.*;
public class Text {//主程序
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		//System.out.println("--请定义人数--");
		Student[] stuArr=new Student[4];
		Admin adminStu=new Admin();
		while(true){
			System.out.println("--你要执行的功能:--");
			System.out.println("10:添加一个学生");
			System.out.println("11:查找一个学生");
			System.out.println("12:根据编号更新学生的基本信息");
			System.out.println("13:根据编号删除学生--");
			System.out.println("14:根据编号输入学生的各门成绩");
			System.out.println("15:根据某门成绩进行排序");
			System.out.println("16:根据总分进行排序");
			System.out.println("99:退出系统");
			String number=in.next();
			if(number.equals("10")){
				System.out.println("请输入学生的姓名：");
				String name=in.next();
				System.out.println("请输入学生的年龄:");
				int age=in.nextInt();
				adminStu.create(name,age,stuArr);//添加学生
				
			}else if(number.equals("11")){
				System.out.println("执行查找学生的基本信息操作");
				System.out.println("请输入学生的编号进行查找:");
				int on=in.nextInt();
				adminStu.select(on,stuArr);
			}else if(number.equals("12")){
				System.out.println("执行更新学员的基本信息");
				System.out.println("请输入学生的编号：");
				int on=in.nextInt();
				System.out.println("请输入学生的姓名：");
				String name=in.next();
				System.out.println("请输入学生的年龄:");
				int age=in.nextInt();
				adminStu.update(on, name, age, stuArr);
			}else if(number.equals("13")){
				System.out.println("执行删除操作");
				System.out.println("请输入学生的编号:");
				int on=in.nextInt();
				adminStu.delete(on,stuArr);
			}else if(number.equals("14")){
				System.out.println("执行输入成绩操作");
				System.out.println("请输入学生的编号:");
				int on=in.nextInt();
				adminStu.input(on,stuArr);
			}else if(number.equals("15")){
				System.out.println("执行根据某科成绩排序操作");
				System.out.println("请确定课程:1.java 2.C# 3.Html 4.sql");
				int num=in.nextInt();
				adminStu.courseSort(num, stuArr);
			}else if(number.equals("16")){
				System.out.println("执行根据总分排序操作");
				adminStu.sumSort(stuArr);
			}else if(number.equals("99")){
				System.out.println("程序以结束");
				System.exit(0);
			}
		}
	} 
}
