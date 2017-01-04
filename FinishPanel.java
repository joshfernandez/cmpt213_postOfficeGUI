// FinishPanel.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.util.Scanner;

public class FinishPanel extends JPanel
{	
	MainFrame parent;
	JTextArea mainFrameTextArea;
	int mainFrameNumRows;

	JButton printButton;

	public FinishPanel(MainFrame frame)
	{
		parent = frame;
		mainFrameTextArea = frame.textArea;
		mainFrameNumRows = frame.num_rows;

		Dimension size = getPreferredSize();
		size.width = 1000;
		size.height = 500;
		setPreferredSize(size);

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		JButton importButton = new JButton("Import commands.txt");
		initializeButton(importButton, "Click to import the Commands text file into the program.");
		importButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					File file1 = new File("commands.txt");
					String baseDir = System.getProperty("user.dir");

					Scanner commands = new Scanner(file1);
					String text = "";
					int initial_size = Integer.parseInt(commands.nextLine());
					int actual_size = 0;

					while(commands.hasNext())
					{
						String input = commands.nextLine();
						text = text + input + "\n";
						actual_size++;
					}

					if(initial_size == actual_size)
					{
						parent.set_text_of_text_area(text, actual_size);
					}
					else
					{
						JOptionPane.showMessageDialog(parent,
													  "The size is commands.txt is incorrect! Please change this.",
													  "Commands Size Warning",
													  JOptionPane.WARNING_MESSAGE);
					}

					commands.close();
				}
				catch(IOException ioe)
				{
					JOptionPane.showMessageDialog(parent,
												  "The commands text file is not found.",
												  "Commands Warning Message",
												  JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		printButton = new JButton("Print to commands.txt");
		initializeButton(printButton, "<html>Click to create a new Commands text file<br>with the commands you've written above.</html>");
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					JOptionPane.showMessageDialog(parent,
												  "The commands have been printed to commands.txt.",
												  "Commands Print Message",
												  JOptionPane.INFORMATION_MESSAGE);

					File file1 = new File("commands.txt");
					String baseDir = System.getProperty("user.dir");
					parent.commands = new PrintWriter(baseDir + "/" + file1);

					String text = mainFrameTextArea.getText();

					parent.commands.println(mainFrameNumRows);
					parent.commands.println(text);

					parent.commands.close();
				}
				catch(IOException ioe)
				{
					JOptionPane.showMessageDialog(parent,
												  "The commands text file cannot be printed.",
												  "Commands Warning Message",
												  JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JButton closeButton = new JButton("Close");
		initializeButton(closeButton, "Click to close the program.");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int close = JOptionPane.showConfirmDialog(parent,
							  "Would you like to close the program?",
							  "Close Post Office Commands Creator",
							  JOptionPane.YES_NO_OPTION);

				if(close == JOptionPane.YES_OPTION)
				{
					JOptionPane.showMessageDialog(parent,
												  "<html><div align = \"center\">Thank you for using the Post Office Commands Creator.<br>See you soon!</div></html>",
												  "",
												  JOptionPane.PLAIN_MESSAGE);
					System.exit(0);
				}				
			}
		});

		gc.weightx = 0.5;
		gc.weighty = 0.5;

		gc.ipadx = 100;
		gc.ipady = 15;

		gc.insets = new Insets(5, 5, 5, 5); // top, left, bottom, right

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 0;
		add(importButton, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 0;
		add(printButton, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 2;
		gc.gridy = 0;
		add(closeButton, gc);
	}

	void initializeButton(JButton button, String text)
	{
		button.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		button.setBackground(new Color(255, 17, 17));
		button.setForeground(Color.WHITE);
		button.setToolTipText(text);
	}

	void setNumRows(int nr)
	{
		if (nr >= 0)
		{
			this.mainFrameNumRows = nr;
		}
	}
}