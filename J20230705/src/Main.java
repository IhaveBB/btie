public class Main {
    public static void main(String [] args){
        System.out.println(judge("abaa"));
    }



    public static boolean judge (String str) {
        int length = str.length();
        int j = length-1;
        int sign = 0;
        boolean flag;
        for(int i = 0;i<length/2;i++){
            if(str.charAt(i)!=str.charAt(j)){
                sign++;
            }
            j--;
        }
        if(sign==0){
            flag = true;
        }
        else{
            flag =  false;
        }
        return flag;
    }

}

