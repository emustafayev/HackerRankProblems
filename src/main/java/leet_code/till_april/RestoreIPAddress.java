package leet_code.till_april;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

//    A valid IP address consists of exactly four integers separated by single dots.
//    Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
//
//    For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses,
//    but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
//    Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting
//    dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid
//    IP addresses in any order.
//

    public static List<String> restoreIpAddresses3(String s) {
        List<String> addresses = new ArrayList<>();
        List<String> address = new ArrayList<>();
        recursion(s, 0, address, addresses);
        return addresses;
    }

    private static void recursion(String s, int i, List<String> address, List<String> addresses) {
        if (address.size() == 4) {
            if (i == s.length()) {
                addresses.add(String.join(".", address));
            }
        } else {
            for (int j = i + 1; j <= i + 3 && j <= s.length(); j++) {
                String digit = s.substring(i, j);
                if (Integer.parseInt(digit) <= 255 && (digit.equals("0") || !digit.startsWith("0"))) {
                    address.add(digit);

                    recursion(s, j, address, addresses);

                    address.remove(address.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses3("19216811"));
    }

}
