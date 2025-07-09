class Solution {
    // 문자열을 초 단위로 변환
    public int toSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    // 초 단위를 "mm:ss" 형식의 문자열로 변환
    public String toTimeString(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = toSeconds(video_len);
        int position = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);

        // 오프닝 구간에 위치할 때 position을 opEnd로 설정
        if (opStart <= position && position < opEnd) {
            position = opEnd;
        }

        // 명령 처리
        for (String command : commands) {
            if (command.equals("prev")) {
                position = Math.max(0, position - 10);
            } else if (command.equals("next")) {
                position = Math.min(videoLen, position + 10);
            }
            
            // 이동 후 오프닝 구간에 위치하면 opEnd로 설정
            if (opStart <= position && position < opEnd) {
                position = opEnd;
            }
        }

        return toTimeString(position); // 결과를 반환
    }
}