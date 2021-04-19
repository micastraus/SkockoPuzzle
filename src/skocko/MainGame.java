package skocko;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.Player;

/**
 * @author Milos
 */
public class MainGame {

	public static GameFrame game;
	public static Player player;
	

	public static void main(String[] args) {		
		
		game = new GameFrame();
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Util.generatePattern();

		JFrame temp = new JFrame();
		temp.setLayout(new FlowLayout(FlowLayout.CENTER));
		temp.setLocationRelativeTo(null);
		temp.setVisible(true);
		temp.getContentPane().setBackground(Color.black);
		temp.setSize(240, 80);
		JLabel lbl = new JLabel("Launching...Please wait...");
		lbl.setFont(new Font("Arial", 1, 16));
		lbl.setForeground(Color.GREEN);
		temp.add(lbl);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

//		FileInputStream fis = null;
		try {
//			fis = new FileInputStream("audio/mk.mp3");
//			player = new Player(fis);
			temp.dispose();
			game.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int count = 0;
		
		while (true) {
			
			if (Util.ResenPATTERN || Util.TimeIsUp || Util.CURRENT_ROW>5) {
				synchronized(MainGame.class) {
					try {
						MainGame.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				continue;
			}	
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			GameFrame.TimeLeftLabel.setText("" + (--Util.TIME));
			SwingUtilities.updateComponentTreeUI(GameFrame.TimeLeftLabel);
			if (Util.TIME == 0) {
				Util.TimeIsUp = true;
				Util.disableButtons();
				Util.showPattern();
			}
	
		}


	}

}
