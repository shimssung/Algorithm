class Solution {
    public int solution(int n, int w, int num) {
        
        // 상자 개수
        int box = n;

        // 세로 크기 (상자 개수에서 가로 크기를 나눈 몫 + 1)
        int y = 0;
        
        if(n%w == 0) {
            y = n/w;
        } else {
            y = n/w + 1;
        }

        // num가 몇층에있는지 확인
        int flor = 0;
        if(num < w) {
            flor = 1;
        } else if((num%w) == 0) {
            flor = (num/w);
        } else {
            flor = (num/w) + 1;
        }
        
        // num에 해당하는 층에서 꼭대기 -1 까지는 무조건 꺼내야하는 박스 + 꺼내야하는 박스 (내 박스) 1
        int outBox = y - flor;
        
        // 이제 꼭대기에서 내 위치에 박스가 있는지 없는지 체크
        // 층의 위치가 짝수면 오른쪽에서 왼쪽
        // 현재 층의 위치가 홀수면 왼쪽에서 오른쪽
        // 우선 내 위치 인덱스 찾기 현재 층수 * w - num
        int index = 0;
        if(flor == 1) {
            index = num;
        } else if(flor%2 == 0) {
            index = ( (flor * w) - num + 1) ;
        } else {
            index = w - ((flor * w) - num);
            
        }

        
        // 최고층에 올라갈 박스 개수
        int topBox = w - (w * y - box);
        
        if(y == 1 || flor == y) {
            outBox += 1;
        } else if(y%2 == 1) {
            outBox += topBox >= index ? 1 : 0;  
        } else {
            outBox += index > w - topBox ? 1 : 0;
        }
        
        return outBox;
    }
}