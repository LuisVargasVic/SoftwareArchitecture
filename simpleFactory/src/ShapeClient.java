public class ShapeClient {
	private ShapeFactory shapeFactory;
	public ShapeClient(ShapeFactory shapeFactory){
		this.shapeFactory = shapeFactory;
	}

	public Shape createShape(String shapeType){
		return this.shapeFactory.create(shapeType);
	}
	
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		ShapeClient client = new ShapeClient(shapeFactory);
		Shape shape1 = client.createShape("Rectangle");
		shape1.draw();
		Shape shape2 = client.createShape("Square");
		shape2.draw();
		Shape shape3 = client.createShape("Circle");
		shape3.draw();
	}
}
