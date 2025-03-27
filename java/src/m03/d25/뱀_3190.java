package m03.d25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class 뱀_3190 {
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Apple> apples = new ArrayList<>();
        for (int i = 0; i < k; i++){
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            apples.add(new Apple(s[0],s[1]));
        }

        Queue<Command> commands = new ArrayDeque<>();

        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            String[] s = br.readLine().split(" ");
            int time = Integer.parseInt(s[0]);
            String dir = s[1];
            commands.add(new Command(time, dir));
        }
        Queue<Snake> tails = new ArrayDeque<>();
        int time = 0;
        int currentDir = 0;
        Snake head = new Snake(0,0);
        while(true){
//            System.out.print("Snake positions at time " + time + ": head - (" + head.x +","+head.y+")|");
//
//            for (Snake snake : tails) {
//                System.out.print("(" + snake.x + "," + snake.y + ") ");
//            }
//            System.out.println();
            //시간에 따른 방향 변경
            if(!commands.isEmpty() && time >= commands.peek().time){
                Command poll = commands.poll();
                currentDir = (currentDir+ poll.dir + 4) % 4;
            }
            // 뱀 움직임 구현
            int newX = head.x + dir[currentDir][0];
            int newY = head.y + dir[currentDir][1];
            if (!canMove(tails,n,newX,newY)){
                break;
            }
            boolean findAppleFlag = false;
            for (var apple : apples){
                if(apple.isFind(newX, newY) && !apple.visited){
                    apple.visited = true;
                    findAppleFlag = true;
                    break;
                }
            }

            tails.add(head);
            if (!findAppleFlag){
                tails.poll();
            }

            head = new Snake(newX,newY);
            time++;
        }
        System.out.println(time+1);
    }

    private static boolean canMove(Queue<Snake> tails,int n, int x, int y){
        if (x >= n || y >= n || x < 0 || y < 0){
            return false;
        }
        for (Snake body : tails) {
            if (body.x == x && body.y == y) {
                return false;
            }
        }


        return true;
    }

    private static class Command{
        int time;
        int dir;

        public Command(int time, String dir) {
            this.time = time;
            if (dir.equals("L")){
                this.dir = -1;
            } else {
                this.dir = 1;
            }
        }
    }
    private static class Apple{
        int x;
        int y;
        boolean visited;

        public Apple(int x, int y) {
            this.x = x-1;
            this.y = y-1;
            this.visited = false;
        }

        public boolean isFind(int x, int y){
            return this.x == x && this.y == y;
        }
    }
    private static class Snake{
        int x;
        int y;

        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
