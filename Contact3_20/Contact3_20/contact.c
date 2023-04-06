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
		printf("ͨѶ¼��ʼ��ʧ��%s", strerror(errno));
		return;
	}
	pc->sz = 0;
	pc->capacity = DEFAULT_SZ;
}

//void AddContact(Contact* pc)
//{
//	if (pc->sz == MAX)//�ж�ͨѶ��������
//	{
//		printf("ͨѶ¼�������޷�����\n");
//		return;
//	}
//	printf("����������:>");
//	scanf("%s", pc->data[pc->sz].name);
//	printf("����������");
//	scanf("%d", &pc ->data[pc ->sz].age);
//	printf("�������Ա�");
//	scanf("%s", pc->data[pc->sz].sex);
//	printf("������绰");
//	scanf("%s", pc->data[pc->sz].tele);
//	printf("�������ַ");
//	scanf("%s", pc->data[pc->sz].addr);
//
//	pc->sz++;
//	printf("��ӳɹ�\n");
//}

void DestoryContact(struct Contact* pc)//����
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
			printf("���ݳɹ�");
			return 1;
		}
	}
}

//��̬������ϵ��

void AddContact(struct Contact* pc)//������Ϣ��ͨѶ¼����
{
	int a = CheckCapacity(pc);
	if (a == 0)
	{
		printf("ʧ��\n");
		return;
	}

	printf("����������:>");
	scanf("%s", pc->data[pc->sz].name);
	printf("�������Ա�:>");
	scanf("%s", pc->data[pc->sz].sex);
	printf("����������:>");
	scanf("%d", &pc->data[pc->sz].age);
	printf("������绰:>");
	scanf("%s", pc->data[pc->sz].tele);
	printf("�������ַ:>");
	scanf("%s", pc->data[pc->sz].addr);
	pc->sz++;
	printf("�ɹ�������ϵ��\n");


}



void ShowContact(Contact* pc)
{
	int i = 0;
	printf("%-10s %-4s %-5s %-12s %-30s\n", "����", "����", "�Ա�", "�绰", "��ַ");
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
	printf("�ͷ��ڴ�\n");                                            
}
void DelContact(pContact pc)
{
	char name[MAX_NAME] = { 0 };
	if (pc->sz == 0)
	{
		printf("ͨѶ¼Ϊ�գ��޷�ɾ��");
		return;
	}
	//1.�ҵ�Ҫɾ���˵���Ϣ
	printf("������Ҫɾ���˵�����:>");
	scanf("%s", name);
	int pos = FindByName(pc, name);
	if (pos == -1)
	{
		printf("Ҫɾ�����˲�����");
		return;
	}
	int i = 0;
	for (i = pos; i < pc->sz - 1; i++)
	{
		pc->data[i] = pc->data[i + 1];
	}
	pc->sz--;
	printf("ɾ���ɹ�");
}


void SearchContact(pContact pc)
{
	char name[MAX_NAME] = { 0 };
	printf("����������˵���Ϣ");
	scanf("%s", name);
	int pos = FindByName(pc, name);
	if (pos == -1)
	{
		printf("Ҫ���ҵ��˲�����\n");
		return;
	}
	//��ӡ
	printf("%-10s %-4s %-5s %-12s %-30s\n", "����", "����", "�Ա�", "�绰", "��ַ");
	printf("%s %d %s %s %s\n", pc->data[pos].name, pc->data[pos].age, pc->data[pos].sex, pc->data[pos].tele, pc->data[pos].addr);
	

}


void ModifyContact(Contact* pc)
{
	char name[MAX_NAME] = { 0 };
	printf("������Ҫ�޸��˵�����:>");
	scanf("%s", name);
	int pos=FindByName(pc, name);
	if (pos == -1)
	{
		printf("Ҫ�޸ĵ��˲�����");
		return;
	}
	//�޸�
	printf("����������");
	scanf("%s", pc->data[pos].name);
	printf("����������");
	scanf("%d", pc->data[pos].age);
	printf("�������Ա�");
	scanf("%s", pc->data[pos].sex);
	printf("������绰");
	scanf("%s", pc->data[pos].tele);
	printf("�������ַ");
	scanf("%s", pc->data[pos].addr);

	printf("�޸ĳɹ�");
}
//qsort�����ȽϷ���
int cmp_by_name(void* e1,void* e2)
{
	return strcmp(((PeoInfo*)e1)->name, ((PeoInfo*)e2)->name);
}
void SortContact(Contact* pc)
{

	qsort(pc->data, pc->sz, sizeof(PeoInfo), cmp_by_name);
	printf("����ɹ�");
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