package problem_solving.HackerRank;

import java.util.Arrays;


public class BreakingTheRecords {

    public static void main(String[] args) {
        int[] scores = {3, 4, 21, 36, 10, 28, 35, 5, 24, 42};
        System.out.println(Arrays.toString(trackRecords(scores)));
    }

    static class Table{
        public int maximum;
        public int minimum;
        public int countMin=0;
        public int countMax=0;

        public Table(int minimum,int maximum){
            this.minimum=minimum;
            this.maximum=maximum;
        }
    }


    static int[] trackRecords(int[] scores){
        Table table = new Table(scores[0],scores[0]);
        Arrays.stream(scores).forEach(element -> {
            if (element>table.maximum) {
                table.maximum=element;
                table.countMax++;
            } else
            if (element<table.minimum){
                table.minimum=element;
                table.countMin++;
            }
        });
        return new int[]{table.countMax, table.countMin};
    }
}
