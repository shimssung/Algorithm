class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++) {
            int count = 0;
            int day = startday;
            int hour = schedules[i] / 100 * 100;
            int minute = schedules[i] % 100 + 10;
            int schedule = minute > 59 ? hour + 100 + minute % 60 : hour + minute;
            for(int j = 0; j < timelogs[i].length; j++) {
                if(schedule < timelogs[i][j] && day % 7 != 6 && day % 7 != 0) {
                    count++;
                }
                day++;
            }
            answer += count == 0 ? 1 : 0;
        }
        
        return answer;
    }
}