	import java.awt.*;
	import javax.swing.*;
	import java.util.ArrayList;
	import java.awt.event.*;

	public class Explosion {
	    private int xPos;
	    private int yPos;
	    private boolean left=false;
	    private boolean right=true;
	    private Image image;
	    private String frame = "";
	    private int num = 3;
	    private int speed =1;
	    private float d1=0.0f;
	    private float s=0.25f;
	    ArrayList<String>anim=new  ArrayList<String>();
	    public Explosion(int x, int y, ArrayList<String> a) {
	        xPos = x;
	        yPos = y;
	        for(int i=0;i<a.size();i++){
	        anim.add(a.get(i));
	        }
	    }

	    public void paint(Graphics g) {
		ImageIcon  m = new ImageIcon(frame);
		image = m.getImage();
		g.drawImage(image,xPos,yPos,null);
	    }

		public void setPosition(int x,int y){
			xPos=x;
			yPos=y;
		}

		public void start(){
			frame=anim.get(0);
		}

		public void move(){
			if(frame!=anim.get(anim.size()-1)){
			if(d1>=anim.size()-1)d1=0.0f;
			else d1+=s;

			for(int i=1;i<anim.size();i++){
				if((int)d1==i)
				frame=anim.get(i);
			}

		}
		}

}