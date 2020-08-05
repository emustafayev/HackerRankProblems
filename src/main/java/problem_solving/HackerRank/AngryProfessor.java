package problem_solving.HackerRank;

import java.util.Arrays;

public class AngryProfessor {
    public static void main(String[] args) {
        int[] arrival = {-1,0,2,1};
        System.out.println(angryProfessor(2,arrival));
    }

    static String angryProfessor(int k, int[] a){
        long attended = Arrays.stream(a).filter(i -> i <= 0).count();//attended 3 person;
        return k > attended ? "YES" : "NO";
    }
}
