import java.util.*;

class Solution {
    // 길: O
    // 장애물: X
    // ex: [E, 5] = 동쪽으로 5칸 이동
    // 명령 수행 전 확인해야 할 두가지
    // 1. 주어진 방향으로 이동할 때 공원을 벗어나는지 확인
    // 2. 주어진 방향으로 이동 중 장애물을 만나는지 확인
    // 하나라도 해당된다면, 명령을 무시하고 다음 명령을 수행
    // 공원 가로 길이: W
    // 공원 세로 길이: H
    // park: 공원
    // routes: 로봇 강아지가 수행할 명령이 담긴 문자열 배열
    // 명령이 끝난 후 로봇 강아지의 위치 리턴
    public int[] solution(String[] park, String[] routes) {
        
        int[] location = new int[2]; // 현재 위치
        
        char[] column = park[0].toCharArray(); 
        int w = column.length; //가로 넓이
        int h = park.length; // 세로 넓이
        
        char[][] map = new char[park.length][column.length];
        // 장애물이 있는 위치의 좌표만을 가지고 공원을 벗어나는지 장애물이 있는지 확인하면될듯
        // 우선 park[i]에 들어있는 문자열을 char[]로 바꿔야함.
        for(int i = 0; i < park.length; i++) {
            char[] park_info = park[i].toCharArray();
            for(int j = 0; j < park_info.length; j++) {
                map[i][j] = park_info[j];
                if(park_info[j] == 'S') {
                    location[0] = i;
                    location[1] = j;
                } 
            }
        }
        
        // E: 동, W: 서, S: 남, N: 북
        for(int i = 0; i < routes.length; i++) {
            
            String[] parts = routes[i].split(" ");
            String direction = parts[0];          // 방향
            int steps = Integer.parseInt(parts[1]);  // 칸 수
            
            if (direction.equals("E")) {
                
                // 먼저 공원 범위 벗어나는지 확인
                if (location[1] + steps >= w) continue;

                boolean blocked = false;
                for (int j = 1; j <= steps; j++) {
                    if (map[location[0]][location[1] + j] == 'X') {
                        blocked = true;
                        break;
                    }
                }

                if (!blocked) location[1] += steps;
            }

            
            if (direction.equals("W")) {
                if (location[1] - steps < 0) continue;

                boolean blocked = false;
                for (int j = 1; j <= steps; j++) {
                    if (map[location[0]][location[1] - j] == 'X') {
                        blocked = true;
                        break;
                    }
                }

                if (!blocked) location[1] -= steps;
            }

            
            if (direction.equals("S")) {
                if (location[0] + steps >= h) continue;

                boolean blocked = false;
                for (int j = 1; j <= steps; j++) {
                    if (map[location[0] + j][location[1]] == 'X') {
                        blocked = true;
                        break;
                    }
                }

                if (!blocked) location[0] += steps;
            }

            
            if (direction.equals("N")) {
                if (location[0] - steps < 0) continue;

                boolean blocked = false;
                for (int j = 1; j <= steps; j++) {
                    if (map[location[0] - j][location[1]] == 'X') {
                        blocked = true;
                        break;
                    }
                }

                if (!blocked) location[0] -= steps;
            }
    
            
            
            
            
        }
        
        int[] answer = {};
        return location;
    }
}