class Solution {
    // schedules: 출근희망시간 배열
    // timelogs: 출근한 시간
    // startday: 이벤트 시작 요일
    // 상품을 받을 수 있는 직원의 수 리턴
    // 1: 월, 2: 화, 3: 수, 4: 목, 5: 금, 6: 토, 7: 일
    // startday가 5보다 클때는 +3 이후 인덱스부터 시작.
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        // 희망출근시간 + 10을 해야함 59이상일 경우 60으로 나눠서 몫은 100을 곱해서 더해주고 나머지는 그냥 더하기
        // 출근 인정시간
        int[] agreeTime = new int[schedules.length];
        for (int i = 0; i < schedules.length; i++) {
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100;
            minute += 10; // 10분 추가
            if(minute >= 60) {
                hour++;
                minute -= 60;
            }
            agreeTime[i] = hour * 100 + minute;
        }
        
        int answer = 0;
        
        // 원래는 요일을 6, 7만 아니면 되도록해도 괜찮다고 생각했음 하지만 요일이 7로 지삭하면 그 다음 토요일을 인식하지 못함
        for(int j = 0; j < schedules.length; j++) {
            int count = 0;
            int daynum = startday;
            
            for(int i = 0; i < 7; i++) {
                if(daynum != 6 && daynum != 7) {
                    count += agreeTime[j] >= timelogs[j][i] ? 1 : 0;
                }
                daynum++;
                if(daynum > 7) {
                    daynum = daynum%7;
                }
            }
            
            if(count == 5) {
                answer += 1;
            }
        }
        
        return answer;
    }
}