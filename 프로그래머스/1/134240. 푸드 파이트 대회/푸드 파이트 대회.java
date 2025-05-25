class Solution {

    public String solution(int[] food) {
        StringBuilder left = new StringBuilder();

        // 왼쪽 문자열 구성: 음식 번호 낮은 것부터
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            for (int j = 0; j < count; j++) {
                left.append(i);
            }
        }

        // 오른쪽은 왼쪽을 뒤집은 것
        String right = left.reverse().toString();  // 뒤집은 뒤 다시 문자열로
        left.reverse(); // 원래 방향으로 복구

        // 가운데 물(0) 추가해서 조합
        return left.toString() + "0" + right;
    }
}
