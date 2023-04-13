public class MyInteger {
    int value;
    MyInteger(int value) {
        this.value = value;
    }
    boolean isEven(){
        return value % 2 == 0? true : false;
    }
    boolean isOdd(){
        return value % 2 == 1? true : false;
    }
    boolean isPrimeNumber(){
        for(int i=2; i<value; i++){
            if(value % i == 0){
                return false;
            }
        }
        return true;
    }

    static boolean isEven(int value){
        return value % 2 == 0? true : false;
    }
   static boolean isOdd(int value){
        return value % 2 == 1? true : false;
    }
    static boolean isPrimeNumber(int value){
        for(int i=2; i<value; i++){
            if(value % i == 0){
                return false;
            }
        }
        return true;
    }
}
