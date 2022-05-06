package leet_code;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCombinationLetter {

    public static void main(String[] args) {

        System.out.println(letterCombinations(""));

    }

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        combine("", res, digits, 0);
        return res;
    }

    private static void combine(String prefix, ArrayList<String> res, String digits, int offset) {
        if (digits.length() <= offset) {
            res.add(prefix);
            return;
        }
        String letters = KEYS[digits.charAt(offset) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            combine(prefix + letters.charAt(i),res,digits,offset+1);
        }
    }

}