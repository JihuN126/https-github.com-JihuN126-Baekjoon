import java.util.*;

class Solution {

    Map<String, PriorityQueue<String>> routes = new HashMap<>();
    List<String> result = new LinkedList<>();

    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            routes.putIfAbsent(ticket[0], new PriorityQueue<>());
            routes.get(ticket[0]).add(ticket[1]);
        }

        dfs("ICN");

        String[] answer = new String[result.size()];
        for(int i=0;i<result.size();i++) {
            answer[result.size()-i-1] = result.get(i);
        }
        return answer;
    }

    private void dfs(String airport) {
        PriorityQueue<String> neighbors = routes.get(airport);

        while (neighbors != null && !neighbors.isEmpty()) {
            dfs(neighbors.poll());
        }

        result.add(airport);
    }
}