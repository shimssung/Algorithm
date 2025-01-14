import java.util.Scanner;

public class Main {

    public String answer(int n, String[] contents){
        char[] ch = new char[contents[0].length()];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < contents[0].length(); j++) {
                    if(i == 0) {
                        ch[j] = contents[i].charAt(j);
                    } else {
                        if(ch[j] != contents[i].charAt(j)) {
                            ch[j] = '?';
                        }
                    }
                    
                }
            }
        return new String(ch);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        String[] contents = new String[n];
        for(int i = 0; i < n; i++) {
            contents[i] = scan.next();
        }
        Main main = new Main();
        String result = main.answer(n, contents);
        System.out.print(result); 
        
        

	}
}