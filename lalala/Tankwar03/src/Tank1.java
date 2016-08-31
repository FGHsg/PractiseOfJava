import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.util.EventListener;
import java.util.Vector;

public class Tank1 extends JFrame implements ActionListener{
	MyPanel mp = null;
	MissionPanel msp = null;
	
	JMenuBar jb = null;
	JMenu jm = null;
	JMenuItem jmi = null;
	JMenuItem jmi1 = null;
	JMenuItem jmi2 = null;
	JMenuItem jmi3 = null;
	
	public static void main(String[] args){
		Tank1 tank = new Tank1();
		}
	/*���캯���������½�һ����Ϸ���*/
	public Tank1(){
	/*�����½�һ���˵���*/	
		jb = new JMenuBar(); 
		jm = new JMenu("��Ϸ(G)");
		jm.setMnemonic('G');//Alt��G��ɴ򿪲˵�
		jmi = new JMenuItem("����Ϸ(N)");
		jmi.setMnemonic('N');
		jmi.setActionCommand("new game");
		jmi.addActionListener(this);
		
		jmi1 = new JMenuItem("�˳���Ϸ(E)");
		jmi1.setMnemonic('E');
		jmi1.setActionCommand("exit");
		jmi1.addActionListener(this);
		
		jmi2 = new JMenuItem("�������(S)");
		jmi2.setMnemonic('S');
		jmi2.setActionCommand("save");
		jmi2.addActionListener(this);
		
		jmi3 = new JMenuItem("������Ϸ(C)");
		jmi3.setMnemonic('C');
		jmi3.setActionCommand("continue");
		jmi3.addActionListener(this);
		
		jm.add(jmi);
		jm.add(jmi1);
		jm.add(jmi2);
		jm.add(jmi3);
		jb.add(jm);//��Ҫ���˵�����˵�����
		this.setJMenuBar(jb);//ע�ⲻ��this.add(jb) ����setJMenuBar(jb)
		
		msp = new MissionPanel();
		Thread t=new Thread(msp);
		t.start();
		this.add(msp);
		
		this.setLocation(100, 0);
		this.setSize(1000,800);
		this.setTitle("TankWar");
		this.setIconImage(new ImageIcon("aaa.gif").getImage());
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.BLACK);
		this.setVisible(true);
	}
/*�½�һ������ �����¡�����Ϸ���� ��ʼ����Ϸ*/
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("new game")){
			mp = new MyPanel("newGame");
			this.remove(msp);
			/*to start the thread of hitenemy*/
			Thread t=new Thread(mp);
			t.start();
			this.addKeyListener(mp);
			this.add(mp);//�˴������MyPanel���������
			this.setVisible(true);
		}
		else if(e.getActionCommand().equals("exit")){
			Jilu.savejilu();
			System.exit(0);
		}
		else if(e.getActionCommand().equals("save")){
			Jilu.save();
		}
		else if(e.getActionCommand().equals("continue")){
			mp = new MyPanel("continue");			
			this.remove(msp);
			/*to start the thread of hitenemy*/
			Thread t=new Thread(mp);
			t.start();
			this.addKeyListener(mp);
			this.add(mp);//�˴������MyPanel���������
			this.setVisible(true);
		}
	}
}
class MissionPanel extends JPanel implements Runnable {
	int time = 0;
	Image im4;
	
	public MissionPanel(){
		try{
			im4=ImageIO.read(new File("aaa.gif"));
		}catch(Exception e){}
	}
		
		public void paint(Graphics g){
			super.paint(g);
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 800, 600);			
			if(time%3!=0){				
//				Color c = g.getColor();
//				g.setColor(Color.PINK);
//				g.setFont(new Font("����",Font.BOLD,40));
//				g.drawString("Mission One", 280, 260);
//				g.setColor(c);
				g.drawImage(im4, 250, 230, 250, 140, this);
			}	
		}
		
		public void run(){
			while(true){
				try{
					Thread.sleep(500);
				}
				catch(Exception e){}
				time++;
				this.repaint();
			}
		}	
}


class MyPanel extends JPanel implements KeyListener,Runnable{
	static MyTank mt = null;
	static Vector<Enemy> enemy = new Vector<Enemy>();
	Vector<Boom> boom = new Vector<Boom>();
	int num_enemy = 11;
	/*��ըͼƬ*/
	Image im1,im2,im3;
	
	public MyPanel(String ss){
		Jilu.readjilu();
		
		try{
//getResource() loads a resource from classpath, not an OS path, so even if "C:\test.png" would be correct you cannot load it that way.
//Also, please check the return value of getResource() before using it so you'd catch these kinds of errors.
//You might want to bundle the image as a resource within your jar and load it using path that specifies the location within your jar.
	
//		im1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("bzxg1.gif"));
//		im2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("bzxg2.gif"));
//		im3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("bzxg3.gif"));
		im1=ImageIO.read(new File("bzxg1.gif"));
		im2=ImageIO.read(new File("bzxg2.gif"));
		im3=ImageIO.read(new File("bzxg3.gif"));
		}
		catch(Exception e){}
		if(ss.equals("newGame")){
			mt = new MyTank(380	,300);
			for(int i=0;i<num_enemy;i++){		
				Enemy enm = new Enemy((i)*75+5,10);				
				Thread t = new Thread(enm);
				t.start();
				/*the sentense below is to make the tank launch a slug in the biginning */
				Slug sg = new Slug(enm.getX()+17,enm.getY()+25,enm.direction);			
				Thread t1 = new Thread(sg);
				t1.start();
				enm.enemy_slug.add(sg);
				enemy.add(enm);
			}
		}
		else if(ss.equals("continue")){//������¼�����ť ���ȡ̹��λ�ò���ʼ��Ϸ
			Vector<Position> pos = Jilu.load();
			Position position = null;
			//ȡ����ҵ�λ��
			position = pos.get(0);
			mt = new MyTank(position.x,position.y);
			//ȡ�õз�̹�˵�λ��
			for(int i=1;i<pos.size();i++){		
				position = pos.get(i);
				Enemy enm = new Enemy(position.x,position.y);				
				Thread t = new Thread(enm);
				t.start();
				/*the sentense below is to make the tank launch a slug in the biginning */
				Slug sg = new Slug(enm.getX()+17,enm.getY()+25,enm.direction);			
				Thread t1 = new Thread(sg);
				t1.start();
				enm.enemy_slug.add(sg);
				enemy.add(enm);
			}
		}
		Shengyin sy=new Shengyin("./tank1.wav");
		sy.start();
	}
	
	/*���ҷ��ӵ���Է�̹����ײ�������*/
	public void hitEnemy(){
		
		for(int i=0;i<mt.sg.size();i++){
			
			Slug sg1 = mt.sg.get(i);
			
			if(sg1.life){
				
				for(int j= 0;j<enemy.size();j++){
					
					Enemy ene1= enemy.get(j);
					if(ene1.life){
						this.hitTank(sg1, ene1,1);						
					}
				}
			}
		}
	}
	/*���з��ӵ����ҷ�̹����ײ�������*/
	public void hitPlayer(){		
		for(int i=0;i<enemy.size();i++){
			Enemy ene = enemy.get(i);
			
			for(int j=0;j<ene.enemy_slug.size();j++){
				Slug sg1 = ene.enemy_slug.get(j);
				
				if(sg1.life){					
					if(mt.life){
						this.hitTank(sg1, mt,0);							
					}
				}
			}			
		}
	}
	
	
	public void hitTank(Slug sg,Tank ene,int a){
		switch(ene.direction){
		case 0:
		case 1:
			
			if(sg.x>ene.x && sg.x<ene.x+35&&sg.y>ene.y&&sg.y<ene.y+20){
				sg.life=false;
				ene.life= false;
				
				if(a==1){//����ǻ��ез� ���һ�� ������Ŀ��һ
					Jilu.gain();
					Jilu.enemy_num();
				}				
				if(a==0){
					Jilu.player_life();
				}
				Boom bm = new Boom(ene.x,ene.y);
				boom.add(bm);				
			}
			break;
		case 2:
		case 3:
			if(sg.x>ene.x&&sg.x<ene.x+20&&sg.y>ene.y&&sg.y<ene.y+35){
				sg.life=false;
				ene.life= false;
				
				if(a==1){//����ǻ��ез� ���һ�� ������Ŀ��һ
					Jilu.gain();
					Jilu.enemy_num();
				}				
				if(a==0){
					Jilu.player_life();
				}
				
				Boom bm = new Boom(ene.x,ene.y);
				boom.add(bm);
			}
		}
	}
//	/*������̹����Է�̹����ײ�������*/
//	public void hitEnemy(MyTank mt,Enemy ene){
//		switch(ene.direction){
//		case 0:
//		case 1:
//			System.out.println("aa");
//			if(mt.x>ene.x && mt.x<ene.x+35&&mt.y>ene.y&&mt.y<ene.y+20){
//				mt.life=false;
//				ene.life= false;
//			}
//			break;
//		case 2:
//		case 3:
//			if(mt.x>ene.x&&mt.x<ene.x+20&&mt.y>ene.y&&mt.y<ene.y+35){
//				mt.life=false;
//				ene.life= false;
//			}
//		}
//	}
	
		
	public void counting(Graphics g)
	{
		this.draw(200,620, g, 0, 0);
		g.setColor(Color.black);
		g.drawString(Jilu.getMtsl()+"",250,635);//int���͵������ں������""������ַ�������
		this.draw(360, 620, g, 1, 0);
		g.setColor(Color.black);
		g.drawString(Jilu.getDtsl()+"",410,635);
        this.draw(820, 190, g, 1,0);
		g.setColor(Color.black);
		g.drawString(Jilu.getScore()+"",870,200);
		g.setColor(Color.black);
		Font f=new Font("����",Font.BOLD,15);
		g.setFont(f);
		g.drawString("�������̹������", 820, 150);
	}
	/*scan to paint the gameobject*/	
	public void paint(Graphics g){
		
		super.paint(g);
		g.fillRect(0, 0, 800, 600);//���»��ƻ��� Ĭ����ɫΪ�Һ�ɫ
		this.counting(g);
		/*������̹��û�����У�����ʾ*/
		if(mt.life){
			this.draw(mt.getX(),mt.getY(),g,0,mt.direction);//����һ������tank
		}
		
		/*ѭ�������ӵ���̹�ˣ���ʾ���̹��*/
		for(int i=0;i<enemy.size();i++){
			Enemy  ene1 = enemy.get(i);			
			if(ene1.life){
				this.draw(ene1.getX(), ene1.getY(), g, 1, ene1.getDirection());								
				for(int j=0;j<ene1.enemy_slug.size();j++){					
					Slug slug1 = ene1.enemy_slug.get(j);					
					if(slug1.life==true){//һ��Ҫ���жϳ�slug!=0���ܻ滭 ��Ȼ����ܶ��쳣 �޷�ִ��
						g.setColor(Color.BLUE);
						g.fillOval(slug1.x, slug1.y, 3, 3);
					}
					/*һ���뿪���棬����ڴ漯���Ƴ�*/
					if(slug1.life==false){
						ene1.enemy_slug.remove(slug1);
					}
				}	
			}
			else{
				enemy.remove(i);
			}
		}
		/*ѭ�������ҷ��ӵ�slug������ͬʱ��ʾ����ӵ������ᷢ��һ��֮����һ����ʧ*/
		for(int i=0;i<mt.sg.size();i++){
			Slug slug = mt.sg.get(i);
			if(slug!=null&&slug.life==true){//һ��Ҫ���жϳ�slug!=0���ܻ滭 ��Ȼ����ܶ��쳣 �޷�ִ��
				g.setColor(Color.RED);
				g.fillOval(slug.x, slug.y, 3, 3);
			}
			/*һ���뿪���棬����ڴ漯���Ƴ�*/
			if(slug.life==false){
				mt.sg.remove(i);
			}
		}
		
		/*ʵ�ֱ�ըЧ��*/
		for(int i =0; i<boom.size();i++){
			Boom boom1 = boom.get(i);
			if(boom1.livetime>18){
				g.drawImage(im1, boom1.x, boom1.y, 30, 30, this);
			}
			else if(boom1.livetime>9){
				g.drawImage(im2, boom1.x, boom1.y, 30, 30, this);
			}
			else {
				g.drawImage(im3, boom1.x, boom1.y, 30, 30, this);
			}
			boom1.livetime();
			if(boom1.livetime==0){
				boom.remove(boom1);
			}
		}
	}
	
	/*����tank���÷���*/
	public void draw(int x,int y,Graphics g,int id,int direction){
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
		this.repaint();
	}
	public void keyTyped(KeyEvent e){};
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e){
	    	int key = e.getKeyCode();
			switch(key){
				 case KeyEvent.VK_D:
					 	mt.right();					 	
					 	mt.setDirection(3);
					 	break;
				 case KeyEvent.VK_W:
					 	mt.up();
					 	mt.setDirection(0);
					 break;
				 case KeyEvent.VK_A:
					 	mt.left();
					 	mt.setDirection(2);

					 break;
				 case KeyEvent.VK_S:	 
					 	mt.down();
					 	mt.setDirection(1);				 
					 break;
			 }
			/*�����ӵ�*/
			if(key==KeyEvent.VK_J){
				if(this.mt.sg.size()<6){
					mt.launchSlug();
				}
					
			}
	 }	
	
	public void run(){
		while(true){
			try{
				Thread.sleep(100);
			}
			catch(Exception e){}
			
			this.hitEnemy();	
			this.hitPlayer();

//			for(int j= 0;j<enemy.size();j++){	
//				Enemy ene1= enemy.get(j);
//				if(ene1.life){
//					this.hitEnemy(mt, ene1);							
//				}
//			}
			/*when the number of enemy is less than six ,then, create new enemy */
			if(enemy.size()<6){
//				System.out.println("aaa");
				Jilu.setDtsl(11);
				for(int k=0;k<6;k++){
					Enemy enm = new Enemy((k)*150+5,10);
					
					Thread t = new Thread(enm);
					t.start();
					/*the sentense below is to make the tank launch a slug in the biginning */
					Slug sg = new Slug(enm.getX()+17,enm.getY()+25,enm.direction);			
					Thread t1 = new Thread(sg);
					t1.start();
					enm.enemy_slug.add(sg);
					enemy.add(enm);
				}
			}			
			this.repaint();
		}
	}
}
