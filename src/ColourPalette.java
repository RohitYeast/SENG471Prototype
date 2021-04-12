import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColourPalette extends JFrame{

	public ColourPalette(ArrayList <Color> colors)
	{
		super("Color Palette Selection");
		setSize(600, 100);
		
		
		
		setLayout(new GridLayout(1, colors.size()));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(20, 200);
		
		for(Color i : colors)
		{
			JPanel button = new JPanel();
			button.setBackground(i);
			add(button);
		}
		
		setVisible(true);
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
		
		new ColourPalette(c);
	}
}
