#define _CRT_SECURE_NO_WARNINGS
////ʵ��һ�����������������ַ����е�k���ַ���
//#include<stdio.h>
//#include<string.h>
//int main()
//{
//	char arr[] = "ABCDEFG";
//	int len = strlen(arr);
//	int n = 0, tmp = 1;
//	scanf("%d", &n);//������λ
//	for (int i = n - 1; i >= 0; i--)
//	{
//		tmp = arr[len - 1];//�ݴ����һ����
//		for (int j = len - 1; j > 0; j--)
//		{
//			arr[j] = arr[j - 1];//
//		}
//		arr[0] = tmp;//���һ����Ų����һ��
//	}
//	printf("%s\n", arr);
//
//	return 0;
//}
// 
//���Ͼ����������
//#include<stdio.h>
//int main()
//{
//	int a[4][4] = { {1,5,7,9},{4,6,10,15},{8,11,12,19},{14,16,18,21} };
//	int i = 0;//����
//	int j = 3;//ÿһ�е�λ��
//	int key = 14;//��Ҫ���ҵ�Ԫ��
//	while (i < 4 && j >= 0)
//	{
//		if (key > a[i][j])
//		{
//			i++;
//		}
//		else if (key < a[i][j])
//		{
//			j--;
//		}
//		else
//		{
//			 printf("�ҵ��ˣ���Ԫ���ڵ� %d �е� %d �С�\n", i+1, j+1);
//            return 0;  // �ҵ�Ԫ�غ�ֱ�ӽ�������
//		}
//	}
//	printf("û�ҵ�");
//	return 0;
//}
