function solution(code) {
    var answer = '';
    let mode = 0;
    // mode가 0일때는 짝수, 1일때는 홀수 문자 붙이기
    // code에서 "1"이 나올때 mode를 바꾼다.
    
    for(let i = 0; i < code.length; i++) {
        if(code[i] === '1') {
            mode = mode === 1 ? 0 : 1;
        } else if(i % 2 === 0 && mode === 0) {
            answer += code[i];
        } else if(i % 2 === 1 && mode === 1) {
            answer += code[i];
        }
    }
    
    return answer = answer === "" ? "EMPTY" : answer;
}