import java.util.*; 
class Solution { 
    public String solution(long n, String[] bans) { 
    //리스트 안의 문자들을 정수로 변환해서 해시에 집어넣기. 
    //해시셋 안에서 n보다 작은거나 같은 숫자의 개수를 구해서 n에 그만큼 더해주기. 
    //n에 더해주는 과정에서 해시안의 값이 있다면 제외하고 더하기. 
    HashSet<Long> set = new HashSet<>(); 
    int counter=0; 
    for(String s: bans){ 
        set.add(convertToInt(s)); 
    }
    for(long i: set){ 
        if(i<=n){ 
            counter++;
        }
    }
    for(int i=0;i<counter;i++){ 
        n++; 
        while(set.contains(n)){
            n++; 
        }
    } 
    String answer = convertToString(n); 
    return answer; 
    } 
                                    
    public long convertToInt(String s){
        long total=0; 
        long c= 1; 
        for(int i=s.length()-1;i>=0;i--){
            total+=(c*(s.charAt(i)-'a'+1)); c=c*26;
        } 
        return total;
    } 
                                    
    public String convertToString(long n){
        StringBuilder sb = new StringBuilder();
        while(n>0){ 
            sb.append((char)('a'+(n-1)%26)); n=(n-1)/26; 
        } 
        
        return sb.reverse().toString(); 
    } 
}