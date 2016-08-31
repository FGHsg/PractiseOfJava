import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class tankwar0_1 extends Frame{
	int x =50,y =50;
	Tank myTank = new Tank(x,y);
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	public static void main(String[] args){
		tankwar0_1 tan = new tankwar0_1(); 
		tan.launchFrame();
	}
	
	public void paint(Graphics g){
		myTank.draw(g,0);
	}

	public void launchFrame(){
		this.setLocation(200, 200);
		this.setSize(GAME_WIDTH,GAME_HEIGHT);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.setResizable(false);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.GREEN);
		this.setVisible(true);
		new Thread(new xc()).start();
		this.addKeyListener(new KeyMonitor());
	}
	/*Ïß³Ì*/
	private class xc implements Runnable{
		public void run(){			
			while(true){
				repaint();
				try{
				Thread.sleep(50);
				}
				catch(Exception e){}
			}
		}
	}
	private class KeyMonitor extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}
	}	
}