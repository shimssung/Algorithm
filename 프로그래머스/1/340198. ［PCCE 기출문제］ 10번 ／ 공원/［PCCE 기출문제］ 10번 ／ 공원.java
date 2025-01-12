import java.util.Arrays;

class Solution {
    // mats : 돗자리들의 한 변의 길이들이 담긴 정수 리스트
    // park : 현재 공원 자리 배치도
    public int solution(int[] mats, String[][] park) {
        int rows = park.length; // 공원의 세로 길이
        int cols = park[0].length; // 공원의 가로 길이
        int maxSize = -1; // 최대 가능한 돗자리 크기(없을 경우 -1)

        Arrays.sort(mats); // 큰 돗자리부터 구하고 가능하면 바로 종료하기 위해 정렬

        // 정렬 후 제일 큰 뒤에서 부터 시작
        for (int m = mats.length - 1; m >= 0; m--) {
            boolean canPlace = false; // 사용 가능한 돗자리 찾으면 바로 종료

            // 공원 전체 크기에서 사용가능한 돗자리 만큼 빼서 돗자리가 들어갈 공간만 확인.
            for (int i = 0; i <= rows - mats[m]; i++) {
                for (int j = 0; j <= cols - mats[m]; j++) {
                    boolean allMinusOne = true;

                    // 가능한 크기를 한칸씩 이동하며 돗자리 크기가 전부 -1인지 확인
                    for (int x = i; x < i + mats[m]; x++) {
                        for (int y = j; y < j + mats[m]; y++) {
                            if (!park[x][y].equals("-1")) {
                                allMinusOne = false;
                                break;
                            }
                        }
                        if (!allMinusOne) break;
                    }

                    // 전부 -1이라면 allMinusOne은 true 상태임 즉, 사용가능한 mat[m]을 찾음.
                    if (allMinusOne) {
                        canPlace = true; // 반복문 종료하기 위해 canPlace를 true로 변환.
                        break;
                    }
                }
                if (canPlace) break; // 사용 가능한 돗자리 찾으면 바로 종료
            }

            if (canPlace) {
                maxSize = mats[m];
                break;  
            }
        }

        return maxSize;
    }
}
