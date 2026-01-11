import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<Integer>[] Student;
    static int[] Degree;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Student = new ArrayList[N+1];
        Degree = new int[N+1];
        for(int i=0;i<=N;i++) Student[i] = new ArrayList<>();
        for(int i=1;i<=M;i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Degree[B]++;
            Student[A].add(B);
        }
        TopologicalSorting();
    }
    public static void TopologicalSorting(){
        Queue<Integer> Que = new LinkedList<>();
        for(int i=1;i<=N;i++) if(Degree[i]==0) Que.add(i);
        while(!Que.isEmpty()) {
            int student = Que.poll();
            System.out.print(student + " ");
            for(int i=0;i<Student[student].size();i++) {
                int temp = Student[student].get(i);
                Degree[temp]--;
                if(Degree[temp] == 0) Que.add(temp);
            }
        }
    }
}
