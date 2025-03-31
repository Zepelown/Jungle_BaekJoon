package m03.d29;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 이진검색트리_5639 {
    static List<Integer> numbers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            int number = Integer.parseInt(input);
            numbers.add(number);
        }
        int n = numbers.size();

        search(0, n-1);
    }

    public static void search(int startIndex, int endIndex){
        if (startIndex>endIndex){
            return;
        }
        int root = numbers.get(startIndex);
        int rootRightChildIndex = startIndex+1;
        while (rootRightChildIndex <= endIndex && root > numbers.get(rootRightChildIndex)){
            rootRightChildIndex++;
        }

        search(startIndex+1,rootRightChildIndex-1);
        search(rootRightChildIndex,endIndex);
        System.out.println(numbers.get(startIndex));
    }

}
