function solution(num_list) {
    let size = num_list.length;
    let answer = size > 10 ? 0 : 1;
    
    if(size > 10) {
        for(let num of num_list) {
            answer += num;
        }
    } else {
            for(let num of num_list) {
            answer *= num;
        } 
    }
    
    return answer;
}