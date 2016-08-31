//import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class Action1_5 extends JFrame implements ActionListener{
	JMenuBar mb;
	JMenu mu1,mu2,mu3;
	JMenuItem mt1,mt2,mt3;
	JTextArea ta; 
	JScrollPane sp;
	public static void main(String[] args) throws Exception{
		Action1_5 a = new Action1_5();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("open")){
				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("打开文件");
				fc.showOpenDialog(null);
				fc.setVisible(true);
				
				String path =fc.getSelectedFile().getAbsolutePath();
				BufferedReader br = null;
				try{
					br = new BufferedReader(new FileReader(path));
					String s1 =" ",s2 = " ";
					s1 = br.readLine();
				
				while(s1!=null){
					s2 += (s1 + "\n");
					s1= br.readLine();
				}
				
				ta.setText(s2);
				}catch(Exception a){					
				}finally{
					try
					{
						br.close();	
					}
					catch(Exception a){}					
				}
				
		}else if(e.getActionCommand().equals("save")){
			JFileChooser fc1 = new JFileChooser();
			fc1.setDialogTitle("保存文件");
			fc1.showSaveDialog(null);
			fc1.setVisible(true);
						
			String path1 = fc1.getSelectedFile().getAbsolutePath();
			PrintStream bw = null;
			String s2="", s3="";
			try{
				bw = new PrintStream(path1);
				System.setOut(bw);
				System.out.print(this.ta.getText());
			}
			catch(Exception a){}
			finally{
				try{
					bw.close();
				}
				catch(Exception a){}
			}
			
		}else if(e.getActionCommand().equals("new")){
			
		}
	}
	Action1_5(){
		ta = new JTextArea();
		sp = new JScrollPane(ta);
		mb = new JMenuBar();
		mu1 = new JMenu("文件(F)");
		mu1.setMnemonic('F');
		mu2 = new JMenu("编辑(E)");
		mu2.setMnemonic('E');
		
		mt1= new JMenuItem("新建P");
		mt1.setActionCommand("new");
		mt1.addActionListener(this);
		mt2= new JMenuItem("打开O");
		mt2.setActionCommand("open");
		mt2.addActionListener(this);
		mt3 = new JMenuItem("保存S");
		mt3.setActionCommand("save");
		mt3.addActionListener(this);
		
//		ImageIcon ii1 = new ImageIcon("C:/Users/FGHsg_/Desktop/java/lalala/Super/image/QQ1.png");
		ImageIcon ii2 = new ImageIcon("C:/Users/FGHsg_/Desktop/java/lalala/Super/image/QQ2.png");
//		mt2.setIcon(ii1);
//		mt3.setIcon(ii2);
		
		mu1.add(mt1);
		mu1.add(mt2);
		mu1.add(mt3);
		
		mb.add(mu1);
		mb.add(mu2);
		 
		this.setJMenuBar(mb);
		this.add(sp);
		 
		this.setTitle("记事本");
		this.setIconImage(ii2.getImage());
		this.setLocation(320, 240);
		this.setSize(480, 320);
//		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
