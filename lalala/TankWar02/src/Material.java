import java.util.Vector;


public class Material {

}
/*tank类*/
class Tank {
	int x=0,y=0;
	int direction=0;
	int speed= 5;
	boolean life = true;
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
		
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public Tank(int x,int y){
		this.x =x;
		this.y =y;
	}
	
}
/*我的tank*/
class MyTank extends Tank{
	 Slug slug = null; 
	 Vector<Slug> sg = new Vector<Slug>();
	public MyTank(int x,int y){
		super(x,y);
	}
	public void up(){
		if(y>0){
			y-=speed;
		}
	}
	public void down(){
		if(y<565){
			y+=speed;
		}
	}
	public void left(){
		if(x>0){
			x-=speed;
		}
	}
	public void right(){
		if(x<765){
			x+=speed;
		}
	}
	public void launchSlug(){
		switch(this.direction){
			case 0:
				slug = new Slug(this.getX()+17,this.getY()-5,this.direction);
				sg.add(slug);
				break;
			case 1:
				slug = new Slug(this.getX()+17,this.getY()+25,this.direction);
				sg.add(slug);
				break;
			case 2:
				slug = new Slug(this.getX()-4,this.getY()+17,this.direction);
				sg.add(slug);
				break;
			case 3:
				slug = new Slug(this.getX()+25,this.getY()+17,this.direction);
				sg.add(slug);
				break;	
		}
		Thread t = new Thread(slug);
		t.start();
	}
}
class Enemy extends Tank implements Runnable{
	
	Vector<Slug> enemy_slug = new Vector<Slug>();//control the number of the slug of enemy
	Slug slug;
	int time;//launch time 
	public Enemy(int x,int y){
		super(x,y);
		this.direction=1;
	}
	public void run(){
		while(true){
			try{
				Thread.sleep(100);
			}
			catch(Exception e){}
			switch(this.direction){
				case 0:
					for(int i= 0;i<30;i++){
						if(y>0){//let the enemy could not move out of the boundary
							y-=speed;
						}
						try{
							Thread.sleep(50);
						}
						catch(Exception e){}
					}					
					break;
				case 1:
					for(int i= 0;i<30;i++){
						if(y<565){
							y+=speed;
						}
						
						try{
							Thread.sleep(50);
						}
						catch(Exception e){}
					}						
					break;
				case 2:
					for(int i= 0;i<30;i++){
						if(x>0){
							x-=speed;
						}
						
						try{
							Thread.sleep(50);
						}
						catch(Exception e){}
					}						
					break;
				case 3:
					for(int i= 0;i<30;i++){
						if(x<765){
							x+=speed;
						}
						try{
							Thread.sleep(50);
						}
						catch(Exception e){}
					}						
					break;
				}
			this.direction= (int)(Math.random()*4);	
			
			if(this.life==false){
				break;
			}
	/*launch slug*/		
			this.time++;//control the frequance of launch slug
			if(time%2==0){
				if(life){
					if(enemy_slug.size()<3){
						Slug slug = null; 
					
						switch(this.direction){
						case 0:
							slug = new Slug(this.getX()+17,this.getY()-5,this.direction);
							enemy_slug.add(slug);
							break;
						case 1:
							slug = new Slug(this.getX()+17,this.getY()+25,this.direction);
							enemy_slug.add(slug);
							break;
						case 2:
							slug = new Slug(this.getX()-4,this.getY()+17,this.direction);
							enemy_slug.add(slug);
							break;
						case 3:
							slug = new Slug(this.getX()+25,this.getY()+17,this.direction);
							enemy_slug.add(slug);
							break;	
						}
						Thread t2 = new Thread(slug);
						t2.start();
					}				
				}
			}
		}	
	}
}
/*子弹类*/
class Slug implements Runnable{
	int x,y;
	int direction;
	int speed = 20;
	boolean life= true;
	public void run(){
		while(true){
			
			try{
				Thread.sleep(100);
			}
			catch(Exception e){}
			switch(this.direction){
			case 0:
				y-=speed;
				break;
			case 1:
				y+=speed;
				break;
			case 2:
				x-=speed;
				break;
			case 3:
				x+=speed;
				break;	
			}
			if(x<0||x>800||y>600||y<0){
				this.life= false;
			}	
		}
	}

	public Slug(int x,int y,int direction){
		this.x = x;
		this.y = y;
		this.direction = direction;		
	}
}

/*爆炸类*/
class Boom{
	int x,y;
	int livetime =27;
	boolean shengming =true;
	
	public Boom(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void livetime(){
		if(livetime>0){
			livetime--;
		}else{
			shengming = false;
		}
		
	}
}