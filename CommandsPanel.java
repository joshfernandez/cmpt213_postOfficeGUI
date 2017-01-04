// CommandsPanel.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class CommandsPanel extends JPanel
{
	JButton pickUpButton;

	public CommandsPanel()
	{
		Dimension size = getPreferredSize();
		size.width = 1000;
		//size.height = 1000;
		setPreferredSize(size);

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.WHITE, 1), 
													"List of Commands", 
													TitledBorder.CENTER, 
													TitledBorder.TOP, 
													new Font("Sans Serif", Font.BOLD, 12), 
													Color.WHITE));

		JButton letterButton = new JButton("LETTER");
		initializeButton(letterButton, "Click to create a new letter.");
		letterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				LetterWindow lw = new LetterWindow(CommandsPanel.this);
				lw.getContentPane().setBackground(Color.DARK_GRAY.brighter());
				lw.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				lw.setSize(380, 300);
				lw.setLocation(10, 650);
				lw.setTitle("Create LETTER command");
				lw.setVisible(true);				
			}
		});

		JButton packageButton = new JButton("PACKAGE");
		initializeButton(packageButton, "Click to create a new package.");
		packageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				PackageWindow pw = new PackageWindow(CommandsPanel.this);
				pw.getContentPane().setBackground(Color.DARK_GRAY.brighter());
				pw.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				pw.setSize(380, 350);
				pw.setLocation(10, 650);
				pw.setTitle("Create PACKAGE command");
				pw.setVisible(true);				
			}
		});

		pickUpButton = new JButton("PICKUP");
		initializeButton(pickUpButton, "Click to create a pickup attempt.");
		pickUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				PickUpWindow pw = new PickUpWindow(CommandsPanel.this);
				pw.getContentPane().setBackground(Color.DARK_GRAY.brighter());
				pw.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				pw.setSize(380, 200);
				pw.setLocation(10, 650);
				pw.setTitle("Create PICKUP command");
				pw.setVisible(true);				
			}
		});

		JButton sneakButton = new JButton("SNEAK");
		initializeButton(sneakButton, "Click to sneak the next item to the post office successfully.");
		sneakButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				fireDetailEvent(new DetailEvent(this, "SNEAK"));
			}
		});

		JButton nsaDelayButton = new JButton("NSADELAY");
		initializeButton(nsaDelayButton, "Click to delay someone's mail.");
		nsaDelayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				DelayWindow dw = new DelayWindow(CommandsPanel.this);
				dw.getContentPane().setBackground(Color.DARK_GRAY.brighter());
				dw.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				dw.setSize(380, 200);
				dw.setLocation(10, 650);
				dw.setTitle("Create NSADELAY command");
				dw.setVisible(true);				
			}
		});

		JButton scienceButton = new JButton("SCIENCE");
		initializeButton(scienceButton, "Click to create a time travel event.");
		scienceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ScienceWindow sw = new ScienceWindow(CommandsPanel.this);
				sw.getContentPane().setBackground(Color.DARK_GRAY.brighter());
				sw.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				sw.setSize(380, 200);
				sw.setLocation(10, 650);
				sw.setTitle("Create SCIENCE command");
				sw.setVisible(true);				
			}
		});

		JButton inflationButton = new JButton("INFLATION");
		initializeButton(inflationButton, "Click to inflate the costs in all post offices.");
		inflationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				fireDetailEvent(new DetailEvent(this, "INFLATION"));
			}
		});

		JButton deflationButton = new JButton("DEFLATION");
		initializeButton(deflationButton, "Click to deflate the costs in all post offices.");
		deflationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				fireDetailEvent(new DetailEvent(this, "DEFLATION"));
			}
		});

		JButton buildButton = new JButton("BUILD");
		initializeButton(buildButton, "Click to create a new post office.");
		buildButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				BuildWindow bw = new BuildWindow(CommandsPanel.this);
				bw.getContentPane().setBackground(Color.DARK_GRAY.brighter());
				bw.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				bw.setSize(380, 375);
				bw.setLocation(10, 650);
				bw.setTitle("Create BUILD command");
				bw.setVisible(true);				
			}
		});

		JButton goodButton = new JButton("GOOD");
		initializeButton(goodButton, "Click to attempt skipping to the end of the day.");
		goodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				fireDetailEvent(new DetailEvent(this, "GOOD"));
			}
		});

		JButton dayButton = new JButton("DAY");
		initializeButton(dayButton, "Click to signify the end of day.");
		dayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				fireDetailEvent(new DetailEvent(this, "DAY"));
			}
		});


		gc.weightx = 0.5;
		gc.weighty = 0.5;

		gc.ipadx = 100;
		gc.ipady = 50;

		gc.insets = new Insets(5, 5, 5, 5); // top, left, bottom, right

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 0;
		add(letterButton, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 0;
		add(packageButton, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 1;
		add(pickUpButton, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 1;
		add(sneakButton, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 2;
		add(nsaDelayButton, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 2;
		add(scienceButton, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 3;
		add(inflationButton, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 3;
		add(deflationButton, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 0;
		gc.gridy = 4;
		add(buildButton, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 4;
		add(goodButton, gc);

		gc.fill = GridBagConstraints.BOTH;
		gc.gridx = 1;
		gc.gridy = 5;
		add(dayButton, gc);
	}

	void initializeButton(JButton button, String text)
	{
		button.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		button.setBackground(new Color(255, 255, 17));
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Sans Serif", Font.BOLD, 16));
		button.setToolTipText(text);
	}

	public void fireDetailEvent(DetailEvent event)
	{
		Object[] listeners = listenerList.getListenerList();
		for(int i = 0; i < listeners.length; i += 2)
		{
			if(listeners[i] == DetailListener.class)
			{
				((DetailListener) listeners[i+1]).detailEventOccurred(event);
			}
		}
	}

	public void addDetailListener(DetailListener listener)
	{
		listenerList.add(DetailListener.class, listener);
	}

	public void removeDetailListener(DetailListener listener)
	{
		listenerList.remove(DetailListener.class, listener);
	}

	public void returnText(String text)
	{
		fireDetailEvent(new DetailEvent(this, text));
	}
}