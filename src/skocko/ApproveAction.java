package skocko;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Milos aka JB
 */
public class ApproveAction extends AbstractAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ApproveAction() {
		putValue(SMALL_ICON, new ImageIcon("icons/approve.png"));
		putValue(SHORT_DESCRIPTION, "Approve current row combination");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Ne radi nista ukoliko:
		// Nisu sva polja u jednom redu popunjena
		// ili ako je popunjeno svih 6 redova
		if (Util.tryShape() || Util.CURRENT_ROW >= Util.MAX_TRIES ||
				Util.TimeIsUp) {
			return;
		}

		// Logika za poredjenje paterna sa figurama unetim u red

		int[] found = new int[Util.PATTERN_LENGTH];
		int k=0;

		int[] patern = new int[Util.SHAPES.length];
		int[] igrac = new int[Util.SHAPES.length];
		// oko 05:00AM -> O(n^2), ali moze u O(nlogn). O(n) ?
		// edit u 14:35PM, moze i u O(n)
		for (int i=0; i<Util.PATTERN_LENGTH; i++) {
			if (Util.PATTERN[i].getId() == Util.MyPATTERN[i].getId()) {
				found[k++] = -2;
				continue;
			}
			patern[Util.PATTERN[i].getId()]++;
			igrac[Util.MyPATTERN[i].getId()]++;
		}

		int istiAliNepodudarni = 0;
		for(int i=0; i<Util.SHAPES.length; i++) {
			istiAliNepodudarni += Math.min(patern[i], igrac[i]);
		}

		for (int i=0; i<istiAliNepodudarni; i++) {
			found[k++] = -1;
		}

		JPanel pnl = Util.getCurrentRowPanel();

		// Postavljanje rezultata potvrdjenog reda
		for (int i=0; i<k; i++) { // idemo do 'k', jer je 'k' broj elemnata koji su isti
			if (found[i] == -2) {
				((JLabel)pnl.getComponent(Util.PATTERN_LENGTH+i+1)).setIcon(new ImageIcon("icons/happy.png"));
				// +1 jer u cloningRow panel iz GameFrame klase smo ubacivali razmak
				// izmedju levih i desnih labela -> cloningRow.add(Box.createHorizontalStrut(50));
			}
			else if (found[i] == -1) {
				((JLabel)pnl.getComponent(Util.PATTERN_LENGTH+i+1)).setIcon(new ImageIcon("icons/sad.png"));
				// +1 jer u cloningRow panel iz GameFrame klase smo ubacivali razmak
				// izmedju levih i desnih labela -> cloningRow.add(Box.createHorizontalStrut(50));
			}
		}

		if (k==4 && found[k-1]==-2) { // Znaci da je pogodjen pattern -> POBEDA
			Util.ResenPATTERN = true;
//			GameFrame.chamberOfGodsItem.setEnabled(true);
		}

		// Ispisivanje resenja ukoliko je resenje pogodjeno ili ukoliko smo ostali bez pokusaja
		if (Util.ResenPATTERN || Util.CURRENT_ROW == Util.MAX_TRIES-1) {
			Util.disableButtons();
			Util.showPattern();
//			if (MainGame.player != null) {
//				MainGame.player.close();
//			}
		}

		Util.CURRENT_ROW++;
		Util.CURRENT_TRY = 0; // Jer smo presli u novi red
	}

}
