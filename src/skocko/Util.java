package skocko;

import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @author Milos
 */
public class Util {

	public static final int MAX_TRIES = 6;
	public static final int PATTERN_LENGTH = 4;
	public static int CURRENT_TRY = 0;
	public static int CURRENT_ROW = 0;
	public static int TIME = 90;
	public static final int GameTime = 90;

	public static MyButton PATTERN[] = new MyButton[4];
	public static MyButton MyPATTERN[] = new MyButton[4];
	public static MyButton[] SHAPES = {Ribbon.NINJA, Ribbon.BALL, Ribbon.STAR,
			Ribbon.ROCKET, Ribbon.WMELON, Ribbon.HEART};

	public static boolean ResenPATTERN = false;
	public static boolean TimeIsUp = false;

	public static boolean tryShape() {
		if (CURRENT_TRY >= PATTERN_LENGTH) {
			return false;
		}
		return true;
	}

	public static void generatePattern() {
		for(int i=0; i<PATTERN_LENGTH; i++) {
			PATTERN[i] = SHAPES [new Random().nextInt(6)];
		}
	}

	public static JPanel getCurrentRowPanel() {
		JPanel pnl = GameFrame.panelsMap.get(Util.CURRENT_ROW);
		return pnl;
	}

	public static void enableButtons() {
		for (MyButton btn : Ribbon.BUTTONS) {
			btn.setEnabled(true);
		}
	}

	public static void disableButtons() {
		for (MyButton btn : Ribbon.BUTTONS) {
			btn.setEnabled(false);
		}
	}

	public static void showPattern() {
		for (int i=0; i<Util.PATTERN_LENGTH; i++) {
			JLabel lbl = (JLabel)GameFrame.pnlSouthEast.getComponent(i+1); // i+1 Jer je na nultom mestu string "Pattern:"
//			if (Util.MusicOn) {
//				lbl.setIcon(new ImageIcon(Ribbon.smallIconsMap.get(PATTERN[i])));
//			}
//			else {
				lbl.setIcon(Util.PATTERN[i].getIcon());
//			}
		}
	}

	public static void playAudio() {
		new Thread(new AudioThread()).start();
	}

}
