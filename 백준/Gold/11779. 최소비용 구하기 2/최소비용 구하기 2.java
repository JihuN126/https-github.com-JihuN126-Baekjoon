import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static class Bus{
        int Destination;
        int Cost;
        public Bus(int Destination, int Cost) {
            this.Destination = Destination;
            this.Cost = Cost;
        }
    }
    static ArrayList<Bus>[] Graph;
    static boolean[] Visit;
    static int[] Dist, Route;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Graph = new ArrayList[N+1];
        Dist = new int[N+1];
        Visit = new boolean[N+1];
        Route = new int[N+1];
        for(int i=1;i<=N;i++){
            Graph[i] = new ArrayList<>();
            Dist[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int Start = Integer.parseInt(st.nextToken());
            int End = Integer.parseInt(st.nextToken());
            int Cost = Integer.parseInt(st.nextToken());
            Graph[Start].add(new Bus(End, Cost));
        }
        st = new StringTokenizer(br.readLine());
        int Depart = Integer.parseInt(st.nextToken());
        int Arrival = Integer.parseInt(st.nextToken());
        System.out.println(Dijkstra(Depart,Arrival));
        ArrayList<Integer> RouteList = new ArrayList<>();
        RouteList.add(Arrival);
        while(Route[Arrival]!=0) {
            RouteList.add(Route[Arrival]);
            Arrival = Route[Arrival];
        }
        System.out.println(RouteList.size());
        for(int i=0;i<RouteList.size();i++) System.out.print(RouteList.get(RouteList.size()-i-1)+" ");
    }
    static int Dijkstra(int Start, int End){
        PriorityQueue<Bus> q = new PriorityQueue<>((o1, o2) -> o1.Cost-o2.Cost);
        q.add(new Bus(Start,0));
        Dist[Start] = 0;
        while(!q.isEmpty()){
            Bus temp = q.poll();
            if(temp.Cost>Dist[temp.Destination]) continue;
            for(Bus Next : Graph[temp.Destination]){
                if(Dist[Next.Destination] > temp.Cost + Next.Cost){
                    Dist[Next.Destination] = temp.Cost + Next.Cost;
                    Route[Next.Destination] = temp.Destination;
                    q.add(new Bus(Next.Destination, Dist[Next.Destination]));
                }
            }
        }
        return Dist[End];
    }
}

