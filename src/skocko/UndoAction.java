package skocko;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Milos
 */
public class UndoAction extends AbstractAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public UndoAction() {
		putValue(SMALL_ICON, new ImageIcon("icons/undo.png"));
		putValue(SHORT_DESCRIPTION, "Undo last move");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Util.CURRENT_TRY==0 || Util.CURRENT_ROW >= Util.MAX_TRIES ||
				Util.TimeIsUp) {
			return;
		}

		Util.CURRENT_TRY--;

		JPanel pnl = Util.getCurrentRowPanel();
		((JLabel)pnl.getComponent(Util.CURRENT_TRY)).setIcon(new ImageIcon("icons/grey.png"));
	}

}
