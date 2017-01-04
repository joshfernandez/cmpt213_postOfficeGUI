// OthersPanel.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class OthersPanel extends JPanel
{
	MainFrame parent;
	JTextArea mainFrameTextArea;
	int mainFrameNumRows;

	public OthersPanel(MainFrame frame)
	{
		parent = frame;
		mainFrameTextArea = frame.textArea;
		mainFrameNumRows = frame.num_rows;

		Dimension size = getPreferredSize();
		size.width = 1000;
		//size.height = 1000;
		setPreferredSize(size);

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

		JButton deleteLastCommandButton = new JButton("Delete last command");
		initializeButton(deleteLastCommandButton, "Click to delete the last command.");
		deleteLastCommandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String text = parent.get_text_of_text_area();
				int last_newspace = text.lastIndexOf('\n', text.length() - 2);

				if (last_newspace > -1) // If it's not out of bounds (Two or more lines, etc.)
				{
					text = text.substring(0, last_newspace);
					text = text + "\n";

					mainFrameTextArea.setText(text);
				}
				else // If it's out of bounds
				{
					mainFrameTextArea.setText("");
				}

				mainFrameNumRows--;
				parent.set_num_rows(mainFrameNumRows);
			}
		});

		JButton clearAllButton = new JButton("Clear all");
		initializeButton(clearAllButton, "Click to delete all the commands in the text area.");
		clearAllButton.setBackground(new Color(40, 101, 243)); // Because I want it blue, instead of red
		clearAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				mainFrameTextArea.setText("");
				mainFrameNumRows = 0;
				parent.set_num_rows(mainFrameNumRows);
			}
		});


		gc.weightx = 0.5;
		gc.weighty = 0.5;

		gc.ipadx = 50;
		gc.ipady = 50;

		gc.insets = new Insets(5, 5, 5, 5); // top, left, bottom, right

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 0;
		add(deleteLastCommandButton, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 1;
		add(clearAllButton, gc);
	}

	void initializeButton(JButton button, String text)
	{
		button.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		button.setBackground(new Color(40, 101, 243));
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