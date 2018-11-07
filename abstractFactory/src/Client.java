public class Client {

	private static Factory shapeFactory = null;
	private static Factory colorFactory = null;
	
	public static Shape createShape(String shapeType){
		if(shapeFactory == null){
			shapeFactory = Factory.getFactory("Shape");
		}
		return shapeFactory.createShape(shapeType);
	}

	public static Color createColor(String colorType){
		if(colorFactory == null){
			colorFactory = Factory.getFactory("Color");
		}
		return colorFactory.createColor(colorType);
	}
	
	public static void main(String[] args) {
		Shape shape1 = Client.createShape("Rectangle");
		shape1.draw();
		Shape shape2 = Client.createShape("Square");
		shape2.draw();
		Color color1 = Client.createColor("Red");
		color1.fill();
		Color color2 = Client.createColor("Green");
		color2.fill();
	}
}
