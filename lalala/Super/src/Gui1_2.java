import java.awt.*;
import javax.swing.*;
public class Gui1_2 extends JFrame{
	JPanel pan1,pan2;
	JButton[] a = {null,null,null,null,null};
	public static void main(String[] args){
		Gui1_2 a = new Gui1_2();
	}
	
	public Gui1_2(){
		a[0] =new JButton( "«Ô”Í");
		a[1] =new JButton( "«Ô”Í1");
		a[2] =new JButton( "«Ô”Í2");
		a[3] =new JButton( "«Ô”Í3");
		a[4] =new JButton( "«Ô”Í4");
		
		pan1 = new JPanel();
		pan2 = new JPanel();
		pan1.add(a[0]);
		pan1.add(a[1]);
		pan2.add(a[2]);
		pan2.add(a[3]);
		this.add(pan1,BorderLayout.NORTH);
		this.add(pan2, BorderLayout.SOUTH);
		this.add(a[4]);
		
		this.setTitle("–¬Œ˜”Œº«÷Æ’ÊºŸ«Ô”Í");
		this.setSize(300,200);
		this.setLocation(200, 100);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
