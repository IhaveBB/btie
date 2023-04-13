/*
//二分查找
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int key=sc.nextInt();
        int arr[]= {25,36,78,95,110,119,135};
        int x=find(arr,key);
        System.out.println(x);
    }


    public static int find(int[] arr,int key)
    {

        int high = arr.length-1;
        int low = 0;
        int mid;
        while(low<=high)
        {
            mid=(high+low)/2;
            if(key==arr[mid]) {
                return mid;
            }
            else if(key<arr[mid]) {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return -1;
    }
}*/



/*
//输出[m，n]之间的所有素数，素数之间用空格分隔，每个输出占一行。
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        find(n,m);
    }
    public static void find(int max,int min)
    {
        for(int i=min;i<=max;i++)
        {
            int sign=0;
            if(i==1)
            {
                continue;
            }
            for(int j=2;j<i;j++)
            {
                if(i%j==0)
                {
                    sign++;
                }
            }
            if(sign==0)
            {
                System.out.printf("%d ",i);
            }
        }

    }
}*/

/*
//线性查找
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        int sign=0;
        int arr[] = {25, 36, 78, 95, 110, 119, 135};
        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                System.out.print(i);
                sign=1;
            }
        }
        if(sign==0)
        {
            System.out.print(-1);
        }
        }
    }
*/


/*
//统计数字
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //接受输入的数字
        int[] arr = new int[n];
        //存储每个数字出现的次数
        int[] arr2=new int[10];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //一个几个数字，就循环几次
        for (int i = 0; i < arr.length; i++)
        {
            //每次循环都重新定义一个数值，用来判断出现了几次这个数。
            int tmp=arr[i];
            int sign=0;
            for (int j = 0; j <arr.length; j++) {
                if (arr[j] == tmp) {
                    sign++;
                }
            }
            arr2[tmp]=sign;
        }
        for(int i=0;i<10;i++)
        {
            System.out.printf("%d %d\n",i,arr2[i]);
        }
    }
}*/
