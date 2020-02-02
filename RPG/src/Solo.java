import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class Solo extends Game {
		
	public Solo() {		
		
		

		/*panSolo.setLayout(new OverlayLayout(panSolo));
		panSolo.add(enn);
		
		enn.add(pan);*/
		
		
		fen.setContentPane(new Player(0, 0));
		
		fen.getContentPane().setBackground(Color.BLACK);
		fen.revalidate();	
		
	}
	
}
