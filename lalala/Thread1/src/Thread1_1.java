
public class Thread1_1 {
		public static void main(String[] args){
			Th1 xiancheng = new Th1();
			Thread td1 = new Thread(xiancheng);
			td1.start();
			
			Thread td2 = new Thread(xiancheng);
			td2.start();
		}
}


class Th1 implements Runnable{
	public static int fare = 100;
	String aa = "1";
	 
	public void run(){
		 while(true){
			synchronized(aa){
				if(fare>0){
					System.out.println("��" + Thread.currentThread().getName()+ "�ҳ�վ��������" + (101-fare)+"�ų�Ʊ");
					fare--;
				}
				else{
					System.out.println("�Բ��𣬳�Ʊ�Ѿ�����");
					break;
				}
			}
		 }
	 }
}