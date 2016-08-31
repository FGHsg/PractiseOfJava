import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Action1_3 extends JFrame{
	pan1 pan = null;
	public static void main(String[] args){
		new Action1_3();
	}
	
	public Action1_3(){
		pan = new pan1();
		this.add(pan);
		/*每添加一个监听就需要在图形对象之中加入一个监听*/  
		this.addKeyListener(pan);
		this.addMouseListener(pan);
	    this.addMouseMotionListener(pan);
	        
		this.setSize(480, 320);
		this.setLocation(480, 320);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}



class pan1 extends JPanel implements KeyListener,MouseListener,MouseMotionListener{
	int x = 50;
	int y = 60;
	public void paint(Graphics g){
		super.paint(g);
		g.fill3DRect(x, y, 100, 100, true);
	}
	@Override
	public void keyPressed(KeyEvent e){
		System.out.println((char)e.getKeyCode());
		if(e.getKeyCode()==KeyEvent.VK_DOWN&&y!=0&&y!=320){
			y+=10;
			this.setBackground(Color.BLUE);
		}
		else if(e.getKeyCode()==KeyEvent.VK_UP&&y!=0&&y!=320){
			y-=10;
			this.setBackground(Color.GREEN);
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT&&x!=0&&x!=480){
			x-=10;
			this.setBackground(Color.RED);
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&x!=0&&x!=480){
			x+=10;
			this.setBackground(Color.YELLOW);
		}
		this.repaint();
	}
	
	public void keyTyped(KeyEvent e){
		//// 有字符输出的函数
	}
	
	public void keyReleased(KeyEvent e){
		//按键松开时
	}
	
	@Override
	
	public void mouseClicked(MouseEvent e){
		
	}
	
	public void mousePressed(MouseEvent e){
		
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	public void mouseExited(MouseEvent e){
		
	}
	
	public void mouseEntered(MouseEvent e){
		
	}
		
	@Override
	
	public void mouseMoved(MouseEvent e){
		
	}
	
	public void mouseDragged(MouseEvent e){
		
	}
}