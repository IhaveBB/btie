#pragma warning(disable:4996)
////�ж�����������
//#include <stdio.h>
//
//int main() {
//    int a, b, c;
//    while (scanf("%d%d%d", &a, &b, &c) != EOF) {  // ��������������ֱ���ļ�����
//        if (a + b <= c || a + c <= b || b + c <= a) {  // �ж��Ƿ��ܹ���������
//            printf("Not a triangle!\n");  // ���ܹ���������
//        }
//        else if (a == b && b == c) {  // �ȱ�������
//            printf("Equilateral triangle!\n");
//        }
//        else if (a == b || b == c || c == a) {  // ����������
//            printf("Isosceles triangle!\n");
//        }
//        else {  // ��ͨ������
//            printf("Ordinary triangle!\n");
//        }
//    }
//    return 0;
//}





////����ˮ�ɻ�
////���磺
////655 = 6 * 55 + 65 * 5
////1461 = 1 * 461 + 14 * 61 + 146 * 1
////��� 5λ���е����� Lily Number��
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



////���������������е����У����������кϲ�Ϊһ���������в������
////����������
////����������У�
////��һ�а�������������n, m���ÿո�ָ���n��ʾ�ڶ��е�һ���������������ֵĸ�����m��ʾ�����еڶ����������������ֵĸ�����
////�ڶ��а���n���������ÿո�ָ���
////�����а���m���������ÿո�ָ���
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
//        scanf("%d", &arr[n + i]);    //ֱ�Ӱ���������ϲ���һ��
//    }
//    //��������
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