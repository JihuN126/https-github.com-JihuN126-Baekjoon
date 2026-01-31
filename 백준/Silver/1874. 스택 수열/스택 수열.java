import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        int currentNum = 1;
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();

            // 1. target이 나올 때까지 오름차순으로 push
            while (currentNum <= target) {
                stack.push(currentNum);
                sb.append("+\n");
                currentNum++;
            }

            // 2. 스택의 맨 위 숫자가 target과 같다면 꺼냄
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 3. 스택의 맨 위가 target이 아니면(이미 더 큰 숫자가 들어있으면) 불가능
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}