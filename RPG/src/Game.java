import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game{
	
	JFrame fen = new JFrame("Menu");
	
	// Tout les panels
	public JPanel panMenu = new JPanel();
	public JPanel panSolo = new JPanel();
	public JPanel panMulti = new JPanel();

	
	// Bouton du menu
	private JButton exit = new JButton("EXIT");
	private JButton multi = new JButton("MULTIPLAYER");
	public JButton solo = new JButton("SOLO");



	
	public Game() {
		
		
		exit.setBackground(Color.BLACK);
		solo.setBackground(Color.BLACK);
		multi.setBackground(Color.BLACK);

		
		fen.setTitle("MyGame");
		fen.setSize(1000, 700);
		fen.setLocationRelativeTo(null);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fen.setLayout(new GridLayout(0, 3));
		
		
		fen.getContentPane().add(solo);
		fen.getContentPane().add(multi);
		fen.getContentPane().add(exit);
		
		
		
		
		// Redirection des menu
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		  
		solo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Solo solo = new Solo();
				fen.setVisible(false);
			}
		});
		
		
		
		multi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fen.setContentPane(panMulti);
				fen.revalidate();
			}
		});
			

		
		fen.setVisible(true);
		
	}
		

}
