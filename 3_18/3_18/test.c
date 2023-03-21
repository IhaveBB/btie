#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
////定义学生类型
//struct stu {
//	char name[20];
//	int age;
//	float weight;
//}s3,s4,s5;//s3 s4 s5为全局变量
//int main()
//{
//	struct stu s1;
//	struct stu s2;
//	//s1 s2为局部边变量
//	return 0;
//}


////匿名结构体
//struct
//{
//	char c;
//	int a;
//	double d;
//}s1;
////匿名结构体指针
//struct
//{
//	char c;
//	int a;
//	double d;
//}* ps;
//
//int main()
//{
//		printf("&s1:%p\n",&s1);
//		printf("p: %p ",ps);
//	return 0;
//}


////结构体自引用
//struct Node
//{
//	int data;//4字节
//	struct Nude* nest;
//};
//int main()
//{
//	struct Node n1;
//	struct Node n2;
//	n1.nest = &n2;
//	return 0;
//}

////自引用结构体，不可食用typedef来定义结构体名。
////结构体名最后才被定义，中间的note* nest自然不存在。
//typedef struct
//{
//	int data;//4字节
//	struct Nude* nest;
//}Node;


//结构体的初始化和使用
//struct S
//{
//	int a;
//	char c;
//};
//struct B
//{
//	float f;
//	struct S s;
//};
//int main()
//{
//	struct B sb = { 3.14f,{200,"w"}};
//	printf("%f,%d,^c", sb.f, sb.s.a, sb.s.c);
//	return 0;
//}


////结构体传参
//struct S
//{
//	int data[1000];
//	int num;
//};
//struct S s = { {1,2,3,4},1000 };
//void print1(struct S m)
//{
//	printf("%d\n", m.num);
//}
//void print2(const struct S* ps)
//{
//	printf("%d\n", ps->num);
//}
//int main()
//{
//	print1(s);
//	print2(&s);
//	return 0;
//}


////位段
//struct A
//{
//	int _a : 2;
//	int _b : 5;
//	int _c : 10;
//	int _d : 30;
//};
//int main()
//{
//	struct A sa = { 0 };
//	printf("%d\n", sizeof(struct A));
//}


////枚举
//enum Sex
//{
//	//枚举的可能取值
//	MALE,
//	FMALE=5,
//	SECRET
//};
//int main()
//{	
//	printf("%d\n", MALE);
//	printf("%d\n", FMALE);
//	printf("%d\n", SECRET);
//}


//enum OPTION
//{
//	EXIT,
//	PLAY
//};
//int main()
//{
//	enum OPTION op = EXIT;
//}
//
//enum Color
//{
//	RED = 1,
//	GREEN=2,
//	BLUE=4
//};
//enum Color clr = GREEN;
//clr = 5;

#include<stdio.h>
int main()
{
	int i, t;
	t = 1;
	i = 2;
	while (i <= 5)
	{
		t = t * i;
		i = i + 1;
	}
	printf("%d\n", t);
	return 0;
}