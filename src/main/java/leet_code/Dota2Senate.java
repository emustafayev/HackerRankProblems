package leet_code;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dota2Senate {

    public static void main(String[] args) {

        System.out.println(predictPartyVictory("RD"));

    }


    public static String predictPartyVictory(String senate) {

        Deque<Integer> radiant = new ArrayDeque<>();

        Deque<Integer> dire = new ArrayDeque<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R')
                radiant.add(i);
            else dire.add(i);
        }

        int counter = senate.length();

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rad = radiant.peekFirst();
            int dir = dire.peekFirst();
            counter++;
            if (rad > dir) { // Dire win the battle. Dire goes to next round
                dire.addLast(counter);
                dire.pop();
                radiant.pop();
            }else {// Radiant win the battle. Radiant goes to next round
                radiant.addLast(counter);
                radiant.pop();
                dire.pop();
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }


}
