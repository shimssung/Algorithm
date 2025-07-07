function solution(arr) {
    var answer = [];
    
    for(let idx in arr) {
        if(arr[idx] >= 50 && arr[idx] % 2 === 0) {
            answer[idx] = arr[idx]/2;
        } else if(arr[idx] < 50 && arr[idx] % 2 === 1) {
            answer[idx] = arr[idx]*2;
        } else {
            answer[idx] = arr[idx];
        } 
    }
    
    return answer;
}