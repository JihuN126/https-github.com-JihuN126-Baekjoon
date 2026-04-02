import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> mapIn = new HashMap<>();
        Map<String, Integer> mapTotal = new TreeMap<>();

        for (String record : records) {
            String[] arr = record.split(" ");
            int time = minuteTimes(arr[0]);
            String carNum = arr[1];
            String type = arr[2];

            if (type.equals("IN")) {
                mapIn.put(carNum, time);
            } else {
                int inTime = mapIn.remove(carNum);
                mapTotal.put(carNum, mapTotal.getOrDefault(carNum, 0) + (time - inTime));
            }
        }

        int lastTime = minuteTimes("23:59");
        for (String carNum : mapIn.keySet()) {
            int inTime = mapIn.get(carNum);
            mapTotal.put(carNum, mapTotal.getOrDefault(carNum, 0) + (lastTime - inTime));
        }

        int[] answer = new int[mapTotal.size()];
        int idx = 0;
        
        for (int totalTime : mapTotal.values()) {
            answer[idx++] = calculateFee(fees, totalTime);
        }

        return answer;
    }

    public int minuteTimes(String str) {
        String[] times = str.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    private int calculateFee(int[] fees, int totalTime) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (totalTime <= baseTime) {
            return baseFee;
        } else {
            int extraTime = totalTime - baseTime;
            int additionalFee = (int) Math.ceil((double) extraTime / unitTime) * unitFee;
            return baseFee + additionalFee;
        }
    }
}