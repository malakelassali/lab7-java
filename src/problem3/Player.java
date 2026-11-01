package problem3;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name= name;
        this.hitPoints= hitPoints;
        this.strength= strength;
        this.weapon= "Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon= weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints= hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength= strength;
    }

    @Override
    public List<String> write() {
        List<String> values= new ArrayList<>();

        values.add(name);
        values.add(String.valueOf(hitPoints));
        values.add(String.valueOf(strength));
        values.add(weapon);

        return values;
    }

    @Override
    public void read(List<String> values) {
        if (values != null && values.size() >= 4) {
            name= values.get(0);
            hitPoints= Integer.parseInt(values.get(1));
            strength= Integer.parseInt(values.get(2));
            weapon= values.get(3);
        }
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', hitPoints=" + hitPoints + ", strength="
                + strength + ", weapon='" + weapon + "'}";
    }
}