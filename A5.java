/**
 *
 * @author jafernan
 * Name: Josh Arik Miguel Fernandez
 * Student Number: 301246300
 * Course: CMPT 213 with Karol Swietlicki (Spring 2016)
 * 
 * Assignment 5 - GUI programming
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
////                                                                                           ////
////                                 ASSIGNMENT 5: GUI Programming                             ////
////                                                                                           ////
////	Note: When printing the commands text file, commands.txt will be in the same folder.   ////
////											       ////
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

public class A5
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new MainFrame("Post Office Commands Creator");
				frame.setSize(960, 1080);
				frame.getContentPane().setBackground(Color.DARK_GRAY.brighter());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
