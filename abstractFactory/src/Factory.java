public abstract class Factory{
    public static Factory getFactory(String factoryType){
        Factory factory = null;
        if (factoryType.equalsIgnoreCase("Shape")){
            factory = new ShapeFactory();
        } else if (factoryType.equalsIgnoreCase("Color")){
            factory = new ColorFactory();
        }
        return factory;
    }

    public abstract Shape createShape(String shapeType);
    public abstract Color createColor(String colorType); 
}