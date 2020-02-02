import java.awt.Color;

import javax.swing.JLabel;

public class Win extends Solo {
	

	private JLabel trayAgain = new JLabel("Win"); 
	
	
	public Win() {
		
		
		fen.getContentPane().setBackground(Color.GREEN);
		
		
		trayAgain.setSize(20, 10);
		fen.setContentPane(trayAgain);
	}
	

}
