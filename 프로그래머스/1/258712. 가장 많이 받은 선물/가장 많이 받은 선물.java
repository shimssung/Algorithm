import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        HashMap<String, Integer> friend = new HashMap<>();
        for (int i = 0; i < n; i++) {
            friend.put(friends[i], i);
        }

        int[][] giftMap = new int[n][n + 1]; // 마지막 열(n)은 선물지수용
        int[] give = new int[n]; // 준 선물 수
        int[] take = new int[n]; // 받은 선물 수

        // 선물 기록 누적
        for (String gift : gifts) {
            String[] m = gift.split(" ");
            int from = friend.get(m[0]);
            int to = friend.get(m[1]);

            giftMap[from][to]++;
            give[from]++;
            take[to]++;
        }

        // 선물 지수 계산: giftMap[i][n] = 준 - 받은
        for (int i = 0; i < n; i++) {
            giftMap[i][n] = give[i] - take[i];
        }

        int[] gift = new int[n];

        // 다음 달에 받을 선물 계산
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i == j) continue;

                if (giftMap[i][j] > giftMap[j][i]) {
                    gift[i]++;
                } else if (giftMap[i][j] < giftMap[j][i]) {
                    gift[j]++;
                } else {
                    if (giftMap[i][n] > giftMap[j][n]) {
                        gift[i]++;
                    } else if (giftMap[i][n] < giftMap[j][n]) {
                        gift[j]++;
                    }
                }
            }
        }

        // 가장 많이 받는 친구의 선물 수 반환
        int max = 0;
        for (int g : gift) {
            max = Math.max(max, g);
        }

        return max;
    }
}
