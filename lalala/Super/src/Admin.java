import java.util.*;
public class Admin {
	 private ArrayList a=null;
	Admin(){
		a = new ArrayList();
	}
	
	public void addGoods(Goods goods){
		a.add(goods);
		for(int i=0;i<a.size();i++){
			System.out.println((Goods)a.get(i));
		}
	}
	
	public void select(String name){
		int i;
		for(i=0;i<a.size();i++){
			Goods goods =(Goods)a.get(i); 
			if(goods.getName().equals(name)){
				System.out.println(goods);				
			}
			break;
		}
		if(i==a.size()){
			System.out.println("�Բ��𣬲ֿ����޸���Ʒ");
		}
	}
	
	public void change(String name,float price){
		int i;
		for(i=0;i<a.size();i++){
			Goods goods =(Goods)a.get(i); 
			if(goods.getName().equals(name)){
				goods.setPrice(price); 
			}
			break;
		}
		if(i==a.size()){
			System.out.println("�Բ��𣬲ֿ����޸���Ʒ");
		}
	}
	
	public void delete(String name){
		int i;
		if(a.size()==0){
			System.out.println("�Բ��𣬲ֿ��������κ���Ʒ");
		}
		for(i=0;i<a.size();i++){
			Goods goods =(Goods)a.get(i); 
			if(goods.getName().equals(name)){
				a.remove(i);
				System.out.println("ɾ����Ʒ�ɹ�");
			}
			break;
		}
		if(i==a.size()&&a.size()!=0){
			System.out.println("�Բ��𣬲ֿ����޸���Ʒ");
		}
	}
}
