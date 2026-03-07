class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, 0);
        return answer;
    }
    
    public void DFS(int[] numbers, int target, int index, int sum) {
        if(sum == target && index == numbers.length) {
            answer++;
            return;
        }
        if(index >= numbers.length) return;
        
        int num = numbers[index];
        DFS(numbers, target, index+1, sum + num);
        DFS(numbers, target, index+1, sum - num);
    }
}