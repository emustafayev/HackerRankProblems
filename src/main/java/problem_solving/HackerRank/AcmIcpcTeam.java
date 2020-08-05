package problem_solving.HackerRank;

import java.util.stream.IntStream;

public class AcmIcpcTeam {
    public static void main(String[] args) {

    }

    static int[] acmTeam(String[] topic){

        int max = IntStream.range(0,topic.length).flatMap(j ->
                IntStream.range(j+1,topic[0].length())
                .map(i-> findCoveredTopic(topic[i],topic[j]))).max().orElseThrow(RuntimeException::new);

        int count = (int)IntStream.range(0,topic.length).flatMap(j ->
                IntStream.range(j+1,topic[0].length())
                        .map(i-> findCoveredTopic(topic[i],topic[j]))).filter(i->i==max).count();
        return new int[]{max,count};
    }

    private static int findCoveredTopic(String s, String s1) {
        return IntStream.range(0,s.length()).map(i->{
            if (s.charAt(i)=='0' && s1.charAt(i)=='0') return 0;
            return 1;
        }).sum();
    }
}
