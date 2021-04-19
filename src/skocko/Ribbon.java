package skocko;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JToolBar;

/**
 * @author Milos
 */
public class Ribbon extends JToolBar {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static SelectFigureAction FigureACTION = new SelectFigureAction();

	public static MyButton HEART = new MyButton(new ImageIcon("icons/heart.png"), "heart", 0, FigureACTION, Color.LIGHT_GRAY);
	public static MyButton STAR = new MyButton(new ImageIcon("icons/star.png"), "star", 1, FigureACTION, Color.LIGHT_GRAY);
	public static MyButton ROCKET = new MyButton(new ImageIcon("icons/rocket.png"), "rocket", 2, FigureACTION, Color.LIGHT_GRAY);
	public static MyButton NINJA = new MyButton(new ImageIcon("icons/ninja.png"), "ninja", 3, FigureACTION, Color.LIGHT_GRAY);
	public static MyButton WMELON = new MyButton(new ImageIcon("icons/wmelon.png"), "wmelon", 4, FigureACTION, Color.LIGHT_GRAY);
	public static MyButton BALL = new MyButton(new ImageIcon("icons/ball.png"), "ball", 5, FigureACTION, Color.LIGHT_GRAY);

	public static MyButton APPROVE = new MyButton(new ImageIcon("icons/approve.png"), new ApproveAction(), Color.LIGHT_GRAY);
	public static MyButton UNDO = new MyButton(new ImageIcon("icons/undo.png"), new UndoAction(), Color.LIGHT_GRAY);
	public static MyButton UndoALL = new MyButton(new ImageIcon("icons/undoAll.png"), new UndoAllAction(), Color.LIGHT_GRAY);

	public static ArrayList<MyButton> BUTTONS = new ArrayList<MyButton>();
	public static HashMap<MyButton, String> smallIconsMap = new HashMap<MyButton, String>();

	public Ribbon() {

		setFloatable(false);
		setBackground(Color.DARK_GRAY);

		BUTTONS.add(HEART);
		BUTTONS.add(STAR);
		BUTTONS.add(ROCKET);
		BUTTONS.add(NINJA);
		BUTTONS.add(WMELON);
		BUTTONS.add(BALL);
		BUTTONS.add(APPROVE);
		BUTTONS.add(UNDO);
		BUTTONS.add(UndoALL);

		smallIconsMap.put(HEART, "icons/urkeS.png");
		smallIconsMap.put(STAR, "icons/coaS.png");
		smallIconsMap.put(ROCKET, "icons/stevaS.png");
		smallIconsMap.put(NINJA, "icons/irenaS.png");
		smallIconsMap.put(WMELON, "icons/zekaS.png");
		smallIconsMap.put(BALL, "icons/perisaS.png");

		add(HEART);
		addSeparator();
		add(STAR);
		addSeparator();
		add(ROCKET);
		addSeparator();
		add(NINJA);
		addSeparator();
		add(WMELON);
		addSeparator();
		add(BALL);
		addSeparator(new Dimension(50, 0));
		add(APPROVE);
		addSeparator();
		add(UNDO);
		addSeparator();
		add(UndoALL);
	}

}
