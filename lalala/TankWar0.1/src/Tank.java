import java.awt.*;
import java.awt.event.*;
public class Tank {
	private int x, y;
	private int direction= 0;
	public Tank(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void draw(Graphics g,int id){
		Color c = g.getColor();
		if(id==1){
			g.setColor(Color.ORANGE);
		}
		else if(id == 0){
			g.setColor(Color.RED);
		}
		switch(direction){
		case 0:
			g.fill3DRect(x, y, 10, 20, false);
			g.fill3DRect(x+10, y+5, 15, 10, false);
			g.fill3DRect(x+25, y, 10, 20, false);
			g.fillOval(x+13, y+6, 8, 8);
			g.fill3DRect(x+17, y-3, 2, 13, false);
			g.fill3DRect(x+16, y-5, 4, 3, false);
			break;
		case 1:
			 g.fill3DRect(x, y, 10, 20, false);
			 g.fill3DRect(x+10, y+5, 15, 10, false);
			 g.fill3DRect(x+25, y, 10, 20, false);
			 g.fillOval(x+13, y+6, 8, 8);
			 g.fill3DRect(x+17, y+10, 2, 13, false);
			 g.fill3DRect(x+16, y+22, 4, 3, false);
			 break;
		case 2:
			g.fill3DRect(x, y, 20, 10, false);
			g.fill3DRect(x+5, y+10, 10, 15, false);
			g.fill3DRect(x, y+25, 20, 10, false);
			g.fillOval(x+6, y+13, 8, 8);
			g.fill3DRect(x-3, y+16, 13, 2, false);
			g.fill3DRect(x-5, y+15, 3, 4, false);
			break;
		case 3:
			g.fill3DRect(x, y, 20, 10, false);
			g.fill3DRect(x+5, y+10, 10, 15, false);
			g.fill3DRect(x, y+25, 20, 10, false);
			g.fillOval(x+6, y+13, 8, 8);
			g.fill3DRect(x+10, y+16, 13, 2, false);
			g.fill3DRect(x+22, y+15, 3, 4, false);
			break;
		}
					
		g.setColor(c);
	}
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		switch(key){
			 case KeyEvent.VK_D:
				  x+=2;
				  direction = 3; 
				  break;
			 case KeyEvent.VK_W:
				 y-=2;
				 direction = 0;
				 break;
			 case KeyEvent.VK_A:
				 x-=2;
				 direction = 2;
				 break;
			 case KeyEvent.VK_S:	 
				 y+=2;
				 direction = 1;
				 
				 break;
		}
		
	}
}
