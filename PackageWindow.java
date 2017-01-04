// PackageWindow.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class PackageWindow extends JFrame
{
	private CommandsPanel parent;

	private JLabel sending_post_office;
	private JLabel addresser;
	private JLabel receiving_post_office;
	private JLabel amount;
	private JLabel length;
	private JLabel invalid_command;

	private JTextField textfield1;
	private JTextField textfield2;
	private JTextField textfield3;
	private JTextField textfield4;
	private JTextField textfield5;

	private JButton okay;
	private JButton close;

	private String package_text;

	public PackageWindow(CommandsPanel panel)
	{
		parent = panel;

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		sending_post_office = new JLabel("Sending post office:");
		sending_post_office.setForeground(Color.WHITE);
		sending_post_office.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield1 = new JTextField();
		textfield1.setToolTipText("Enter the name of the post office to which the package was brought.");

		addresser = new JLabel("Package's recipient:");
		addresser.setForeground(Color.WHITE);
		addresser.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield2 = new JTextField();
		textfield2.setToolTipText("Enter the name of the package's recipient.");

		receiving_post_office = new JLabel("Receiving post office:");
		receiving_post_office.setForeground(Color.WHITE);
		receiving_post_office.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield3 = new JTextField();
		textfield3.setToolTipText("Enter the name of the destination post office.");

		amount = new JLabel("Package's amount:");
		amount.setForeground(Color.WHITE);
		amount.setFont(new Font("Sans Serif", Font.PLAIN, 12));
		
		textfield4 = new JTextField();
		textfield4.setToolTipText("Enter the value of the package.");

		length = new JLabel("Package's length:");
		length.setForeground(Color.WHITE);
		length.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield5 = new JTextField();
		textfield5.setToolTipText("Enter the length of the package.");

		invalid_command = new JLabel("Please fill in all fields.");
		invalid_command.setForeground(Color.DARK_GRAY.brighter());
		invalid_command.setFont(new Font("Sans Serif", Font.BOLD, 12));

		okay = new JButton("OK");
		initializeButton(okay, "Click to add the package attempt to the commands window.");
		okay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{	
				String param1 = textfield1.getText();
				String param2 = textfield2.getText();
				String param3 = textfield3.getText();
				String param4 = textfield4.getText();
				String param5 = textfield5.getText();

				try
				{
					if(!param1.equals("") && !param2.equals("") && !param3.equals("") && !param4.equals("") && !param5.equals("")
						&& param4.matches("^[+-]?\\d+$") && Integer.parseInt(param4) >= 0
						&& param5.matches("^[+-]?\\d+$") && Integer.parseInt(param5) >= 0)
					{
						package_text = "PACKAGE " + param1 + " " + param2 + " " + param3 + " " + param4 + " " + param5;
						parent.returnText(package_text);
						setVisible(false);
					}
					else if(!param4.equals("") && !param4.matches("^[+-]?\\d+$") ||
							!param4.equals("") && param4.matches("^[+-]?\\d+$") && Integer.parseInt(param4) < 0)
					{
						invalid_command.setText("Package's amount should be a positive integer.");
						invalid_command.setForeground(new Color(255, 17, 17));
					}
					else if(!param5.equals("") && !param5.matches("^[+-]?\\d+$") || 
							!param5.equals("") && param5.matches("^[+-]?\\d+$") && Integer.parseInt(param5) < 0)
					{
						invalid_command.setText("Package's length should be a positive integer.");
						invalid_command.setForeground(new Color(255, 17, 17));
					}
					else
					{
						invalid_command.setText("Please fill in all fields.");
						invalid_command.setForeground(new Color(255, 17, 17));
					}
				}
				catch(NumberFormatException nfe)
				{
					invalid_command.setText("Please provide valid inputs.");
					invalid_command.setForeground(new Color(255, 17, 17));
				}

			}
		});

		close = new JButton("Cancel");
		initializeButton(close, "Click to cancel the package attempt.");
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
		add(amount, gc);

		gc.ipadx = 150;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 3;
		add(textfield4, gc);

		gc.ipadx = 1;
		gc.fill = GridBagConstraints.BASELINE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 4;
		add(length, gc);

		gc.ipadx = 150;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 4;
		add(textfield5, gc);

		gc.weighty = 0.2;
		gc.ipadx = 1;
		gc.fill = GridBagConstraints.BASELINE;
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridwidth = 2;
		gc.gridy = 5;
		add(invalid_command, gc);

		gc.anchor = GridBagConstraints.PAGE_END;
		gc.insets = new Insets(5, 30, 5, 30); // top, left, bottom, right
		gc.gridwidth = 1;

		gc.ipadx = 1;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 6;
		add(okay, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 6;
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