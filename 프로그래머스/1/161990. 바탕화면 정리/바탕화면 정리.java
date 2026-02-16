class Solution {
    public int[] solution(String[] wallpaper) {
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    if (i < minRow) minRow = i;
                    if (j < minCol) minCol = j;
                    if (i > maxRow) maxRow = i;
                    if (j > maxCol) maxCol = j;
                }
            }
        }


        return new int[]{minRow, minCol, maxRow + 1, maxCol + 1};
    }
}