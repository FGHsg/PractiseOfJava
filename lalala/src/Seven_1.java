/*
 * 用try...catch 和 throws Exception 语句进行异常处理
 * */

import java.util.*;
public class Seven_1 {
	public static void main(String[] args){
		//Scanner in = new Scanner(System.in);
		try{
		 /*int a= in.nextInt();
		 int b= in.nextInt();
		 int c =a/b;
		 System.out.println(c);
		 
		  //}catch(Exception e){
		//	  System.out.println("输入类型不符");
		//  	}
		  System.out.println("程序顺利进行");*/
		 show1.show();
	}catch(Exception e){
		System.out.println("输入类型不符");
	}
	}
}

class show1{
	static void show() throws Exception
	{
		 Scanner in = new Scanner(System.in);
		 int a= in.nextInt();
		 int b= in.nextInt();
		 int c =a/b;
		 System.out.println(c);
		//System.out.println("程序顺利运行中");
	}
}