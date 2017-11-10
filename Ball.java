import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

public class Ball {
private int xPos;
private int yPos;
private boolean up;
private Image image;
private float max;
private String ballPic = "ball0.png";
Thread t;
float d1;
float s;
    public Ball(int x, int y,float s,float m) {
        xPos = x;
        yPos = y;
        //h=ballPic;
        this.s=s;
        max=m;
    }

    public void paint(Graphics g) {
	ImageIcon  i = new ImageIcon(ballPic);
	image = i.getImage();
	g.drawImage(image,xPos,yPos,null);
	
    }

    public void move() {
        	if(up)
		{
			if(yPos>35)
			yPos-=4;
		}
		else{
		
			if(d1>=max)d1=0;
			else
			d1+=s;
			
			yPos+=(int)(d1);
		}
		
    }

    public void pKey(KeyEvent ke) {
       if(ke.getKeyCode()==38||ke.getKeyCode()==32)
       		up=true;
       	
    }

    public void setPosition(int x,int y){
   	 up= false;
	xPos=x;
	yPos=y;
	d1=0.0f;
	}

public void reset(){
	up= false;
}

public int gety(){
	return yPos;
}
public void stop(){
	up=false;
}

public void setSpeed(float f, float m){
	s=f;
	max=m;
}

public void setImage(String s){
	ballPic = s;
}

    public Rectangle getBorder() {
    	//return new Ellipse2D.Double(xPos,yPos,20,20);
        return new Rectangle(xPos+5, yPos+5, 25, 25);
    }
}