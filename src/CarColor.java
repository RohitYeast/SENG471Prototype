import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class CarColor {
	
	private String fileName;
	private String colorName;
	private String vehicleModel;
	
	private Image image;
	
	
	public CarColor(String fileName, String colorName, String vehicleModel)
	{
		this.fileName = fileName;
		this.colorName = colorName;
		this.vehicleModel = vehicleModel;
		createImage(fileName);
	}
	
	private void createImage(String fileName) 
	{
		Toolkit t=Toolkit.getDefaultToolkit();  
	    Image i=t.getImage(fileName);  
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
