package m03.d27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class last_문자열_폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String explosion = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            stack.push(charAt);
            if (stack.size() >= explosion.length()) {
                boolean equalFlag = true;
                for (int j = 0; j < explosion.length(); j++) {
                    if (stack.get(stack.size() - explosion.length() + j)
                            != explosion.charAt(j)) {
                        equalFlag = false;
                    }
                }
                if (equalFlag) {
                    for (int j = 0; j < explosion.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (char i : stack) {
            result.append(i);
        }
        if (result.toString().length() == 0) {
            System.out.println("FRULA");
            return;
        }
        System.out.println(result);
    }
}
