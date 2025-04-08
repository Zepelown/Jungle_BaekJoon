package m04.d07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] split = str.split("-");
        int result = add(split[0]);
        if (split.length >= 2){
            for (int i = 1; i < split.length; i++){
                result -= add(split[i]);
            }
        }
        System.out.println(result);
    }
    private static int add(String str){
        String[] split = str.split("\\+");
        int result = 0;
        for(var i : split){
            result += Integer.parseInt(i);
        }
        return result;
    }
}
