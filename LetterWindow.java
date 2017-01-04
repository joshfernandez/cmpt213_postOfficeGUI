// LetterWindow.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class LetterWindow extends JFrame
{
	private CommandsPanel parent;

	private JLabel sending_post_office;
	private JLabel addresser;
	private JLabel receiving_post_office;
	private JLabel addressee;
	private JLabel invalid_command;

	private JTextField textfield1;
	private JTextField textfield2;
	private JTextField textfield3;
	private JTextField textfield4;

	private JButton okay;
	private JButton close;

	private String letter_text;

	public LetterWindow(CommandsPanel panel)
	{
		parent = panel;

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		sending_post_office = new JLabel("Sending post office:");
		sending_post_office.setForeground(Color.WHITE);
		sending_post_office.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield1 = new JTextField();
		textfield1.setToolTipText("Enter the name of the post office to which the letter was brought.");

		addresser = new JLabel("Letter's recipient:");
		addresser.setForeground(Color.WHITE);
		addresser.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield2 = new JTextField();
		textfield2.setToolTipText("Enter the name of the letter's recipient.");

		receiving_post_office = new JLabel("Receiving post office:");
		receiving_post_office.setForeground(Color.WHITE);
		receiving_post_office.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield3 = new JTextField();
		textfield3.setToolTipText("Enter the name of the destination post office.");

		addressee = new JLabel("Letter's return sender:");
		addressee.setForeground(Color.WHITE);
		addressee.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield4 = new JTextField();
		textfield4.setToolTipText("<html>Enter the name of the letter's returning sender.<br>If you want the letter to have no return address, type \"NONE\".</html>");

		invalid_command = new JLabel("Please fill in all fields.");
		invalid_command.setForeground(Color.DARK_GRAY.brighter());
		invalid_command.setFont(new Font("Sans Serif", Font.BOLD, 12));

		okay = new JButton("OK");
		initializeButton(okay, "Click to add the letter attempt to the commands window.");
		okay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{	
				String param1 = textfield1.getText();
				String param2 = textfield2.getText();
				String param3 = textfield3.getText();
				String param4 = textfield4.getText();

				if(!param1.equals("") && !param2.equals("") && !param3.equals("") && !param4.equals(""))
				{
					letter_text = "LETTER " + param1 + " " + param2 + " " + param3 + " " + param4;
					parent.returnText(letter_text);
					setVisible(false);
				}
				else
				{
					invalid_command.setForeground(new Color(255, 17, 17));
				}
			}
		});

		close = new JButton("Cancel");
		initializeButton(close, "Click to cancel the letter attempt.");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
			}
		});

		gc.weightx = 0.5;
		gc.weighty = 0.5;

		gc.insets = new Insets(5, 5, 5, 5); // top, left, bottom, right

		gc.ipadx = 1;
		gc.ipady = 5;

		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 0;
		add(sending_post_office, gc);

		gc.ipadx = 150;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 0;
		add(textfield1, gc);

		gc.ipadx = 1;
		gc.fill = GridBagConstraints.BASELINE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 1;
		add(addresser, gc);

		gc.ipadx = 150;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 1;
		add(textfield2, gc);

		gc.ipadx = 1;
		gc.fill = GridBagConstraints.BASELINE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 2;
		add(receiving_post_office, gc);

		gc.ipadx = 150;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 2;
		add(textfield3, gc);

		gc.ipadx = 1;
		gc.fill = GridBagConstraints.BASELINE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 3;
		add(addressee, gc);

		gc.ipadx = 150;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 3;
		add(textfield4, gc);

		gc.weighty = 0.2;
		gc.ipadx = 1;
		gc.fill = GridBagConstraints.BASELINE;
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridwidth = 2;
		gc.gridy = 4;
		add(invalid_command, gc);

		gc.anchor = GridBagConstraints.PAGE_END;
		gc.insets = new Insets(5, 30, 5, 30); // top, left, bottom, right
		gc.gridwidth = 1;

		gc.ipadx = 1;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 5;
		add(okay, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 5;
		add(close, gc);
	}

	void initializeButton(JButton button, String text)
	{
		button.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		button.setBackground(new Color(40, 101, 243));
		button.setForeground(Color.BLACK);
		button.setToolTipText(text);
	}
}