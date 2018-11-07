public class ShapeFactory extends Factory{
	
	public Shape createShape(String shapeType){
		Shape shape = null;
		if(shapeType.equalsIgnoreCase("Rectangle"))
		{
			shape = new Rectangle();
		} else if(shapeType.equalsIgnoreCase("Square"))
		{
			shape = new Square();
		}
		return shape;
	}
	public Color createColor(String colorType){
		return null;
	}
}