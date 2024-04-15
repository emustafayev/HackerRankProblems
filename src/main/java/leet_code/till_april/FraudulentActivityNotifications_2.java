package leet_code.till_april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FraudulentActivityNotifications_2 implements Runnable {


    public static void main(String[] args) {
        new Thread(new FraudulentActivityNotifications_2()).start();
    }

    int[] cnt;

    int median(int d) {
        int[] a = Arrays.copyOf(cnt, cnt.length); // needed sub array of count
        int r = d / 2; // median index
        if (d % 2 == 1) {// if d is odd(days)
            r++;
        }
        int res = 0;
        boolean odd = d % 2 == 1;
        for (int k = 0; k <= 200; k++) { // loop through list
            while (r > 0 && a[k] > 0) {
                a[k]--;
                r--;
            }
            if (r == 0) {
                res += k;
                if (d % 2 == 0) {
                    d--;
                    r++;
                    if (a[k] > 0) {
                        return 2 * k;
                    }
                } else {
                    break;
                }
            }
        }
        return res * (odd ? 2 : 1);
    }

    void solve() throws IOException {
        int n = nextInt();
        int d = nextInt();
        cnt = new int[201];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        for (int i = 0; i < d; i++) {
            cnt[a[i]]++;
        }
        int res = 0;
        for (int i = d; i < n; i++) {
            int m = median(d);
//            out.println(m);
            if (a[i] >= m) {
                res++;
            }
            cnt[a[i - d]]--; // use count array as an window
            cnt[a[i]]++;
        }
        out.print(res);

    }

    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();
            br.close();
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(123);
        }
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null)
                return null;
            st = new StringTokenizer(s);
        }
        return st.nextToken();
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

}
