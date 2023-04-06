#define _CRT_SECURE_NO_WARNINGS
#include<string.h>
#include<stdio.h>
#include<assert.h>
#include<stdlib.h>
#include"contact.h"

void InitContact(struct Contact* pc)
{

	assert(pc);
	pc->data = (PeoInfo*)malloc(DEFAULT_SZ * sizeof(PeoInfo));
	if (pc->data == NULL) {
		printf("通讯录初始化失败%s", strerror(errno));
		return;
	}
	pc->sz = 0;
	pc->capacity = DEFAULT_SZ;
}

//void AddContact(Contact* pc)
//{
//	if (pc->sz == MAX)//判断通讯里满了吗
//	{
//		printf("通讯录已满，无法增加\n");
//		return;
//	}
//	printf("请输入名字:>");
//	scanf("%s", pc->data[pc->sz].name);
//	printf("请输入年龄");
//	scanf("%d", &pc ->data[pc ->sz].age);
//	printf("请输入性别");
//	scanf("%s", pc->data[pc->sz].sex);
//	printf("请输入电话");
//	scanf("%s", pc->data[pc->sz].tele);
//	printf("请输入地址");
//	scanf("%s", pc->data[pc->sz].addr);
//
//	pc->sz++;
//	printf("添加成功\n");
//}

void DestoryContact(struct Contact* pc)//销毁
{
	free(pc->data);
	pc->data = NULL;
	pc->capacity = 0;
	pc->sz = 0;
}


int CheckCapacity(Contact* pc)
{
	if (pc->sz == pc->capacity)
	{
		PeoInfo* ptr = (PeoInfo*)realloc(pc->data, (pc->capacity + 2) * sizeof(PeoInfo));
		if ( ptr == NULL)
		{
			printf("CheckCapacity %s", strerror(errno));
			return 0;
		}
		else {
			pc->capacity += INC_SZ;
			printf("增容成功");
			return 1;
		}
	}
}

//动态增加联系人

void AddContact(struct Contact* pc)//增加信息到通讯录当中
{
	int a = CheckCapacity(pc);
	if (a == 0)
	{
		printf("失败\n");
		return;
	}

	printf("请输入名字:>");
	scanf("%s", pc->data[pc->sz].name);
	printf("请输入性别:>");
	scanf("%s", pc->data[pc->sz].sex);
	printf("请输入年龄:>");
	scanf("%d", &pc->data[pc->sz].age);
	printf("请输入电话:>");
	scanf("%s", pc->data[pc->sz].tele);
	printf("请输入地址:>");
	scanf("%s", pc->data[pc->sz].addr);
	pc->sz++;
	printf("成功增加联系人\n");


}



void ShowContact(Contact* pc)
{
	int i = 0;
	printf("%-10s %-4s %-5s %-12s %-30s\n", "姓名", "年龄", "性别", "电话", "地址");
	for (i = 0; i < pc->sz; i++)
	{

		printf("%s %d %s %s %s\n", pc->data[i].name, pc->data[i].age, pc->data[i].sex, pc->data[i].tele, pc->data[i].addr);
	}
}


void DestroyConact(Contact* pc) {
	free(pc->data);
	pc->data = NULL;
	pc->capacity = 0;
	pc->sz = 0;
	printf("释放内存\n");                                            
}
void DelContact(pContact pc)
{
	char name[MAX_NAME] = { 0 };
	if (pc->sz == 0)
	{
		printf("通讯录为空，无法删除");
		return;
	}
	//1.找到要删除人的信息
	printf("请输入要删除人的名字:>");
	scanf("%s", name);
	int pos = FindByName(pc, name);
	if (pos == -1)
	{
		printf("要删除的人不存在");
		return;
	}
	int i = 0;
	for (i = pos; i < pc->sz - 1; i++)
	{
		pc->data[i] = pc->data[i + 1];
	}
	pc->sz--;
	printf("删除成功");
}


void SearchContact(pContact pc)
{
	char name[MAX_NAME] = { 0 };
	printf("请输入查找人的信息");
	scanf("%s", name);
	int pos = FindByName(pc, name);
	if (pos == -1)
	{
		printf("要查找的人不存在\n");
		return;
	}
	//打印
	printf("%-10s %-4s %-5s %-12s %-30s\n", "姓名", "年龄", "性别", "电话", "地址");
	printf("%s %d %s %s %s\n", pc->data[pos].name, pc->data[pos].age, pc->data[pos].sex, pc->data[pos].tele, pc->data[pos].addr);
	

}


void ModifyContact(Contact* pc)
{
	char name[MAX_NAME] = { 0 };
	printf("请输入要修改人的姓名:>");
	scanf("%s", name);
	int pos=FindByName(pc, name);
	if (pos == -1)
	{
		printf("要修改的人不存在");
		return;
	}
	//修改
	printf("请输入名字");
	scanf("%s", pc->data[pos].name);
	printf("请输入年龄");
	scanf("%d", pc->data[pos].age);
	printf("请输入性别");
	scanf("%s", pc->data[pos].sex);
	printf("请输入电话");
	scanf("%s", pc->data[pos].tele);
	printf("请输入地址");
	scanf("%s", pc->data[pos].addr);

	printf("修改成功");
}
//qsort函数比较方法
int cmp_by_name(void* e1,void* e2)
{
	return strcmp(((PeoInfo*)e1)->name, ((PeoInfo*)e2)->name);
}
void SortContact(Contact* pc)
{

	qsort(pc->data, pc->sz, sizeof(PeoInfo), cmp_by_name);
	printf("排序成功");
}

static int FindByName(Contact* pc, char name[])
{
	int i = 0;
	int pos = 0;
	for (i = 0; i < pc->sz; i++)
	{
		if (0 == strcmp(pc->data[i].name, name))
		{
			return i;
		}
		return -1;
	}
}