import java.util.*;
import java.io.*;
public class Array1_2 {
	public static void main(String[] args) throws Exception{
		Admin admin = new Admin();
		BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("��ӭ������Ʒ����ϵͳ");
			System.out.println("�����Ʒ�밴1");
			System.out.println("ѡ����Ʒ�밴2");
			System.out.println("������Ʒ�۸��밴3");
			System.out.println("ɾ����Ʒ�밴4");
			System.out.println("�˳�ϵͳ�밴5");
			
			String num = a.readLine();
			if(num.equals("1")){
				System.out.println("��������Ʒ����");
				String name = a.readLine();
				System.out.println("��������Ʒ���");
				String id = a.readLine();
				System.out.println("��������Ʒ�۸�");
				float price = Float.parseFloat(a.readLine());
				Goods goods = new Goods(name,id,price);
				admin.addGoods(goods);
								
			}
			else if(num.equals("2")){
				System.out.println("��������Ʒ���ƣ�");
				String name = a.readLine();
				admin.select(name);
			}
			else if(num.equals("3")){
				System.out.println("��������Ʒ���ƣ�");
				String name = a.readLine();
				System.out.println("��������Ʒ�¼۸�");
				float price = Float.parseFloat(a.readLine());
				admin.change(name,price);
			}
			else if(num.equals("4")){
				System.out.println("��������Ʒ���ƣ�");
				String name = a.readLine();
				admin.delete(name);
			}
		}
		
	}
}
