
class Solution {
    public String solution(String str1, String str2) {
        char[] str3 = str1.toCharArray();
        char[] str4 = str2.toCharArray();
        char[] result = new char[str3.length*2];
        for(int i = 0; i < str3.length; i++) {
            result[i*2] = str3[i];
            result[i*2+1] = str4[i];
        }
        String str_result = new String(result);
        return str_result;
    }
}