package skocko;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Milos
 */
public class UndoAllAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UndoAllAction() {
		putValue(SMALL_ICON, new ImageIcon("icons/removeAll.png"));
		putValue(SHORT_DESCRIPTION, "Undo all moves in current row");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (Util.CURRENT_TRY==0 || Util.CURRENT_ROW >= Util.MAX_TRIES ||
				Util.TimeIsUp) { 
			return;
		}
		
		JPanel pnl = Util.getCurrentRowPanel();
		
		for (int i=Util.CURRENT_TRY; i > 0; i--) {
			((JLabel)pnl.getComponent(i-1)).setIcon(new ImageIcon("icons/grey.png"));
		}
		
		Util.CURRENT_TRY = 0;
		
		
	}

}
