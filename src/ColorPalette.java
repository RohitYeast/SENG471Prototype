	import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ColorPalette extends JFrame{

	public ColorPalette(ArrayList <Color> colors)
	{
		super("Color Palette Selection");
		setSize(colors.size() * 100, 100);
		
		
		
		setLayout(new GridLayout(1, colors.size()));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(20, 200);
		
		for(Color i : colors)
		{
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(3, 3));
			
			JButton button = new JButton();
			
			panel.setBackground(i);
			panel.add(button);
			
			addColorListeners(i, button);
			
			add(panel);
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
		JFrame frame = new JFrame("Color selected");
		JPanel panel = new JPanel();
		
		panel.setBackground(color);
		frame.add(panel);
		
		frame.setSize(100, 100);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) 
	{
		ArrayList <Color> c = new ArrayList<Color>();
		
		c.add(Color.black);
		c.add(Color.blue);
		c.add(Color.DARK_GRAY);
		c.add(Color.GREEN);
		c.add(Color.WHITE);
		c.add(Color.pink);
		
		new ColorPalette(c);
	}
}
