#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

struct People {
    int number;
    int key;
    struct People* next;
};

struct Josephus {
    struct People* first;
    struct People* last;
    int n;
};

void Insert(struct Josephus* josephus, int n) {
    josephus->n = n;
    struct People* cur = NULL;

    for (int i = 1; i <= n; i++) {
        printf("请您输入第%d个密码: ", i);
        int key;
        scanf("%d", &key);
        struct People* node = (struct People*)malloc(sizeof(struct People));
        node->number = i;
        node->key = key;

        if (i == 1) {
            josephus->last = josephus->first = node;
            node->next = node;
        }
        else {
            josephus->last->next = node;
            josephus->last = node;
            josephus->last->next = josephus->first;
        }
    }


}

void gameStart(struct Josephus* josephus, int max) {
    printf("出列顺序为: ");
    struct People* cur = josephus->first;

    while (josephus->n > 1) {
        for (int i = 1; i < max - 1; i++) {
            cur = cur->next;
        }

        max = cur->next->key;

        if (max == 1) {
            printf("%d ", cur->next->number);
            struct People* temp = cur->next;
            cur->next = cur->next->next;
            free(temp);
            josephus->n--;
        }
        else {
            printf("%d ", cur->next->number);
            struct People* temp = cur->next;
            cur->next = cur->next->next;
            free(temp);
            josephus->n--;
            cur = cur->next;
        }
    }
    printf("%d\n", cur->number);
}

int main() {
    struct Josephus josephus;
    josephus.first = NULL;
    josephus.last = NULL;
    printf("请输入总人数: ");
    int n;
    scanf("%d", &n);
    printf("请输入第一圈的最大值: ");
    int max;
    scanf("%d", &max);
    Insert(&josephus, n);
    gameStart(&josephus, max);
    return 0;
}