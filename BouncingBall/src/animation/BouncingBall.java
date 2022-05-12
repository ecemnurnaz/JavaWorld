package animation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;


public class BouncingBall extends JPanel {

public int xPos=0, yPos= 0, diameter=50, xDir = 1, yDir = 1, frameWidth, frameHeight;
public JFrame thisFrame;
public boolean isRun=false;
public int pressedLocX, pressedLocY, draggedLocX, draggedLocY;

public BouncingBall(){

    thisFrame = new JFrame();

    thisFrame.add(this);

    thisFrame.setTitle("Bouncing Ball");
    
    thisFrame.setAlwaysOnTop(true);
    
    thisFrame.setBackground(Color.darkGray);
    
    this.setBackground(Color.darkGray);

    thisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    thisFrame.setSize(700, 500);
    

    this.addMouseListener(new MouseInputAdapter() {
    	
    	@Override
    	public void mousePressed(MouseEvent e) {
    		
    	  pressedLocX=e.getX(); 
  		  pressedLocY=e.getY();
  		  
  		  xPos = e.getX()-25; 
  		  yPos = e.getY()-25;
  		  
  		  //System.out.println("mousePresse girdi");
  		  repaint();
  		  
    	}});
    
    this.addMouseMotionListener(new MouseInputAdapter() {
    	
    	@Override
		public void mouseDragged(MouseEvent e) {
    		
    	draggedLocX = e.getX();
    	draggedLocY = e.getY();
    	
    	xPos = draggedLocX - 25;
        yPos = draggedLocY - 25;

        if(isRun==false) {
        	
        Thread t = new Thread() {
        
            @Override
            public void run() {

                while(true){
                	
                        try {
							Thread.sleep(5);
							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
                        
                    if(draggedLocX-pressedLocX>0 & draggedLocY-pressedLocY>0) {
                    	
                    	xPos += xDir;
                        yPos += yDir;
                        //System.out.println("x");
                        
                    }else if(draggedLocX-pressedLocX>0 & draggedLocY-pressedLocY<0) {
                    	
                    	xPos += xDir;
                        yPos -= yDir;
                        //System.out.println("y");
                        
                    }else if(draggedLocX-pressedLocX<0 & draggedLocY-pressedLocY<0) {
                    	
                    	xPos -= xDir;
                        yPos += yDir;
                        
                        //System.out.println("z");
                    }else {
                    	
                    	xPos -= xDir;
                        yPos -= yDir;
                        
                      //System.out.println("t");
                    }
                    
                    if(xPos + diameter >= thisFrame.getWidth() || xPos <= 0) xDir = -xDir;

                    if(yPos + diameter >= thisFrame.getHeight() -25 || yPos <= 0) yDir = -yDir;

                    repaint();

                }}};

        t.start();

        isRun=true;
    }
    	}});
    
    thisFrame.setVisible(true); 
}

@Override

    public void paintComponent(Graphics g) { 

	Graphics2D pen = (Graphics2D)g;
	
	pen.setColor(Color.red);
	
	pen.fillArc(xPos, yPos, 50, 50, 0, 360);

    }

}
