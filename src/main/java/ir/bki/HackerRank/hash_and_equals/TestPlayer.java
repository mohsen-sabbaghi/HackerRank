package ir.bki.HackerRank.hash_and_equals;

import java.util.HashSet;
import java.util.Set;

public class TestPlayer {

    public static void main(String[] args) {
        Player player1 = new Player("john");
        Player player2 = new Player("john");

        System.out.println("player1.hashcode = " + player1.hashCode() + "\nplayer2.hashcode = " + player2.hashCode());
        System.out.println("player1.equals(player2) --> " + player1.equals(player2));


        Set<Player> uniquePlayers = new HashSet<>();
        uniquePlayers.add(new Player("John"));
        uniquePlayers.add(new Player("John"));
        System.out.println("Unique players " + uniquePlayers.size());


    }
}
