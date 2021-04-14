import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ColorPalette extends JFrame{

	private JFrame displayFrame;
	private JPanel displayPanel;
	
	private static int xSkew = 25;
	private static int ySkew = 25;
	
	public ColorPalette(ArrayList <Color> colors, String name)
	{
		super(name);
		setSize(colors.size() * 100, 200);
		displayFrame = null;
		
		
		setLayout(new GridLayout(2, colors.size()));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(xSkew, ySkew);
		xSkew += 650;
		
		ArrayList <JButton> buttons = new ArrayList<JButton>();
		
		for(Color i : colors)
		{
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(3, 3));
			
			JButton button = new JButton();
			
			panel.setBackground(i);
			addColorListeners(i, button);
			buttons.add(button);
			add(panel);
		}
		
		for(JButton i : buttons)
		{
			add(i);
		}
		
		setVisible(true);
	}
	
	private void addColorListeners(Color color, JButton button)
	{
		button.addActionListener((ActionEvent event) -> 
										{
											colorResponse(color);
										});
	}
	
	private void colorResponse(Color color)
	{
		if(displayFrame == null || !displayFrame.isVisible())
		{
			displayFrame = new JFrame("Color selected");
			displayPanel = new JPanel();
			
			setSkews();
			
			displayFrame.setLocation(xSkew, ySkew+200);
			
			
			displayFrame.setSize(300,300);
			displayFrame.add(displayPanel);
			
			displayFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			displayPanel.setBackground(color);
			displayFrame.setVisible(true);
		}
		else
		{
			displayPanel.setBackground(color);
			displayPanel.repaint();
			displayFrame.repaint();
		}
	}
	
	
	
	private static void setSkews()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		if(xSkew > screenSize.getWidth()) xSkew = 100;
		else xSkew += 570;
		if(ySkew > screenSize.getHeight()) ySkew = 100;
	}

	public static void main(String[] args) 
	{
		ArrayList <Color> c1 = new ArrayList<Color>();
		
		c1.add(Color.black);
		c1.add(Color.blue);
		c1.add(Color.DARK_GRAY);
		c1.add(Color.GREEN);
		c1.add(Color.WHITE);
		c1.add(Color.pink);
		
		new ColorPalette(c1, "Exterior Color Options");
		
		ArrayList <Color> c2 = new ArrayList <Color>();
		
		c2.add(Color.yellow);
		c2.add(Color.magenta);
		c2.add(Color.CYAN);
		
		new ColorPalette(c2, "Interior Color Options");
	}
}
