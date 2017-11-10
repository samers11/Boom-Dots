import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class BoomDots extends JPanel implements KeyListener, ActionListener{
	int x = (int)(Math.random()*452+100);
	int y = 50*(int)((Math.random()*6))+150;
	int yb = 0;
	int i=0;
	int points = 0;
	int HS=0;
	int scorex = 300;
	int bgy=-261;
	String current = "bg0.png";
	String bg ="bg0.png";
	boolean game=true;
	boolean hit=false;
	boolean phb=false;
	boolean change=false;
	float d1=0.0f;
	float speed = 0.06f;
	float max=1;
	float phi = 0;
	String AnimE = "Images/one.png";
	String ph="Perfect hit";
	String p="+3";
	String ballPic="ball0.png";
	String eballPic="evil0.png";
	Ball ball = new Ball(332, 480, speed, max);
	TargetBall enemy = new TargetBall(x,y,speed,max);
	Image image;
	ArrayList<String> anim = new ArrayList<String>();
	ArrayList<String> anim2 = new ArrayList<String>();
	Explosion explosion;
	Explosion explosion2;
	ActionEvent a2;
	JButton Button;
	//ImageIcon start = new ImageIcon(getClass().getResource("pb.png"));
	JFrame frame = new JFrame("Boom Dots - Samer Shaban");
    public BoomDots() {
		anim.add("imag/1.png");
		anim.add("imag/2.png");
		anim.add("imag/3.png");
		anim.add("imag/4.png");
		anim.add("imag/5.png");
		anim.add("imag/6.png");
		anim.add("imag/7.png");
		anim.add("imag/8.png");
		anim.add("imag/9.png");
		anim.add("imag/10.png");
		anim.add("imag/11.png");
		anim.add("imag/12.png");
		anim.add("imag/13.png");
		anim.add("imag/14.png");
		anim.add("imag/15.png");
		anim.add("imag/0.png");

		anim2.add("imag2/1.png");
		anim2.add("imag2/2.png");
		anim2.add("imag2/3.png");
		anim2.add("imag2/4.png");
		anim2.add("imag2/5.png");
		anim2.add("imag2/6.png");
		anim2.add("imag2/7.png");
		anim2.add("imag2/8.png");
		anim2.add("imag2/9.png");
		anim2.add("imag2/10.png");
		anim2.add("imag2/11.png");
		anim2.add("imag2/12.png");
		anim2.add("imag2/13.png");
		anim2.add("imag2/14.png");
		anim2.add("imag2/15.png");
		anim2.add("imag2/0.png");

		explosion = new Explosion(0,0,anim);
		explosion2 = new Explosion(0,0,anim2);
		setLayout(null);
		Button = new JButton(new ImageIcon(getClass().getResource("pb.png")));
		Button.setBounds(100+25,45+25,50,50);
		add(Button);
		Button.setFocusable(false);
		Button.addActionListener(this);

	setFocusable(true);
	frame.setSize(708, 655);
	frame.add(this);
	frame.setVisible(true);
	addKeyListener(this);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	while(true){
	if(game){
		ball.move();
		enemy.move();
		explosion.move();
		explosion2.move();
	}
		ball.setSpeed(speed,max);
		enemy.setSpeed(speed,max);
		if(hit){
		speed=0.7f;
		ball.stop();
			max=(97f-(ball.gety()/5f));
			if(ball.gety()>=480){
			hit=false;
			max=1f;
			speed=0.06f;
			}
		}
		//////////////////////movement
	if(game){
		if(d1>=max)d1=0;
		else
		d1+=speed;
		if(bgy>=0)
		bgy=-255;
		else
		bgy+=(int)(d1);
	}
			Rectangle top = new Rectangle(100,0, 492, 50);
			Rectangle bottom = new Rectangle(100,572, 492, 35);
			Rectangle phr = new Rectangle(enemy.getx()+24,enemy.gety()+20, 2, 30);
			if (enemy.getBorder().intersects(ball.getBorder())){
				explosion.setPosition(enemy.getx()-(246-25),enemy.gety()-(246-25));
				i = 50*(int)((Math.random()*7))+100;
				while(i==y){
				i = 50*(int)((Math.random()*6))+150;
				}
				y=i;
				x = (int)(Math.random()*452+100);
				hit=true;
				explosion.start();
				speed = 0.06f;
				max=10;
				enemy.setPosition(x, y+(ball.gety()-480));
				points++;
				change=true;
				//////////////////////////////////////////////////////////////
			}

			if(phr.intersects(ball.getBorder())){
				phb=true;
				explosion.setPosition(enemy.getx()-(246-25),enemy.gety()-(246-25));
				explosion.start();
				i = 50*(int)((Math.random()*7))+100;
				while(i==y){
				i = 50*(int)((Math.random()*6))+150;
				}
				y=i;
				x = (int)(Math.random()*452+100);
				hit=true;
				//explosion.start();
				speed = 0.06f;
				max=10;
				enemy.setPosition(x, y+(ball.gety()-480));
				points+=2;
			}

			if (top.intersects(ball.getBorder())||bottom.intersects(ball.getBorder())){
				if(HS<points){
				HS=points;
				}
				points=0;
				explosion2.setPosition(332-246+15,ball.gety()-(246-15));
				explosion2.start();
				int x = (int)(Math.random()*452+100);
				int y = 50*(int)((Math.random()*6))+150;
				ball.setPosition(332, 480);
				enemy.setPosition(x, y);

			ball.setImage("ball1.png");
			enemy.setImage("evil1.png");
			bg="bg0.png";
			}

			if(points==1)
			scorex=328;
			else if(points==11)
			scorex=316;
			else if(points>=10)
			scorex=304;
			else
			scorex=318;

		if(change){
		change=false;
			int cc=1;
			//while((current).equals(bg)){
			cc = (int)(Math.random()*7)+1;
			bg="bg"+Integer.toString(cc)+".png";
			//}

			int c = (int)(Math.random()*4);

			ball.setImage("ball"+Integer.toString(c)+".png");
			enemy.setImage("evil"+Integer.toString(c)+".png");
		}
            repaint();
            try {
                Thread.sleep(6);
            } catch (Exception e) {}
    }//while(true)
}
    public static void main(String[] args) {
        BoomDots app = new BoomDots();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
	ImageIcon i = new ImageIcon(bg);
	image = i.getImage();
	g.drawImage(image,100,bgy,null);

	g.setColor(new Color(95,114,159));
	g.setFont(new Font("Agency FB", Font.BOLD, 120));
	g.drawString(Integer.toString(points), scorex, 140);

	g.setFont(new Font("Agency FB", Font.BOLD, 20));
	g.drawString("Hi Score:"+Integer.toString(HS), 116, 140);

	g.drawString("Made by Samer Shaban", 100, 60);////////////////

	g.setFont(new Font("Agency FB", Font.BOLD, 55));
	g.setColor(new Color(229,62,135));
	if(phb){
	phi+=0.2f;
	g.setColor(new Color(95,114,159));
	g.drawString(ph, 250, 300);
	g.setColor(new Color(229,62,135));
	g.drawString(p, 316, 350);
		if(phi>16){
		phi=0;
		phb=false;
		}
	}
    	Graphics2D g2d = (Graphics2D) g;
	ball.paint(g2d);

		enemy.paint(g2d);
		explosion.paint(g2d);
		explosion2.paint(g2d);

	i = new ImageIcon("spiket.png");
	image = i.getImage();
	g.drawImage(image,100,0,null);

	i = new ImageIcon("spikeb.png");
	image = i.getImage();
	g.drawImage(image,100,572,null);
	if(game==false)
		g.drawString("Paused", 180, 340);///////////////////////////////////////////////////////////
	if(!game){
	i = new ImageIcon("psplash.png");
	image = i.getImage();
	g.drawImage(image,100,0,null);
	}

	g.setColor(new Color(30,30,30));
	g.fillRect(0,0,100,616);
	g.setColor(new Color(9,9,9));
	g.fillRect(592,0,100,616);
	}

    public void keyPressed(KeyEvent e) {
       if(game){
    	if(!hit)
        ball.pKey(e);
       }
        if(e.getKeyCode()==80){
        pause();
        }

        if(e.getKeyCode()==82){
        restart();
        }
    }
    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
	public void actionPerformed(ActionEvent a){
		pause();
	}

	public void restart(){
		//if(game){
		//ball.setImage("ball2.png");
		//enemy.setImage("evil2.png");
		//bg="bg2.png";

		explosion2.setPosition(332-246+15,ball.gety()-(246-15));
		explosion2.start();
		x = (int)(Math.random()*452+100);
		y = 50*(int)((Math.random()*6))+150;
		ball.setPosition(332, 480);
		enemy.setPosition(x, y);
		game=true;
		if(HS<points){
			HS=points;
		}
		points=0;
		int x = (int)(Math.random()*452+100);
		int y = 50*(int)((Math.random()*6))+150;
		change=true;
	}
	public void pause(){
		if(game){
		game=false;
		//Button.setText("Resume");
		}
		else{
		game=true;
		//Button.setText("Pause");
		}
	}

}