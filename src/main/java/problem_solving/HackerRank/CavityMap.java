package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CavityMap {
    public static void main(String[] args) {
        String[] arr = {"1112","1912","1892","1234"};
        System.out.println(Arrays.toString(cavityMap(arr)));
    }

    static String[] cavityMap(String[] grid){
        String[] res = new String[grid.length];
        System.out.println(Arrays.toString(res));
        IntStream.range(0,grid.length).forEach(i->
                IntStream.range(0,grid[i].length()).forEach(j->{
                    int center = at(i,j,grid);
                    System.out.println(res[i]);
                    res[i] = i > 0 &&
                             j > 0 &&
                             i < grid.length-1 &&
                             j < grid[i].length()-1 &&
                             center > at(i,j-1,grid) &&
                             center > at(i-1,j,grid) &&
                             center < at(i+1,j,grid) &&
                             center < at(i,j+1,grid) ?
                                 res[i].concat("X") :
                                     res[i].concat(String.valueOf(grid[i].charAt(j))
                                     );
                })
        );
        return res;
    }

    private static int at(int i, int j, String[] grid) {
        return parse(grid[i].charAt(j));
    }

    private static int parse(char ch){
        return Integer.parseInt(String.valueOf(ch));
    }


}
