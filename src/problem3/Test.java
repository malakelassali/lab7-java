package problem3;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Player player= new Player("Tim", 10, 15);
        Monster monster= new Monster("Werewolf", 20, 40);

        System.out.println(player);
        System.out.println(monster);
        List<String> playerData= player.write();

        player.setHitPoints(5);
        player.setWeapon("Axe");
        System.out.println("Modified: " + player);

        player.read(playerData);
        System.out.println("Restored: " + player);

        List<String> monsterData= monster.write();
        Monster copy= new Monster("Unknown", 0, 0);
        copy.read(monsterData);
        System.out.println("Monster copy: " + copy);
    }
}