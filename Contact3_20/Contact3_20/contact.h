#include<string.h>
#include<stdio.h>
#include<assert.h>
#include<stdlib.h>
#define MAX 100
#define MAX_NAME 40
#define MAX_SEX 20
#define MAX_TELE 20
#define MAX_ADDR 20
#define DEFAULT_SZ 3
#define INC_SZ 2

//表示一个人的信息
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
	PeoInfo* data;
	int sz;//记录通讯录中有效信息个数
	int capacity; //通讯录当前容量
} Contact, * pContact;


void InitContact(Contact* pc);
void AddContact(Contact* pc);
void ShowContact(const Contact* pc);
void DelContact(Contact *pc);
void SearchContact(const pContact pc);
void ModifyContact(Contact* pc);
void SortContact(Contact* pc);
void DestroyConact(Contact *pc);