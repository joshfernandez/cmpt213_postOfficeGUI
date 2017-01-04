// PickUpWindow.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class PickUpWindow extends JFrame
{
	private CommandsPanel parent;

	private JLabel post_office;
	private JLabel recipient;
	private JLabel invalid_command;

	private JTextField textfield1;
	private JTextField textfield2;

	private JButton okay;
	private JButton close;

	private String pickup_text;

	public PickUpWindow(CommandsPanel panel)
	{
		parent = panel;

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		post_office = new JLabel("Post Office:");
		post_office.setForeground(Color.WHITE);
		post_office.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield1 = new JTextField();
		textfield1.setToolTipText("Enter the name of the targeted post office for pickup.");

		recipient = new JLabel("Recipient of the pickup:");
		recipient.setForeground(Color.WHITE);
		recipient.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield2 = new JTextField();
		textfield2.setToolTipText("Enter the name of the person attempting the pickup.");

		invalid_command = new JLabel("Please fill in all fields.");
		invalid_command.setForeground(Color.DARK_GRAY.brighter());
		invalid_command.setFont(new Font("Sans Serif", Font.BOLD, 12));

		okay = new JButton("OK");
		initializeButton(okay, "Click to add the pickup attempt to the commands window.");
		okay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{	
				String param1 = textfield1.getText();
				String param2 = textfield2.getText();

				if(!param1.equals("") && !param2.equals(""))
				{
					pickup_text = "PICKUP " + param1 + " " + param2;
					parent.returnText(pickup_text);
					setVisible(false);
				}
				else
				{
					invalid_command.setForeground(new Color(255, 17, 17));
				}

			}
		});

		close = new JButton("Cancel");
		initializeButton(close, "Click to cancel the pickup attempt.");
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
		add(post_office, gc);

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
		add(recipient, gc);

		gc.ipadx = 150;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 1;
		add(textfield2, gc);

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