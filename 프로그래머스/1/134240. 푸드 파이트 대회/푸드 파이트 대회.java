class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        int resultLength = 0;
        int[] foodCount = new int[food.length];
        for(int i=0;i<food.length;i++) {
            foodCount[i] = food[i]/2;
            resultLength += food[i]/2;
        }
        for(int i=0;i<foodCount.length;i++) {
            for(int j=0;j<foodCount[i];j++) {
                answer += String.valueOf(i);
            }
        }
        sb.append(answer).reverse();
        sb.insert(0,answer + "0");
        return sb.toString();
    }
}