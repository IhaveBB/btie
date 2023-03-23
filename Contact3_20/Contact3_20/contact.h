#include<stdio.h>
#define MAX 100
#define MAX_NAME 40
#define MAX_SEX 20
#define MAX_TELE 20
#define MAX_ADDR 20

//��ʾһ���˵���Ϣ
typedef struct PeoInfo
{
	char name[MAX_NAME];
	int age;
	char sex[MAX_SEX];
	char tele[MAX_TELE];
	char addr[MAX_ADDR];
}PeoInfo;
typedef struct Contact
{
	PeoInfo data[MAX];
	int sz;//��¼ͨѶ¼����Ч��Ϣ����
}Contact,*pContact;


void InitContact(Contact* pc);
void AddContact(Contact* pc);
void ShowContact(const Contact* pc);
void DelContact(pContact pc);
void SearchContact(const pContact pc);
void ModifyContact(Contact* pc);
void SortContact(Contact* pc);