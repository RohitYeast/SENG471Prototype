import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ColorPalette extends JFrame{

	private JFrame displayFrame;
	private JPanel displayPanel;
	
	private static int xSkew = 25;
	private static int ySkew = 25;
	
	public ColorPalette(ArrayList <CarColor> colors, String name)
	{
		super(name);
		setSize(colors.size() * 100, 200);
		displayFrame = null;
		
		
		setLayout(new GridLayout(2, colors.size()));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(xSkew, ySkew);
		xSkew += 650;
		
		ArrayList <JButton> buttons = new ArrayList<JButton>();
		
		for(CarColor i : colors)
		{
			JPanel panel = new JPanel();			
			JButton button = new JButton(i.getColorName());
			
			panel.setBackground(i.getColor());
			
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
	
	private void addColorListeners(CarColor color, JButton button)
	{
		button.addActionListener((ActionEvent event) -> 
										{
											colorResponse(color);
										});
	}
	
	private void colorResponse(CarColor color)
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
			addImage(color);
			displayFrame.setVisible(true);
		}
		else
		{
			addImage(color);
			displayPanel.revalidate();
			displayPanel.repaint();
			displayFrame.revalidate();
			displayFrame.repaint();
		}
	}
	
	
	private void addImage(CarColor color)
	{
		JLabel label = new JLabel(color.getImage());
		displayPanel.removeAll();
		
		displayPanel.add(label);
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
		ArrayList <CarColor> c1 = new ArrayList<CarColor>();
		
		c1.add(new CarColor("blueTaco.jpg", "Blue", Color.blue));
		c1.add(new CarColor("blackTaco.jpg", "Black", Color.black));
		c1.add(new CarColor("greenTaco.jpg", "Army Green", new Color(114, 135, 0)));
		c1.add(new CarColor("whiteTaco.jpg", "White", Color.WHITE));
		c1.add(new CarColor("greyTaco.jpg", "Dark Grey", Color.DARK_GRAY));
		
		new ColorPalette(c1, "Exterior Color Options");
		
		ArrayList <CarColor> c2 = new ArrayList <CarColor>();
		
		
		c2.add(new CarColor("greenInt.jpg", "Army Green", new Color(114, 135, 0)));
		c2.add(new CarColor("brownInt.jpg", "Brown", new Color(210, 105, 30)));
		c2.add(new CarColor("blackInt.jpg", "Black", Color.black));
		
		new ColorPalette(c2, "Interior Color Options");
	}
}
