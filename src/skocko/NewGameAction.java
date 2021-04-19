package skocko;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 *
 * @author Milos
 */
public class NewGameAction extends AbstractAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {

		MainGame.game.remove(GameFrame.PnlCENTER);
		MainGame.game.remove(GameFrame.PnlSOUTH);
		MainGame.game.remove(GameFrame.PnlEAST);

		Util.ResenPATTERN = false;
		Util.TimeIsUp = false;
		Util.CURRENT_ROW=0;
		Util.CURRENT_TRY=0;
		Util.TIME = Util.GameTime;
		Util.enableButtons();

		if (e.getActionCommand().equals(GameFrame.chamberOfGodsItem.getText())) {
//			Ribbon.HEART.setIcon(new ImageIcon("icons/urke.png"));
//			Ribbon.HEART.setToolTipText("Raiden");
//			Ribbon.STAR.setIcon(new ImageIcon("icons/coa.png"));
//			Ribbon.STAR.setToolTipText("Liu Kang");
//			Ribbon.ROCKET.setIcon(new ImageIcon("icons/steva.png"));
//			Ribbon.ROCKET.setToolTipText("Johny Cage");
//			Ribbon.NINJA.setIcon(new ImageIcon("icons/irena.png"));
//			Ribbon.NINJA.setToolTipText("Sonya Blade");
//			Ribbon.WMELON.setIcon(new ImageIcon("icons/zeka.png"));
//			Ribbon.WMELON.setToolTipText("Shinock");
//			Ribbon.BALL.setIcon(new ImageIcon("icons/perisa.png"));
//			Ribbon.BALL.setToolTipText("Shao Khan");
//			Util.playAudio();
		}
		
//		else {
//			if (MainGame.player != null) {
//				MainGame.player.close();
//			}
//		}

//		else {
			Ribbon.HEART.setIcon(new ImageIcon("icons/heart.png"));
			Ribbon.STAR.setIcon(new ImageIcon("icons/star.png"));
			Ribbon.ROCKET.setIcon(new ImageIcon("icons/rocket.png"));
			Ribbon.NINJA.setIcon(new ImageIcon("icons/ninja.png"));
			Ribbon.WMELON.setIcon(new ImageIcon("icons/wmelon.png"));
			Ribbon.BALL.setIcon(new ImageIcon("icons/ball.png"));
//			Util.MusicOn = false;
//		}

		MainGame.game.initialiseComponents();
		SwingUtilities.updateComponentTreeUI(MainGame.game);

		Util.generatePattern();
		
		synchronized(MainGame.class) {
			MainGame.class.notify();
		}
		
	}

}
