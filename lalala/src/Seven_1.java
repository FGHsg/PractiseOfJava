/*
 * ��try...catch �� throws Exception �������쳣����
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
		//	  System.out.println("�������Ͳ���");
		//  	}
		  System.out.println("����˳������");*/
		 show1.show();
	}catch(Exception e){
		System.out.println("�������Ͳ���");
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
		//System.out.println("����˳��������");
	}
}