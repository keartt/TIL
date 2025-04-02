class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = 52, minY = 52;
        int maxX = -1, maxY = -1;
        for (int i = 0; i < wallpaper.length; i++) {
            char[] arr = wallpaper[i].toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == '#'){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        return new int[] {minX, minY, maxX + 1, maxY + 1};
    }
}