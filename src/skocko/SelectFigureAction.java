package skocko;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * @author Milos
 */
public class SelectFigureAction extends AbstractAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {

		// Ne raditi nista ukoliko:
		// Nije moguce vise postavljati figure,
		// ili ako je popunjeno svih 6 redova
		// ili ako je igrac pogodio resenje (prikazana su 4 happy smajlija)
		if (Util.CURRENT_ROW >= Util.MAX_TRIES || !Util.tryShape()
				|| Util.ResenPATTERN || Util.TimeIsUp) {
			return;
		}

		JPanel pnl = Util.getCurrentRowPanel();
		MyButton btn = (MyButton)e.getSource();

//		if (Util.MusicOn) {
//			((JLabel) pnl.getComponent(Util.CURRENT_TRY)).setIcon(new ImageIcon(Ribbon.smallIconsMap.get(btn)));
//		}

//		else {
			((JLabel) pnl.getComponent(Util.CURRENT_TRY)).setIcon(btn.getIcon());
//		}

		SwingUtilities.updateComponentTreeUI(pnl);

		Util.MyPATTERN[Util.CURRENT_TRY] = btn;

		Util.CURRENT_TRY++;

	}
}
