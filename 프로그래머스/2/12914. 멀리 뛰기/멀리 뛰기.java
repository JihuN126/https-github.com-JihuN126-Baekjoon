class Solution {
    public long solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] F = new long[n + 1];
        F[1] = 1;
        F[2] = 2;

        for (int i = 3; i <= n; i++) {
            F[i] = (F[i - 1] + F[i - 2]) % 1234567;
        }

        return F[n];
    }
}