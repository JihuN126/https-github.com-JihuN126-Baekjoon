class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int Num = x;
        int Sum = 0;
        while(x>0) {
            Sum += (x % 10);
            x/=10;
        }
        return Num % Sum == 0 ? true : false;
    }
}