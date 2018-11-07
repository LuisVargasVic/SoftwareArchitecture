public class ColorFactory extends Factory{
    
    public Shape createShape(String shapeType){
		return null;
	}
	public Color createColor(String colorType){
		Color color = null;
		if(colorType.equalsIgnoreCase("Red"))
		{
			color = new Red();
		} else if(colorType.equalsIgnoreCase("Green"))
		{
			color = new Green();
		}
		return color;
	}
}