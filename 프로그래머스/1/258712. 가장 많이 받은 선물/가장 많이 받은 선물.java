// 요약
// 두 사람이 선물은 주고받았다면 더 많은 선물을 준 사람이 선물을 하나 받는다.
// 두 사람이 선물을 주고받은 기록이 없거나 수가 같다면, 선물 지수가 더 큰 사람이 선물을 받는다.
// 선물 지수: 내가 나눠준 선물 - 받은 선물
// 만약 선물 지수까지 같다면 선물을 주고받지 않는다.
// friends: 친구들의 이름이 담겨있음
// gifts: 선물을 주고 받은 기록이 담겨있음
// 가장 많은 선물을 받을 친구의 선물의 수를 return 하라.

// 반복문으로 주는 사람과 받는 사람을 나누고
// 주고받은 테이블을 만들때
// 첫번째 사람을 friends에서 찾고 두번째 사람도 friends에서 찾아서 
// [첫번째 사람 index][두번째 사람 index]로 표를 만들면될듯

// 통계는 첫번째로 해당 이름이 몇번 나왔는지 += 1로 몇번줬는지
// 두번째로 해당 이름이 몇번 나왔는지 += 1로 몇번 받았는지
// 선물지수는 첫번째-두번째

class Solution {
  public int solution(String[] friends, String[] gifts) {
      int MaxGift = 0;
      int[][] giftTable = new int[friends.length][friends.length];  // 통계표
      int[][] giftcountTable = new int[friends.length][3];          // 선물지수 표
      int[][] resultTable = new int [friends.length][1];            // 결과 표(받을 선물의 개수)
      
      // 우선 gifts를 split으로 나눠야할듯
      for(int i = 0; i < gifts.length; i++) {
          String[] result = gifts[i].split(" ");
          String giver = result[0]; // 주는 사람(짝수)
          String receiver =result[1]; // 받는 사람(홀수)
          
          // 통계표
          int giverIndex = -1;
          int receiverIndex = -1;
          for(int j = 0; j < friends.length; j++) {
              if(friends[j].equals(giver)) {
                  giverIndex = j;
              }
              if(friends[j].equals(receiver)) {
                  receiverIndex = j;
              }

          }
          
          if(giverIndex != -1 && receiverIndex != -1) {
              giftTable[giverIndex][receiverIndex] += 1;
          }
          
      }
      
      // 준 선물
      for(int x = 0; x < friends.length; x++) {
          for(int y = 0; y < friends.length; y++) {
              giftcountTable[x][0] += giftTable[x][y];
          }
      }
      
      // 받은 선물
      for(int q = 0; q < friends.length; q++) {
          for(int w = 0; w < friends.length; w++) {
              giftcountTable[q][1] += giftTable[w][q];
          }
          // 선물지수
          giftcountTable[q][2] = giftcountTable[q][0] - giftcountTable[q][1];
      }
      
      // 이제 가장 많이 받는 사람을 찾아야함.
      for(int e = 0; e < friends.length; e++) {
          for(int r = 0; r < friends.length; r++) {
              // 본인 제외
              if(e != r) {
                  // 내가 상대방보다 준 선물이 많은 경우
                  if(giftTable[e][r] > giftTable[r][e]) {
                      resultTable[e][0] += 1;
                    
                    // 둘다 선물을 똑같이 주거나 안줫을경우(안줫을 경우 둘다 0) && 내가 선물 지수가 더 큰경우
                  } else if(giftTable[e][r] == giftTable[r][e] && giftcountTable[e][2] > giftcountTable[r][2]) {
                      resultTable[e][0] += 1;
 
                    // 나머지 그대로
                  } else {
                            resultTable[e][0] += 0;
                            resultTable[r][0] += 0;
                      } 
              }
          }
      }
      
      // 이제 가장 큰 수 리턴
      for(int i = 0; i < friends.length; i++) {
          if(resultTable[i][0] > MaxGift) {
              MaxGift = resultTable[i][0];
          }
      }
      
      
      

      return MaxGift;
  }
}