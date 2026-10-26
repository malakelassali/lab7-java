package ex1;

public class Main {
    public static void main(String[] args) {
        Mappable building= new Building("Sydney Town Hall", UsageType.GOVERNMENT);
        Mappable utilityLine= new UtilityLine("College St", UtilityType.FIBER_OPTIC);

        Mappable.mapIT(building);
        Mappable.mapIT(utilityLine);
    }
}