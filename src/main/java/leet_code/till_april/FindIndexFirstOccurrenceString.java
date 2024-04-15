package leet_code.till_april;

public class FindIndexFirstOccurrenceString {

    public static void main(String[] args) {

        System.out.println(strStr("sddbutsad", "sad"));

    }


//    Given two strings needle and haystack,
//    return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack

    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++)
            if (haystack.startsWith(needle, i)) return i;
        return -1;
    }
}
