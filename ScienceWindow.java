// ScienceWindow.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class ScienceWindow extends JFrame
{
	private CommandsPanel parent;

	private JLabel num_days;
	private JLabel invalid_command;

	private JTextField textfield1;

	private JButton okay;
	private JButton close;

	private String science_text;

	public ScienceWindow(CommandsPanel panel)
	{
		parent = panel;

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		num_days = new JLabel("<html><div align = \"right\">Number of days<br>to travel time:</div></html>");
		num_days.setForeground(Color.WHITE);
		num_days.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield1 = new JTextField();
		textfield1.setToolTipText("The number of days can be 0, positive, or negative.");

		invalid_command = new JLabel("Please fill in all fields.");
		invalid_command.setForeground(Color.DARK_GRAY.brighter());
		invalid_command.setFont(new Font("Sans Serif", Font.BOLD, 12));

		okay = new JButton("OK");
		initializeButton(okay, "Click to add the time travel attempt to the commands window.");
		okay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{	
				String param1 = textfield1.getText();

				if(!param1.equals("") && param1.matches("^[+-]?\\d+$"))
				{
					science_text = "SCIENCE " + param1;
					parent.returnText(science_text);
					setVisible(false);
				}
				else if(!param1.equals("") && !param1.matches("^[+-]?\\d+$"))
				{
					invalid_command.setText("Number of days should be an integer.");
					invalid_command.setForeground(new Color(255, 17, 17));
				}
				else
				{
					invalid_command.setText("Please fill in all fields.");
					invalid_command.setForeground(new Color(255, 17, 17));
				}

			}
		});

		close = new JButton("Cancel");
		initializeButton(close, "Click to cancel the time travel attempt.");
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
		add(num_days, gc);

		gc.ipadx = 150;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 0;
		add(textfield1, gc);

		gc.weighty = 0.2;
		gc.ipadx = 1;
		gc.fill = GridBagConstraints.BASELINE;
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridwidth = 2;
		gc.gridy = 2;
		add(invalid_command, gc);

		gc.anchor = GridBagConstraints.PAGE_END;
		gc.insets = new Insets(5, 30, 5, 30); // top, left, bottom, right
		gc.gridwidth = 1;

		gc.ipadx = 1;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 3;
		add(okay, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 3;
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