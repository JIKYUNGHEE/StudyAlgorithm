package RealTest.T2_march.showMetheCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MainTemplate {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        System.out.println(minus(inputs[0], inputs[1]));
    }

    private static int minus(String a, String b) {
        return Integer.parseInt(a) - Integer.parseInt(b);
    }
}
