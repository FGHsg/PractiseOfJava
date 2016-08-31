import java.util.*;
import java.io.*;
public class Array1_2 {
	public static void main(String[] args) throws Exception{
		Admin admin = new Admin();
		BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("欢迎进入商品管理系统");
			System.out.println("添加商品请按1");
			System.out.println("选择商品请按2");
			System.out.println("更改商品价格请按3");
			System.out.println("删除商品请按4");
			System.out.println("退出系统请按5");
			
			String num = a.readLine();
			if(num.equals("1")){
				System.out.println("请输入商品名称");
				String name = a.readLine();
				System.out.println("请输入商品编号");
				String id = a.readLine();
				System.out.println("请输入商品价格");
				float price = Float.parseFloat(a.readLine());
				Goods goods = new Goods(name,id,price);
				admin.addGoods(goods);
								
			}
			else if(num.equals("2")){
				System.out.println("请输入商品名称！");
				String name = a.readLine();
				admin.select(name);
			}
			else if(num.equals("3")){
				System.out.println("请输入商品名称！");
				String name = a.readLine();
				System.out.println("请输入商品新价格！");
				float price = Float.parseFloat(a.readLine());
				admin.change(name,price);
			}
			else if(num.equals("4")){
				System.out.println("请输入商品名称！");
				String name = a.readLine();
				admin.delete(name);
			}
		}
		
	}
}
