package ex1;

public interface Mappable {
    String JSON_PROPERTY = """
            "properties:" {%s}"
            """;

    static void mapIT(Mappable mappable) {
        System.out.println(mappable.toJSON());
    }

    default String toJSON() {
        String s= String.format("""
                "type": "%s", "label": "%s", "marker": "%s", "name": "%s", "type": "%s" """,
                getShape().name(), getLabel(), getMarker(), getName(), getType());
        return String.format(JSON_PROPERTY, s);
    }
    String getName();
    String getType();
    String getLabel();
    String getMarker();
    Geometry getShape();

}
