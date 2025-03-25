import java.util.*;

class Solution {
    // 사진별 추억점수 매기기
    // name: 그리워하는 사람의 이름을 담은 문자열 배열
    // yearning: 각 사람별 그리움 점수를 담은 정수 배열
    // photo: 각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        // hashMap함수를 이용해 풀면될거같음.
        HashMap<String, Integer> member = new HashMap<String, Integer>();
        
        for(int i = 0; i < name.length; i++) {
            member.put(name[i], yearning[i]);
        }
        int[] answer = new int [photo.length];
        
        for(int i = 0; i < photo.length; i++) {
            for(int j = 0; j < photo[i].length; j++) {
                
                // 점수가있을때만 추가
                if(member.containsKey(photo[i][j])){
                    answer[i] += member.get(photo[i][j]);
                }
            }
        }
        
        
        return answer;
    }
}