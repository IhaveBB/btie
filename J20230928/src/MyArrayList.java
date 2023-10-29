import javax.sound.midi.Soundbank;
import java.util.Arrays;

/*
完成顺序表代码（30）
进行测试确保正确（20）
写出设计过程中遇到的问题和解决（40）
写出练习经历，比如一共写了几遍完整代码，是否参考书籍等（10）
 */
class MyArraylist {
    public int[] elem;
    public int usedSize;
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
            System.out.print(elem[i]+" ");
        }
        System.out.println();
    }

    // 新增元素,默认在数组最后新增
    public void add(int data) {
        if (isFull()) {
            //二倍扩容
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        elem[usedSize] = data;
        usedSize++;
    }

    /**
     * 判断当前的顺序表是不是满的！
     *
     * @return true:满   false代表空
     */
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }


    private boolean checkPosInAdd(int pos) {
        if (pos < 0 || pos >= this.usedSize) {
            return false;
        }
        return true;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if (!checkPosInAdd(pos)) {
            throw new MyArrayListIndexOutOfException("下标不合法");
        }
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        for (int i = usedSize - 1; i >= pos; i--) {
            elem[i + 1] = elem[i];
            i--;
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) {
                return i;
            }
        }
        return -1;
    }


    // 获取 pos 位置的元素
    public int get(int pos) {
        if (!checkPosInAdd(pos)){
            throw new MyArrayListIndexOutOfException("下标不合法");
        }
        if(isEmpty()){
            throw new MyArrayListIndexOutOfException("顺序表为空");
        }
        return this.elem[pos];
    }

    private boolean isEmpty() {
        if (usedSize == 0) {
            return true;
        }
        return false;
    }

    // 给 pos 位置的元素设为【更新为】 value
    public void set(int pos, int value) {
        if (!checkPosInAdd(pos)) {
            throw new MyArrayListIndexOutOfException("下标不合法");
        }
        if (isEmpty()) {
            throw new MyArrayListIndexOutOfException("顺序表为空");
        }
        this.elem[pos] = value;
    }

    /**
     * 删除第一次出现的关键字key
     *
     * @param key
     */
    public void remove(int key) {
        if (isEmpty()) {
            throw new MyArrayListIndexOutOfException("顺序表为空");
        }
        int index = indexOf(key);
        if (index == -1) {
            System.out.println("不存在你要删除的数据");
            return;
        }
        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }

    // 获取顺序表长度
    public int size() {
        return usedSize;
    }

    // 清空顺序表
    public void clear() {
        /*
        for (int i = 0; i < this.usedSize; i++) {
            this.elem[i] = null;
        }*/
        this.usedSize = 0;
    }
}