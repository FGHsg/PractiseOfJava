import java.awt.*;
import javax.swing.*;
public class GUI1_1 extends JFrame{
	//JButton a,b,c,d,e;
	JButton[] a = {null,null,null,null,null};
	public static void main(String[] args){
		GUI1_1 a = new GUI1_1();
		//JFrame a = new JFrame();
		
	}
	
	public GUI1_1(){//�����˼�룬��ʼ�����ڹ��췽����ʵ��
		/*BorderLayout
		a = new JButton("��");
		b = new JButton("��");
		c = new JButton("��");
		d = new JButton("��");
		e = new JButton("��");
		*/
		a[0] = new JButton("��");
		a[1] = new JButton("��1");
		a[2] = new JButton("��2");
		a[3] = new JButton("��3");
		a[4] = new JButton("��4");
				 
		/*this.add(a,BorderLayout.EAST);
		this.add(b,BorderLayout.WEST);
		this.add(c,BorderLayout.SOUTH);
		this.add(d,BorderLayout.NORTH);
		this.add(e,BorderLayout.CENTER);
		*/
		for(int i=0;i<a.length;i++){
		this.add(a[i]);
		}
		
		//this.setLayout(new FlowLayout());
		//this.setLayout(new FlowLayout(FlowLayout.TRAILING));
		//this.setLayout(new FlowLayout(FlowLayout.LEFT));//��BorderLayout���ֹ���ʱ��Ҫ���ò�������
		this.setLayout(new GridLayout(2,3,10,10));
		this.setTitle("JFrame");
		this.setSize(350, 280);
		this.setLocation(380,250);
		this.setResizable(false);//���ò��ܵ������ڴ�С����ֹ��������ʱ����Ť��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}
