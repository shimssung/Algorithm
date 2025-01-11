import java.util.Arrays;

class Solution {
    // mats : 돗자리들의 한 변의 길이들이 담긴 정수 리스트
    // park : 현재 공원 자리 배치도
    public int solution(int[] mats, String[][] park) {
         int rows = park.length;
        int cols = park[0].length;
        int maxSize = -1;

        Arrays.sort(mats);

        for (int m = mats.length - 1; m >= 0; m--) {
            boolean canPlace = false;

            for (int i = 0; i <= rows - mats[m]; i++) {
                for (int j = 0; j <= cols - mats[m]; j++) {
                    boolean allMinusOne = true;

                    for (int x = i; x < i + mats[m]; x++) {
                        for (int y = j; y < j + mats[m]; y++) {
                            if (!park[x][y].equals("-1")) {
                                allMinusOne = false;
                                break;
                            }
                        }
                        if (!allMinusOne) break;
                    }

                    if (allMinusOne) {
                        canPlace = true;
                        break;
                    }
                }
                if (canPlace) break;
            }

            if (canPlace) {
                maxSize = mats[m];
                break;  
            }
        }

        return maxSize;
    }
}