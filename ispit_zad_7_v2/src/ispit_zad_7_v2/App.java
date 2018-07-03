package ispit_zad_7_v2;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MainFrame();
				
			}
		});
	}

}
