package ex1;

public class Building implements Mappable {
    private String name;
    private UsageType type;

    public Building(String name, UsageType type) {
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
        return Geometry.POINT;
    }
}
