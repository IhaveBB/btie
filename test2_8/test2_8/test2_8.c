#pragma warning(disable:4996)
////判断三角形种类
//#include <stdio.h>
//
//int main() {
//    int a, b, c;
//    while (scanf("%d%d%d", &a, &b, &c) != EOF) {  // 读入三个整数，直到文件结束
//        if (a + b <= c || a + c <= b || b + c <= a) {  // 判断是否能构成三角形
//            printf("Not a triangle!\n");  // 不能构成三角形
//        }
//        else if (a == b && b == c) {  // 等边三角形
//            printf("Equilateral triangle!\n");
//        }
//        else if (a == b || b == c || c == a) {  // 等腰三角形
//            printf("Isosceles triangle!\n");
//        }
//        else {  // 普通三角形
//            printf("Ordinary triangle!\n");
//        }
//    }
//    return 0;
//}





////变种水仙花
////例如：
////655 = 6 * 55 + 65 * 5
////1461 = 1 * 461 + 14 * 61 + 146 * 1
////求出 5位数中的所有 Lily Number。
//#include<stdio.h>
//int main()
//{
//    int a, b, c, d;
//    for (int i = 10000; i < 99999; i++)
//    {
//        a = (i / 10000) * (i % 10000);
//        b = (i / 1000) * (i % 1000);
//        c = (i / 100) * (i % 100);
//        d = (i / 10) * (i % 10);
//        if (i == a + b + c + d)
//            printf("%d ", i);
//    }
//    return 0;
//}



////输入两个升序排列的序列，将两个序列合并为一个有序序列并输出。
////输入描述：
////输入包含三行，
////第一行包含两个正整数n, m，用空格分隔。n表示第二行第一个升序序列中数字的个数，m表示第三行第二个升序序列中数字的个数。
////第二行包含n个整数，用空格分隔。
////第三行包含m个整数，用空格分隔。
//#include<stdio.h>
//int main() {
//    int n = 0, m = 0, i = 0, j = 0, k = 0;
//    scanf("%d %d", &n, &m);
//    int len = m + n;
//    int arr[30000];
//    for (i = 0; i < n; i++) {
//        scanf("%d", &arr[i]);
//    }
//    for (i = 0; i < m; i++) {
//        scanf("%d", &arr[n + i]);    //直接把两个数组合并成一个
//    }
//    //升序排序
//    for (int i = 0; i < len; i++) {
//        for (int j = i + 1; j < len; j++) {
//            if (arr[i] > arr[j]) {
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//        }
//    }
//    for (int i = 0; i < n + m; i++) {
//        printf("%d ", arr[i]);
//    }
//    return 0;
//}