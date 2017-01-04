// BuildWindow.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class BuildWindow extends JFrame
{
	private CommandsPanel parent;

	private JLabel post_office;
	private JLabel transit_time;
	private JLabel postage_required;
	private JLabel capacity;
	private JLabel persuasion_amount;
	private JLabel length;
	private JLabel invalid_command;

	private JTextField textfield1;
	private JTextField textfield2;
	private JTextField textfield3;
	private JTextField textfield4;
	private JTextField textfield5;
	private JTextField textfield6;

	private JButton okay;
	private JButton close;

	private String build_text;

	public BuildWindow(CommandsPanel panel)
	{
		parent = panel;

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		post_office = new JLabel("Name of the post office:");
		post_office.setForeground(Color.WHITE);
		post_office.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield1 = new JTextField();
		textfield1.setToolTipText("Enter the name of the new post office.");

		transit_time = new JLabel("Transit Time:");
		transit_time.setForeground(Color.WHITE);
		transit_time.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield2 = new JTextField();
		textfield2.setToolTipText("Enter the number of days for transit to deliver items.");

		postage_required = new JLabel("Postage Required:");
		postage_required.setForeground(Color.WHITE);
		postage_required.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield3 = new JTextField();
		textfield3.setToolTipText("Enter the amount of postage required.");

		capacity = new JLabel("Capacity:");
		capacity.setForeground(Color.WHITE);
		capacity.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield4 = new JTextField();
		textfield4.setToolTipText("Enter the maximum capacity of the post office.");

		persuasion_amount = new JLabel("Persuasion Amount:");
		persuasion_amount.setForeground(Color.WHITE);
		persuasion_amount.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield5 = new JTextField();
		textfield5.setToolTipText("Enter the post office's valid persuasion amount.");

		length = new JLabel("Maximum Package Length:");
		length.setForeground(Color.WHITE);
		length.setFont(new Font("Sans Serif", Font.PLAIN, 12));

		textfield6 = new JTextField();
		textfield6.setToolTipText("Enter the post office's maximum package length.");

		invalid_command = new JLabel("Please fill in all fields.");
		invalid_command.setForeground(Color.DARK_GRAY.brighter());
		invalid_command.setFont(new Font("Sans Serif", Font.BOLD, 12));

		okay = new JButton("OK");
		initializeButton(okay, "Click to add the build attempt to the commands window.");
		okay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{	
				String param1 = textfield1.getText();
				String param2 = textfield2.getText();
				String param3 = textfield3.getText();
				String param4 = textfield4.getText();
				String param5 = textfield5.getText();
				String param6 = textfield6.getText();

				

				try
				{
					if(!param1.equals("") && !param2.equals("") && !param3.equals("") && !param4.equals("") && !param5.equals("")
						&& param2.matches("^[+-]?\\d+$") && Integer.parseInt(param2) >= 0
						&& param3.matches("^[+-]?\\d+$") && Integer.parseInt(param3) >= 0
						&& param4.matches("^[+-]?\\d+$") && Integer.parseInt(param4) >= 0
						&& param5.matches("^[+-]?\\d+$") && Integer.parseInt(param5) >= 0
						&& param6.matches("^[+-]?\\d+$") && Integer.parseInt(param6) >= 0)
					{
						build_text = "BUILD " + param1 + " " + param2 + " " + param3 + " " + param4 + " " + param5 + " " + param6;
						parent.returnText(build_text);
						setVisible(false);
					}
					else if(!param2.equals("") && !param2.matches("^[+-]?\\d+$") ||
							!param2.equals("") && param2.matches("^[+-]?\\d+$") && Integer.parseInt(param2) < 0)
					{
						invalid_command.setText("Transit time should be a positive integer.");
						invalid_command.setForeground(new Color(255, 17, 17));
					}
					else if(!param3.equals("") && !param3.matches("^[+-]?\\d+$") ||
							!param3.equals("") && param3.matches("^[+-]?\\d+$") && Integer.parseInt(param3) < 0)
					{
						invalid_command.setText("Postage should be a positive integer.");
						invalid_command.setForeground(new Color(255, 17, 17));
					}
					else if(!param4.equals("") && !param4.matches("^[+-]?\\d+$") ||
							!param4.equals("") && param4.matches("^[+-]?\\d+$") && Integer.parseInt(param4) < 0)
					{
						invalid_command.setText("Capacity should be a positive integer.");
						invalid_command.setForeground(new Color(255, 17, 17));
					}
					else if(!param5.equals("") && !param5.matches("^[+-]?\\d+$") || 
							!param5.equals("") && param5.matches("^[+-]?\\d+$") && Integer.parseInt(param5) < 0)
					{
						invalid_command.setText("Persuasion amount should be a positive integer.");
						invalid_command.setForeground(new Color(255, 17, 17));
					}
					else if(!param6.equals("") && !param6.matches("^[+-]?\\d+$") ||
							!param6.equals("") && param6.matches("^[+-]?\\d+$") && Integer.parseInt(param6) < 0)
					{
						invalid_command.setText("Max. package length should be a positive integer.");
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
		initializeButton(close, "Click to cancel the build attempt.");
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
		add(transit_time, gc);

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
		add(postage_required, gc);

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
		add(capacity, gc);

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
		add(persuasion_amount, gc);

		gc.ipadx = 150;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 4;
		add(textfield5, gc);

		gc.ipadx = 1;
		gc.fill = GridBagConstraints.BASELINE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 5;
		add(length, gc);

		gc.ipadx = 150;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 5;
		add(textfield6, gc);

		gc.weighty = 0.2;
		gc.ipadx = 1;
		gc.fill = GridBagConstraints.BASELINE;
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridwidth = 2;
		gc.gridy = 6;
		add(invalid_command, gc);
		gc.gridwidth = 1;

		gc.anchor = GridBagConstraints.PAGE_END;
		gc.insets = new Insets(5, 30, 5, 30); // top, left, bottom, right

		gc.ipadx = 1;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 7;
		add(okay, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 7;
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