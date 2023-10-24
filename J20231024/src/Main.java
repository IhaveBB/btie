
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Character,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        for(int i = 'a'; i <= 'z'; i ++){
            map.put((char)i,0);
        }
        while (sc.hasNext()) {
            String string = sc.nextLine();
                for(char c : string.toCharArray()) {
					if(c == '#'){
						break;
					}
                    if (c >= 'a' && c <= 'z') {
                        if (map.containsKey(c)) {
                            map.put(c, map.get(c) + 1);
                        } else {
                            map.put(c, 1);
                        }
                    }else{
                        continue;
                    }
                }
        }
        for(char c : map.keySet()){
            System.out.println(c + " "+map.get(c));
        }
    }
}