import java.util.*;
public class Goods {
	static String name;
	static String id;
	static float price;
	Goods(String name,String id,float price){
		this.name=name;
		this.id= id;
		this.price = price;
	}
	 public String toString(){
		return "	��Ʒ����: " + this.name + "	��Ʒ���:" + id + "	��Ʒ�۸�:" + price;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public void setPrice(float price){
		this.price = price;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getId(){
		return this.id;
	}
	
	public float getPrice(){
		return this.price;
	}
}
