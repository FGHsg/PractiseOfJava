import java.awt.*;
import javax.swing.*;

public class Gui1_3 extends JFrame
{
    JSplitPane cf,df;
    JList lb;
    JLabel bq,dq,jq;
    
	public static void main(String[] args) 
    {
		Gui1_3 lx=new Gui1_3();
	}
	
	Gui1_3()
	{
		String[] jsj={"��Ԫ������ɵ����","��Ԫ������ɵ����","��Ԫ������ɵ����","��Ԫ������ɵ����","��Ԫ������ɵ����"};
		lb=new JList(jsj);
		
		bq=new JLabel(new ImageIcon("image/a.jpg"));
		dq=new JLabel(new ImageIcon("image/b.png"));
		jq=new JLabel(new ImageIcon("image/c.png"));
		cf=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,dq,bq);
		df=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,cf,jq);
		//cf.setOneTouchExpandable(true);
		df.setOneTouchExpandable(true);
		
		this.add(df);
		
		this.setTitle("��Ԫ������ɵ����");
		 this.setSize(690,480);
		 this.setLocation(300,280);
		// this.setResizable(false);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setVisible(true);	
		
	}
}
