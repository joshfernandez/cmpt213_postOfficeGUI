// MainFrame.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class MainFrame extends JFrame
{
	private CommandsPanel commandsPanel;
	private OthersPanel othersPanel;
	private FinishPanel finishPanel;
	private RowsPanel rowsPanel;

	JTextArea textArea;
	int num_rows;

	PrintWriter commands;

	public MainFrame(String title)
	{
		// PART A - Set Layout
		super(title);
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		// PART B - Set Menu
		JMenuBar menubar = new JMenuBar();
		menubar.setForeground(Color.WHITE);
		menubar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menubar);

		JMenu file = new JMenu("File");
		file.setBackground(Color.LIGHT_GRAY);
		menubar.add(file);

		JMenuItem importItem = new JMenuItem("Import commands.txt");
		importItem.setToolTipText("Click to import the Commands text file into the program.");
		importItem.setBackground(Color.LIGHT_GRAY);
		importItem.addActionListener(new ActionListener() {
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
							set_text_of_text_area(text, actual_size);
						}
						else
						{
							JOptionPane.showMessageDialog(MainFrame.this,
														  "The size is commands.txt is incorrect! Please change this.",
														  "Commands Size Warning",
														  JOptionPane.WARNING_MESSAGE);
						}

						commands.close();
					}
					catch(IOException ioe)
					{
						JOptionPane.showMessageDialog(MainFrame.this,
													  "The commands text file is not found.",
													  "Commands Warning Message",
													  JOptionPane.WARNING_MESSAGE);
					}
			}
		});
		file.add(importItem);

		JMenuItem exit = new JMenuItem("Exit");
		exit.setBackground(Color.LIGHT_GRAY);
		exit.setToolTipText("Click to close the program.");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int close = JOptionPane.showConfirmDialog(MainFrame.this,
							  "Would you like to close the program?",
							  "Close Post Office Commands Creator",
							  JOptionPane.YES_NO_OPTION);

				if(close == JOptionPane.YES_OPTION)
				{
					JOptionPane.showMessageDialog(MainFrame.this,
												  "<html><div align = \"center\">Thank you for using the Post Office Commands Creator.<br>See you soon!</div></html>",
												  "",
												  JOptionPane.PLAIN_MESSAGE);
					System.exit(0);
				}	
			}
		});
		file.add(exit);

		// PART C - Set Content
		JLabel mainLabel = new JLabel("Click on any of the following to create a new command.");
		mainLabel.setForeground(Color.WHITE);

		textArea = new JTextArea(25, 25);
		textArea.setEditable(false);
		textArea.setFont(new Font("Sans Serif", Font.PLAIN, 18));
		JScrollPane scrollPane = new JScrollPane(textArea);

		num_rows = 0;

		commandsPanel = new CommandsPanel();
		commandsPanel.setBackground(Color.DARK_GRAY.brighter());

		commandsPanel.addDetailListener(new DetailListener() {
			public void detailEventOccurred(DetailEvent event)
			{
				String text = event.getText();
				textArea.append(text + "\n");

				num_rows++;
				finishPanel.setNumRows(num_rows);
				othersPanel.setNumRows(num_rows);
				rowsPanel.rowsField.setText(new Integer(num_rows).toString());
			}
		});

		othersPanel = new OthersPanel(this);
		othersPanel.setBackground(Color.DARK_GRAY.brighter());

		finishPanel = new FinishPanel(this);
		finishPanel.setBackground(Color.DARK_GRAY.brighter());

		rowsPanel = new RowsPanel();
		rowsPanel.setBackground(Color.DARK_GRAY.brighter());

		// PART D - Arrange Content
		gc.weightx = 0.5;
		gc.weighty = 0.5;

		gc.weighty = 0.8;
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridy = 0;
		add(mainLabel, gc);

		gc.insets = new Insets(0, 5, 0, 5); // top, left, bottom, right

		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 1;
		gc.gridy = 0;
		add(rowsPanel, gc);

		gc.insets = new Insets(0, 0, 0, 0); // top, left, bottom, right

		gc.weighty = 0.5;
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.gridx = 0;
		gc.gridwidth = 1;
		gc.gridy = 1;
		add(commandsPanel, gc);

		gc.weighty = 0.5;
		gc.anchor = GridBagConstraints.PAGE_END;
		gc.gridx = 0;
		gc.gridy = 2;
		add(othersPanel, gc);

		gc.weighty = 0.5;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 1;
		gc.gridy = 3;
		add(finishPanel, gc);

		gc.insets = new Insets(0, 5, 0, 5); // top, left, bottom, right

		gc.weightx = 10;
		gc.weighty = 20;
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridheight = 2;
		add(scrollPane, gc);
	}

	void set_num_rows(int nr)
	{
		if (nr >= 0)
		{
			this.num_rows = nr;
			othersPanel.setNumRows(nr);
			finishPanel.setNumRows(nr);
			rowsPanel.rowsField.setText(new Integer(num_rows).toString());
		}
	}

	String get_text_of_text_area()
	{
		return textArea.getText();
	}

	void set_text_of_text_area(String ta, int nr)
	{
		textArea.append(ta);
		set_num_rows(num_rows + nr);
	}
}