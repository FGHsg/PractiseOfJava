import javax.imageio.ImageIO;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class DB02 extends JFrame implements ActionListener{
	JPanel jp1,jp2;
	JLabel jl;
	JTextField jtext;
	JTable jtable;
	JButton jb1,jb2,jb3,jb4;
	JScrollPane js;
	
	Message mess1;
	
	public static void main(String[] args){
		new DB02();
	}
	public DB02(){
		jp1= new JPanel();
		jp2= new JPanel();
		jl= new JLabel("请输入学生姓名");
		jtext = new JTextField(10);		
		
		jb1 = new JButton("搜索");
		jb1.setActionCommand("search");
		jb1.addActionListener(this);
		jb2 = new JButton("新增");
		jb2.setActionCommand("add");
		jb2.addActionListener(this);
		jb3 = new JButton("修改");
		jb3.setActionCommand("fix");
		jb3.addActionListener(this);
		jb4 = new JButton("删除");
		jb4.setActionCommand("delete");
		jb4.addActionListener(this);
		
		jp1.add(jl);jp1.add(jtext);jp1.add(jb1);
		jp2.add(jb2);jp2.add(jb3);jp2.add(jb4);		
		
		mess1=new Message();
		jtable = new JTable(mess1);
		js = new JScrollPane(jtable);
		
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.add(js);
		
		try{
			Image image=ImageIO.read(new File("aaa.gif"));
			this.setIconImage(image);
		}catch(Exception e){}
		
		this.setLocation(100, 80);
		this.setSize(600, 500);
		this.setTitle("学生管理系统");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);				
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("search")){
			String name = this.jtext.getText().trim();
			String sql = "select* from stu where named ='" +name+"'";
			mess1=new Message(sql);
			jtable.setModel(mess1);
		}
		else if(e.getActionCommand().equals("add")){
			new Add(this,"添加学生信息",true);//true 则在编辑的时候父面板不允许编辑
			mess1=new Message();
			jtable.setModel(mess1);
		}
		else if(e.getActionCommand().equals("fix")){
			int ii=this.jtable.getSelectedRow();
			if(ii==-1)
			{
				JOptionPane.showMessageDialog(this,"请选中要修改的行");
				return;
			}
			new Fix(this,"修改学生信息",true,mess1,ii);
			
			mess1=new Message();//内容每次有改变 则需要再次重新加载信息
			jtable.setModel(mess1);
		}
		else if(e.getActionCommand().equals("delete")){
			int ii=this.jtable.getSelectedRow();
			if(ii==-1)
			{
				JOptionPane.showMessageDialog(this,"请选中要删除的行");
				return;
			}
			   String st=(String)mess1.getValueAt(ii,0);
			   PreparedStatement ps=null;
			   Connection ct=null;
			   ResultSet rs=null;
			   
			   try {
				      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					  ct=DriverManager.getConnection("jdbc:odbc:SQL server","sa","321wssba");
					  ps=ct.prepareStatement("delete from stu where id=?");
					  ps.setString(1,st);
					  ps.executeUpdate();					 
				} catch (Exception e2){}
			    finally
			    {
			    	try {
			    		if(rs!=null)
						{
							rs.close();
						}
			    		if(ps!=null)
						{
							ps.close();
						}
						if(ct!=null)
						{
							ct.close();
						}
						
					} catch (Exception e3){}		
			    }
			      mess1=new Message();
				 jtable.setModel(mess1);
		}
	}

}
