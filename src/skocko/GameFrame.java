package skocko;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import net.miginfocom.swing.MigLayout;

/**
 * @author Milos
 */
public class GameFrame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static JPanel PnlCENTER;
	public static JPanel PnlSOUTH;
	public static JPanel pnlSouthEast;
	public static JPanel PnlEAST;
	public static JLabel TimeLeftLabel;
	public static HashMap<Integer, JPanel> panelsMap = new HashMap<Integer, JPanel>();
	public static JMenu FileMENU = new JMenu("File");
	public static JMenuItem chamberOfGodsItem;

	public GameFrame() {
		setTitle("Trajla be, Trajla be, Refko i Combe bacaju bombe");
		setSize(900, 700);
		setLocationRelativeTo(null);

		// Meni bar
		JMenuBar bar = new JMenuBar();

		JMenu newGameItem = new JMenu("New Game...");

		JMenuItem regular = new JMenuItem("Regular");
		chamberOfGodsItem = new JMenuItem("Enter Chamber of Gods...");
		chamberOfGodsItem.setIcon(new ImageIcon("icons/dragon.png"));
		chamberOfGodsItem.setHorizontalTextPosition(SwingConstants.LEFT);
		chamberOfGodsItem.setEnabled(false);

		NewGameAction newGame = new NewGameAction();
		regular.addActionListener(newGame);
		chamberOfGodsItem.addActionListener(newGame);

		newGameItem.add(regular);
		newGameItem.addSeparator();
		newGameItem.add(chamberOfGodsItem);

		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ExitAction());

		FileMENU.add(newGameItem);
		FileMENU.addSeparator();
		FileMENU.add(exitItem);
		bar.add(FileMENU);
		setJMenuBar(bar);

		// Toolbar
		Ribbon r = new Ribbon();
		add(r, BorderLayout.NORTH);

		initialiseComponents();
	}

	public void initialiseComponents() {

		// Glavni panel
		Border border = BorderFactory.createDashedBorder(Color.BLACK, 2, 1, 0, false);
		PnlCENTER = new JPanel(new MigLayout());
		PnlCENTER.setPreferredSize(new Dimension(600, 300));
		PnlCENTER.setBackground(Color.LIGHT_GRAY);

		JPanel inCenter = new JPanel(new MigLayout());
		inCenter.setPreferredSize(new Dimension(430, 350));
		inCenter.setBorder(border);
		inCenter.setBackground(Color.LIGHT_GRAY);

		for (int j = 0; j < 6; j++) {
			JPanel cloningRow = new JPanel(new MigLayout());
			cloningRow.setBackground(Color.LIGHT_GRAY);
			cloningRow.setPreferredSize(new Dimension(680, 50));

			for (int i = 0; i < 4; i++) {
				JLabel lbl = new JLabel(new ImageIcon("icons/grey.png"));
				cloningRow.add(lbl);
			}

			cloningRow.add(Box.createHorizontalStrut(50));

			for (int i = 0; i < 4; i++) {
				JLabel lbl = new JLabel(new ImageIcon("icons/black.png"));
				cloningRow.add(lbl);
			}

			panelsMap.put(j, cloningRow);

			inCenter.add(cloningRow, "wrap");
		}

		PnlCENTER.add(inCenter);

		add(PnlCENTER, BorderLayout.CENTER);

		JLabel lblTimeText = new JLabel("TIME");
		lblTimeText.setForeground(Color.DARK_GRAY);
		lblTimeText.setFont(new Font("Courier New", 1, 50));

		TimeLeftLabel = new JLabel(Util.TIME + "");
		TimeLeftLabel.setBackground(Color.LIGHT_GRAY);
		TimeLeftLabel.setForeground(Color.RED);
		TimeLeftLabel.setFont(new Font("Courier New", 1, 100));

		JPanel pnlEastNorth;
		PnlEAST = new JPanel(new MigLayout());
//		if (!Util.MusicOn) {
			pnlEastNorth = new JPanel(new MigLayout());
			pnlEastNorth.add(lblTimeText, "wrap");
			pnlEastNorth.setPreferredSize(new Dimension(150, 150));
			pnlEastNorth.setBackground(Color.LIGHT_GRAY);

			pnlEastNorth.add(TimeLeftLabel);
			pnlEastNorth.setBorder(border);
			PnlEAST = new JPanel(new MigLayout());
			PnlEAST.setPreferredSize(new Dimension(310, 310));
			PnlEAST.setBackground(Color.LIGHT_GRAY);
			PnlEAST.add(pnlEastNorth, "wrap");
//		}

//		else {
//			PnlEAST = new JPanel(new FlowLayout(FlowLayout.CENTER));
//			PnlEAST.setPreferredSize(new Dimension(310, 310));
//			PnlEAST.setBackground(Color.LIGHT_GRAY);
//			JLabel mkLbl = new JLabel(new ImageIcon("icons/mkk.png"));
//			mkLbl.setBackground(Color.LIGHT_GRAY);
//			PnlEAST.add(mkLbl);
//		}
		add(PnlEAST, BorderLayout.EAST);

		PnlSOUTH = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 15));
		PnlSOUTH.setPreferredSize(new Dimension(0, 100));
		PnlSOUTH.setBackground(Color.DARK_GRAY);
		PnlSOUTH.setToolTipText("Pattern will be revealed if you fail to find it at given time.");

		pnlSouthEast = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 15));
		pnlSouthEast.setBackground(Color.LIGHT_GRAY);
		pnlSouthEast.setPreferredSize(new Dimension(370, 70));

		JLabel lblPattern = new JLabel("PATTERN:");
		lblPattern.setForeground(Color.DARK_GRAY);
		lblPattern.setFont(new Font("Courier New", 1, 32));

		pnlSouthEast.add(lblPattern);

		for (int i = 0; i < 4; i++) {
			JLabel lbl = new JLabel(new ImageIcon("icons/black.png"));
			pnlSouthEast.add(lbl);
		}

		PnlSOUTH.add(pnlSouthEast);
		add(PnlSOUTH, BorderLayout.SOUTH);
	}

}
