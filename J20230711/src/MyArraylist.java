import java.util.Arrays;

/**
 * @author IhaveBB
 */
public class MyArraylist {

    public int[] elem;
    public int usedSize;//0
    //默认容量
    private static final int DEFAULT_SIZE = 10;

    public MyArraylist() {
        this.elem = new int[DEFAULT_SIZE];
    }

    /**
     * 打印顺序表:
     * 根据usedSize判断即可
     */
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.println(elem[i] + " ");
        }
    }

    // 新增元素,默认在数组最后新增
    public void add(int data) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }
    

    /**
     * 判断当前的顺序表是不是满的！
     *
     * @return true:满   false代表空
     */
    public boolean isFull() {
        if (this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }


    private boolean checkPosInAdd(int pos) {
        if (pos < 0 || pos >= this.usedSize) {
            throw new PosOutOfBoundsException("Given position is out of bounds!");
        }
        return true;//合法
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //先检测pos是否合法，然后检测是否需要扩容
        if (checkPosInAdd(pos)) {
            if (isFull()) {
                this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
            }
        }
        //从后往前依次挪动，最后一个到新增的位置，倒数第二个到倒数第一个位置.挪到pos位置即可
        for(int i=this.usedSize-1;i>=pos;i--){
            this.elem[i+1]=this.elem[i];//依次往后挪一个
        }
        this.elem[pos]=data;
        this.usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for(int i=0;i<this.usedSize;i++){
            if(elem[i]==toFind){
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for(int i=0;i<this.usedSize;i++){
            if(elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int get(int pos) {
        //先检测pos是否合法.
        checkPosInAdd(pos);
        return this.elem[pos];
    }
    //判断是否为空
    private boolean isEmpty() {
        if(usedSize==0){
            return true;
        }
        return false;
    }

    // 给 pos 位置的元素设为【更新为】 value
    public void set(int pos, int value) {
        //判断pos是否合法
        checkPosInAdd(pos);
        this.elem[pos] = value;
    }

    /**;
     */
    public void remove(int key) {
        int index = indexOf(key);
        if(index == -1){
            System.out.println("Can't remove. The key is not found.");
            return;
        }
        for(int i=index;i<usedSize-1;i++){
            //从index位置开始，每个元素往前面挪一个
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }

    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}


class PosOutOfBoundsException extends RuntimeException {
    public PosOutOfBoundsException(String message) {
        super(message);
    }
}