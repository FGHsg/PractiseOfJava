/*�������*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;;
public class Action1_2 extends JFrame implements ActionListener{//���췽������Ҫ����JFrame �Լ���д��ActionListener�����actionPerformed����
	JButton bt1,bt2;
	graphic gra = null;
	public static void main(String[] args0){
		new Action1_2();
	}
	
	public void actionPerformed(ActionEvent e){//��дActionListener����ķ���
		System.out.println("��ť��������");
		if(e.getActionCommand().equals("111")){
			gra.setBackground(Color.red);
		}
		else if(e.getActionCommand().equals("222")){
			gra.setBackground(Color.blue);
		}
	}
	Action1_2(){
		Monitor1 mon = new Monitor1(); 
		
		bt1 =new JButton("��ɫ");
		bt1.addActionListener(mon);
		bt1.addActionListener(this);
		
		bt1.setActionCommand("111");
		bt2 = new JButton("��ɫ");
		
		bt2.addActionListener(this);
		bt2.addActionListener(mon);
		bt2.setActionCommand("222");
		
		gra = new graphic();
		
		this.add(bt1,BorderLayout.NORTH);
		this.add(bt2,BorderLayout.SOUTH);
		this.add(gra);
		
		this.setSize(480, 300);
		this.setLocation(300, 200);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

	class graphic extends JPanel{//�������һ��ͼƬ
		public void paint(Graphics g){
			super.paint(g);
		}
	}
	
	class Monitor1 implements ActionListener{//�ظ�����
		public void actionPerformed(ActionEvent e){
			System.out.println("��ť��������");
			if(e.getActionCommand().equals("111")){
				System.out.println("��ɫ��ť��������");
			}
			else if(e.getActionCommand().equals("222")){
				System.out.println("��ɫ��ť��������");
			}
		}
	}