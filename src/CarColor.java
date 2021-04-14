
import java.awt.Color;

import javax.swing.ImageIcon;

public class CarColor {
	
//	private String fileName;
//	private String colorName;
//	private String vehicleModel;
	
	private ImageIcon image;
	
	private Color color;
	
	private String colorName;
	
	
	public CarColor(String fileName, String colorName, Color color)
	{
		this.image = new ImageIcon(fileName);
		this.color = color;
		this.colorName = colorName;
	}
	
//	private void createImage(String fileName) 
//	{
//		Toolkit t=Toolkit.getDefaultToolkit();  
//	    this.image = 
//	}
//	
//	public String getFileName() {
//		return fileName;
//	}
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
	
//	public String getColorName() {
//		return colorName;
//	}
//	public void setColorName(String colorName) {
//		this.colorName = colorName;
//	}
//	public String getVehicleModel() {
//		return vehicleModel;
//	}
//	public void setVehicleModel(String vehicleModel) {
//		this.vehicleModel = vehicleModel;
//	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public String getColorName() {
		return colorName;
	}
}
