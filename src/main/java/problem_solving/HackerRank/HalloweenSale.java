package problem_solving.HackerRank;

public class HalloweenSale {
    public static void main(String[] args) {
        System.out.println(howManyGames(20,3,6,85));
    }

    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int games = 0;
        while (true){
            int newGameCost = (p - games*d);
            if (newGameCost <= m) newGameCost = m;
            if (s - newGameCost  < 0) break;
            s = s - newGameCost;
            games++;
        }
        return games;   
    }
}
