package leet_code;

public class MinimumTimeTypeWordUsingSpecialTypewriter {

//    There is a special typewriter with lowercase English letters 'a' to 'z' arranged in a circle with a pointer.
//    A character can only be typed if the pointer is pointing to that character.
//    The pointer is initially pointing to the character 'a'.
//
//    Each second, you may perform one of the following operations:
//
//    Move the pointer one character counterclockwise or clockwise.
//    Type the character the pointer is currently on.
//    Given a string word, return the minimum number of seconds to type out the characters in word.


    public static void main(String[] args) {
//        System.out.println((char) 97);

        System.out.println(minTimeToType("bza")); // 7
    }


    public static int minTimeToType(String word) {
        int time = word.length();

        int pointer = 'a';

        for (int i = 0; i < word.length(); i++) {

            int curr = word.charAt(i);

            int diff = Math.abs(curr - pointer);

            time += Math.min(diff, 26 - diff);

            pointer = curr;
        }

        return time;
    }
}
