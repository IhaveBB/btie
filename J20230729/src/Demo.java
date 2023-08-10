import java.util.Arrays;

class Demo {
    //插入排序
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }

    //希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            gap = gap / 2;
            shellSort(array, gap);
        }
    }

    public static void shellSort(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int temp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (array[j] > temp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = temp;
        }
    }

    // 选择排序
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    //堆排序
    public static void heapSort(int[] array) {
        createBigHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            shiftDown(array, 0, i);
        }
    }

    private static void createBigHeap(int[] array) {
        for (int parent = (array.length - 1 - 1) / 2; parent >= 0; parent--) {
            shiftDown(array, parent, array.length);
        }
    }

    public static void shiftDown(int[] array, int parent, int end) {
        int child = parent * 2 + 1;
        while (child <= end) {
            if (child + 1 <= end && array[child] < array[child + 1]) {
                child++;
            }
            if (array[child] > array[parent]) {

                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;

                parent = child;
                child = parent * 2 + 1;
            } else {
                break;
            }
        }
    }


    public static void bubbbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }


    public static void quickSort(int[] array)  {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[j] >= pivot) {
                j--;
            }
            while (i < j && array[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        swap(array, left, i);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}