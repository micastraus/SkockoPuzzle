package skocko;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

public class MyButton extends JButton {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	public MyButton(Icon icon, String command, int id, ActionListener listener, Color backgroundColor) {
		this.id = id;
		setIcon(icon);
		setActionCommand(command);

		addActionListener(listener);
		setBackground(backgroundColor);
	}

	public MyButton(Icon icon, ActionListener listener, Color backGroundColor) {
		setIcon(icon);
		addActionListener(listener);
		setBackground(backGroundColor);
	}

	public int getId() {
		return id;
	}


}
