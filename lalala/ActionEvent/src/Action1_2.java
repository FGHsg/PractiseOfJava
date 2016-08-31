/*组件监听*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;;
public class Action1_2 extends JFrame implements ActionListener{//构造方法中需要调用JFrame 以及重写了ActionListener里面的actionPerformed方法
	JButton bt1,bt2;
	graphic gra = null;
	public static void main(String[] args0){
		new Action1_2();
	}
	
	public void actionPerformed(ActionEvent e){//重写ActionListener里面的方法
		System.out.println("按钮被按下了");
		if(e.getActionCommand().equals("111")){
			gra.setBackground(Color.red);
		}
		else if(e.getActionCommand().equals("222")){
			gra.setBackground(Color.blue);
		}
	}
	Action1_2(){
		Monitor1 mon = new Monitor1(); 
		
		bt1 =new JButton("红色");
		bt1.addActionListener(mon);
		bt1.addActionListener(this);
		
		bt1.setActionCommand("111");
		bt2 = new JButton("蓝色");
		
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

	class graphic extends JPanel{//用于输出一个图片
		public void paint(Graphics g){
			super.paint(g);
		}
	}
	
	class Monitor1 implements ActionListener{//重复监听
		public void actionPerformed(ActionEvent e){
			System.out.println("按钮被按下了");
			if(e.getActionCommand().equals("111")){
				System.out.println("红色按钮被按下了");
			}
			else if(e.getActionCommand().equals("222")){
				System.out.println("蓝色按钮被按下了");
			}
		}
	}