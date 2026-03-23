class Solution {
    public int solution(int n) {
        int tile[] = new int[60001];
        int answer = 0;
        tile[1]=1;
        tile[2]=2;
        for(int i=3;i<=n;i++) {
            tile[i] = (tile[i-1] + tile[i-2]) % 1000000007;
        }
        return tile[n];
    }
}