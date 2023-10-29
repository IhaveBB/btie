import java.lang.reflect.Array;
import java.util.Arrays;

public class PriorityQueue {
    public int[] elem;
    public int usedSize;

    public PriorityQueue() {
    }
    /**
     * 建堆的时间复杂度：
     *
     * @param array
     */
    public void createHeap(int[] array) {
        for (int root = (usedSize-1-1)/2; root >= 0 ; root--) {
            shiftDown(root,usedSize);
        }
    }

    /**
     *
     * @param root 是每棵子树的根节点的下标
     * @param len  是每棵子树调整结束的结束条件
     * 向下调整的时间复杂度：O(logn)
     */
    private void shiftDown(int root,int len) {
        //首先找出孩子节点
        int child = 2 * root +1;
        // 进入循环，只要存在有效的孩子节点，就执行下面的操作。
        while(child < len){
            // 判断是否有右孩子节点,并且child指向左右孩子中的最大的一个
            if(child + 1 < len && elem[child + 1] > elem[child]){
                child++;
            }
            // 判断孩子节点是否大于父节点
            if(elem[child] > elem[root]){
                // 交换
                swap(child,root);
                // 继续向下调整
                root = child;
                child = 2 * root + 1;
            }else{
                break;
            }

        }

    }

    private void swap(int child, int root) {
        int temp = elem[child];
        elem[child] = elem[root];
        elem[root] = temp;
    }


    /**
     * 入队：仍然要保持是大根堆
     * @param val
     */
    public void push(int val) {
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        // 插入到最后一个位置
        this.elem[usedSize] = val;
        shiftUp(usedSize);
        usedSize++;

    }

    private void shiftUp(int child) {
        int root = (child - 1) / 2;
        while(child > 0){
            //因为已经是大跟堆，所以堆顶元素肯定大于左边，所以只需要判断右边和堆顶的关系即可
            if(elem[child] > elem[root]){
                swap(child,root);
                // 继续向上调整
                child = root;
                root = (child - 1) / 2;
            }else{
                break;
            }
        }
    }




    public boolean isFull() {
        return usedSize == elem.length;
    }

    /**
     * 出队【删除】：每次删除的都是优先级高的元素
     * 仍然要保持是大根堆
     */
    public void pollHeap() {
        int tmp = elem[0];
        swap(0,usedSize-1);
        usedSize--;
        shiftDown(0,usedSize);
    }

    public boolean isEmpty() {
        return false;
    }

    /**
     * 获取堆顶元素
     * @return
     */
    public int peekHeap() {
        return elem[0];
    }
}