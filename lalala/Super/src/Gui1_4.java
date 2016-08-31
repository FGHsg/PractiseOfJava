import java.awt.*;
import javax.swing.*;
public class Gui1_4 extends JFrame {
	JPanel pan1,pan2,pan3;
	JButton butt1,butt2,butt3,butt4,butt5;
	JLabel lab1,lab2,lab3,lab4,lab5,lab6;
	JPasswordField pw;
	JTextField tf1;
	JRadioButton rb1,rb2;
	JTabbedPane tp1,tp2,tb3;
	public static void main(String[] args){
		Gui1_4 a = new Gui1_4();
	}
	
	 public Gui1_4(){
		lab1 = new JLabel(new ImageIcon("image/QQ.png"));//North
		
		lab2 = new JLabel(new ImageIcon("image/QQ2.png"));//South
		lab3 = new JLabel("账号");
		lab4 = new JLabel("密码");
		tf1 = new JTextField();
		pw = new JPasswordField();
		lab5 = new JLabel("<html><a href = 'www.QQ.com'>注册账号</a>");
		lab5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lab6 = new JLabel("<html><a href = 'www.QQ.com'>找回密码</a>");
		lab6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		rb1 = new JRadioButton("记住账号");
		rb2 = new JRadioButton("记住密码");
		/*页面右中部分*/
		pan1 = new JPanel();
		pan1.add(lab3); pan1.add(tf1); pan1.add(lab5);
		pan1.add(lab4); pan1.add(pw); pan1.add(lab6);
		pan1.add(rb1); pan1.add(rb2);
		pan1.setLayout(new GridLayout(3,3,10,10));
		/*页面中间部分*/
		pan2 = new JPanel();
		pan2.add(lab2); pan2.add(pan1);
		pan2.setLayout(new GridLayout(1,2,10,10));
		
		/*页面下方部分*/
		ImageIcon ii1 = new ImageIcon("image/load.png");
		butt1 = new JButton(ii1);
		butt2 = new JButton();
		butt1.setFont(new Font("微软雅黑",Font.PLAIN,16));
		butt1.setBackground(new Color(244,244,244));
		butt1.setForeground(Color.WHITE);
		
		/*整合部分 BorderLayout*/
		this.add(lab1,BorderLayout.NORTH);
		this.add(pan2,BorderLayout.CENTER);
		this.add(butt1,BorderLayout.SOUTH);
		
		ImageIcon ii = new ImageIcon("image/QQ1.png");
		this.setIconImage(ii.getImage());
		this.setTitle("QQ登陆");
		this.setLocation(320, 240);
		this.setSize(530,320);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
	}
}
