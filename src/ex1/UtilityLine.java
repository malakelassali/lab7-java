package ex1;

public class UtilityLine implements Mappable{
    private String name;
    private UtilityType type;

    public UtilityLine(String name, UtilityType type) {
        this.name= name;
        this.type= type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type.name();
    }

    @Override
    public String getLabel() {
        return name + " (" + type + ")";
    }

    @Override
    public String getMarker() {
        return type.name();
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }
}
