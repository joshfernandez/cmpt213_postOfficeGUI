// RowsPanel.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class RowsPanel extends JPanel
{

	public JTextField rowsField;

	public RowsPanel()
	{
		Dimension size = getPreferredSize();
		size.width = 1000;
		size.height = 500;
		setPreferredSize(size);

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		JLabel label = new JLabel("Number of commands:");
		label.setForeground(Color.WHITE);

		rowsField = new JTextField(100);
		rowsField.setEditable(false);
		rowsField.setFont(new Font("Sans Serif", Font.PLAIN, 18));

		gc.weightx = 0.5;
		gc.weighty = 0.5;

		gc.ipadx = 5;
		gc.ipady = 15;

		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 0;
		gc.gridy = 0;
		add(label, gc);

		gc.ipadx = 100;

		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 0;
		add(rowsField, gc);
	}

}