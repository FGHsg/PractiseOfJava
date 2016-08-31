import java.awt.*;
import javax.swing.*;
public class GUI1_1 extends JFrame{
	//JButton a,b,c,d,e;
	JButton[] a = {null,null,null,null,null};
	public static void main(String[] args){
		GUI1_1 a = new GUI1_1();
		//JFrame a = new JFrame();
		
	}
	
	public GUI1_1(){//对象的思想，初始化都在构造方法中实现
		/*BorderLayout
		a = new JButton("东");
		b = new JButton("西");
		c = new JButton("南");
		d = new JButton("北");
		e = new JButton("中");
		*/
		a[0] = new JButton("东");
		a[1] = new JButton("东1");
		a[2] = new JButton("东2");
		a[3] = new JButton("东3");
		a[4] = new JButton("东4");
				 
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
		//this.setLayout(new FlowLayout(FlowLayout.LEFT));//非BorderLayout布局管理时需要设置布局类型
		this.setLayout(new GridLayout(2,3,10,10));
		this.setTitle("JFrame");
		this.setSize(350, 280);
		this.setLocation(380,250);
		this.setResizable(false);//设置不能调整窗口大小，防止拖拉窗口时内容扭曲
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}
