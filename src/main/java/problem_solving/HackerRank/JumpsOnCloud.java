package problem_solving.HackerRank;

public class JumpsOnCloud {
    private static final int SAFE = 0;

    public static void main(String[] args) {
        int[] arr = {0,0,0,1,0,0};
        System.out.println(
                jumpingOnCloud(arr)
        );
    }

    static int jumpingOnCloud(int[] c){
        int jump = 0;
        int index=0;
        while(index<c.length-1){
            if (index+2<c.length && c[index+2]==SAFE){
                jump++;
                index+=2;
                continue;
            }
            if (index+1<c.length && c[index+1]==SAFE){
                jump++;
                index+=1;
                continue;
            }
            throw new RuntimeException("No Way");
        }
        return jump;
    }



//    private static void checkPosition(int i,int[] c) {
//        return c[i+1]==0 ? 2
//    }


}
