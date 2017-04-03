import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameViewer extends JFrame{

	/**
	 * @param args
	 */
	

		
	public static void main(String[] args) 
	{	
		GameViewer window = new GameViewer();
		JPanel p = new JPanel();
        p.add(new GamePanel());  //  add a class that extends JPanel
        window.setTitle("MixMaxMoe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        window.setContentPane(p);
        
       
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
	}

}