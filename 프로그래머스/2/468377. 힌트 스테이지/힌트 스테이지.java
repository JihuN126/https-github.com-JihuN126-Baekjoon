import java.util.*;

class Solution {
    // 상태를 저장할 클래스
    class State implements Comparable<State> {
        int stage;
        int totalCost;
        int[] inventory; // 각 스테이지별 보유 힌트권 개수

        State(int stage, int totalCost, int[] inventory) {
            this.stage = stage;
            this.totalCost = totalCost;
            this.inventory = inventory;
        }

        @Override
        public int compareTo(State o) {
            return this.totalCost - o.totalCost;
        }
    }

    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;
        // memoization: stage와 inventory 상태에 따른 최소 비용 저장
        // 실제 구현 시 inventory 배열을 문자열이나 리스트로 변환해 Map의 키로 사용 가능
        PriorityQueue<State> pq = new PriorityQueue<>();
        
        // 초기 상태: 0번 스테이지, 비용 0, 힌트권 없음
        pq.add(new State(0, 0, new int[n + 1]));
        
        Map<String, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (cur.stage == n) {
                return cur.totalCost;
            }

            // 중복 상태 체크 (현재 스테이지와 인벤토리 상황)
            String stateKey = cur.stage + Arrays.toString(cur.inventory);
            if (visited.containsKey(stateKey) && visited.get(stateKey) <= cur.totalCost) continue;
            visited.put(stateKey, cur.totalCost);

            int currentHintCount = cur.inventory[cur.stage + 1];
            // 힌트권 사용 한도(n-1) 처리
            int useCount = Math.min(currentHintCount, n - 1);
            int solveCost = cost[cur.stage][useCount];

            // 1. 힌트 번들을 구매하지 않는 경우
            int[] nextInvNoBundle = cur.inventory.clone();
            nextInvNoBundle[cur.stage + 1] = 0; // 현재 스테이지 힌트 소진
            pq.add(new State(cur.stage + 1, cur.totalCost + solveCost, nextInvNoBundle));

            // 2. 힌트 번들을 구매하는 경우 (마지막 스테이지 제외)
            if (cur.stage < n - 1) {
                int[] nextInvWithBundle = cur.inventory.clone();
                nextInvWithBundle[cur.stage + 1] = 0;
                int bundlePrice = hint[cur.stage][0];
                for (int j = 1; j < hint[cur.stage].length; j++) {
                    int hintTarget = hint[cur.stage][j];
                    nextInvWithBundle[hintTarget]++;
                }
                pq.add(new State(cur.stage + 1, cur.totalCost + solveCost + bundlePrice, nextInvWithBundle));
            }
        }

        return -1;
    }
}