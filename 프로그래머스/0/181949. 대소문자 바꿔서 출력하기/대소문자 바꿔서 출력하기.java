import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] test = a.toCharArray();
        for(int i = 0; i < test.length; i++) {
            if(Character.isLowerCase(test[i])) {
                test[i] = Character.toUpperCase(test[i]);
            } else {
                test[i] = Character.toLowerCase(test[i]);
            }
        }
        String result = new String(test);
        System.out.print(result);
    }
}