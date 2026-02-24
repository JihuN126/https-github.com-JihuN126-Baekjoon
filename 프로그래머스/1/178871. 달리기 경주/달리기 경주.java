import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        Map<Integer, String> mapMember = new HashMap<>();
        Map<String, Integer> mapRank = new HashMap<>();
        for(int i=0;i<players.length;i++) {
            mapMember.put(i+1, players[i]);
            mapRank.put(players[i], i+1);
        }
        for(int i=0;i<callings.length;i++){
            String member1 = callings[i];
            int rank1 = mapRank.get(member1);
            
            int rank2 = rank1-1;
            String member2 = mapMember.get(rank2);
            
            mapRank.put(member1, rank2);
            mapRank.put(member2, rank1);
            
            mapMember.put(rank2, member1);
            mapMember.put(rank1, member2);
        
            
        }
        for(int i=0;i<players.length;i++) {
            answer[i] = mapMember.get(i+1);
        }
        return answer;
    }
}