import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends JPanel implements KeyListener, ActionListener {
	
	
	Timer tm = new Timer(5, this);
	Image imageH, imageEnnemie1, imageEnnemie2, imageEnnemie3, imageEnnemie4;
	boolean readyToFire, shot, killed1, killed2, killed3, killed4 = false;
	


	int[] hp = new int[3];
	
	
	/*Missile*/
	int bx = 0, velBX = 1;  
	int by = 0, velBY = 1;
	
	Rectangle missile;

  	int x = 0, y = 0, velX = 0, velY = 0;
  	
  	
  	/*First Ennemie*/
  	int ennemie1X = 150, velT = 1;
  	int ennemie1Y = 150, velC = 1;
  	
  	int ennemie2X = 350, velT2 = 3;
  	int ennemie2Y = 350, velC2 = 3;
  	
  	int ennemie3X = 550, velT3 = 4;
  	int ennemie3Y = 500, velC3 = 4;
  	
  	int ennemie4X = 650, velT4 = 4;
  	int ennemie4Y = 350, velC4 = 4;
  	
  	
  	

	  public Player(int x, int y) {
		  
		  this.x = x;
		  this.y = y;
		  
		  
		  imageH = Toolkit.getDefaultToolkit().createImage("F:/Dev/PiscineJS/RPG/src/mario.gif");
		  imageEnnemie1 = Toolkit.getDefaultToolkit().createImage("F:/Dev/PiscineJS/RPG/src/ennemiePNG.png");
		  imageEnnemie2 = Toolkit.getDefaultToolkit().createImage("F:/Dev/PiscineJS/RPG/src/nannyogg.png");
		  imageEnnemie3 = Toolkit.getDefaultToolkit().createImage("F:/Dev/PiscineJS/RPG/src/war_biker.png");
		  imageEnnemie4 = Toolkit.getDefaultToolkit().createImage("F:/Dev/PiscineJS/RPG/src/nightelf_female1.png");




	    
		  /* missiles = new ArrayList<Missile>();*/
	   
		  addKeyListener(this);
		  setFocusable(true);
		  setFocusTraversalKeysEnabled(false);
	  }
	  
	 
	  
	  
	 
	  @Override
	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    	
	    	g.drawImage(imageH, x, y, this);
	    	g.drawImage(imageEnnemie1, ennemie1X, ennemie1Y, this);
	    


	    	if (shot) {
	    		g.setColor(Color.RED);
	    		g.fillOval(bx, by, 30, 10);
	    	}
	    	if (killed1) {
	    		
	    		g.drawImage(imageEnnemie2, ennemie2X, ennemie2Y, this);
	    	}
	    	if (killed2) {
	    		
	    		g.drawImage(imageEnnemie3, ennemie3X, ennemie3Y, this);
	    		g.drawImage(imageEnnemie4, ennemie4X, ennemie4Y, this);

	    	}
	    	
	    	tm.start();
	    
	  }
	  
	  
	 
	  public void actionPerformed(ActionEvent e) {
		  
		  /*Main Character borderPage*/
		  if (x < 0) {
			  
			  velX = 0;
			  x = 0;
		  }
		  if (x > 930) {
			  
			  velX = 0;
			  x = 930;
		  }
		  if (y < 0) {
			  
			  velY = 0;
			  y = 0;
		  }
		  if(y > 630) {
			  
			  velY = 0;
			  y = 630;
		  }
		  
		  
		  
		  
		  /*Ennemie borderPage*/
		  
		  
		  if (ennemie1X < 0 || ennemie1X > 950) {
			  
			  velT = -velT;
		  }
		  
		  if (ennemie1Y < 0 || ennemie1Y > 650) {
			  
			  velC = -velC;
		  }
		  
		  
		  
		  
		  if (ennemie2X < 0 || ennemie2X > 950) {
			  
			  velT2 = -velT2;
		  }
		  
		  if (ennemie2Y < 0 || ennemie2Y > 650) {
			  
			  velC2 = -velC2;
		  }
		  
		  
		  
		  if (ennemie3X < 0 || ennemie3X > 950) {
			  
			  velT3 = -velT3;
		  }
		  
		  if (ennemie3Y < 0 || ennemie3Y > 650) {
			  
			  velC3 = -velC3;
		  }
		  
		  
		  if (ennemie4X < 0 || ennemie4X > 950) {
			  
			  velT4 = -velT4;
		  }
		  
		  if (ennemie4Y < 0 || ennemie4Y > 650) {
			  
			  velC4 = -velC4;
		  }
		  
		 
		  /*Mario*/
		  x = x + velX;
		  y = y + velY;
		 
		  
		  
		  /*Ennemie*/
		  ennemie1X = ennemie1X + velT;
		  ennemie1Y = ennemie1Y + velC;
		  
		  ennemie2X = ennemie2X+ velT2;
		  ennemie2Y = ennemie2Y + velC2;
		  
		  ennemie3X = ennemie3X+ velT3;
		  ennemie3Y = ennemie3Y + velC3;
		  
		  ennemie4X = ennemie4X+ velT4;
		  ennemie4Y = ennemie4Y + velC4;
		  
		  
		  
		  /*Missile*/  
		  bx = bx + velBX ;

		  if (bx > 1000) {
			  
			  missile = null;
		  }
		  
		 
		  
		  if (x > ennemie1X && x < ennemie1X + 40 && y > ennemie1Y && y < ennemie1Y + 47) {
			  
				//Condition temp du beug
					
				GameOver endGame = new GameOver();

				System.out.println("mort");
		  }
		  if (x > ennemie2X && x < ennemie2X + 40 && y > ennemie2Y && y < ennemie2Y + 47) {
			  
			  if (killed1) {
				  GameOver endGame = new GameOver();
			  }
			
		  }
		  if (x > ennemie3X && x < ennemie3X + 40 && y > ennemie3Y && y < ennemie3Y + 47 || x > ennemie4X && x < ennemie4X + 40 && y > ennemie4Y && y < ennemie4Y + 47) {
			
			  if (killed2) {
				  GameOver endGame = new GameOver();
			  }
			
		  }
		  
		  
		  
		  
		  /*Si je touche un ennemie*/
		  if (bx > ennemie1X && bx < ennemie1X + 40 && by > ennemie1Y && by < ennemie1Y + 47) {
			  
			  killed1 = true;
			  ennemie1X = 1000000;
			  ennemie1Y = 1000000;
			 
			  System.out.println("toucher");
		  }
		  if (bx > ennemie2X && bx < ennemie2X + 45 && by > ennemie2Y && by < ennemie2Y + 53) {
			  
			  killed2 = true;
			  
			  ennemie2X = 1000000;
			  ennemie2Y = 1000000; 
		  }
		  
		  
		  
		 
			  
		  if (bx > ennemie3X && bx < ennemie3X + 45 && by > ennemie3Y && by < ennemie3Y + 50) {
				  
			  killed3 = true;
				  
				  
			  ennemie3X = 1000000;
			  ennemie3Y = 1000000; 
		  }
			  
		  if (bx > ennemie4X && bx < ennemie4X + 45 && by > ennemie4Y && by < ennemie4Y + 50) {
				  
			  killed4 = true;
				  
			  ennemie4X = 1000000;
			  ennemie4Y = 1000000; 
		  }
				  
			  
	  
		  if (killed3 && killed4) {
			  Win win = new Win();
		  }
	  
		  repaint(); 
	  }
	  
	  
	  
	  
	  
	  public void keyPressed(KeyEvent e) {
		  
		  int sens;
		  int c = e.getKeyCode();
		  
		  if (c == KeyEvent.VK_SPACE) {
	            if (missile == null) {
	            	
	            	readyToFire = true;
	            	by = y+10;
	            	bx = x+20;
	   
	            }
	            if (readyToFire) {
	            	
	            	velBX = 6;
	            	shot = true;
	            }
	
	        }
		  
		  if(c == KeyEvent.VK_LEFT) {
			
			  velX = -4;
			  velY = 0;
		  }
		  if(c == KeyEvent.VK_RIGHT) {
			
			  velX = 4;
			  velY = 0;
		  }
		  if(c == KeyEvent.VK_UP) {
			  velX = 0;
			  velY = -4;
		  }
		  if(c == KeyEvent.VK_DOWN) {
			  velX = 0;
			  velY = 4;
		  }
		  
	  }
	  
	  public void keyTyped(KeyEvent e) {
		  
	  }
	  public void keyReleased(KeyEvent e) {

		  velX = 0;
		  velY = 0;
		  
	  }
	  
	  
	  
	  
	  
	  
}
