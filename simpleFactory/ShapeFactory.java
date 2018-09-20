public class ShapeFactory{

    public Shape create(String shapeType){
		Shape shape = null;
		if(shapeType.equalsIgnoreCase("Rectangle")){
			shape = new Rectangle();
		} else if(shapeType.equalsIgnoreCase("Square")){
			shape = new Square();
		} else if(shapeType.equalsIgnoreCase("Circle")){
			shape = new Circle();
		}
		return shape;
	}
}