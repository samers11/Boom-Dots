import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

public class TargetBall {
    private int xPos;
    private int yPos;
    private boolean left=false;
    private boolean right=true;
    private Image image;
    private int speed =1;
    float d1;
    float s;
    float max;
    String ballPic = "evil0.png";
    public TargetBall(int x, int y, float s,float m) {
        xPos = x;
        yPos = y;
        //move();
        this.s=s;
	max=m;
    }

    public void paint(Graphics g) {
	ImageIcon  i = new ImageIcon(ballPic);
	image = i.getImage();
	g.drawImage(image,xPos,yPos,null);
	//g.setColor(Color.BLUE);
	//g.fillOval(xPos, yPos, 20, 20);
    }

    public void move() {
		if(right)
		{
			if(xPos<542)
			xPos+=speed;
			else{
			right=false;
			left=true;
			}
		}
		else if(left)
		{
			if(xPos>100)
			xPos-=speed;
			else{
			left=false;
			right=true;
			}
		}
		
			
			if(d1>=max)d1=0;
			else
			d1+=s;
			yPos+=(int)(d1);

    }

	public void setPosition(int x,int y){
		xPos=x;
		yPos=y;
		
		if(y>=350)
		speed=(int)(Math.random()*2+3);//3-4
		else if(y<=200)
		speed=(int)(Math.random()*2+1);//1-2
		else
		speed = (int)(Math.random()*4+1);//1-4
		d1=0.0f;
	}

    public void pKey(KeyEvent ke) {
    }

    public void rKey(KeyEvent ke) {
    }

	public int getx(){
		return xPos;
	}
	
	public int gety(){
		return yPos;
	}
	
	public void setSpeed(float f,float m){
		s=f;
		max=m;
	}
	
	public void setImage(String s){
		ballPic = s;
	}

    public Ellipse2D getBorder() {
	return new Ellipse2D.Double(xPos,yPos,50,50);
    }
}